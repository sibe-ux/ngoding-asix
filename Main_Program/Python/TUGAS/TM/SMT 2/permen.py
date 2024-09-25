def lolipop(n,harga=0,tukar=0,uang=0):
    if n > 0:
        harga = float(input('Harga permen : '))
        tukar = int(input('Jumlah tukar : '))
        uang = float(input('jumlah uang : '))
        lolipop(n-1,harga,tukar,uang)
    else:
        sum_lolipop = uang // harga
        sum_tukar = sum_lolipop // tukar
        sum_total = sum_lolipop + sum_tukar
        print(f'total permen yang dimiliki pembeli : {int(sum_total)}')
        return
lolipop(1)