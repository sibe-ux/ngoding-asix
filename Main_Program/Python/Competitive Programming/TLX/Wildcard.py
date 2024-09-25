word = str(input())

first_word = word.split("*")[0]
last_word = word.split("*")[1]

result = []
number = int(input())
index = number
while index > 0:
    word1 = str(input())
    if word1.startswith(first_word):
        result.append(word1)
    elif word1.endswith(last_word):
        result.append(word1)
    elif word == "*":
        result.append(word1)
    index -= 1

print(*result,sep="\n")