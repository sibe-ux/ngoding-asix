import csv 
import os
a = []
b = []
file = "read.csv"

def clear_screen(): 
    os.system('cls' if os.name == 'nt' else 'clear')
clear_screen()

#==================== dengan list
print('============== dengan list')
with open(file, mode = 'r') as baca:
    baca = csv.DictReader(baca)
    for x in baca:
        a.append(x)
print('nama nim nilai')
for i in a:
    print(f"{i['nama']} {i['nim']} {i['nilai']} ")

#===================== tanpa list
print('\n============== tanpa list')
with open(file, mode = 'r') as baca:
    baca = csv.DictReader(baca)
    for x in baca:
        print(x)

#===================== dengan list dan newline
print('\n============== dengan list dan newline')
with open(file, mode = 'r') as baca:
    baca = csv.DictReader(baca)
    for x in baca:
        b.append(x)
for i in b:
    print(f"\nnama : {i['nama']} \nnim : {i['nim']} \nnilai : {i['nilai']} ")
  
