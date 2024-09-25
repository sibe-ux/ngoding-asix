def recursive(n):
    if n < 1:
        return 0
    else:
        print(n)
        recursive(n-1)

recursive(10)