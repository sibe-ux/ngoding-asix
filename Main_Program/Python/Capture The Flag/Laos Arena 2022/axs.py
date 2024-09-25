# uncompyle6 version 3.5.0
# Python bytecode 2.7 (62211)
# Decompiled from: Python 2.7.5 (default, Nov 16 2020, 22:23:17) 
# [GCC 4.8.5 20150623 (Red Hat 4.8.5-44)]
# Embedded file name: chall.py
# Compiled at: 2022-05-27 19:15:49
import time, hashlib
from Crypto import Random
from Crypto.Cipher import AES

class AxxEeeS:

    def __init__(self):
        self.IV = Random.new().read(16)
        self.key = Random.new().read(32)
        self.mode = AES.MODE_OFB
        self.token = hashlib.sha1(Random.new().read(16)).hexdigest()
        self.time_enc = time.asctime(time.localtime(time.time()))

    def pad(self, data):
        return data + (16 - len(data) % 16) * chr(16 - len(data) % 16)

    def encfile(self, name):
        plain = open(name, 'rb').read()
        cipher = self.encrypt(plain)
        out = open(name + '.AxxEeeS', 'wb').write(cipher)

    def encrypt(self, plain):
        aes_obj = AES.new(self.key, self.mode, self.IV)
        cipher = aes_obj.encrypt(self.pad(plain))
        out = 'AxxEeeSed' + cipher
        return out


def main():
    axes = AxxEeeS()
    axes.encfile('backup/oak')
    axes.encfile('backup/spruce')
    axes.encfile('backup/birch')
    axes.encfile('backup/jungle')
    axes.encfile('backup/23428347')
    print ('just AxxEeeS!!!!!!')


if __name__ == '__main__':
    main()