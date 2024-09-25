import math

def segitiga(n,a,b):
    if n < 1:
        return b
    else:
        result = math.sqrt(a**2 + b**2)
        return segitiga(n-1,a,b=result)

print(segitiga(4,4,3))
