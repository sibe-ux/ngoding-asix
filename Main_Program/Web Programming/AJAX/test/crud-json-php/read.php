<?php
// File json yang akan dibaca (full path file)
$file = "anggota.json";

// Mendapatkan file json
$anggota = file_get_contents($file);

// Mendecode anggota.json
$data = json_decode($anggota, true);

// Membaca data array menggunakan foreach
foreach ($data as $d) {
    echo $d['no'] . "<br>";
    echo $d['nama'] . "<br>";
    echo $d['alamat'] . "<br>";
}