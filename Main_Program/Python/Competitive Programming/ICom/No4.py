input = input()

num1, op, num2 = input.split()

num1 = int(num1)
num2 = int(num2)

if op == "+":
    print(num1 + num2)
elif op == "-":
    print(num1 - num2)
elif op == "*":
    print(num1 * num2)
elif op == ">":
    if num1 > num2:
        print("BENAR")
    else:
        print("SALAH")
elif op == "<":
    if num1 < num2:
        print("BENAR")
    else:
        print("SALAH")
elif op == "=":
    if num1 == num2:
        print("BENAR")
    else:
        print("SALAH")