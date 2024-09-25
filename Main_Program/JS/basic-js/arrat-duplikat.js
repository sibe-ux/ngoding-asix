let buah = ['anggur', 'apel','pisang']

// jangan duplikat seperti ini
let buah2 = buah

// karena akan mengubah variable buah juga
buah2.push('mangga')
console.log(buah)
console.log(buah2)

// pakai cara ini
let buah3 = [...buah]
buah3.push('sirsak')
console.log(buah)
console.log(buah3)