roda = int(input('kendaraan roda (2/4) : '))
waktu = int(input('lama parkir (jam) : '))
rego_ban2 = waktu * 2000
rego_ban4 = waktu * 4000
denda = (waktu // 24) * 10000
denda1 = denda - 10000
total2 = rego_ban2 + denda
total4 = rego_ban4 + denda

print('\nMall XYZ')
print('-' * 40)
print('kendaraan anda beroda',roda)
print('Anda parkir selama',waktu,'jam')
if(roda == 2):
    print('biaya parkir Anda sebesar',rego_ban2,"rupiah")
elif(roda == 4):
    print('biaya parkir Anda sebesar',rego_ban4,'rupiah')
if(waktu % 24) == 0:
    print('denda = ',denda1,'rupiah')
elif(waktu > 24):
    print('denda = ',denda,'rupiah')
elif(waktu <= 24):
    print('denda = 0 rupiah')
print('-' * 40)
if(roda == 2):
    print('total : ',total2,'rupiah')
elif(roda == 4):
    print('total : ',total4,'rupiah')