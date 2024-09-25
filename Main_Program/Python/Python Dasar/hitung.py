# LATIHAN HITUNG SEDERHANA
# Latihan konversi satuan temperatur 

#  A. program konversi celcius ke satuan lain

print("\nPROGRAM KONVERSI TEMPERATUR\n")

print("===CELCIUS TO OTHER===")

celcius = float(input('masukkan suhu dalam celcius : '))
print("suhu adalah",celcius,"celcius")

# reamur
reamur = (4/5) * celcius
print("suhu dalam reamur adalah",reamur,"reamur")

# fahrenheit
fahrenheit = ((9/5 ) * celcius) + 32
print("suhu dalam fahrenheit adalah",fahrenheit, "fahrenheit")

# kelvin
kelvin = celcius + 273
print("suhu dalam kelvin adalah",kelvin, "kelvin")


# B. konversi fahrenheit ke kelvin

print("\n===FAHRENHEIT TO KELVIN===")
fahrenheit = float(input('masukkan suhu dalam fahrenheit : '))
print("suhu adalah",fahrenheit, "fahrenheit")
celcius = 5/9 * (fahrenheit - 32)
kelvin = celcius + 273
print("suhu dalam kelvin adalah",kelvin, "kelvin")


# C. konversi kelvin ke fahrenheit

print("\n===KELVIN TO FAHRENHEIT===")
kelvin = float(input('masukkan suhu dalam kelvin : '))
print("suhu adalah",kelvin, "kelvin")
celcius = kelvin - 273
fahrenheit = ((9/5) * celcius) + 32
print("suhu dalam fahrenheit adalah",fahrenheit, "fahrenheit")