e = int(input())
p = str(input())
for x in range(1,e+1):
    a = str(x)
    print(a*(x-1) + p + a*(e-x))