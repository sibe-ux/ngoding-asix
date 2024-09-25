import math
x,y = map(int,input().split())
m,n = map(int,input().split())
o,p = map(int,input().split())

number = x /y
number2 = m / n
number3 = o / p

print(math.ceil(number))
print(math.ceil(number2))
print(math.ceil(number3))

