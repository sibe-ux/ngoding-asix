<?php

require_once("./db.php");

$ngetik = $_GET["ngetik"];


$sql = "SELECT * FROM mahasiswa
        WHERE nama LIKE '%{$ngetik}%' OR
        nim LIKE '%{$ngetik}%' OR
        email LIKE '%{$ngetik}%' OR
        jurusan LIKE '%{$ngetik}%'
";

$result = $db->query($sql);

while ($row = $result->fetch_assoc()) {
    echo "
    <tr>
        <td>{$row['nama']}</td>
        <td>{$row['nim']}</td>
        <td>{$row['email']}</td>
        <td>{$row['jurusan']}</td>
    </tr>
    ";
}