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

def path(limit,route,tampung,node):
    if limit==0:
        return ['X']
    else:
        for x in route:
            indeks = tampung.index(x)
            for y in tree[x]:
                tampung.insert(indeks+1,y)
                node.append(y)
                indeks+=1
        if len(node)>0:
            limit-=1
            if limit>0:
                path(limit=limit,route=node,tampung=tampung,node=[])
        return tampung

limit=2
print(*path(limit,['X'],['X'],[]),'\njumlah Y pada tree :',path(limit,['X'],['X'],[]).count('Y'))