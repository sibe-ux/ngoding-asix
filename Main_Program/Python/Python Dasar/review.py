# primitive variable
angka = 65 
kata = 'Hallo'
cacah = 65.6
huruf = ''

urutkan = [4, 5, 6, 7]

# Ascii
for i in range(65, 91):
    huruf += chr(i)

print(huruf)

chinta = 90
fakhrii = 80

# Swap variable
#? digunakan untuk menukar nilai dari beberapa variabel
temp = chinta
chinta = fakhrii
fakhrii = temp

chinta, fakhrii = fakhrii, chinta
# print(ord(kata[0]))
# print(chr(72))

# non primitive (reference variable)
myList = [66, 'halo', [['halo2', 'halo3'], {'dictionary': 'Hello'}], 65.5]
mydict = {'iniList': {
    'hargaRoti': 2000
}}
mySet = {1, 3, 6, 8, 8}
mySet2 = {1, 9}

# print(mydict['iniList']['hargaRoti'])

# percabangan 
# inputan = input('Masukkan nama: ')
# inputan2 = input('Masukkan nama 2: ')

# if inputan == '' or inputan2 == '':
#     print('Harap memasukkan nama')
# else:
#     if inputan == 'chinta' and inputan2 == 'handika':
#         print('asdos ga boleh pake program ini')
#     else:
#         print(f'{inputan}')

angka = 65

# if 50 < angka < 100:
#     print('angka lebih besar dari 50 dan kurang dari 100')
# else:
#     print('angka kurang dari 50')

# Perulangan
myTupple = (1, 2, 3)
myList2 = [1, 2, 3, [4, 5, 6]]

# for i in range(len(myList2)):
#     if i == 3:
#         for j in range(len(myList2[i])):
#             print(myList2[i][j])
#     else:
#         print(myList2[i])

# counter = 0
# while counter < len(myTupple):
#     print(myTupple[counter])
#     counter += 1

# function
#? satu bintang (*) untuk menghasilkan argumen berbentuk tupple
#? dua bintang (**) untuk menghasilkan argumen berbentuk dictionary (keyword arguments)

def fungsiBiasa(argumen):
    #blok kode yang akan dijalankan pada fungsi
    print(argumen)

fungsiBiasa('Hello!')

fungsi('Hello', 'World') #! akan menghasilkan error jika diberi parameter lebih dari satu

def fungsiTupple(*args):
    print(args)

fungsiTupple('Hello', 'World', 78) #! tidak akan menghasilkan error jika diberi parameter lebih dari satu

def pesan(**args):
    print(args)
    
# pesan(pertama='hello', kedua='world!', ketiga='!!!') 

# pesan(halo='world!')