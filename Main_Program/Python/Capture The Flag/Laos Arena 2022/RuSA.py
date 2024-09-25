from functools import reduce
from math import ceil, floor, gcd
from numbers import Integral
from random import randint
from random import random_prime
from termios import CRTSCTS
from sklearn import random_projection
from Crypto.Util.number import long_to_bytes, bytes_to_long



nbits = 1024
e = 5
flag = open("flag.txt").read().strip()
assert len(flag) <= 64
m = Integral(int(flag.encode('hex'),16))
out = open("data.txt","w")

for i in range(e):
    while True:    
        p = random_projection(2^floor(nbits/2)-1, lbound=2^floor(nbits/2-1), proof=False)
        q = random_prime(2^floor(nbits/2)-1, lbound=2^floor(nbits/2-1), proof=False)
        ni = p*q
        phi = (p-1)*(q-1)
        if gcd(phi, e) == 1:
            break

    while True:
        ai = randint(1,ni-1)
        if gcd(ai, ni) == 1:
            break

    bi = randint(1,ni-1)
    mi = ai*m + bi
    ci = pow(mi, e, ni)
    out.write(str(ai)+'\n')
    out.write(str(bi)+'\n')
    out.write(str(ci)+'\n')
    out.write(str(ni)+'\n')

def main():
    import codecs
    with codecs.open("data.txt", "r") as input_file:
        data = [int(c) for c in input_file.readlines()]
        a = [data[i * 4] for i in range(5)]
        b = [data[i * 4+1] for i in range(5)]
        c = [data[i * 4+2] for i in range(5)]
        ns = [data[i * 4 + 3] for i in range(5)]
        t = []
        for n in ns:
            other_moduli = [x for x in ns if x != n]
            t.append(CRTSCTS([1, 0, 0, 0, 0], [n]+other_moduli))
        N = reduce(lambda x, y: x*y, ns)
        e = 5
        P.< x > = PolynomialRing(Zmod(N), implementation='NTL')
        pol = 0
        for i in range(5):
            pol += t[i]*((a[i]*x+b[i]) ^ e - c[i])
        dd = pol.degree()
        if not pol.is_monic():
            leading = pol.coefficients(sparse=False)[-1]
            inverse = inverse_mod(int(leading), int(N))
            pol *= inverse
        beta = 1
        epsilon = beta / 7
        mm = ceil(beta**2 / (dd * epsilon))
        tt = floor(dd * mm * ((1/beta) - 1))
        XX = ceil(N**((beta**2/dd) - epsilon))
        roots = pol.small_roots()
        for root in roots:
            print(long_to_bytes(root))


main()
