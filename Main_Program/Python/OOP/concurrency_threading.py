import threading  # import library threading
import time  # import library time


def print_with_dynamic_sleep(total_iteration):
    """
    fungsi berikut akan melakukan print command
    dengan interval yang berbeda-beda
    """
    for x in range(total_iteration):
        print("Hello from dynamic-sleep interval, pengulangan ke-{}".format(x))
        # fungsi akan berhenti selama x second, akan berubah2 secara dinamis
        time.sleep(x)


def print_with_static_sleep(total_iteration):
    """
        fungsi berikut akan melakukan print command
        dengan interval yang statis/sama
    """
    for x in range(total_iteration):
        print("Hello from static-sleep interval, pengulangan ke-{}".format(x))
        time.sleep(2)  # fungsi akan berhenti selama 2 second


if __name__ == "__main__":
    # creating thread
    t1 = threading.Thread(target=print_with_dynamic_sleep, args=(5,))
    t2 = threading.Thread(target=print_with_static_sleep, args=(5,))

    # memulai thread pertama
    t1.start()
    # memulai thread kedua
    t2.start()

    # tunggu sampai thread 1 selesai dilaksanakan
    t1.join()
    # tunggu sampai thread 2 selesai dilaksanakan
    t2.join()

    # both threads completely executed
    print("Selesai!")

# mendeclare fungsi

# output
"""
Hello from dynamic-sleep interval, pengulangan ke-0
Hello from dynamic-sleep interval, pengulangan ke-1
Hello from static-sleep interval, pengulangan ke-0
Hello from dynamic-sleep interval, pengulangan ke-2
Hello from static-sleep interval, pengulangan ke-1
Hello from dynamic-sleep interval, pengulangan ke-3
Hello from static-sleep interval, pengulangan ke-2
Hello from static-sleep interval, pengulangan ke-3
Hello from dynamic-sleep interval, pengulangan ke-4
Hello from static-sleep interval, pengulangan ke-4
Selesai!
"""

# Untuk membuat thread kita cukup menggunakan sintaks berikut
    # def nama_fungsi(params):
        # lakukan sebuah process


    # t3 = threading.Thread(target=nama_fungsi, args=(5,))
        # kita juga bisa memberikan argument kedalam fungsi tersebut
        # nama fungsi tidak perlu menggunakan '()'