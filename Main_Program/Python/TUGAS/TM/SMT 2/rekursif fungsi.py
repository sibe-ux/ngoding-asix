def sibe(n):
    print(n)
    if(n>0):
        sibe(n-1)
sibe(3)

def f(n):
    if n == 0:
        return 1
    else:
        return n * f(n-1)
print( f(3) )

def pangkat(n, p):
    if p == 0:
        return 1
    elif p > 0:
        return n * pangkat(n, p-1)
    else:
        return 1 / pangkat(n, 0-p)
print(pangkat(2,-1))

def fibo2(n):
    return fibonacci(0,1,n)

def fibonacci(x,y,n):
    if n == 0:
        return x
    elif n == 1:
        return y
    else:
        return fibonacci(y, x+y, n-1)
print(fibo2(6))
