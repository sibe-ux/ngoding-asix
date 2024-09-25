from itertools import combinations
import json
import os
from datetime import datetime

data = []
nama = []

with open('undelivered.json') as file :  
    see = json.load(file)["Data Barang yang Belum Dikirim"]    
    for a in see:
        data.append(a)
        nama.append(a['Nama Barang'])

combname = []
indeks = 1
while indeks <= len(nama):
    coname = combinations(nama,indeks)
    for x in coname:
        combname.append(list(x))
    indeks+=1

[('kasur', 'sapu'), ('kasur', 'pen'), ('sapu', 'pen'), ('kasur', 'sapu', 'pen')]

value = []
berat = []
value_sementara = []
berat_sementara = []
ind = 0
while ind < len(combname):
    for x in data:
        if x['Nama Barang'] in combname[ind]:
            value_sementara.append(int(x['Nilai Barang']))
            berat_sementara.append(int(x['Berat Barang']))
    value.append(([sum(value_sementara),sum(berat_sementara)]+combname[ind]))
    del value_sementara[::]
    del berat_sementara[::]
    ind+=1

fix = []
for x in value:
    if x[1] <= 8:
        fix.append(x)
fix.sort()
print('Barang Yang Dikirim :')
for x in data:
    if x['Nama Barang'] in fix[-1]:
        print(x)

print(fix[-1])

        
