# from itertools import permutations

# numbers_str = input()
# numbers_list = [int(num) for num in numbers_str.split()]

# perm = permutations((numbers_list))

# result = []
# for x in perm:
#     result.append(list(x))

# print(result)

# x = int(input())
# y = int(input())
# m = int(input())

# print(int((y/m)+1))

papanl = []
papan = input()
for x in papan:
    papanl.append(x)
ball = input()
for x in ball:
    papanl.append(x)

warna = ['P','M',"B",'K','H']
for x in warna:
    papanl.count(x)
    if papanl.count(x) < 1:
        continue
    elif papanl.count(x) % 3 != 0 and papanl.count(x) > 0:
        print('LOSE')
        break
    
    


