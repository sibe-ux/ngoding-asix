# NO 1 ===============================================================

nilai = int(float(input("Nilai: ")))
huruf = str()
lulus = str()

if 90 <= nilai <= 100:
    huruf = "A"
    lulus = "Lulus"
elif 75 <= nilai <= 89:
    huruf = "B"
    lulus = "Lulus"
elif 60 <= nilai <= 74:
    huruf = "C"
    lulus = "Lulus"
elif 45 <= nilai <= 59:
    huruf = "D"
    lulus = "Tidak Lulus"
elif 0 <= nilai <= 44:
    huruf = "E"
    lulus = "Tidak Lulus"

if huruf:
    print(f"Kategori nilai adalah {huruf}\n"
          f"{lulus}")


# NO 2  ===============================================================

# NIM 192410102043 (12 digit)

nim = int(input("NIM: "))
prodi = str()

hasil_modulo = nim % 10000
hasil_bagi = hasil_modulo // 1000
print(hasil_bagi)

if hasil_bagi == 1:
    prodi = "Sistem Informasi"
elif hasil_bagi == 2:
    prodi = "Teknologi Informasi"
elif hasil_bagi == 3:
    prodi = "Informatika"

print(f"NIM {nim} adalah mahasiswa prodi {prodi}")


# NO 3  ===============================================================

angka = int(input("Nilai angka: "))
akar = int(input("Akar: "))

if akar == 2 or akar == 3:
    print(f"Akar {akar} dari {angka} adalah {angka ** (1/akar)}")

# NO 4  ===============================================================

roda = int(input("Kendaraan roda: "))
waktu = int(input("Waktu parkir (jam): "))
biaya = 0
denda = 0
total = 0

if roda == 2 or roda == 4:
    biaya = waktu * (roda * 1000)
    denda = ((waktu - 1) // 24) * 10000 if waktu > 24 else 0
    total = biaya + denda

    print(f"MALL XYZ\n"
          f"========\n"
          f"Kendaraan Roda {roda}\n"
          f"Waktu parkir: {waktu} jam\n"
          f"Biaya parkir: Rp {biaya}\n"
          f"Denda: Rp {denda}\n"
          f"Total: Rp {total}")

# NO 5  ===============================================================

angka_arab = int(input("Angka: "))

# I, II, III, IV, V, VI, VII, VIII, IX, X

if 1 <= angka_arab <= 3:
    print("I" * angka_arab)
elif angka_arab == 4:
    print("IV")
elif 5 <= angka_arab <= 8:
    print("V" + "I"*(angka_arab - 5))
elif angka_arab == 9 or angka_arab == 10:
    print("I" * (angka_arab % 2) + "X")
else:
    print("Invalid")