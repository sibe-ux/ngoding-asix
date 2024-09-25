def palindrome(a,b,n): 
    if n == 0:
        return f'{z} is palindrome'
    if n == 1:
        return f'{z} is palindrome'
    else:
        if z[a].isalpha() and z[b].isalpha():
            if z[a] == z[b]:
                return palindrome(a+1,b-1,n-2)
            else:
                return f'{z} is not palindrome'
        else:
            if z[a].isalpha(): # jika indeks z[a] = hruf, yang satunya bukan
                return palindrome(a,b-1,n-1)
            elif z[b].isalpha():
                return palindrome(a+1,b,n-1)
            else:
                return palindrome(a+1,b-1,n-2)   
z = input('type here : ').lower()
print(palindrome(0,-1,(len(z))))