from itertools import permutations

list = []
value = int(input())
for x in range(1,value+1):
    list.append(x)

perm = permutations(list,value)

perm_list = []
for i in perm:
    perm_list.append(i)

count = 0
for x in perm_list:
    temp = 0
    indeks = 0
    values = False
    for i in x:
        if temp == 0:
            temp = i
        else:
            if i - temp == 1 or temp - i == 1:
                count += 1
                break
            else:
                temp = i
                indeks+=1
        if indeks == value-1:
            values = True
            break
    if values:
        print(*x)
        break
    elif count == len(perm_list)-1:
        print("NO SOLUTION")
        break