import json
import os
from datetime import datetime
from itertools import combinations

lises = []
line = []
data = dict()

def cleanView():
    os.system('cls')

def back():
    print('\n')    
    input('\t\t\t\t\t\t>>> Click enter to back <<<')  
    menuUtama()

def menuUtama():
    cleanView()
    print('''
                ===     MAIN MENU     ===           
    = = = = = = = = = = = = = = = = = = = = = = = = =  
    =   1. Add New Items                  -->       =
    =   2. Undelivered Items              -->       =
    =   3. Delivered Items                -->       =
    =   0. Exit                           -->       =
    = = = = = = = = = = = = = = = = = = = = = = = = =
    = = =                                       = = =
                        = = = = =
    ''')

def read(): 
    line.clear()
    with open('undelivered.json') as file :  
        see = json.load(file)["Data Barang yang Belum Dikirim"]    
        for a in see:
            line.append(a)
        print('{:^100}'.format('Data Barang yang Belum Dikirim'))
        print(100*'-' + '\n')  
        for i in line:  
            log = ['Nama Barang      : ' + i['Nama Barang'], 'Berat Barang     : ' + i['Berat Barang'], 'Nilai Barang    : ' + i['Nilai Barang']]
    
            for x in log:
                print(x)
            print('\n' + 100*'-'+'\n')

def readDone(): 
    line.clear()
    with open('delivered.json') as file :  
        see = json.load(file)["Data Barang yang Telah Dikirim"]    
        for a in see:
            line.append(a)
        print('{:^100}'.format('Data Barang yang Telah Dikirim'))
        print(100*'-' + '\n')  
        for i in line:  
            log = ['Nama Barang      : ' + i['Nama Barang'], 'Berat Barang     : ' + i['Berat Barang'], 'Nilai Barang    : ' + i['Nilai Barang']]
    
            for x in log:
                print(x)
            print('\n' + 100*'-'+'\n')

def reader():
    with open('undelivered.json') as file :   
        data = json.load(file)        
    return data

def addItems():
    while True:
        confirm = input('\n Ingin Menambahkan Data? [y]/[n] \n')
        if confirm == 'y':
            item_name = input("Nama Barang: ")
            weight = input("Berat Barang: ")
            value = input('Nilai Barang: ')
            itemdata = {
                "Nama Barang"       : item_name,
                "Berat Barang"      : weight,       
                "Nilai Barang"      : (value)
            }
            lises = reader()["Data Barang yang Belum Dikirim"]
            lises.append(itemdata)
            data = {
                "Data Barang yang Belum Dikirim" : lises
            }

            with open('undelivered.json','w') as file:
                json.dump(data,file,indent=3)
            
            print("Item Sukses Ditambahkan")
        elif confirm == 'n':
            break

def knapsack(capacity):
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
                value_sementara.append(float(x['Nilai Barang']))
                berat_sementara.append(float(x['Berat Barang']))
        value.append(([sum(value_sementara),sum(berat_sementara)]+combname[ind]))
        del value_sementara[::]
        del berat_sementara[::]
        ind+=1
    global fix
    fix = []
    for x in value:
        if x[1] <= capacity:
            fix.append(x)
    fix.sort()
    print('Barang Yang Dikirim :')
    for x in data:
        if x['Nama Barang'] in fix[-1]:
            print(x)

    print(fix[-1])
    deletE()

def delete():
    temp = []
    update = {"Data Barang yang Belum Dikirim" : temp}      
    with open('undelivered.json') as file:     
        read = json.load(file)["Data Barang yang Belum Dikirim"] 
        for i in read:
            if i['Nama Barang'] == brng:
                continue
            elif i['Berat Barang'] == (brat):
                continue
            elif i['Nilai Barang'] == (nlai):
                continue
            else:
                temp.append(i)
            
    with open('undelivered.json', 'w') as file:  
        json.dump(update, file, indent = 3)

def deletE():
    temp=[]
    update = {"Data Barang yang Belum Dikirim" : temp}
    with open('undelivered.json') as file:
        read = json.load(file)["Data Barang yang Belum Dikirim"]      
        for u in read: 
            if u['Nama Barang'] in fix[-1]:
                pass
            else:
                temp.append(u)
            

    with open('undelivered.json', 'w') as file:  
        json.dump(update, file, indent = 3)

def rules():
    while True:
        choice = input("Pilih Menu : ")
        if choice == '1':
            cleanView()
            addItems()
            back()
        elif choice =='2':
            cleanView()
            read()
            x = input("Apakah anda ingin mengirimkan barang secara otomatis: [y]/[n] \n ")
            if x == 'y':
                capacity = int(input("Masukkan Kapasitas Pengiriman: "))
                knapsack(capacity)
                print("Item Berhasil Dikirim")
            else:
                pass
            back()
        elif choice == '3':
            cleanView()
            readDone()
            back()
        elif choice == '0':
            exit()
        else:
            print("Anda memilih menu yang salah!")
            back()

def loadingAccount():
    with open('user.json') as file:
        data = json.load(file)
    return data

def account(fix):   
    
    temp = []
    if fix == 'n':
        username      = input('Tuliskan Username      >>> ')
        password      = input('Tuliskan Password      >>> ')

        dataAkun = {
            "Username"        : username,
            "Password"        : password 
        }       

        temp = loadingAccount()["AKUN"]
        temp.append(dataAkun)   
        tambah = {
            "AKUN" : temp      
        }                                

        with open('user.json', 'w') as file :   
            json.dump(tambah, file, indent=3)  

def first():
    while True:
        tanya = input('Apakah sudah memiliki akun? [y] / [n]\n>>> ')
        if tanya == 'n':
            account(tanya)
            continue
        elif tanya == 'y':
            while True:
                print('-'*10+' LOGIN '+10*'-')
                username = input('Username : ')
                password = input('Password : ')
                with open('user.json') as file:     
                    read = json.load(file)["AKUN"] 
                    for x in read:
                        if username == x["Username"] and password == x["Password"]:
                            menuUtama()
                            rules()
                            break
                        else:
                            pass
first()

