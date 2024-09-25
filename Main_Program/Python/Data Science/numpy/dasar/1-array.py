import numpy as np

# membuat vector
a = np.array([1, 2, 3, 4, 5])
# jika membuat array dengan salah satu value float,
# maka semua value akan diubah menjadi float
b = np.array([1.5 , 2.5 , 3 , 4 , 5])

# membuat vector dengan range
c1 = np.arange(1, 10, 1)
c = np.arange(1, 10, 2)

# membuat linspace
# linspace akan membuat array dengan 5 value
d = np.linspace(1, 10, 5)

# array multi dimensi / matrix
e = np.array([[1, 2, 3], [4, 5, 6]])

# matrix dengan nilai 0
f = np.zeros((3, 3))

# matrix dengan nilai 1
g = np.ones((3, 3))

# matrix dengan nilai random
h = np.random.random((3, 3))

# matrix identitas
i = np.eye(3)
j = np.identity(3)