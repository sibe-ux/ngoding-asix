def ben(x):
    ans = 0
    for i in range(x+1):
        ans = ans + i
    return ans

def ten(x):
    ans = 0
    for i in range(x+1):
        ans = ans + ben(i)
    return ans

print(ten(4))
print(ten(10))