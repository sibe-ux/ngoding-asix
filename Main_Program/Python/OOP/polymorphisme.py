class Bird:
    def intro(self):
        print("There are different types of birds")

    def flight(self):
        print("Most of the birds can fly but some cannot")


class parrot(Bird):
    def flight(self):
        print("Parrots can fly")


class penguin(Bird):
    def flight(self):
        print("Penguins do not fly")


obj_bird = Bird()
obj_parr = parrot()
obj_peng = penguin()

obj_bird.intro()
obj_bird.flight()

obj_parr.intro()
obj_parr.flight()

obj_peng.intro()
obj_peng.flight()

# output
# There are different types of birds
# Most of the birds can fly but some cannot
# There are different types of bird
# Parrots can fly
# There are different types of birds
# Penguins do not fly

# looping polymorphism


class Hewan():
    def suara(self):
        print("Suara hewan")


class Kucing():
    def suara(self):
        print("Meow")

    def harapan_hidup(self):
        print("Harapan hidup kucing adalah 10 tahun.")

    def warna_tubuh(self):
        print("Warna tubuh kucing pada umumnya adalah kuning")


class Anjing():
    def suara(self):
        print("Woof")

    def harapan_hidup(self):
        print("Harapan hidup anjing adalah 15 tahun.")

    def warna_tubuh(self):
        print("Warna tubuh anjing pada umumnya adalah hitam")


obj1 = Kucing()
obj2 = Anjing()
for type in (obj1, obj2):  # creating a loop to iterate through the obj1, obj2
    type.harapan_hidup()
    type.warna_tubuh()

# output
# Harapan hidup kucing adalah 10 tahun.
# Warna tubuh kucing pada umumnya adalah kuning
# Harapan hidup anjing adalah 15 tahun.
# Warna tubuh anjing pada umumnya adalah hitam
