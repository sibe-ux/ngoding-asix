word = str(input())

list = []
split_word = word.split()
list.append(split_word[0])
list.append(split_word[1])
list.append(split_word[2])

if list[1] == "+":
    print(int(list[0]) + int(list[2]))
elif list[1] == "-":
    print(int(list[0]) - int(list[2]))
elif list[1] == "*":
    print(int(list[0]) * int(list[2]))
elif list[1] == "<":
    if int(list[0]) < int(list[2]):
        print("benar")
    else:
        print("salah")
elif list[1] == ">":
    if int(list[0]) > int(list[2]):
        print("benar")
    else:
        print("salah")
elif list[1] == "=":
    if int(list[0]) == int(list[2]):
        print("benar")
    else:
        print("salah")