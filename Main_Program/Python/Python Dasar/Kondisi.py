# PENGGUNAAN IF, ELSE, ELIF

print('\n=====IF=====')

# if (jika nilai true, maka akan menampilkan if)
nilai = int(input('masukkan nilai: '))
if(nilai > 1):
    print('Selamat anda lulus')

print('\n=====IF ELSE=====')

# if else (jika nilai true maka akan if, jika false maka akan else)
nilai = int(input('masukkan nilai: '))
if(nilai > 3):
    print('anda lulus')
else:
    print('anda gagal')

print('\n=====ELIF=====')

# elif (sama seperti else, bedanya elif lebih banyak)
hari_ini = str(input('masukkan hari: '))
if(hari_ini == "senin"):
    print('aku akan kuliah')
elif(hari_ini == "selasa"):
    print('aku akan kuliah')
elif(hari_ini == "rabu"):
    print('aku akan kuliah')
elif(hari_ini == "kamis"):
    print('aku akan kuliah')
elif(hari_ini == "jumat"):
    print('aku akan kuliah')
elif(hari_ini == "sabtu"):
    print('aku akan kuliah')
elif(hari_ini == "minggu"):
    print('aku akan libur')

