array = []
#total = 0
n = int(input("Masukkan banyaknya elemen array: "))
for x in range(n):
    nilai = float(input("Masukkan nilai ke-{} : ".format(x+1)))
    array.append(nilai)
print("\nHasil nilai total adalah : {}".format(sum(array)))
print("Hasil rata-rata adalah : {}".format(sum(array)/n))