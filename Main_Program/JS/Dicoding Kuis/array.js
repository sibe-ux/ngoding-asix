/**
 * TODO:
 * Buatlah sebuah variabel dengan nama evenNumber yang merupakan sebuah array dengan ketentuan:
 *   - Array tersebut menampung bilangan genap dari 1 hingga 100
 *
 * Catatan:
 *   - Agar lebih mudah, gunakanlah for loop dan logika if untuk mengisi bilangan genap pada array.
 */

// TODO
let evenNumber = []

for (let i = 2; i <= 100;i+=2){
    evenNumber.push(i)
}

console.log(...evenNumber)


/**
 * Jangan hapus kode di bawah ini
 */

module.exports = evenNumber;
