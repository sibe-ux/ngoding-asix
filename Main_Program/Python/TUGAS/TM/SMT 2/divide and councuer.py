# # NO 3
# def binn(sk,binary,h1=0,h2=0):
#     if len(binary) ==1:
#         if binary[0] == sk:
#             print(sk)
#         else:
#             print('number not found')
#     elif len(binary) > 1:
#         if len(binary) % 2 == 1:
#             lenbin = (len(binary)+1) /2
#             h1 = binary[:int(lenbin)]
#             h2 = binary[int(lenbin):]
#             binn(sk,[],h1,h2)
#         elif len(binary) % 2 == 0:
#             lenbin = (len(binary)) /2
#             h1 = binary[:int(lenbin)]
#             h2 = binary[int(lenbin):]
#             binn(sk,[],h1,h2)
#     else:
#         if len(h1) == 1 or len(h2) == 1:
#             if len(h2) == 1 and len(h1) > 1:
#                 if h2[0] == sk:
#                     print(sk)
#                 else:
#                     if h1[0] == sk or h1[1] == sk:
#                         print(sk)
#                     else:
#                         print('number not found')
#             elif len(h1) == 1 and len(h2) == 1:
#                 if h1[0] == sk:
#                     print(sk)
#                 elif h2[0] == sk:
#                     print(sk)
#                 else:
#                     print('numb not found') 
#         else:
#             if max(h1) >= sk:
#                 if len(h1) % 2 == 1:
#                     lenh1 = (len(h1)+1) / 2
#                     h2 = h1[int(lenh1):]
#                     h1 = h1[:int(lenh1)]
#                     binn(sk,[],h1,h2)
#                 elif len(h1) % 2 == 0:
#                     lenh1 = (len(h1)) / 2
#                     h2 = h1[int(lenh1):]
#                     h1 = h1[:int(lenh1)]
#                     binn(sk,[],h1,h2) 
#             elif max(h2) >= sk:
#                 if len(h2) % 2 == 1:
#                     lenh2= (len(h2)+1) / 2
#                     h1 = h2[:int(lenh2)]
#                     h2 = h2[int(lenh2):]
#                     binn(sk,[],h1,h2)
#                 elif len(h2) % 2 == 0:
#                     lenh2 = (len(h2)) / 2
#                     h1 = h2[:int(lenh2)]
#                     h2 = h2[int(lenh2):]
#                     binn(sk,[],h1,h2)
# binn(int(input('type number : ')),[2,5,8,12,16,23,38,56,72,91])

# # NO 2
def base(n,c=[],x=1):
    if n < 1:
        maxx(c,len(c))
    else:
        numb = int(input(f'input number {x} : '))
        c.append(numb)
        base(n-1,c,x+1)

def maxx(a,n,z=0,ca=[]):
    if n == 0:
        print(a)
        print(max(ca))
        exit
    elif n > 0:
        if z == 0:
            ca.append(a[z])
            maxx(a,n-1,z+1)
        elif z > 0:
            if a[z] > ca[z-1] + a[z]:
                ca.append(a[z])
                maxx(a,n-1,z+1)
            elif a[z] < ca[z-1] + a[z]:
                ca.append(ca[z-1] + a[z])
                maxx(a,n-1,z+1)
base(int(input('type numb : ')))
