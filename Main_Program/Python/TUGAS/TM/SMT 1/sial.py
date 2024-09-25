a = int(input('masukkan angka : '))
count = []
for x in range(a):
    userinput = int(input("masukkan angka ke-{} : ".format(x+1)))
    count.append(userinput)
    b = sum(count)
    if b == 13:
        print('sial')
        break
    a -= 1

if b != 13:
    print(b)