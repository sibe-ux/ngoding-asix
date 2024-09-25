""" string = ""

x = int(input())
a = input()
c = (f"{a}")
bar = x
while bar >= 0:

	kol = bar
	while kol > 0:
		string = string + " "
		kol = kol - 1
	
	kanan = 1
	while kanan < (x - (bar-1)):
		string = string + c
		kanan = kanan + 1		
		
	string = string + "\n"
	bar = bar - 1
	A
print (string) """

print('='*40)

limit=5
for bintang in range (0,5):
    for pola in range (0, limit+1):
        print(" ",end="")

    for bentuk in range (0,bintang+1):
        print('x',end="")
    limit-=1
    print("")

print('='*40)
for i in range(5,0,-1):
    print(' '*(i-1) + 'x'*(5+1-i))