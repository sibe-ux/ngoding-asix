n = int(input())

result = int((n//2) + (n//3) + (n//4))
if n > result:
    print(n)
else:
    print(result)