from operator import index
import requests
import os
import random
import datetime
import re


def generate_random_duration():
    # Durasi dalam detik, antara 30 detik dan 5 menit (300 detik)
    duration_seconds = random.randint(30, 300)
    minutes = duration_seconds // 60
    seconds = duration_seconds % 60
    return f"{minutes:02}:{seconds:02}"


def escape_sql_string(value):
    # Escape single quotes by doubling them
    return value.replace("'", "''")


def fetch_github_files(repo_url):
    # Ekstrak informasi pemilik, repository, dan path folder dari URL
    parts = repo_url.split("/")
    owner = parts[3]
    repo = parts[4]
    folder_path = "/".join(parts[7:])

    # Starting timestamp for date_added
    base_time = datetime.datetime.now().replace(microsecond=0)

    # Base SQL INSERT statement template
    insert_statement_template = "INSERT INTO music (id_music, category, link_gdrive, title, artist, album, time, cover, favorite, date_added) VALUES \n"

    # Parameters for the static fields
    # 2 = 日本の歌 (Japanese Songs)
    category = "2"
    # hati-hati dengan karakter khusus dalam string SQL, seperti tanda kutip tunggal
    artist = "Akira Senju, Keita Kawaguchi, Shintaro Tokita, Takuya Ohashi, Yuki Kuromitsu, Yusuke Itagaki"
    album = "Fullmetal Alchemist Brotherhood Original Soundtrack 2"
    cover_link = "https://raw.githubusercontent.com/sibeux/fantastic-eureka/main/Fullmetal%20Alchemist%20Brotherhood%20Original%20Soundtrack%202/Cover.jpg"
    favorite = "0"

    # Collecting each row of values
    values = []

    # Buat URL API untuk folder
    api_url = f"https://api.github.com/repos/{owner}/{repo}/contents/{folder_path}"

    # Lakukan request ke API GitHub
    response = requests.get(api_url)

    if response.status_code == 200:
        files = response.json()
        index = 0
        for file in files:
            if file["type"] == "file":
                # Hapus ekstensi file untuk menampilkan nama file tanpa ekstensi
                file_name_without_ext = os.path.splitext(file["name"])[0]

                date_added = base_time + datetime.timedelta(seconds=index)
                date_added_str = date_added.strftime("%Y-%m-%d %H:%M:%S")

                index += 1

                duration = generate_random_duration()

                # Escape special characters in the values
                artist = escape_sql_string(artist)
                album = escape_sql_string(album)
                cover_link = escape_sql_string(cover_link)
                date_added_str = escape_sql_string(date_added_str)

                values.append(
                    f"(NULL, '{category}', '{file['download_url']}', '{file_name_without_ext}', '{artist}', '{album}', '{duration}', '{cover_link}', '{favorite}', '{date_added_str}')"
                )

        # Joining all values into the final SQL INSERT statement
        insert_statement = insert_statement_template + ",\n".join(values) + ";"
        print(insert_statement)

    else:
        print("Error:", response.status_code, response.json())


# Contoh penggunaan dengan URL yang kamu berikan
repo_url = "https://github.com/sibeux/fantastic-eureka/tree/main/Fullmetal%20Alchemist%20Brotherhood%20Original%20Soundtrack%202/MP3"
fetch_github_files(repo_url)
