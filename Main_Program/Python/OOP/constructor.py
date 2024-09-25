class Cat:
    def __init__(self, name, color):  # menginisialisasi instance dengan constructor
        self.name = name
        self.color = color


# membuat instance dari kelas Cat dengan nama nabi dan warna hitam
nobi = Cat('nobi', 'black')
nero = Cat('nero', 'white')

print(nobi.name)
print(nobi.color)
print(nero.name)
print(nero.color)

# output
# nobi
# black
# nero
# white
