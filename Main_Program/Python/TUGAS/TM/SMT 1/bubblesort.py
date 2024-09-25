def bubblesort(data):
    jmltahapan = len(data) - 1
    for x in range(jmltahapan):
        jmliterasi = jmltahapan - x
        for i in range(jmliterasi):
            if data[i] > data[i + 1]:
                data[i], data[i + 1] = data[i + 1], data[i]
    return data

bilangan = [2,3,9,5,6,7]
urut = bubblesort(bilangan)
print(urut)