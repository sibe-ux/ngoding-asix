# tabungan dapu

mb = 22000000
zb = 15500000
zx = 5000000
tp = 4800000
m = 2000000

a = float(input('masukkan tabungan : '))
print('jumlah tabungan dapu : Rp.',a,'rupiah')
if a >= mb:
    sisa = a - mb
    print('dapu membeli mackbook \nsisa tabungan dapu : Rp.',sisa,'rupiah')
elif zb <= a < mb:
    sisa = a - zb
    print('dapu membeli zenbook \nsisa tabungan dapu : Rp.',sisa,'rupiah')
elif zx <= a < zb:
    sisa = a
    b = str(input('Anda ingin membeli zyrex atau thinkpad bekas? '))
    if b == 'zyrex':
        sisa -= zx
        print('dapu membeli zyrex \nsisa tabungan dapu : Rp.',sisa,'rupiah')
    else:
        sisa -= tp
        print('dapu membeli thinkpad bekas \nsisa tabungan dapu : Rp.',sisa,'rupiah')
elif tp <= a < zx:
    sisa = a - tp
    print('tabungan anda hanya cukup untuk membeli thinkpad bekas'
     "\ndapu membeli thinkpad bekas \nsisa tabungan dapu : Rp",sisa,"rupiah")
else:
    sisa = 0
    print("maaf tabungan anda tidak cukup"
    "\nsilahkan mencari pekerjaan untuk menambah biaya membeli laptop")
if sisa >= m:
    g = str(input('apakah anda ingin membeli monitor (iya/tidak) ? '))
    if g == 'iya':
        sisa -= m
        print('dapu membeli monitor \nsisa tabungan dapu : Rp.',sisa,'rupiah')
    else:
        print('dapu tidak membeli monitor \nsisa tabungan : Rp',sisa,"rupiah")
