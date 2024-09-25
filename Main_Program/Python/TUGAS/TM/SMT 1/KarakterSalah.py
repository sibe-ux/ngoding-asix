total = 0
karaktersalah = []
while True:
    jumlah = int(input('masukkan jumlah barang : '))
    harga = int(input('masukkan harga barang : '))
    total = jumlah * harga
    while True:
        ulangi = input('apakah ada barang yang ingin dientrikan atau tidak? [y]/[t] ')
        if ulangi == 'y' or ulangi == 't':
            break
        else:
            karaktersalah.append(ulangi)
    if ulangi == 't':
        break
print('total harga adalah Rp.',total)
for x in range(0,len(karaktersalah)):
    print('karakter salah indeks ke '+str(x)+' adalah ',karaktersalah[x])


# jika menggunakan while

'''
count = 0
while count < len(karaktersalah):
    print(f'karakter salah indeks ke {count} adalah',karaktersalah[count])
    count += 1
'''
