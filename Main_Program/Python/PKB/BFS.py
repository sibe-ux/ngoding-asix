tree = {
    'X' : ["A","B"],
    #leftside
    "A" : ["B_2","C"],
    "B_2" : ["D","Y"],
    "C" : ["Y"],
    "D" : [],
    #rightside
    "B" : ["A_2","Y"],
    "A_2" : ["D_2","E"],
    "E" : ["Y"],
    "D_2" : [],
    "Y" : []
}

def path(route,tampung,indeks):
    if len(route)>0:
        for x in route:
            indeks+=tree[x]
        tampung+=indeks
        path(route=indeks,tampung=tampung,indeks=[])
    else:
        print(*tampung,"\nJumlah Y pada tree :",tampung.count("Y"))

path(['X'],['X'],[])