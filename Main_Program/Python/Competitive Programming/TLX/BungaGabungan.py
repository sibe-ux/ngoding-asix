bunga = str(input())

list = bunga.split()

if ((int(list[0])**2) + (int(list[1])**2) + 1) % 4 == 0:
    print((int(list[0])**2) + (int(list[1])**2) + 1) / 4
else:
    print(-1)