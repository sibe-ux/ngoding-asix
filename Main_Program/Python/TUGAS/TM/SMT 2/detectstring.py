# TUGAS 1
text = str(input('type here : '))
vouwels = ['a','i','u','e','o','A','I','U','E','O']
konsonan = ['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z']
konsonan_upper = []
for x in konsonan:
    konsonan_upper.append(x.upper())
consonant = []
count_vouwels = []
count_blank = []
count_consonant = []
a = 0
b = 1
for x in range(len(text)):
    if text[a:b] in vouwels:
        count_vouwels.append(x)
    if text[a:b] in konsonan or text[a:b] in konsonan_upper:
        count_consonant.append(text[a:b])
    if text[a:b] == ' ':
        count_blank.append(x)
    a += 1
    b += 1
print(f'vouwels = {len(count_vouwels)}') 
print(f'consonant = {len(count_consonant)}')
print(f'blank = {len(count_blank)}')


# TUGAS 2
text = str(input('type here : '))
word = []
uppercase = []
angka = ['1','2','3','4','5','6','7','8','9','0']
count_word = []
count_angka = []
count_upper = []
count_lower = []
a = 0
b = 1
for x in range(len(text)):
    word.append(text[a:b])
    uppercase.append(text[a:b].upper())
    a += 1
    b += 1
indeks = 0
for x in word:
    if x in angka:
        count_angka.append(x)
        continue
    if x == ' ':
        count_word.append(x)
        continue
    if x in uppercase:
        count_upper.append(x)
        continue
    if x in word:
        count_lower.append(x)
print(f'angka = {len(count_angka)}')
print(f'word = {len(count_word)+1}')
print(f'upper = {len(count_upper)}')
print(f'lower = {len(count_lower)}')


# TUGAS 3
text = str(input('type here : '))
word = []
upper = []
lower = []
finalword = []
a = 0
b = 1
for x in range(len(text)):
    word.append(text[a:b])
    upper.append(text[a:b].upper())
    lower.append(text[a:b].lower())
    a += 1
    b += 1
for x in word:
    if x in upper:
        finalword.append(x.lower())
        continue
    if x in lower:
        finalword.append(x.upper())
print(''.join(finalword))