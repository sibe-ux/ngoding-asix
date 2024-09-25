n = int(input())

result = 0
index = n
while index > 0:
    if index == n:
        numb = int(input())
        result = numb
        index -= 1
    else:
        numb = int(input())
        if numb % result == 0:
            result = numb
            index -= 1
        elif result % numb == 0:
            index -= 1
        else:
            result = numb * result
            index -= 1
            
print(result)
