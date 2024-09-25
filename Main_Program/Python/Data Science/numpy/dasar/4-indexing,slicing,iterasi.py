import numpy as np

a = np.arange(10)**2

print(a)

# mengambil nilai
print('element ke 3 dari a adalah',a[2])
print('element terakhir dari a adalah',a[-1])

# slicing
print('element ke 3 sampai dengan element ke 6 dari a adalah',a[2:6])
print('element dari 4 sampai akhir',a[4:])
print('element dari awal sampai ke 5',a[:5])

# iterasi
for i in a:
    print('value',i)