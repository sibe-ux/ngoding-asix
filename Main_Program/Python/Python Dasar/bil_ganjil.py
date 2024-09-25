# menampilkan program bilangan ganjil

bb = 1 
ba = 20
print('bilangan ganjil antara',bb,'dan',ba,': ')
for angka in range(bb,ba + 1):
    if angka > 1:
        for i in range(angka):
            if(angka % 2) == 0 : break
        else:
            print(angka)