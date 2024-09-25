import csv # memanggil modul file csv 
import os # memanggil modul os
import time # memanggil modul time

file = 'transaksi.csv' # membuat variabel untuk menampung data csv

def clear_screen(): # membuat function baru
    os.system('cls' if os.name == 'nt' else 'clear') # function untuk menghapus layar saat program dijalankan
    # cls untuk user windows, clear untuk user mac

def show_menu(): # membuat function baru
    clear_screen() # memanggil function clear_screen untuk menghapus layar
    print("=== transaksi barang ===") # menampikan kalimat "=== transaksi barang ==="
    print("[1] Buat transaksi Baru") # menampikan kalimat "[1] Buat transaksi Baru"
    print("[2] Ubah transaksi") # menampikan kalimat "[2] Ubah transaksi"
    print("[3] Hapus transaksi") # menampikan kalimat "[3] Hapus transaksi"
    print("[4] Lihat transaksi") # menampikan kalimat "[4] Lihat transaksi"
    print("[0] Selesai") # menampikan kalimat "[0] Selesai" 
    print("-"*30) # menampilkan karakter '=' sebanyak 30 kali
    home = input("Pilih menu> ") # membuat variabel input baru untuk menampilkan menu selanjutnya
    
    if(home == "1"): # jika variabel input home adalah 1, maka-
        create_transaksi() # -memanggil function create_transaksi untuk membuat data baru
    elif(home == "2"): # atau jika variabel input home adalah 2, maka-
        edit_transaksi() # -memanggil function edit_transaksi untuk mengubah data yang baru
    elif(home == "3"): # atau jika variabel input home adalah 3, maka-
        delete_transaksi() # -memanggil function delete_transaksi untuk menghapus data
    elif(home == "4"): # atau jika variabel input home adalah 4, maka-
        view_transaksi() # -memanggil function view_transaksi untuk melihat data
    elif(home == "0"):  # atau jika variabel input home adalah 0, maka-
        exit() # perintah untuk keluar dari program
    else: # jika kondisi lain, maka-
        print("Pilihan tidak ditemukan! please try again!!") # menampilkan kalimat "Pilihan tidak ditemukan! please try again!!"
        back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama
    
def back_to_menu(): # membuat function baru 
    print("\n") # membuat karakter escape newline
    input("Tekan Enter untuk kembali") # membuat inputan user untuk kembali- 
    # -ke menu utama dengan menekan tombol enter
    show_menu() # memanggil function untuk menampilkan menu utama


# MEMBUAT TRANSAKSI BARU
def create_transaksi(): # membuat function baru
    clear_screen() # memanggil function untuk menghapus layar
    with open(file, mode='a', newline='') as csv_file: # membuka dan menutup file csv dalam mode append sebagai variabel baru
        nama_kolom = ['NO', 'NAMA BARANG', 'JUMLAH', 'HARGA', 'TOTAL', 'TANGGAL'] # membuat-
        # -variabel baru yang menampung daftar nama header di file csv
        writer = csv.DictWriter(csv_file, fieldnames=nama_kolom) # membuat variabel baru untuk menulis data dictionary-
        # -ke csv_file dan nama header dari data nama_kolom
        
        no = input("No transaksi: ") # menginput no transaksi dari user
        nama = input("Nama barang: ") # menginput nama barang dari user
        jumlah = input("jumlah: ") # menginput jumlah barang dari user 
        harga = input('harga: ') # menginput harga barang dari user
        jumlah1 = int(jumlah) # casting variabel input jumlah ke integer
        harga1 = int(harga) # casting variabel input harga ke integer
        total1 = jumlah1 * harga1 # operasi aritmatika untuk menghitung total harga
        dtime = time.ctime() # untuk menampilkan waktu lokal saat user membuat transaksi

        writer.writerow({'NO': no, 'NAMA BARANG': nama, 'JUMLAH': jumlah, 'HARGA': harga, 'TOTAL': total1, 'TANGGAL': dtime})  # menuliskan data yang-
        # -telah diinput oleh user ke dalam file csv writer
    print('data berhasil ditambahkan') # menampilkan kalimat "data berhasil ditambahkan"  
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

# MENGUBAH TRANSAKSI
def edit_transaksi(): # membuat function baru
    clear_screen() # memanggil function untuk menghapus layar
    transaksi = [] # variabel untuk menampung data list

    with open(file, mode="r", newline='') as csv_file: # membuka dan menutup file csv dalam mode read sebagai variabel baru
        read = csv.DictReader(csv_file) # membuat variabel baru untuk membaca data dictionary-
        # -dari csv_file
        for barisan in read: # mengulang variabel read ke dalam variabel barisan
            transaksi.append(barisan) # memasukkan data dari variabel barisan ke dalam variabel transaksi

    print("NO \t NAMA BARANG \t JUMLAH  HARGA \t TOTAL \t TANGGAL ") # menampilkan "no-nama barang-"
    # -jumlah-harga-total-tanggal dengan karakter escape tab
    print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali

    for data in transaksi: # mengulang variabel transaksi ke dalam variabel data
        print(f"{data['NO']} \t {data['NAMA BARANG']} \t {data['JUMLAH']} \t {data['HARGA']} \t {data['TOTAL']} \t {data['TANGGAL']}") # menampilkan list data dari-
        # -setiap indeks dengan karakter escape tab

    print("-"*50) # menampilkan karakter '=' sebanyak 50 kali
    no = input("Pilih nomer transaksi> ") # user memilih no transaksi yang akan diubah
    nama = input("nama baru: ") # user menginput nama baru
    jumlah = input("jumlah baru: ") # user menginput jumlah barang baru
    harga = input("harga baru: ") # user menginput harga barang baru
    jumlah2 = int(jumlah) # casting variabel input jumlah ke integer
    harga2 = int(harga) # casting variabel input harga ke integer
    total2 = jumlah2 * harga2 # operasi aritmatika untuk menghitung total harga
    dtime = time.ctime()  # untuk menampilkan waktu lokal saat user membuat transaksi

    # mencari transaksi dan mengubah datanya dengan data yang baru
    indeks = 0 # membuat variabel baru dengan value 0
    for data in transaksi: # mengulang variabel transaksi ke dalam variabel data
        if (data['NO'] == no): # jika nomor yang diinput user sama dengan nomor di dalam variabel data, maka-
            transaksi[indeks]['NAMA BARANG'] = nama # mengganti data list dengan nama baru
            transaksi[indeks]['JUMLAH'] = jumlah # mengganti data list dengan jumlah baru
            transaksi[indeks]['HARGA'] = harga # mengganti data list dengan harga baru
            transaksi[indeks]['TOTAL'] = total2 # mengganti data list dengan total baru
            transaksi[indeks]['TANGGAL'] = dtime # mengganti data list dengan tanggal baru
        indeks += 1 # setiap value dari variabel indeks akan ditambah satu hingga loop berhenti

    # Menulis data baru ke file CSV (tulis ulang)
    with open(file, mode="w", newline='') as csv_file: # membuka dan menutup file csv dalam mode write sebagai variabel baru
        nama_kolom = ['NO', 'NAMA BARANG', 'JUMLAH', 'HARGA', 'TOTAL', 'TANGGAL'] # membuat-
        # -variabel baru yang menampung daftar nama header di file csv
        writer = csv.DictWriter(csv_file, fieldnames=nama_kolom) # membuat variabel baru untuk menulis data dictionary-
        # -ke csv_file dan nama header dari data nama_kolom
        writer.writeheader() # menampilkan nama kolom/header di dalam file csv
        for new_data in transaksi: # mengulang variabel transaksi ke dalam variabel new_data
            writer.writerow({'NO': new_data['NO'], 'NAMA BARANG': new_data['NAMA BARANG'], 'JUMLAH': new_data['JUMLAH'], 'HARGA': new_data['HARGA'], 'TOTAL': new_data['TOTAL'], 'TANGGAL': new_data['TANGGAL']}) # menuliskan data yang-
        # -telah diinput oleh user ke dalam file csv writer untuk mengganti data lama
    print('data berhasil diubah') # menampilkan "data berhasil diubah"
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

# MENGHAPUS TRANSAKSI
def delete_transaksi(): # membuat function baru
    clear_screen() # memanggil function untuk menghapus layar
    transaksi = [] # variabel untuk menampung data list

    with open(file, mode="r") as csv_file: # membuka dan menutup file csv dalam mode read sebagai variabel baru
        read = csv.DictReader(csv_file) # membuat variabel baru untuk menulis data dictionary-
        # -dari csv_file 
        for barisan in read: # mengulang variabel read ke dalam variabel barisan
            transaksi.append(barisan) # memasukkan data dari variabel barisan ke dalam variabel transaksi

    print("NO \t NAMA BARANG \t JUMLAH HARGA \t TOTAL \t TANGGAL") # menampilkan "no-nama barang-"
    # -jumlah-harga-total-tanggal dengan karakter escape tab
    print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali

    for data in transaksi: # mengulang data dari variabel transaksi ke variabel data
      print(f"{data['NO']} \t {data['NAMA BARANG']} \t {data['JUMLAH']} \t {data['HARGA']} \t {data['TOTAL']} \t {data['TANGGAL']}") # menampilkan list data dari-
        # -setiap indeks dengan karakter escape tab
    print("-"*50) # menampilkan karakter '=' sebanyak 50 kali
    no = input("pilih nomor transaksi yang ingin dihapus> ") # user mengnput nomor transaksi yang ingin dihapus

    # mencari transaksi dan mengubah datanya dengan data yang baru
    indeks = 0 # membuat variabel baru dengan value 0
    for data in transaksi: # mengulang variabel transaksi ke dalam variabel data
        if (data['NO'] == no): # jika nomor yang diinput user sama dengan nomor di dalam variabel data, maka-
            transaksi.remove(transaksi[indeks]) # -data transaksi akan dihapus berdasarkan nomor yang diinput user
        indeks += 1 # setiap value dari variabel indeks akan ditambah 1 hingga loop berhenti

    # Menulis data baru ke file CSV (tulis ulang)
    with open(file, mode="w", newline='') as csv_file: # membuka dan menutup file csv dalam mode write sebagai variabel baru
        nama_kolom = ['NO', 'NAMA BARANG', 'JUMLAH', 'HARGA', 'TOTAL', 'TANGGAL'] # membuat-
        # -variabel baru yang menampung daftar header di file csv
        writer = csv.DictWriter(csv_file, fieldnames=nama_kolom) # membuat variabel baru untuk menulis data dictionary-
        # -ke csv_file dan nama header dari data nama_kolom
        writer.writeheader() # menampilkan nama kolom di dalam file csv
        for new_data in transaksi: # mengulang variabel transaksi ke dalam variabel new_data
           writer.writerow({'NO': new_data['NO'], 'NAMA BARANG': new_data['NAMA BARANG'], 'JUMLAH': new_data['JUMLAH'], 'HARGA': new_data['HARGA'], 'TOTAL': new_data['TOTAL'], 'TANGGAL': new_data['TANGGAL']}) # menuliskan data baru yang-
        # -telah diinput oleh user ke dalam file csv untuk menggantikan data lama
    print("Data berhasil dihapus") # menampilkan "Data berhasil dihapus"
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

def view_transaksi(): # membuat function baru
    clear_screen() # memanggil function untuk menghapus layar
    transaksi = [] # variabel untuk menampung data list

    with open(file, mode="r", newline='') as csv_file: # membuka dan menutup file csv dalam mode read sebagai variabel baru
        read = csv.DictReader(csv_file) # membuat variabel baru untuk membaca data dictionary-
        # -dari csv_file 
        for barisan in read: # mengulang variabel read ke dalam variabel barisan
            transaksi.append(barisan) # memasukkan data dari variabel barisan ke dalam variabel transaksi

    print("NO \t NAMA BARANG \t JUMLAH  HARGA \t TOTAL \t TANGGAL ") # menampilkan "no-nama barang-"
    # -jumlah-harga-total-tanggal dengan karakter escape tab
    print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali

    for data in transaksi: # mengulang variabel transaksi ke dalam variabel data
        print(f"{data['NO']} \t {data['NAMA BARANG']} \t {data['JUMLAH']} \t {data['HARGA']} \t {data['TOTAL']} \t {data['TANGGAL']}") # menampilkan list data dari-
        # -setiap indeks dengan karakter escape tab
    back_to_menu() # memanggil function untuk kembali ke menu utama

    
while __name__ == '__main__': # selama program yang dijalankan adalah program utama, maka-
    show_menu() # memanggil function untuk menampilkan menu utama
        