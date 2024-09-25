# program untuk menampilkan semua bilangan prima pada interval tertentu

# versi 1
lower = 1
upper = 20
print('bilangan prima antara',lower,'dan',upper,': ')
for angka in range(lower,upper + 1):
    if angka > 1: # untuk memulai menampilkan angka
        for i in range(2,angka):
            if(angka % i) == 0:
               break
        else:
            print(angka)

# versi 2
# i = 2
# while(i < 20):
#     j = 2
#     while(j <= (i/j)):
#         if not(i%j): break
#         j = j + 1
#     if(j > i/j) : print(i,' is prime')
#     i = i + 1