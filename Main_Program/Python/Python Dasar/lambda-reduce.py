from functools import reduce
# Returns the sum of two elements
def sumTwo(a,b):
    return a+b

result = reduce(sumTwo, [1, 2, 3, 4])
print(result)

#output
# 10

from functools import reduce # mengimport fungsi reduce

a = [1,2,3,4]
n = reduce(lambda x,y : x + y, a)
print(n)

#output
# 10