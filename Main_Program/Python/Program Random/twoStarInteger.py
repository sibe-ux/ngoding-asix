n = int(input('n : '))
for x in range(1,n+1):
    result = ''
    for i in range(1,n+4):
        if x < i < x+3:
            result+='*'
        else:
            result+=str(i)
    print(result)
