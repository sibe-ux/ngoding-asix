from unittest import result

result = []
x,y = map(int, input().split())

index = x
selisih = y
while index > 0:
    numb = int(input())
    if abs(numb - y) <= selisih or abs(y - numb) <= selisih:
        selisih = min(abs(numb - y), abs(y - numb))
        result.append(numb)
    index -= 1

result.sort()
print(*result,sep="\n")