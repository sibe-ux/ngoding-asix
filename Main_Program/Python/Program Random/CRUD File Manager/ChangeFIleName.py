import os
import re

# Ganti dengan path direktori yang sesuai
directory_path = r"C:\Users\Nasrul Wahabi\Downloads\Music\[Nemuri] Charlotte シャーロット (2015-2016) [FLAC]\ECHO\Disc 1"
# Pattern regex untuk mencari nomor diikuti titik dan spasi
pattern = re.compile(r"^\d{2}\. ") # contoh: "01. "
# pattern = re.compile(r"^\d{2} - ") # contoh: "01 - "
# pattern = re.compile(r"^\d{1}\.\d{2} ") # contoh: "1.01 "
# pattern = re.compile(r"^\d{2} ") # contoh: "01 "

# Loop melalui semua file di direktori
for filename in os.listdir(directory_path):
    old_file_path = os.path.join(directory_path, filename)

    # Hanya proses file, bukan direktori
    if os.path.isfile(old_file_path):
        # Cek apakah filename dimulai dengan pola yang ingin dihapus
        new_filename = pattern.sub("", filename)

        # Hasilkan path baru
        new_file_path = os.path.join(directory_path, new_filename)

        # Rename file
        os.rename(old_file_path, new_file_path)
        print(f"File {filename} telah diubah namanya menjadi {new_filename}")
