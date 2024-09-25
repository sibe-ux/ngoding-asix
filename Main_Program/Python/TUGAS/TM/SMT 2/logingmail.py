print('{0:8s} {1:12}'.format(' ','LOGIN GMAIL'))
# format berfungs untuk mencetak string sesuai syntax yang akan ditampilkan ke monitor
x = '-'
y = x.rjust(29,'-')
# rjust berfungsi menambah space kosong/berisi sebanyak n dimuali dari indeks -1
print(y)
email_list = []
while True:
    username = str(input('USERNAME : '))
    if username.startswith('@'):
        # string akan bernilai true jika indeks 0 sama dengan karakter yang diinput
        reverse = username[::-1]
        if reverse.index('@') >= 3:
            # mengetahui indeks dari karakter yang diiput
            break
        else:
            print('minimum karakter username adalah 3 karakter')
    else:
        print('username harus menggunakan @')
a = 0
while True:
    email = str(input('EMAIL : '))
    if '@gmail.com' in email:
        x = email.rpartition('@')
        # rpartition berfungsi membagi 3 bagi dari karakter paling kanan yang ditentukan
        # yaitu sebelum, karakter itu sendiri, dan sesudah
        email_list.append(x)
        y = email_list[a][0]
        a += 1
        if y.isalpha():
            break
        else:
            print('gunakan kombinasi huruf')
    else:
        print('mohon gunakan @gmail.com')
while True:
    password = str(input('PASSWORD : '))
    if len(password) < 8:
        print('password min 8 digit')
    else:
        x = str(input('CONFIRM PASSWORD : '))
        if x == password:
            print('Akun berhasil ditambahkan')
            break
        else:
            print('mohon masukkan password dengan benar')