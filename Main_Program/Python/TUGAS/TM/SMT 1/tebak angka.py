""" # tebak angka 
ab = 1
x = []
import random
a = random.randint (1, 10)
while True:
    b = int(input('masukkan angka : '))
    if b > 10 or b < 1:
        print("nilai yang dapat diinput hanya 1 - 10")
    elif b > a:
        print('angka terlalu besar')
        x.append(b)
    elif b < a:
        print('angka terlalu kecil')
        x.append(b)
    elif b == a:
        print("selamat anda berhasil menebak!! \nrandom angka : ",a)
        break
    if ab == 3:
        print(f'Game over!! \nangka anda = {x} \nrandom angka = {a}')    
        break
    ab +=1 """

# hitung karakter beda
teks = str(input('type here : '))
char = {0}
char2 = []
x = 0
y = 1
for z in range(len(teks)):
    char.add(teks[x:y].upper())
    x += 1
    y += 1
for s in char:
    if s == 0 or s == ' ':
        pass
    else:
        char2.append(s)
print(f'jumlah karakter unik : {len(char2)}')



