let suaraKucing = "Meow";
let suaraAnjing = "Gukguk";
let suaraTikus = "Citcitcit";

// nama variable dan parameter harus sama
let suaraHewan = { suaraKucing, suaraAnjing, suaraTikus };

console.log(suaraHewan); // Output:  { suaraKucing: 'Meow', suaraAnjing: 'Gukguk', suaraTikus: 'Citcitcit' }
console.log(suaraHewan.suaraKucing); // Output: Meow
console.log(suaraHewan.suaraAnjing); // Output: Gukguk
console.log(suaraHewan.suaraTikus); // Output: Citcitcit

// Di sini selain menggunakan object shorthand, kita juga akan menggunakan arrow function dari ES6
let membuatBiodata2 = (nama, umur, jenisKelamin) => {
	return { nama, umur, jenisKelamin };
};

console.log(membuatBiodata2("Andi", 22, "pria")); // Output: { nama: 'Andi', umur: 22, jenisKelamin: 'pria' }

let operasiMatematika = {
	nama: "Penjumlahan",
	operasi(angka1, angka2) {
		let hasil = angka1 + angka2;
		return `${this.nama} dari ${angka1} dan ${angka2} adalah ${hasil}`;
	},
};

console.log(operasiMatematika.operasi(3, 5)); // Output: Penjumlahan dari 3 dan 5 adalah 8
