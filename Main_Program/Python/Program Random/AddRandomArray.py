import random

array = []
length = 700

while len(array) != 700:
    number = random.randint(0, 700)
    if (number not in array):
        array.append(number)

print(array)
