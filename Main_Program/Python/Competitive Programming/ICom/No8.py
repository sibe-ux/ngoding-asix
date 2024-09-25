input()
n = str(input())

number = n.split()
indeks = 0
result = []
for x in range(len(number)):
    result.append(int(number[indeks]))
    indeks += 1

print(sum(result))