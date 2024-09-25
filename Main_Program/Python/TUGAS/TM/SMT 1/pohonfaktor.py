print('program untuk mencari pohon faktor')

bilangan = int(input('masukkan angka : '))
hasil = []
len1 = {0}
len2 = []
for x in range(1,bilangan + 1):
    if x > 0:
        for y in range(1,bilangan+1):
            q = (F'{x} * {y} \t= {bilangan}')
            if x * y == bilangan:
                if x > y:
                    pass
                else:
                    hasil.append(q)
                    len1.add(x)
                    len1.add(y)
            else:
                pass
for z in hasil:           
    print(z)
for z in len1:
    if z == 0:
        pass
    else:
        len2.append(z)
len2.sort()
print(f'jumlah faktor bilangan : {len(len2)} {len2}')

