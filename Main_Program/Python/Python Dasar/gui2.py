import tkinter as tk
import random
import math
from time import sleep

frame = tk.Tk()
frame.configure(bg='blue')

# frame.attributes('-fullscreen', True)
# frame.state('zoomed')

lebar=1300
tinggi=600
jumlah_point = 200

canvas1 = tk.Canvas(frame, width=lebar, height=tinggi)
canvas1.pack()

list_point = []
list_connected = []

def buat_point():
    # buat point secara random
    for i in range(jumlah_point):
        x = random.randint(0, lebar)
        y = random.randint(0, tinggi)
        list_point.append([ i, x, y ])
        canvas1.create_oval(x-5, y-5, x+5, y+5, fill='red')
        frame.update()
        sleep(0.05)
    
    frame.after(1000, gambar_garis)


def gambar_garis():
    while len(list_connected) < jumlah_point:
        # point index 0 diset sebagai terhubung / awal mulai
        if len(list_connected) == 0:
            list_connected.append(0)
            continue
        

        selected_point = -1
        closest_distance = 10000000
        selected_source = []
        selected_sink = []
        # mencari unconnected point yg memiliki jarak terkecil dengan point-point yg sudah terhubung
        for uc in list_point:
            index = uc[0]
            if index in list_connected:
                continue
            
            x1 = uc[1]
            y1 = uc[2]

            # menghubungkan ke point terdekat yg sudah pernah terhubung
            for c in list_connected:
                cpoint = list_point[c]
                x2 = cpoint[1]
                y2 = cpoint[2]
                
                # hitung jarak
                x3 = math.pow(x2 - x1, 2)
                y3 = math.pow(y2 - y1, 2)
                jarak = math.sqrt(x3 + y3)

                # simpan point jika jaraknya lebih kecil dari point sebelumnya
                if jarak < closest_distance:
                    closest_distance = jarak
                    selected_source = cpoint
                    selected_sink = uc
        
        # sudah menemukan point terdekat untuk dihubungkan,
        # gambar ke gui dan simpan ke list point terhubung
        list_connected.append(selected_sink[0])
        canvas1.create_line(selected_source[1], selected_source[2], selected_sink[1], selected_sink[2])
        frame.update()
        sleep(0.5)

def mulai(args):
    frame.unbind('<Visibility>')
    print('mulai')
    print(args)
    frame.after(1000, buat_point)

frame.bind('<Visibility>', mulai)

frame.mainloop()