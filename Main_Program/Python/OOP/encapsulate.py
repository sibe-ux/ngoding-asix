# single underscore
class Orang:
    def __init__(self, name, age=0):
        self.name = name
        self._age = age

    def tampilkan(self):
        print(self.name)
        print(self._age)


orang_obj = Orang('Budi', 30)

# mengakses melalui metode
orang_obj.tampilkan()

# mengakses langsung variable
print(orang_obj.name)
print(orang_obj._age)

# output
# Budi
# 30
# Budi
# 30
# Terlihat dari kode di atas bahwa kita tetap bisa mengakses langsung variable _age dari luar class menggunakan instance dari class tersebut.

# double underscore

# getter


class Orang:
    def __init__(self, name, age=0):
        self.name = name
        self.__age = age

    def tampilkan(self):
        print(self.name)
        print(self.__age)


orang_obj = Orang('Budi', 30)

# mengakses melalui metode
orang_obj.tampilkan()

# mengakses langsung variable
print(orang_obj.name)
print(orang_obj.__age)

# output
# Budi
# 30
# Budi
# Traceback (most recent call last):
#   File "test.py", line 17, in <module>
#     print(orang_obj.__age)
# AttributeError: 'Orang' object has no attribute '__age'


# setter
class Orang:
    def __init__(self, name, age=0):
        self.name = name
        self.__age = age

    def setAge(self, age):
        self.__age = age

    def tampilkan(self):
        print(self.name)
        print(self.__age)
        print("----------")


orang_obj = Orang('Budi', 30)

# mengakses melalui metode
orang_obj.tampilkan()

# mengubah data tanpa setter tidak memungkinkan
orang_obj.__age = 50
orang_obj.tampilkan()

# mengubah data harus memalui setter
orang_obj.setAge(27)
orang_obj.tampilkan()

# output
# Budi
# 30
# ----------
# Budi
# 30
# ----------
# Budi
# 27
# ----------
