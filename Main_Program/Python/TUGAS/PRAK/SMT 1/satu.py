# quiz anjayani

a = int(input('nilai : '))
if(a >= 90 and a <= 100):
    print('Anda mendapatkan nilai A \n Selamat!!! Anda dinyatakan lulus')
elif(a >= 75 and a <= 89):
    print('Anda mendapatkan nilai B \n Selamat!!! Anda dinyatakan lulus')
elif(a >= 60 and a <= 74):
    print('Anda mendapatkan nilai c \n Selamat!!! Anda dinyatakan lulus')
elif(a >= 45 and a <= 59):
    print('Anda mendapatkan nilai d \n Tetap semangat!! Anda dinyatakan tidak lulus')
elif(a >= 0 and a <= 44):
    print('Anda mendapatkan nilai e \n Tetap semangat!! Anda dinyatakan tidak lulus')
elif(a > 100):
    print('maksimum nilai yang dapat dimasukkan adalah 100')
