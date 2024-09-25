from itertools import permutations
n = int(input())
a = [0,0,0,0,1,1,1,1]
hasil = permutations(a,n)
b = {0}
for x in hasil:
    b.add(x)
b.remove(0)
for x in b:
    print(*x,sep='')