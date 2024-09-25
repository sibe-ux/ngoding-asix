from datetime import datetime as dt
import json

with open('dictionary.json', 'r') as file:
    data = json.load(file)
item = dict()
data = list()
item['nama'] = input('masukkan nama : ')
item['jumlah'] = 1
item['harga'] = 10000
item['date'] = dt.now().strftime('%y-%m-%d')

data.append(item)

with open('dictionary.json','w') as file:
    json.dump(data, file, indent=4)

