import numpy as np

# list python
a = [1, 2, 3, 4, 5]
b = [6,7,8,9,10]

# array numpy
anp = np.array([1,2,3,4,5])
bnp = np.array([6,7,8,9,10])

# elementwise operation
# penjumlahan
hasil = a + b
# [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
hasil = anp + bnp
# [ 7  9 11 13 15]

# pengurangan
# hasil = a - b (error)
hasil = anp - bnp # [ -5 -5 -5 -5 -5]

# perkalian
# hasil = a * b (error)
hasil = anp * bnp # [ 6  14  24  34  44]

# pembagian
# hasil = a / b (error)
hasil = anp / bnp 
# [ 0.16666667  0.33333333  0.5         0.66666666  0.83333333]

# kuadrat
hasil = anp ** 2 # [ 1  4  9 16 25]

# multidimensi array numpy
c = np.array([[1, 2, 3], [4, 5, 6]])
d = np.array([[7,8,9], [-1, -2, -3]])

hasil = c + d 
# [[ 8  9 10] 
# [ 3  5  7]]
hasil = c * d 
# [[  7  16  27] 
# [ -4 -10 -18]]
print(hasil)
print(hasil)