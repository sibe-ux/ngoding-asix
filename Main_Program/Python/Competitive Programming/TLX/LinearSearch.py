n = str(input())

numb = n.split()
index = int(numb[0])
result = []

while index > 0:
    result.append(int(input()))
    index -= 1

if int(numb[1]) in result:
    print(result.index(int(numb[1])))
else:
    print(-1)