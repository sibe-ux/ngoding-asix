# OPERASI ARITMATIKA

a = 10
b = 3

# operasi tambah +
hasil = a + b
print(a,'+',b,'=',hasil)

# operasi pengurangan -
hasil = a - b
print(a,'-',b,'=',hasil)

# operasi pengalian *
hasil = a * b
print(a,'*',b,'=',hasil)

# operasi pembagian /
hasil = a / b
print(a,'/',b,'=',hasil)

# operasi eksponen (pangkat) **
hasil = a ** b
print(a,'**',b,'=',hasil)

# operasi modulus %
hasil = a % b # sisa dari pembagian
print(a,'%',b,'=',hasil)

# operasi floor division //
hasil = a // b # sama seperti pembagian tapi dibulatkan ke bawah
print(a,'//',b,'=',hasil)

# prioritas operasi, operasional precedence
'''
    1. ()
    2. eksponen **
    3. perkalian dll * / ** % //
    4. pertambahan pengurangan + -
'''
x = 3
y = 2
z = 4
hasil = x ** y * z + x / y - y % z // x
print(x,'**',y,'*',z,'+',x,'/',y,'-',y,'%',z,'//',x,'=',hasil)
# kurung akan dihitung paling pertama
hasil = x ** y * (z + x) / y - y % z // x
print(x,'**',y,'*',z,'+',x,'/',y,'-',y,'%',z,'//',x,'=',hasil)

print("==== without () ====")
hasil = x + y * z
print(x,'+',y,'*',z,'=',hasil)

print("==== with () ====")
hasil = (x + y) * z
print('(',x,'+',y,') *',z,'=',hasil)

