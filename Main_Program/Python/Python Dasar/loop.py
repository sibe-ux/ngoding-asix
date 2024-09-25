# LOOP PYTHON

# ada 3 macam : while loop, for loop, nested loop

print("\n=====while loop=====")
# penggunaan while loop (untuk memanjangkan angka hingga batas yg ditentukan)
count = int(input('masukkan nilai: '))
while(count < 9): #batas angka
    print('the count is: ',count)
    count = count + 1 # seperti beda dalam barisan aritmatika

print("\n=====for loop=====")
# penggunaan for loop
# for sederhana
# untuk memanjangkan angka sesuai dari data
angka = [1,2,3,4,5]
for x in angka:
    print(x) 
for y in angka:
    print(y)
    
# pengulangan for
buah = ["nanas", "apel", "jeruk"]
for makanan in buah:
    print("saya suka makan: ",makanan)


print("\n=====for loop=====")
# penggunaan nested loop/ loop bersarang/ ada loop di dalam loop
# bilangan prima
i = 3
while(i < 50):
    j = 2
    while(j <= (i/j)):
        if not(i%j): break
        j = j + 1
    if(j > i/j) : print(i,' is prime')
    i = i + 1

