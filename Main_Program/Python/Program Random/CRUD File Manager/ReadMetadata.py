import os
from mutagen.id3 import ID3, TPE1, TIT2, TALB  # type: ignore
from mutagen.flac import FLAC


def get_mp3_metadata(file_path):
    try:
        tags = ID3(file_path)
        author = tags.get("TPE1", None)
        title = tags.get("TIT2", None)
        album = tags.get("TALB", None)

        # Ambil nama file tanpa ekstensi
        file_name_without_ext = os.path.splitext(os.path.basename(file_path))[0]

        print(f"File: {file_name_without_ext}")
        # print(f"Title: {title.text[0] if title else 'Unknown'}")
        print(f"Author: {author.text[0] if author else 'Unknown'}")
        # print(f"Album: {album.text[0] if album else 'Unknown'}")
    except Exception as e:
        print(f"Error reading metadata for {file_path}: {e}")


def get_flac_metadata(file_path):
    try:
        audio = FLAC(file_path)
        artist = audio.get("artist", None)
        title = audio.get("title", None)
        album = audio.get("album", None)

        # Ambil nama file tanpa ekstensi
        file_name_without_ext = os.path.splitext(os.path.basename(file_path))[0]

        print(f"File: {file_name_without_ext}")
        # print(f"Title: {title[0] if title else 'Unknown'}")
        # print(f"Album: {album[0] if album else 'Unknown'}")
        print(f"Artist: {artist[0] if artist else 'Unknown'}")
    except Exception as e:
        print(f"Error reading metadata for {file_path}: {e}")


# Ganti dengan path direktori yang sesuai
directory_path = "C:\\Users\\Nasrul Wahabi\\Downloads\\Music\\Blue Exorcist Original Soundtrack 1\\Files"

# List semua file di direktori
files = os.listdir(directory_path)

# Filter hanya file (bukan direktori)
files = [f for f in files if os.path.isfile(os.path.join(directory_path, f))]

for file_name in files:
    file_path = os.path.join(directory_path, file_name)

    if file_name.lower().endswith(".mp3"):
        get_mp3_metadata(file_path)
    elif file_name.lower().endswith(".flac"):
        get_flac_metadata(file_path)
