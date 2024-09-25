# uncompyle6 version 3.5.0
# Python bytecode 3.8 (3413)
# Decompiled from: Python 2.7.5 (default, Nov 16 2020, 22:23:17) 
# [GCC 4.8.5 20150623 (Red Hat 4.8.5-44)]
# Embedded file name: chall.py
# Size of source mod 2**32: 237 bytes
# from operator import xor
# from operator import xor
from pwn import *
import base64

def enc(plain, key):
    flag = base64.b64encode(plain.encode())
    flag = xor(flag, key)
    return flag


f = open('G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\KULIAH\\00 - UNEJ\Algorithm Programming\PEMROGRAMAN\Main Program\\flag.txt', 'r').read()
res = open('G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\KULIAH\\00 - UNEJ\Algorithm Programming\PEMROGRAMAN\Main Program\\enc.txt', 'wb')
res.write(enc(f, 'LINZ_IS_HERE'))
# res.write(enc(("%s\r\n"%f).encode('ascii'), 'LINZ_IS_HERE'))
res.close()