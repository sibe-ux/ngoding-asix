from tracemalloc import start


numb = str(input())

split_numb = numb.split()

index = int(split_numb[1])
start = int(split_numb[0])
while index > 0:
    print(start)
    start+=int(split_numb[2])
    index-=1