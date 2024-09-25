list_umur = [34,39,20,18,13,54]
print("Umur yang dewasa: ")
for a in filter(lambda x: x >= 19, list_umur): # filter umur menggunakan fungsi filter
    print(a,end = ' ')

#output
# Umur yang dewasa: 
# 34 39 20 54 