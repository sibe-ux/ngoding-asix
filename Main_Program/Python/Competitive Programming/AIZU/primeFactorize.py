n = int(input('n = '))
temp = n


def prime(temp, x=2, dump=[]):
    for y in range(2, x):
        if (x % y) == 0:
            prime(temp, x+1, dump=dump)
            break
    else:
        if (temp % x) == 0:
            dump.append(str(x))
            temp /= x
            if temp > 1:
                prime(temp, x=2, dump=dump)
            else:
                print(f"{n}: {' '.join(dump)}")
                exit
        else:
            prime(temp, x+1, dump=dump)


prime(temp)
