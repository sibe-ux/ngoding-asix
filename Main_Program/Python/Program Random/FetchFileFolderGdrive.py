from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import os
import random
import datetime

# to install those libraries use the following command
# pip install google-api-python-client google-auth-httplib2 google-auth-oauthlib
# don't forget to use command prompt as administrator

# Replace with your API key
API_KEY = "AIzaSyCxkdo7DDaO7-QiIxQjGtoTfWo39VwNu-M"

# Replace with the ID of your folder
FOLDER_ID = "11pXPfz1Qg6wnOwUV4ZrwVBhiuZVF-R7n"


def generate_random_duration():
    # Durasi dalam detik, antara 30 detik dan 5 menit (300 detik)
    duration_seconds = random.randint(30, 300)
    minutes = duration_seconds // 60
    seconds = duration_seconds % 60
    return f"{minutes:02}:{seconds:02}"


def escape_sql_string(value):
    # Escape single quotes by doubling them
    return value.replace("'", "''")


def list_files_in_folder(api_key, folder_id):
    try:
        service = build("drive", "v3", developerKey=api_key)

        query = f"'{folder_id}' in parents"
        response = service.files().list(q=query, fields="files(id, name)").execute()
        files = response.get("files", [])

        if not files:
            print("No files found.")
            return

        # Starting timestamp for date_added
        base_time = datetime.datetime.now().replace(microsecond=0)

        # Base SQL INSERT statement template
        insert_statement_template = "INSERT INTO music (id_music, category, link_gdrive, title, artist, album, time, cover, favorite, date_added) VALUES \n"

        # Parameters for the static fields
        category = "2"
        artist = "Keiji Inai, Kohei Tanaka, Shiro Hamaguchi, Yasuhisa Murase"
        album = "One Piece Music Material Disc 5"
        cover_link = "https://drive.google.com/file/d/1QC4jUFavRuzR49GOIBi0tGqHEs8x5-6S/view?usp=drive_link"
        favorite = "0"

        # Collecting each row of values
        values = []

        for index, file in enumerate(files):
            file_name = file.get("name")
            file_name_without_extension, _ = os.path.splitext(file_name)
            file_id = file.get("id")
            link_gdrive = (
                f"https://drive.google.com/file/d/{file_id}/view?usp=drive_link"
            )
            date_added = base_time + datetime.timedelta(seconds=index)
            date_added_str = date_added.strftime("%Y-%m-%d %H:%M:%S")

            duration = generate_random_duration()

            # Escape special characters in the values
            file_name_without_extension = escape_sql_string(file_name_without_extension)
            link_gdrive = escape_sql_string(link_gdrive)
            artist = escape_sql_string(artist)
            album = escape_sql_string(album)
            cover_link = escape_sql_string(cover_link)
            date_added_str = escape_sql_string(date_added_str)

            values.append(
                f"(NULL, '{category}', '{link_gdrive}', '{file_name_without_extension}', '{artist}', '{album}', '{duration}', '{cover_link}', '{favorite}', '{date_added_str}')"
            )

        # Joining all values into the final SQL INSERT statement
        insert_statement = insert_statement_template + ",\n".join(values) + ";"
        print(insert_statement)

    except HttpError as error:
        print(f"An error occurred: {error}")


if __name__ == "__main__":
    list_files_in_folder(API_KEY, FOLDER_ID)
