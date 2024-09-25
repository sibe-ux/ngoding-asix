from itertools import permutations

def tsp(indeks=1,node=[],perm=[]):
    graf = [[0, 10, 15, 20],
            [5, 0, 9, 10],
            [6, 13, 0, 12],
            [8, 8, 9, 0]]
    if indeks < len(graf):
        node.append(indeks)
        tsp(indeks+1,node,perm)
    else:
        path = permutations(node)
        for x in path:
            perm.append(x)
        count(perm,graf,len(perm))

def count(path,graf,default,s=0,current=0,root=0,sum=[]):
    if default > 0:
        if s >2:
            p = path[default-1][2]
            jarak = graf[p][0]
            jumlah = current + jarak
            sum.append(jumlah)
            print(path[default-1])
            print(f'current_cost : {jumlah}')
            print('----')
            count(path,graf,default-1,s=0,root=0)
        elif s < 4:
            otw = path[default-1][s]
            jarak = graf[root][otw]
            jumlah = current + jarak
            count(path,graf,default,s+1,root=otw,current=jumlah)
    else:
        print(f'----\n----\nShortest Path : {min(sum)}')

tsp()