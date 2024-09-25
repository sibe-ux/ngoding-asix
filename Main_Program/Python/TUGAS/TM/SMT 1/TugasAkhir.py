import json
import os
from datetime import datetime as time


def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')


def back_to_login():
    print("\n")
    input("Tekan Enter untuk kembali")
    login()


def back_to_menu():
    print("\n")
    input("Tekan Enter untuk kembali")
    menu()


def back_to_signin():
    input('username atau password salah! klik enter untuk ulangi!')
    sign_in()


def cont_to_menu():
    input('login successful! click enter to continue!')
    menu()


def back_to_logout():
    print('perintah tidak ditemukan! Harap coba lagi!')
    log_out()


def back_to_edit():
    input('Please click enter to try again! ')
    edit_transaksi()


def back_to_delete():
    input('Please click enter to try again! ')
    remove_transaksi()

# LOG OUT


def log_out():
    a = input('Anda yakin ingin logout? [y/t] ')
    if a == "y":
        login()
    elif a == 't':
        menu()
    else:
        back_to_logout()

# LOGIN


def login():
    clear_screen()
    print('{0:^48s}'.format('======== SELAMAT DATANG DI BUYBLEE ======='))
    print('\nSilakan pilih metode login Anda!')
    print('-'*10)
    print('1. Sign In')
    print('2. Register')
    print('0. Close Apps')
    print('-'*10)
    login = input('Pilih metode> ')

    if login == '1':
        sign_in()
    elif login == '2':
        register()
    elif login == '0':
        exit()
    else:
        print('metode tidak ditemukan, harap coba lagi!')
    back_to_login()

# SIGN IN


def sign_in():
    clear_screen()
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\login.json', 'r') as logs:
        temp = json.load(logs)
    print('{0:^48s}'.format('SIGN IN\n'))
    usersign = input('username : ')
    passlog = input('password : ')
    for x in temp:
        if (x['USERNAME'] == usersign) and (x['PASSWORD'] == passlog):
            cont_to_menu()
    back_to_signin()

# REGISTER


def register():
    clear_screen()
    temp = dict()
    print('{0:^48s}'.format('REGISTER\n'))
    print('Mohon masukkan data Anda di bawah dengan benar!')
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\login.json', 'r') as regs:
        data = json.load(regs)
    temp['USERNAME'] = input('USERNAME : ')
    temp['PASSWORD'] = input('PASSWORD : ')
    data.append(temp)
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\login.json', 'w') as regs:
        json.dump(data, regs, indent=4)
    print('akun berhasil ditambahkan')
    back_to_login()

# MENU


def menu():
    clear_screen()
    print('[1] Transaksi Baru')
    print('[2] Ubah Transaksi')
    print('[3] Riwayat Transaksi')
    print('[4] Hapus Transaksi')
    print('[5] Total Pengeluaran')
    print('[0] Log Out')
    print("-"*30)
    home = input("Pilih menu> ")

    if (home == "1"):
        create_transaksi()
    elif (home == "2"):
        edit_transaksi()
    elif (home == "4"):
        remove_transaksi()
    elif (home == "3"):
        view_transaksi()
    elif (home == "5"):
        total()
    elif (home == "0"):
        log_out()
    else:
        print("Pilihan tidak ditemukan! please try again!!")
        back_to_menu()

# BUAT TRANSAKSI


def create_transaksi():
    clear_screen()
    print('{0:^48s}'.format('TRANSAKSI BARU'))
    print('{0:^48s}'.format('='*40))
    temp = dict()
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'r') as file_json:
        data = json.load(file_json)
    temp['no'] = input('\nnomor transaksi\t: ')
    cname = input('nama barang\t: ')
    temp['nama'] = cname
    jump = int(input('jumlah\t\t: '))
    temp['jumlah'] = str(jump)
# -----------------------------------------------------------------------------------
    charga = int(input('harga\t\t: Rp'))
    sharga = str(charga)
    vg = len(sharga) - 3
    pg = len(sharga) - 6
    Dg = len(sharga) - 9
    if 3 < len(sharga) < 7:  # ratusan ribu
        temp['harga'] = (f'Rp{sharga[:vg]}.{sharga[vg:]},-')
    elif 6 < len(sharga) < 10:  # jutaan
        temp['harga'] = (f'Rp{sharga[:pg]}.{sharga[pg:vg]}.{sharga[vg:]},-')
    elif 9 < len(sharga) < 13:  # miliaran
        temp['harga'] = (f'Rp{sharga[:Dg]}.{sharga[Dg:pg]}.{sharga[pg:vg]}.{sharga[vg:]},-')
    elif len(sharga) < 4:  # ribuan
        temp['harga'] = (f'Rp{sharga},-')
# -----------------------------------------------------------------------------------
    jumlah = jump
    harga = charga
    total = jumlah * harga
    sto = str(total)
    vt = len(sto) - 3
    pt = len(sto) - 6
    Dt = len(sto) - 9
    if 3 < len(sto) < 7:
        temp['total'] = (f'Rp{sto[:vt]}.{sto[vt:]},-')
    elif 6 < len(sto) < 10:
        temp['total'] = (f'Rp{sto[:pt]}.{sto[pt:vt]}.{sto[vt:]},-')
    elif 9 < len(sto) < 13:
        temp['total'] = (f'Rp{sto[:Dt]}.{sto[Dt:pt]}.{sto[pt:vt]}.{sto[vt:]},-')
    elif len(sto) < 4:
        temp['total'] = (f'Rp{sto},-')
    elif len(sto) >= 13:
        temp['total'] = (f'Rp{sto},-')
    print('-'*20)
# -----------------------------------------------------------------------------------
    strtot = str(total)
    v = len(strtot) - 3
    p = len(strtot) - 6
    D = len(strtot) - 9
    if len(strtot) < 13:
        if 3 < len(strtot) < 7:
            print(f'Total Harga\t: Rp{strtot[:v]}.{strtot[v:]},-')
        elif 6 < len(strtot) < 10:
            print(f'Total Harga\t: Rp{strtot[:p]}.{strtot[p:v]}.{strtot[v:]},-')
        elif 9 < len(strtot) < 13:
            print(f'Total Harga\t: Rp{strtot[:D]}.{strtot[D:p]}.{strtot[p:v]}.{strtot[v:]},-')
        elif len(strtot) < 4:
            print(f'Total harga\t: Rp{strtot},-')
        print('-'*20)
    elif len(strtot) >= 13:
        print('Maaf, total harga harus di bawah 1 triliun ')
        back_to_menu()
# -----------------------------------------------------------------------------------
    cuang = int(input('Jumlah uang\t: Rp'))
    scu = str(cuang)
    vc = len(scu) - 3
    pc = len(scu) - 6
    Dc = len(scu) - 9
    if 3 < len(scu) < 7:
        temp['total uang'] = (f'Rp{scu[:vc]}.{scu[vc:]},-')
    elif 6 < len(scu) < 10:
        temp['total uang'] = (f'Rp{scu[:pc]}.{scu[pc:vc]}.{scu[vc:]},-')
    elif 9 < len(scu) < 13:
        temp['total uang'] = (f'Rp{scu[:Dc]}.{scu[Dc:pc]}.{scu[pc:vc]}.{scu[vc:]},-')
    elif len(scu) < 4:
        temp['total uang'] = (f'Rp{scu},-')
    elif len(scu) >= 13:
        print('Maaf! Uang harus dibawah 1 triliun!')
        back_to_menu()
    print('-'*40)
# -----------------------------------------------------------------------------------
# -----------------------------------------------------------------------------------
    uang = cuang
    strang = str(uang)
    kem = uang - total
    skem = str(kem)
    vk = len(skem) - 3
    pk = len(skem) - 6
    Dk = len(skem) - 9
    if 3 < len(skem) < 7:
        temp['kembalian'] = (f'Rp{skem[:vk]}.{skem[vk:]},-')
    elif 6 < len(skem) < 10:
        temp['kembalian'] = (f'Rp{skem[:pk]}.{skem[pk:vk]}.{skem[vk:]},-')
    elif 9 < len(skem) < 13:
        temp['kembalian'] = (f'Rp{skem[:Dk]}.{skem[Dk:pk]}.{skem[pk:vk]}.{skem[vk:]},-')
    elif len(skem) < 4:
        temp['kembalian'] = (f'Rp{skem},-')
    temp['date'] = time.now().strftime('%d-%m-%Y')
# -----------------------------------------------------------------------------------

    while True:
        b = input('Yakin untuk melakukan transaksi?? [y/t] ')
        if b == 'y':
            if uang < total:
                kembalian = uang - total
                print('Maaf uang anda tidak cukup untuk melakukan transaksi')
                back_to_menu()
            else:
                kembalian = uang - total
                strkem = str(kembalian)
                vi = len(strang) - 3
                pi = len(strang) - 6
                Di = len(strang) - 9
                if 3 < len(strang) < 7:
                    print('-'*39+'- +')
                    print(f'Total uang Anda\t\t: Rp{strang[:vi]}.{strang[vi:]},-')
                elif 6 < len(strang) < 10:
                    print('-'*39+'- +')
                    print(f'Total uang Anda\t\t: Rp{strang[:pi]}.{strang[pi:vi]}.{strang[vi:]},-')
                elif 9 < len(strang) < 13:
                    print('-'*39+'- +')
                    print(f'Total uang Anda\t\t: Rp{strang[:Di]}.{strang[Di:pi]}.{strang[pi:vi]}.{strang[vi:]},-')
                elif len(strang) < 4:
                    print('-'*39+'- +')
                    print(f'Total uang Anda\t\t: Rp{strang},-')

                ve = len(strkem) - 3
                pe = len(strkem) - 6
                De = len(strkem) - 9
                if 3 < len(strkem) < 7:
                    print('-'*39+'- -')
                    print(f'kembalian Anda sebesar\t: Rp{ strkem[:ve]}.{strkem[ve:]},-')
                elif 6 < len(strkem) < 10:
                    print('-'*39+'- -')
                    print(f'kembalian Anda sebesar\t: Rp{strkem[:pe]}.{
                          strkem[pe:ve]}.{strkem[ve:]},-')
                elif 9 < len(strkem) < 13:
                    print('-'*39+'- -')
                    print(f'kembalian Anda sebesar\t: Rp{strkem[:De]}.{
                          strkem[De:pe]}.{strkem[pe:ve]}.{strkem[ve:]},-')
                elif len(strkem) < 4:
                    print('-'*39+'- -')
                    print(f'kembalian Anda sebesar\t: Rp{strkem},-')
                print('-'*40)
                print('transaksi berhasil ditambahkan')
                data.append(temp)
                with open('data_transaksi.json', 'w') as file_json:
                    json.dump(data, file_json, indent=4)
                back_to_menu()
        elif b == 't':
            print('transaksi dibatalkan!')
            back_to_menu()
        else:
            print('Perintah tidak ditemukan! Harap coba lagi!')

# EDIT TRANSAKSI


def edit_transaksi():
    clear_screen()
    print('{0:^115s}'.format('EDIT TRANSAKSI'))
    print('{0:^115s}'.format('='*70))
    new_data = []
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'r') as file_json:
        temp = json.load(file_json)
        print('\n')
        print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
            'NO', 'NAMA BARANG', 'JUMLAH', 'HARGA BARANG', 'TOTAL HARGA', 'JUMLAH UANG', 'KEMBALIAN', 'TANGGAL'))
        print('='*125)
        for x in temp:
            print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
                x['no'], x['nama'], x['jumlah'], x['harga'], x['total'], x['total uang'], x['kembalian'], x['date']))
            print('-'*125)
    print('\nnomor transaksi manakah yang ingin anda ubah?? \nketik cancel untuk membatalkan perubahan!')
    ubah = input('pilih nomor transaksi\t: ')
    i = 0
    if ubah == 'cancel':
        print('perubahan dibatalkan')
        back_to_menu()
    for urutan in temp:
        if urutan['no'] == ubah:
            no = urutan['no']
            nama = urutan['nama']
            jumlah = urutan['jumlah']
            hargaaa = urutan['harga']
            print(f'nama barang saat ini\t: {nama}')
            nama = input('masukkan nama baru\t: ')
            print(f'jumlah saat ini\t\t: {jumlah}')
            jumlah = int(input('masukkan jumlah baru\t: '))
            print(f'harga saat ini\t\t: {hargaaa}')
            harga = int(input('masukkan harga baru\t: Rp'))
            harst = str(harga)
            vco = len(harst) - 3
            pco = len(harst) - 6
            Dco = len(harst) - 9

            if 3 < len(harst) < 7:
                newharga = (f'Rp{harst[:vco]}.{harst[vco:]},-')
            elif 6 < len(harst) < 10:
                newharga = (f'Rp{harst[:pco]}.{harst[pco:vco]}.{harst[vco:]},-')
            elif 9 < len(harst) < 13:
                newharga = (f'Rp{harst[:Dco]}.{harst[Dco:pco]}.{harst[pco:vco]}.{harst[vco:]},-')
            elif len(harst) < 4:
                newharga = (f'Rp{harst},-')
            date = time.now().strftime('%d-%m-%Y')
# -----------------------------------------------------------------------------------
# -----------------------------------------------------------------------------------
            total2 = jumlah * harga
            torst = str(total2)
            vcp = len(torst) - 3
            pcp = len(torst) - 6
            Dcp = len(torst) - 9
            if 3 < len(torst) < 7:
                newtotal = (f'Rp{torst[:vcp]}.{torst[vcp:]},-')
            elif 6 < len(torst) < 10:
                newtotal = (f'Rp{torst[:pcp]}.{torst[pcp:vcp]}.{torst[vcp:]},-')
            elif 9 < len(torst) < 13:
                newtotal = (f'Rp{torst[:Dcp]}.{torst[Dcp:pcp]}.{torst[pcp:vcp]}.{torst[vcp:]},-')
            elif len(torst) < 4:
                newtotal = (f'Rp{torst},-')
            elif len(torst) >= 13:
                print('Maaf, total harga tidak boleh lebih dari 1 triliun')
                back_to_menu()
            print('-'*30)
            print(f'total harga baru\t: {newtotal}')
            print('-'*30)
# -----------------------------------------------------------------------------------
# -----------------------------------------------------------------------------------
            uang = int(input('jumlah uang baru\t: Rp'))
            sina = str(uang)
            vasv = len(sina) - 3
            pasv = len(sina) - 6
            Dasv = len(sina) - 9
            if 3 < len(sina) < 7:
                newuang = (f'Rp{sina[:vasv]}.{sina[vasv:]},-')
            elif 6 < len(sina) < 10:
                newuang = (f'Rp{sina[:pasv]}.{sina[pasv:vasv]}.{sina[vasv:]},-')
            elif 9 < len(sina) < 13:
                newuang = (f'Rp{sina[:Dasv]}.{sina[Dasv:pasv]}.{sina[pasv:vasv]}.{sina[vasv:]},-')
            elif len(sina) < 4:
                newuang = (f'Rp{sina},-')
            elif len(sina) >= 13:
                print('Maaf! Uang harus dibawah 1 triliun!')
                back_to_menu()
            print('-'*30)
# -----------------------------------------------------------------------------------
# -----------------------------------------------------------------------------------
            kembalian2 = uang - total2
            rose = str(kembalian2)
            vga = len(rose) - 3
            pga = len(rose) - 6
            Dga = len(rose) - 9
            if 3 < len(rose) < 7:
                newkemb = (f'Rp{rose[:vga]}.{rose[vga:]},-')
            elif 6 < len(rose) < 10:
                newkemb = (f'Rp{rose[:pga]}.{rose[pga:vga]}.{rose[vga:]},-')
            elif 9 < len(rose) < 13:
                newkemb = (f'Rp{rose[:Dga]}.{rose[Dga:pga]}.{rose[pga:vga]}.{rose[vga:]},-')
            elif len(rose) < 4:
                newkemb = (f'Rp{rose},-')
# -----------------------------------------------------------------------------------
# -----------------------------------------------------------------------------------
            if uang < total2:
                print('maaf uang anda tidak cukup untuk melakukan transaksi')
                back_to_menu()
            else:
                print(f'kembalian\t\t: {newkemb}')
                jump = str(jumlah)
                print('-'*30)
                new_data.append({'no': no, 'nama': nama, 'jumlah': jump, 'harga': newharga,
                                'total': newtotal, 'total uang': newuang, 'kembalian': newkemb, 'date': date})
                i += 1
        else:
            new_data.append(urutan)
            i += 1
    if temp == new_data:
        print('nomor transaksi tidak ditemukan!')
        back_to_edit()
    while True:
        a = input('Yakin ingin mengubah transaksi? [y/t] ')
        if a == 'y':
            print('transaksi berhasil diubah')
            with open(
                    'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'w') as file_json:
                json.dump(new_data, file_json, indent=4)
            back_to_menu()
        elif a == 't':
            print('Ubah data Transaksi dibatalkan!')
            back_to_menu()
        else:
            print('perintah tidak ditemukan! Harap ulangi!')

# RIWAYAT TRANSAKSI


def view_transaksi():
    clear_screen()
    print('{0:^115s}'.format('RIWAYAT TRANSAKSI'))
    print('{0:^115s}'.format('='*70))
    print('\n')
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'r') as file_json:
        temp = json.load(file_json)
        print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
            'NO', 'NAMA BARANG', 'JUMLAH', 'HARGA BARANG', 'TOTAL HARGA', 'JUMLAH UANG', 'KEMBALIAN', 'TANGGAL'))
        print('='*125)
        for x in temp:
            print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
                x['no'], x['nama'], x['jumlah'], x['harga'], x['total'], x['total uang'], x['kembalian'], x['date']))
            print('-'*125)
    back_to_menu()

# HAPUS TRANSAKSI


def remove_transaksi():
    clear_screen()
    print('{0:^115s}'.format('HAPUS TRANSAKSI'))
    print('{0:^115s}'.format('='*70))
    new_data = []
    print('\n')
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'r') as file_json:
        temp = json.load(file_json)
        print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
            'NO', 'NAMA BARANG', 'JUMLAH', 'HARGA BARANG', 'TOTAL HARGA', 'JUMLAH UANG', 'KEMBALIAN', 'TANGGAL'))
        print('='*125)
        for x in temp:
            print('{0:2s} {1:15s} {2:8s} {3:20s} {4:20s} {5:20s} {6:20s} {7:10s}'.format(
                x['no'], x['nama'], x['jumlah'], x['harga'], x['total'], x['total uang'], x['kembalian'], x['date']))
            print('-'*125)

    print('\nnomor transaksi manakah yang ingin anda hapus?? \nketik cancel untuk membatalkan perubahan! ')
    hapus = input('pilih nomor transaksi : ')
    if hapus == 'cancel':
        print('perubahan dibatalkan')
        back_to_menu()
    while True:
        eren = input('Yakin ingin menghapus transaksi? [y/t] ')
        if eren == 'y':
            i = 0
            for urutan in temp:
                if urutan['no'] == hapus:
                    pass
                    i += 1
                else:
                    new_data.append(urutan)
                    i += 1
            if temp == new_data:
                print('Nomor transaksi tidak ditemukan!')
                back_to_delete()
            with open(
                    'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'w') as file_json:
                json.dump(new_data, file_json, indent=4)
            print('Transaksi berhasil dihapus!')
            back_to_menu()
        elif eren == 't':
            print('Transaksi batal dihapus!')
            back_to_menu()
        else:
            print('perintah tidak ditemukan! Harap ulangi!')

# TOTAL


def total():
    clear_screen()
    print('{0:^45s}'.format('TOTAL TRANSAKSI'))
    print('{0:^45s}'.format('='*40))
    print('\n')
    reiner = []
    with open(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\data_transaksi.json', 'r') as file_json:
        temp = json.load(file_json)
        print('TANGGAL\t\t  TOTAL')
        print('-'*40)
        for x in temp:
            erwin = x['total']
            print(f"{x['date']}\t: {x['total']}")
            if 8 < len(erwin) < 12:  # 1k - 100k
                c = len(erwin) - 6
                v = c + 1
                g = v + 3
                mikasa = (f'{erwin[2:c]}{erwin[v:g]}')
                armin = int(mikasa)  # integer
                reiner.append(armin)
            elif 12 < len(erwin) < 16:
                c = len(erwin) - 10
                v = c + 1
                g = v + 3
                o = g + 1
                h = o + 3
                mikasa = (f'{erwin[2:c]}{erwin[v:g]}{erwin[o:h]}')
                armin = int(mikasa)
                reiner.append(armin)
            elif len(erwin) < 8:  # 100
                c = len(erwin) - 2
                mikasa = (f'{erwin[2:c]}')
                armin = int(mikasa)
                reiner.append(armin)
            elif 16 < len(erwin) < 20:  # 1m - 100m
                c = len(erwin) - 14
                v = c + 1
                g = v + 3
                o = g + 1
                h = o + 3
                l = h + 1
                f = l + 3
                mikasa = (f'{erwin[2:c]}{erwin[v:g]}{erwin[o:h]}{erwin[l:f]}')
                armin = int(mikasa)
                reiner.append(armin)

        print('-'*39+'- +')
        jean = sum(reiner)
        rose = str(jean)
        vga = len(rose) - 3
        pga = len(rose) - 6
        Dga = len(rose) - 9

        if 3 < len(rose) < 7:
            newkemb = (f'Rp{rose[:vga]}.{rose[vga:]},-')
        elif 6 < len(rose) < 10:
            newkemb = (f'Rp{rose[:pga]}.{rose[pga:vga]}.{rose[vga:]},-')
        elif 9 < len(rose) < 13:
            newkemb = (f'Rp{rose[:Dga]}.{rose[Dga:pga]}.{rose[pga:vga]}.{rose[vga:]},-')
        elif len(rose) < 4:
            newkemb = (f'Rp{rose},-')
        print(f'Total\t\t: {newkemb}')
    back_to_menu()


if __name__ == '__main__':
    login()
