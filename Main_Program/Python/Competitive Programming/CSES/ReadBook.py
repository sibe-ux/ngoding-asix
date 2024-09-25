n = int(input())
y = str(input())
result =  y.split()
if len(result) > 1:
    if len(set(result)) <2:
        print(n*max(list(map(int, result))))
    else:
        print(max(list(map(int, result)))*2)
else:
    print(n*max(list(map(int, result))))