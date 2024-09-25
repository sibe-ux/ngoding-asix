answer = "y"
total = 0
while answer != "t":
    if answer == "y":
        jumlah = int(input("masukkan jumlah barang : "))
        harga = int(input("masukkan harga barang : "))
        total += jumlah * harga
    answer = input ("apakah ada barang yg ingin ditambahkan (y/t) ?? ")
print(f"jumlah total harga : Rp. {total}")