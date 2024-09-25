#Nama :Betty Agustina Amanu
#NIM  :200108110025
#Kelas:Pemrograman Komputer B
#UAS-2

# n mempresentasikan jumlah segitiga
#panjang b untuk n+1 dicari dari hipotenusa segitiga n
#hipotenusa segitiga n = sqrt((b_n*2 + a*2))

#Mulai
from math import sqrt


print("  ")
print("     Menentukan Hipotenus     ")
print("==============================")

jawaban = "ya"
faktor = 0
while True:
    faktor += 1
    print()

    a = int(input("Masukkan panjang a   : "))
    b = int(input("Masukkan panjang b   : "))
    n = int(input("Masukkan segitiga ke-: "))

    def Cn(n,a,b):
        if n < 1:
            return b
        else:
            import math
            c1 = sqrt(a**2 + b**2)
            return Cn(n-1,a,b=c1)

    print(Cn(n,a,b))

    print()
    jawaban = input("Ingin mencari hipotenus lagi? ")
    if jawaban == "tidak":
        break

print()
print("---------Terima Kasih---------")
print()
#Selesai