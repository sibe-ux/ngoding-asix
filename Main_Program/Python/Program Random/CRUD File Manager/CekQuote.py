import os
import re

# Ganti dengan path direktori yang sesuai
directory_path = r"C:\Users\Nasrul Wahabi\Downloads\Music\[Nemuri] Charlotte シャーロット (2015-2016) [FLAC]\ECHO\Disc 2"
# List semua file di direktori
files = os.listdir(directory_path)

# Filter hanya file (bukan direktori)
files = [f for f in files if os.path.isfile(os.path.join(directory_path, f))]

# List untuk menyimpan file yang mengandung karakter petik
files_with_single_quote = []
files_with_double_quote = []
files_with_symbols = []

# Regular expression untuk mendeteksi simbol selain huruf dan angka
symbol_pattern = re.compile(r'[^a-zA-Z0-9.\-_ ]')

# Cek setiap file dan ganti karakter petik dengan backtick
for file_name in files:
    new_file_name = file_name
    if "'" in file_name:
        files_with_single_quote.append(file_name)
        new_file_name = new_file_name.replace("'", "`")
    if '"' in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace('"', "`")
    if "<" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("<", "[")
    if ">" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace(">", "]")
    if ":" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace(":", "~")
    if "/" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("/", "-")
    if "\\" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("\\", "-")
    if "|" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("|", "~")
    if "?" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("?", "...")
    if ";" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace(";", "~")
    if "*" in file_name:
        files_with_double_quote.append(file_name)
        new_file_name = new_file_name.replace("*", "~")
    if symbol_pattern.search(file_name):
        files_with_symbols.append(file_name)
    
    # Rename file jika ada perubahan
    if new_file_name != file_name:
        os.rename(
            os.path.join(directory_path, file_name),
            os.path.join(directory_path, new_file_name)
        )
        print(f"Renamed: {file_name} -> {new_file_name}")

# Cetak hasil
if files_with_single_quote:
    print("\nFile yang mengandung karakter petik tunggal:")
    for file_name in files_with_single_quote:
        print(f"- {os.path.join(directory_path, file_name)}")

if files_with_double_quote:
    print("\nFile yang mengandung karakter petik ganda:")
    for file_name in files_with_double_quote:
        print(f"- {os.path.join(directory_path, file_name)}")

if files_with_symbols:
    print("\nFile yang mengandung simbol selain huruf dan angka:")
    for file_name in files_with_symbols:
        print(f"- {os.path.join(directory_path, file_name)}")

if not files_with_single_quote and not files_with_double_quote:
    print("Tidak ada file yang mengandung karakter petik tunggal atau ganda.")
