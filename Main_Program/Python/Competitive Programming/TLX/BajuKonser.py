from posixpath import split


numb = str(input())

split_numb = numb.split()

if (int(split_numb[0]) <= 10 and int(split_numb[1]) <= 40 and int(split_numb[2]) <= 90):
    print("S")
elif (int(split_numb[0]) <= 14 and int(split_numb[1]) <= 60 and int(split_numb[2]) <= 120):
    print("M")
elif (int(split_numb[0]) <= 18 and int(split_numb[1]) <= 80 and int(split_numb[2]) <= 180):
    print("L")
elif (int(split_numb[0]) <= 25 and int(split_numb[1]) <= 100 and int(split_numb[2]) <= 220):
    print("X")
else:
    print("X")