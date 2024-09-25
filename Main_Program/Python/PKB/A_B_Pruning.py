def alpha(node, a=0, b=0, index=0):
    if index >= len(node)-1:
        print('The Value is : ', max(a, b))
        exit() 
    if (a == 0 and b == 0):
        alpha(node, a=min(node[0], node[1]), b=0, index=2)
    if index+1 <= 4:
        if a >= node[index]:
            alpha(node, a=0, b=a, index=index+2)
        else:
            alpha(node, a=0, b=max(a,min(node[index], node[index+1])), index=index+2)
    elif index+1 <= 6:
        if min(node[index], node[index+1]) >= b:
            alpha(node, a=b, b=0, index=index+4)
        else:
            alpha(node, a=min(node[index],node[index+1]), b=b, index=index+2)
    elif index+1 <= 8:
        if a >= node[index]: 
            alpha(node, a=max(a,node[index]), b=b, index=index+2)
        else:
            alpha(node, a=max(a,min(node[index],node[index])), b=b, index=index+2)
    elif index+1 <= 12:
        if a >= node[index]:
            alpha(node, a=a, b=b, index=index+2)
        else:
            alpha(node, a=a, b=max(min(node[index], node[index+1]), b), index=index+2)
    elif index+1 > 12:
        if a >= b:
            alpha(node, a=a, b=b, index=index+3)
        else:
            if a >= node[index]:
                alpha(node, a=a, b=node[index], index=index+2)
            else:
                alpha(node, a=min(min(node[index], node[index+1]),b), b=b, index=index+1)

alpha([8,  7,  3, 9,  9,  8,  2, 4, 1, 8,  8,  7,  9, 9, 3,  4])
# alpha([10, 11, 9, 12, 14, 15, 13, 14, 15, 2, 4, 1, 3, 22, 24, 25])
# alpha([11, 12, 9,  2, 15, 16, 1, 2, 3, 4,  1,   7, 5, 2, 7,  9])
# alpha([10, 5,  7, 11, 12, 8,  9, 8, 5, 12, 11, 12, 9, 8, 7, 10])
# alpha([10, 11, 9, 9,  14, 15, 2, 4, 5, 1,  4,  7,  9, 9, 3,  4])
# alpha([7, 9, 6, 5, 11, 12, 6, 2, 5, 8, 4, 7, 2, 1, 8, 9])
# alpha([6, 5, 2, 6, 4, 7, 2, 2, 5, 6, 1, 5, 3, 9, 2, 6])
# alpha([30, 40, 30, 20, 70, 60, 90, 50, 30, 10, 70, 80, 80, 90, 50, 60])
# alpha([2,  8, 3, 1,   6,  9, 8, 9, 3,10,  2, 14, 16, 8,15, 18])
# alpha([24,-10,-33,-18,40,35,5,41,-40,-21,17,23,-36,17,49,-37])

# [10, 11, 9, 12, 14, 15, 13, 14, 15, 2, 4, 1, 3, 22, 24, 25] = 10
# [11, 12, 9,  2, 15, 16, 1, 2, 3, 4,  1,   7, 5, 2, 7,  9]   = 11
# [10, 5,  7, 11, 12, 8,  9, 8, 5, 12, 11, 12, 9, 8, 7, 10]   = 8
# [10, 11, 9, 9,  14, 15, 2, 4, 5, 1,  4,  7,  9, 9, 3,  4]   = 10
# [7, 9, 6, 5, 11, 12, 6, 2, 5, 8, 4, 7, 2, 1, 8, 9]          = 7
# [6, 5, 2, 6, 4, 7, 2, 2, 5, 6, 1, 5, 3, 9, 2, 6]            = 4
# [30, 40, 30, 20, 70, 60, 90, 50, 30, 10, 70, 80, 80, 90, 50, 60] = 70
# [2,  8, 3, 1,   6,  9, 8, 9, 3,10,  2, 14, 16, 8,15, 18]    = 3
# [24,-10,-33,-18,40,35,5,41,-40,-21,17,23,-36,17,49,-37]     = -10
# [8,  7,  3, 9,  9,  8,  2, 4, 1, 8,  8,  7,  9, 9, 3,  4]   = 7 (INI SOAL PKB)

# PROGRAM INI SANGAT STATIS, KEMUNGKINAN HANYA DAPAT MEMECAHKAN KASUS DENGAN 16 NODE SAJA