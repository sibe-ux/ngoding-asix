def fizzbuzz(n,x=1):
    if x>n:
        return 0
    if x % 3 == 0 and x % 5 == 0 :
        print ('fizz buzz')
        fizzbuzz(n,x+1)
    elif x % 3 ==0:
        print('fizz')
        fizzbuzz(n,x+1)
    elif x % 5 == 0:
        print('buzz')
        fizzbuzz(n,x+1)  
    else:
        print(x)
        fizzbuzz(n,x+1)  

fizzbuzz(20)