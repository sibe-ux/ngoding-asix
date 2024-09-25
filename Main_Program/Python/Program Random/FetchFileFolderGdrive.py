from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import os
import random
import datetime
import re

# to install those libraries use the following command
# pip install google-api-python-client google-auth-httplib2 google-auth-oauthlib
# don't forget to use command prompt as administrator

# Replace with your API key
API_KEY = "AIzaSyCxkdo7DDaO7-QiIxQjGtoTfWo39VwNu-M"

def extract_folder_id(drive_url):
    # Regular expression to extract the folder ID from the URL
    match = re.search(r'/folders/([a-zA-Z0-9_-]+)', drive_url)
    if match:
        return match.group(1)
    else:
        raise ValueError("Invalid Google Drive folder URL")

def generate_random_duration():
    # Durasi dalam detik, antara 30 detik dan 5 menit (300 detik)
    duration_seconds = random.randint(30, 300)
    minutes = duration_seconds // 60
    seconds = duration_seconds % 60
    return f"{minutes:02}:{seconds:02}"


def escape_sql_string(value):
    # Escape single quotes by doubling them
    return value.replace("'", "''")


def list_files_in_folder(api_key, drive_url):
    try:
        folder_id = extract_folder_id(drive_url)
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
        # 1 = Indopride
        # 2 = 日本の歌 (Japanese Songs)
        category = "2"
        # hati-hati dengan karakter khusus dalam string SQL, seperti tanda kutip tunggal
        # absolutely tidak boleh ada bentuk kutip, baik tunggal/ganda atau backtick sekali pun
        artist = "Hiroyuki Sawano, Akira, TAKUYA∞, ROOKiEZ is PUNK D, J.Y.Park (The Asiansoul), Super Changddai, Akihito Tanaka, Nao ymt"
        album = "Blue Exorcist Original Soundtrack 2"
        cover_link = "https://drive.google.com/file/d/1f4Ey_CfBCRpm9eWYIuIw1JVSILG5WW4J/view?usp=drive_link"
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
    except ValueError as error:
        print(f"An error occurred: {error}")


if __name__ == "__main__":
    # Replace with your full Google Drive folder URL
    FOLDER_URL = "https://drive.google.com/drive/folders/1f0KzdoJ8M-kTi0gvfbMDmM3pHwZQ9C5W?usp=drive_link"
    list_files_in_folder(API_KEY, FOLDER_URL)
