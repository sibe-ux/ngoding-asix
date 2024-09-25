angka = int(input("Angka : "))

if angka <= 3 :
    print ("I" * angka)
elif angka == 4 :
    print ("IV")
elif angka >= 5 and angka <9:
    print ("V",(angka - 5)*"I")
elif angka == 9 :
    print ("IX")
elif angka == 10 :
    print ("X")
