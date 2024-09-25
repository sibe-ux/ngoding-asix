# operasi yg dapat dilakukan dengan penyingkatan
# operasi tambah dengan assignment

a = 5
print("nilai a = ",a)
a += 1 # a = 5 + 1 = 6
print('a += 1 =',a) 

a = 5
print("nilai a = ",a)
a -= 1 # a = 6 - 1 = 5
print('a -= 1 =',a) 

a = 5
print("nilai a = ",a)
a *= 2 # a = 5 * 2 = 10
print('a *= 2 =',a) 

a = 5
print("nilai a = ",a)
a /= 2 # a = 10 / 2 = 5.00
print('a /= 2 =',a) 

# modulus & floor division
b = 10
print('\nnilai b =',b)

b %= 3 # b = 10 % 3 = 1
print('b %= 3 =',b)

b = 10
print('nilai b =',b)

b //= 3
print('b //= 3 =',b)

a = 2
print('\nnilai a =',a)
a **= 3
print('a **= 3 =',a)

# operasi bitwise
# or 
c = True
print('\nnilai c =',c)
c |= False
print('c |= false =',c)
c = False
print('nilai c =',c)
c |= False
print('c |= False =',c)

# and
c = True
print('\nnilai c =',c)
c &= False
print('c &= false =',c)
c = True
print('nilai c =',c)
c &= True
print('c &= true =',c)

# xor
c = True
print('\nnilai c =',c)
c ^= False
print('c ^= false =',c)
c = True
print('nilai c =',c)
c ^= True
print('c ^= true =',c)

# geser geser
d = 0b0100
print('\nnilai d =',format(d,"04b"))
d >>= 2
print('nilai d >>= 2 =',format(d,'04b'))
d = 0b0100
print('\nnilai d =',format(d,"04b"))
d <<= 1
print('nilai d <<= 1 =',format(d,'04b'))
