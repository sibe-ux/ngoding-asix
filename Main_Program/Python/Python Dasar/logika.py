# OPERASI LOGIKA ATAU BOOLEAN

# not, or, and, xor

# NOT
print('====NOT====')
a = False
c = not a 
print('data a =',a)
print('----------------NOT')
print('data c =',c)

# OR (jika salah satu true, maka nilainya true)
print("====OR====")
a = False
b = False
c = a or b 
print(a,'or',b,'=',c)
a = False
b = True
c = a or b 
print(a,'or',b,' =',c)
a = True
b = False
c = a or b 
print(a,' or',b,'=',c)
a = True
b = True
c = a or b 
print(a,' or',b,' =',c)

# AND (nilai hanya akan true jika semua true)
print("====AND====")
a = False
b = False
c = a and b 
print(a,'and',b,' =',c)
a = False
b = True
c = a and b 
print(a,'and',b,'  =',c)
a = True
b = False
c = a and b 
print(a,' and',b,' =',c)
a = True
b = True
c = a and b 
print(a,' and',b,'  =',c)

# XOR (nilai hanya akan true jika salah satu false)
print("====XOR====")
a = False
b = False
c = a ^ b 
print(a,'xor',b,' =',c)
a = False
b = True
c = a ^ b 
print(a,'xor',b,'  =',c)
a = True
b = False
c = a ^ b 
print(a,' xor',b,' =',c)
a = True
b = True
c = a ^ b 
print(a,' xor',b,'  =',c)