import os
from datetime import datetime as time

new_data = 400123
new_list = 100000
new_math = new_data % new_list
modulus_value = str(new_math)

'''
print('tampilkan nilai modulus)
if modulus == new_data:
    while True:
        format_integer = new_list // new_math
        print('hasil bagi tidak dapat diproses)
else:
    break
'''
# MEMASUKKAN DATA
string_list = (['q', 'w', 'e', 'r', 't', 'y'], ['b', 'a', 'c', 'k'])
qwerty_string = string_list[1][1]
integer_Keys = string_list[1][0]
dictionary_data = string_list[1][2]

# MENAMPILKAN DATA
if __name__ == '__main__':
    access_code = qwerty_string + integer_Keys + dictionary_data + modulus_value
    print(f'kode akses M-Banking adalah {access_code}')

integer_mode = 900342
data_binary = integer_mode % new_list
indent_keys = str(data_binary)

valueTrue = 700169
valueFalse = not valueTrue
if valueFalse == False:
    appendData = valueTrue % new_list
    code_string = str(appendData)
    print(f'pin atm adalah {indent_keys + code_string}')
