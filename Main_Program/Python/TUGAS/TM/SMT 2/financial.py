import csv
from datetime import datetime as time
file = 'financial1.csv'

x = time.strptime("14/01/2014", "%d/%m/%Y")
y = time.strptime("09/09/2014", "%d/%m/%Y")

finance = []
country = []
product = []
specific_product = []
unit_sold = []
date = []


with open(file, mode="r", newline='') as csv_file:
    read = csv.DictReader(csv_file)
    for DataFin in read:
        finance.append(DataFin)

indeks = 0
for data in finance:
    if (data['Country'] == 'Canada'):
        country.append(finance[indeks])
    indeks += 1

""" indeks = 0
for data in finance:
    if (data['Product'] == 'Velo'):
        product.append(finance[indeks])
    indeks += 1 """

indeks = 0
for data in country:
    if time.strptime("14-01-2014", "%d-%m-%Y") >= data['Date'] <= time.strptime("09-09-2014", "%d-%m-%Y"):
        date.append(data[indeks])
    indeks += 1


for data in date:
    int_unit = float(data['Profit'])
    unit_sold.append(int_unit)

""" indeks = 0
for data in product:
    if (data == 'VTT'):
        specific_product.append(product[indeks])
    indeks += 1 """

a = len(unit_sold)
b = sum(unit_sold)
print(a)
print(b)
print(b/a)

