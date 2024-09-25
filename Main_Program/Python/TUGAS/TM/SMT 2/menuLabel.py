listt = []
final_id = [] # [1,2,3,6,5,4]
fix = [] # [menu 1,.....menu 2,............menu 3, menu 4]
trash_par = [] # [1,1,2,3,2,4]
# 1        
#...2
#.....3
#.......6
#.....5
# 4
def final1(x,f,z): # 4 1 1
    parnt = x-(f) # 0 0 1 2 
    listt.sort() # [[0,'1',menu 1],[0,'4',menu 4],[1,'2',menu 2],[2,'3',menu 3],[2 '5' menu 5]]
    if f > 0:
        if listt[parnt][0] == '0':
            trash_par.append(listt[parnt][1])
            final_id.append(listt[parnt][1])
            fix.append(listt[parnt][2])
            final1(x,f-1,z)
        elif listt[parnt][0] not in trash_par:
            ef = listt[parnt][0] # 2
            ex = final_id.index(ef) # 1
            trash_par.insert(ex+1,listt[parnt][0])
            final_id.insert(ex+1,listt[parnt][1])
            fix.insert(ex+1,'.'*((z+1)*5)+listt[parnt][2])
            final1(x,f-1,z+1)
        elif listt[parnt][0] in trash_par:
            ef = listt[parnt][0] # 2
            ex = trash_par.index(ef) # 2
            sam = trash_par.count(ef) # 1
            final_id.insert(ex+sam,listt[parnt][1]) 
            trash_par.insert(ex+sam,listt[parnt][0])
            fix.insert(ex+sam,'.'*(z*5)+listt[parnt][2])
            final1(x,f-1,z)
    else:
        print('\n')
        print('\n'.join(fix))

def menu(a,x):
    if x == 0:
        exit
    elif a > x:
        final1(x,x,1)
    elif a > 0:
        print(f'ID : {a}')
        par = str(input('parent : '))
        if par >= str(a):
            print('parent harus < ID')
            menu(a,x)
        else:
            label = str(input('label : '))  
            listt.append([par,str(a),label]) 
            menu(a+1,x)
menu(1,int(input('jumlah menu : ')))