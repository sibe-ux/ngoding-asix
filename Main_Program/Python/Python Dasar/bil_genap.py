# program untuk menampilkan bilangan genap
# ba (batas atas), bb (batas bawah)

bb = 1
ba = 20
print('bilangan genap antara',bb,'dan',ba,": ")
for angka in range(bb,ba + 1):
    if angka > 1:
        for i in range(angka):
            if(angka % 2) == 1 : break
        else:
            print(angka)

bb = 1
ba = 20
print('bilangan genap antara',bb,'dan',ba,": ")
for angka in range(bb,ba + 1):
    if(angka % 2) == 1 : break
else:
    print(angka)