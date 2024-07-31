"""MyList = ["b", "a", "a", "c", "b", "a", "c", 'a']
res = {}

for i in MyList:
    res[i] = MyList.count(i)
    
print(res)"""

from collections import defaultdict
from math import gcd

# value = []
# n = int(input())
# gaguna = int(input())
# for x in range(1, n+1):
#     value.append(input().split())

# def nearlySimilarRectangles(sides):
#     MyList = []
#     for x in sides:
#         MyList.append(int(x[0])/int(x[1]))
#     res = {}
#     for i in MyList:
#         res[i] = MyList.count(i)
#     all_values = res.values()
#     return 0 if max(all_values) == 1 else sum([x*(x-1)/2 for x in all_values])

# print(nearlySimilarRectangles(value))


from collections import defaultdict
from math import gcd


def normalize(a, b):
    g = gcd(a, b)
    return (a // g, b // g)


def nearlySimilarRectangles(sides):
    ratio_count = defaultdict(int)
    pair_count = 0

    for a, b in sides:
        ratio = normalize(a, b)
        pair_count += ratio_count[ratio]
        ratio_count[ratio] += 1

    return pair_count


# Input handling
def main():
    import sys

    input = sys.stdin.read
    data = input().split()

    n = int(data[0])
    sides = []
    index = 2  # starting index of the sides array in the input data
    for i in range(n):
        a = int(data[index])
        b = int(data[index + 1])
        sides.append([a, b])
        index += 2

    result = nearlySimilarRectangles(sides)
    print(result)


if __name__ == "__main__":
    main()
