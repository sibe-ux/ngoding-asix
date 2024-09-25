n = int(input())

def fibo(x, y, m):
    if m == 0:
        print(x)
    if m == 1:
        print(y)
    else:
        print(y)
        fibo(y, x+y, m-1)

fibo(0, 1, n)