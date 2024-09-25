a = int(input())
for x in range(0, a):
    woi = x + 1
    asap = str(a)
    xixi = str(woi)
    octal = format(x+1,'01o')
    hexa = format(x+1,'01x')
    binary = format(x+1,'01b')
    binarymax = format(a,'01b')
    hexaCS = hexa.upper()
    oc = len(octal)
    he = len(hexa)
    bir = len(binary)
    birymax = len(binarymax)
    lenmax = len(asap)
    lenx = len(xixi)
    dor = ' '
    
    print(f'{dor*(birymax-lenx) + xixi} {dor*(birymax-oc) + octal} {dor*(birymax-he) + hexaCS} {dor*(birymax-bir) + binary}')