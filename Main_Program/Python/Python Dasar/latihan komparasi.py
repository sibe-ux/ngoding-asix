# latihan logika dan komparasi

# Membuat gabungan area rentang rentang angka

# +++++++++3--------------10+++++++++++

inputUser = float(input("masukkan angka yang bernilai \nkurang dari 3 \natau \nlebih dari 10 \n:"))

# +++++++3-------------------
# memeriksa angka kurang dari 3
isKurangDari = (inputUser < 3)
print("kurang fari 3 =", isKurangDari)

# --------------10+++++++++++
# memeriksa angka lebih dari 10
isLebihDari = (inputUser > 10)
print("lebih dari 10 =", isLebihDari)

# +++++++++3--------------10+++++++++++
isCorrect = isKurangDari or isLebihDari
print("amgka yang anda masukkan: ", isCorrect)


# ---------3+++++++++10--------
# kasus irisan
print("\n",10*"=", "\n")
inputUser = float(input("masukkan angka yang bernilai \nlebih dari 3 \ndan \nkurang dari 10 \n:"))

# ----------3+++++++++
# lebih dari 3
isLebihDari = inputUser > 3
print("lebih dari 3 =", isLebihDari)

# +++++++++10---------
# kurang dari 10
isKurangDari = inputUser < 10
print("kurang dari 10 =", isKurangDari)
 
# ---------3+++++++++10--------
isCorrect = isKurangDari and isLebihDari
print("amgka yang anda masukkan: ", isCorrect)


# PR gabungan komparasi dan logika
# --------0++++++++5----------8++++++++11--------
print("\n",10*"=", "\n")
inputUser = float(input("masukkan angka yang bernilai \nlebih dari 0 \ndan \nkurang dari 5 \natau \nlebih dari 8 \ndan \nkurang dari 11 \n:"))

# ----------0+++++++++
# lebih dari 0
isLebihDari = inputUser > 0
print("lebih dari 0 =", isLebihDari)

# +++++++++5---------
# kurang dari 5
isKurangDari = inputUser < 5
print("kurang dari 5 =", isKurangDari)


#  --------0++++++++5----------
isCorrect = isKurangDari and isLebihDari
print("amgka yang anda masukkan: ", isCorrect)


# ----------8+++++++++
# lebih dari 8
isLebihDari = inputUser > 8
print("lebih dari 8 =", isLebihDari)

# +++++++++11---------
# kurang dari 11
isKurangDari = inputUser < 11
print("kurang dari 11 =", isKurangDari)

#  --------8++++++++11----------
isCorrect = isKurangDari and isLebihDari
print("amgka yang anda masukkan: ", isCorrect)


# +++++++++0----------5+++++++++8---------11++++++++++++
print("\n",10*"=", "\n")
inputUser = float(input("masukkan angka yang bernilai \nkurang dari 0 \natau \nlebih dari 5 \natau \nkurang dari 8 \natau \nlebih dari 11 \n:"))


# +++++++0-------------------
# memeriksa angka kurang dari 0
isKurangDari = (inputUser < 0)
print("kurang fari 0 =", isKurangDari)

# --------------5+++++++++++
# memeriksa angka lebih dari 5
isLebihDari = (inputUser > 5)
print("lebih dari 5 =", isLebihDari)

# +++++++++0--------------5+++++++++++
isCorrect = isKurangDari or isLebihDari
print("amgka yang anda masukkan: ", isCorrect)

# +++++++8-------------------
# memeriksa angka kurang dari 8
isKurangDari = (inputUser < 8)
print("kurang fari 8 =", isKurangDari)

# --------------11+++++++++++
# memeriksa angka lebih dari 11
isLebihDari = (inputUser > 11)
print("lebih dari 11 =", isLebihDari)

# +++++++++8--------------11+++++++++++
isCorrect = isKurangDari or isLebihDari
print("amgka yang anda masukkan: ", isCorrect)