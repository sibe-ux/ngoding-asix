let buah = ["mangga", "pisang", "anggur"];

// lakukan destrukturisasi array
let [buah1, buah2, buah3] = buah;

console.log(buah1); // Output: mangga
console.log(buah2); // Output: pisang
console.log(buah3); // Output: anggur

// gunakan koma kosong untuk melewati element kedua dan keempat
let [namaDepan, , namaBelakang, , buku] = [
	"Joanne",
	"K",
	"Rowling",
	"pengarang",
	"Harry Potter",
];

console.log(namaDepan); // Output: Joanne
console.log(namaBelakang); // Output: Rowling
console.log(buku); // Output: Harry Potter

// switch value
let a = 10;
let b = 15;

[a, b] = [b, a];
// nilai a sekarang adalah 15, dan nilai b adalah 10

// lakukan destrukturisasi objek
let orang = {
	nama: "Joko",
	umur: 22,
	sudahMenikah: false,
};

// Destrukturisasi Objek
let { nama, umur, statusMenikah } = orang;

console.log(nama); // Output: Joko
console.log(umur); // Output: 22
console.log(statusMenikah); // Output: undefined karena nama variabel dan properti berbeda

let orang2 = {
	name: "Joko",
	age: 22,
};

// buat variabel nama berisi nilai dari properti name2 pada orang2
// buat variabel age berisi nilai dari properti umur2 pada orang2
let { name: nama2, age: umur2 } = orang2;

console.log(nama2); // Output: Joko
console.log(umur2); // Output: 22

// Destrukturisasi Objek Bertingkat
let murid = {
	kelas: "12a",
	nama: ["ani", "yahya", "sinto"],
	prestasi: {
		olahraga: "juara 1",
		akademik: "juara 2",
	},
};

let {
	prestasi: { olahraga },
} = murid;

console.log(olahraga); // Output: juara 1