from datetime import datetime as time # memanggil modul datetime dari datetime sebagai variabel time
import json # memanggil modul json
import os # memanggil modul os

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
        remove_transaksi() # -memanggil function remove_transaksi untuk menghapus data
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

# MELIHAT TRANSAKSI
def view_transaksi(): # membuat function baru
    clear_screen() # memanggil function hapus layar
    with open ('transaksi.json', 'r') as file_json: # membuka dan menutup file transaksi.json dalam mode read sebagai variabel file_json
        temp = json.load(file_json) # membuat variabel untuk menampung muatan data sebelumnya dari file json 
        print("NO \t NAMA \t JUMLAH  HARGA \t TOTAL \t DATE ") # menampilkan "no-nama-"
        # -jumlah-harga-total-date dengan karakter escape tab
        print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali
        for x in temp: # mengulang data temp ke dalam variabel x
            print(f"{x['no']} \t {x['nama']} \t {x['jumlah']} \t {x['harga']} \t {x['total']} \t {x['date']}") # menampilkan list data dari-
            # -setiap indeks dengan karakter escape tab
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

# MEMBUAT TRANSAKSI
def create_transaksi(): # membuat function baru
    clear_screen() # memanggil function hapus layar
    temp = dict() # membuat variabel baru untuk menampung data dictionary
    with open('transaksi.json', 'r') as file_json: # membuka dan menutup file transaksi.json dalam mode read sebagai variabel file_json
        data = json.load(file_json) # membuat variabel untuk menampung muatan data sebelumnya dari file json    
    temp['no'] = input('nomor transaksi : ') # menuliskan value baru dari key 'no'
    temp['nama'] = input('masukkan nama : ') # menuliskan value baru dari key 'nama'
    temp['jumlah'] = int(input('jumlah : ')) # menuliskan value baru dari key 'jumlah'
    temp['harga'] = int(input('harga : ')) # menuliskan value baru dari key 'harga'
    jumlah = temp['jumlah'] # menampung value 'jumlah' dari temp ke dalam jumlah
    harga = temp['harga'] # menampung value 'harga' dari temp ke dalam harga
    total = jumlah * harga # operasi aritmatika untuk menghitung total 
    temp['total'] = total # menuliskan value baru dari key 'total'
    temp['date'] = time.now().strftime('%y-%m-%d') # menuliskan value baru dari key 'date'
    data.append(temp) # memasukkan data temp ke dalam variabel data
    with open('transaksi.json', 'w') as file_json: # membuka dan menutup file transaksi.json dalam mode write sebagai variabel file_json
        json.dump(data, file_json, indent=4) # kode untuk menuliskan data baru dari variabel data ke file json dengan indentasi 4
    print('transaksi berhasil ditambahkan') # menampilkan kalimat "data berhasil ditambahkan" 
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

# MENGUBAH TRANSAKSI
def edit_transaksi(): # membuat function baru
    clear_screen() # memanggil function hapus layar
    new_data = [] # membuat variabel baru untuk menampung data list
    with open ('transaksi.json', 'r') as file_json: # membuka dan menutup file transaksi.json dalam mode read sebagai variabel file_json
        temp = json.load(file_json) # membuat variabel untuk menampung muatan data sebelumnya dari file json 
        print("NO \t NAMA \t JUMLAH  HARGA \t TOTAL \t DATE ") # menampilkan "no-nama-"
        # -jumlah-harga-total-date dengan karakter escape tab
        print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali
        for x in temp: # mengulang data temp ke dalam variabel x
            print(f"{x['no']} \t {x['nama']} \t {x['jumlah']} \t {x['harga']} \t {x['total']} \t {x['date']}") # menampilkan list data dari-
            # -setiap indeks dengan karakter escape tab

    print('\nnomor transaksi manakah yang ingin anda ubah?? ') # menampilkan kalimat- 
    # -"nomor transaksi manakah yang ingin anda ubah??" dengan karakter escape newline
    ubah = input('pilih nomor transaksi : ') # variabel input untuk memilih no transaksi
    i = 0  # membuat variabel baru dengan value 0
    for urutan in temp: # mengulang data temp ke dalam variabel urutan
        if urutan['no'] == ubah: # jika value 'no' dari urutan sama dengan variabel input ubah, maka-
            no = urutan['no'] # membuat variabel untuk menampung value dari key 'no'
            nama = urutan['nama'] # membuat variabel untuk menampung value dari key 'nama'
            jumlah = urutan['jumlah'] # membuat variabel untuk menampung value dari key 'jumlah'
            harga = urutan['harga'] # membuat variabel untuk menampung value dari key 'harga'
            date = urutan['date'] # membuat variabel untuk menampung value dari key 'date'
            #total = urutan['total'] # membuat variabel untuk me\nampung value dari key 'total'
            print(f'nama barang saat ini : {nama}') # menampilkan nama barang sebelum diubah
            nama = input('masukkan nama baru : ') # membuat variabel input baru untuk mengganti nama
            print(f'jumlah saat ini : {jumlah}') # menampilkan jumlah barang sebelum diubah
            jumlah = int(input('masukkan jumlah baru : ')) # membuat variabel input baru untuk mengganti jumlah
            print(f'harga saat ini : {harga}') # menampilkan harga barang sebelum diubah
            harga = int(input('masukkan harga baru : ')) # membuat variabel input baru untuk mengganti harga
            date = time.now().strftime('%y-%m-%d') # variabel untuk menampung data tanggal
            total2 = jumlah * harga # operasi aritmatika untuk menghitung total harga
            new_data.append({'no':no,'nama':nama,'jumlah':jumlah,'harga':harga,'total':total2,'date':date}) # memasukkan data dictionary-
            # -keys dan values ke dalam varabel new_data
            i += 1 # value variabel i akan ditambah 1 hingga loop berakhir
        else: # jika kondisi lain, maka-
            new_data.append(urutan) # memasukkan data urutan ke dalam variabel new_data
            i += 1 # value variabel i akan ditambah 1 hingga loop berakhir

    print('transaksi berhasil diubah') # menampilkan "data berhasil diubah"
    with open ('transaksi.json', 'w') as file_json: # membuka dan menutup file transaksi.json dalam mode write sebagai variabel file_json
        json.dump(new_data, file_json, indent=4) # kode untuk menuliskan data baru dari variabel new_data ke file json dengan indentasi 4
    
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

# MENGHAPUS TRANSAKSI
def remove_transaksi(): # membuat function baru
    clear_screen() # memanggil function hapus layar
    new_data = [] # membuat variabel baru untuk menampung data list
    with open ('transaksi.json', 'r') as file_json: # membuka dan menutup file transaksi.json dalam mode read sebagai variabel file_json
        temp = json.load(file_json) # membuat variabel untuk menampung muatan data sebelumnya dari file json 
        print("NO \t NAMA \t JUMLAH  HARGA \t TOTAL \t DATE ") # menampilkan "no-nama-"
        # -jumlah-harga-total-date dengan karakter escape tab
        print("-" * 50) # menampilkan karakter '=' sebanyak 50 kali
        for x in temp: # mengulang data temp ke dalam variabel x
            print(f"{x['no']} \t {x['nama']} \t {x['jumlah']} \t {x['harga']} \t {x['total']} \t {x['date']}") # menampilkan list data dari-
            # -setiap indeks dengan karakter escape tab

    print('\nnomor transaksi manakah yang ingin anda hapus?? ') # menampilkan kalimat- 
    # -"nomor transaksi manakah yang ingin anda hapus??" dengan karakter escape newline
    hapus = input('pilih nomor transaksi : ') # variabel input untuk memilih no transaksi
    i = 0 # membuat variabel baru dengan value 0
    for urutan in temp: # mengulang data temp ke dalam variabel urutan
        if urutan['no'] == hapus: # jika value 'no' dari variabel urutan sama dengan variabel input hapus, maka-
            pass # kode tidak akan dieksekusi
            i += 1 # value variabel i akan ditambah 1 hingga loop berakhir
        else: # jika kondisi lain, maka-
            new_data.append(urutan) # memasukkan data urutan ke dalam variabel new_data
            i += 1 # value variabel i akan ditambah 1 hingga loop berakhir
    with open ('transaksi.json', 'w') as file_json: # membuka dan menutup file transaksi.json dalam mode write sebagai variabel file_json
        json.dump(new_data, file_json, indent=4) # kode untuk menuliskan data baru dari variabel new_data ke file json dengan indentasi 4
    print('transaksi berhasil dihapus') # menampilkan "Data berhasil dihapus"
    back_to_menu() # function untuk menampilkan perintah untuk kembali ke menu utama

while __name__ == '__main__': # selama program yang dijalankan adalah program utama, maka-
    show_menu() # memanggil function untuk menampilkan menu utama
