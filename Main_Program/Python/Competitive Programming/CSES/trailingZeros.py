# def zero(n,hasil=1,nol=-1,count=0):
#     if n>1:
#         hasil*=n
#         zero(n-1,hasil=hasil,nol=-1,count=0)
#     else:
#         b = str(hasil)
#         if b[nol]=="0":
#             nol -= 1
#             count+=1
#             zero(n=0,hasil=hasil,nol=nol,count=count)
#         else:
#             print(count)
            
# n = int(input())
# zero(n)

from math import factorial
n = int(input())
hasil=factorial(n)
b=str(hasil)
print((len(b)-max(b.rindex('8'),b.rindex('6'),b.rindex('2'),b.rindex('4')))-1)
# for x in range(n,0,-1):
#     hasil*=x
#     b = str(hasil)
#     if b[z]=='0':
#         count+=1
#         z-=1

 