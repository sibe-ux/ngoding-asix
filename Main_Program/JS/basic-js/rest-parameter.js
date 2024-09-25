// elipsis

const foo = (...params) => {
	console.log(params);
};

foo("A", "B", "C"); // Output: ["A", "B", "C"]

// rest parameter sebagai parameter terakhir
// rest parameter harus ditaruh paling belakang
const bar = (param1, param2, ...params) => {
	console.log("Argument pertama ", param1);
	console.log("Argument pertama ", param2);
	console.log("Sisa argument ", params);
};

bar("A", "B", "C", "D", "E");
// Output:
// Argument pertama  A
// Argument pertama  B
// Sisa argument ["C", "D", "E"]

// spread paremeter
// spread parameter digunakan untuk membuka array
let arrayBilangan = [1, 2, 3, 4, 5];

// tanpa spread operator
console.log(arrayBilangan); // Output: [1, 2, 3, 4, 5]

// kalau pakai spread operator
console.log(...arrayBilangan); // Output: 1, 2, 3, 4, 5

// array duplikat dengan spread operator
let arrayAsli = [1, 2, 3];

let arrayDuplikat = [...arrayAsli];
console.log(arrayDuplikat); // Output: [1, 2, 3]

// menggabungkan array (concatenate)
let array1 = [1, 2, 3];
let array2 = [4, 5, 6];

let arrayGabungan = [...array1, ...array2];
console.log(arrayGabungan); // Output: [1, 2, 3, 4, 5, 6]

// Spread Operator Dengan Objek
let orang = {
	nama: "Yudistya",
	umur: 32,
};
orang = {...orang, pekerjaan: "arsitek", pendidikan: "S1"};

// menggabungkan 2 objek
const objek1 = {a: 1, b: 2};
const objek2 = {c: 3, d: 4};
const objekGabungan = {...objek1, ...objek2};

console.log(objekGabungan); // Output: {a: 1, b: 2, c: 3, d: 4}