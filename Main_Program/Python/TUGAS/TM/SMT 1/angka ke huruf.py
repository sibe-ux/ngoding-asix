# latihan algo 1

a = float(input('Masukkan nilai Anda : '))

if(a >= 0 and a <= 40 or a > 40 and a < 41):
    print('kategori nilai Anda adalah E')
elif(a >= 41 and a <= 45):
    print('kategori nilai Anda adalah ED')
elif(a > 45 and a <= 50 or a > 50 and a < 51):
    print('kategori nilai Anda adalah D')
elif(a >= 51 and a <= 55 or a > 55 and a < 56):
    print('kategori nilai Anda adalah CD')
elif(a >= 56 and a <= 65 or a > 65 and a < 66):
    print('kategori nilai Anda adalah C')
elif(a >= 66 and a <= 70 or a > 70 and a < 71):
    print('kategori nilai Anda adalah BC')
elif(a >= 71 and a <= 75 or a > 75 and a < 76):
    print('kategori nilai Anda adalah B')
elif(a >= 76 and a <= 80):
    print('kategori nilai Anda adalah AB')
elif(a > 80 and a <= 100):
    print('kategori nilai Anda adalah A')
elif(a < 0):
    print('minimum angka yang dapat dimasukkan adalah 0')
elif(a > 100):
    print('maksimal angka yang dapat dimasukkan adalah 100')