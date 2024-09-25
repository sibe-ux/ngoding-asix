<?php

require_once "./db.php";

$typing = $_GET["typing"];


$sql = "SELECT * FROM mahasiswa
            WHERE 
        nama LIKE '%{$typing}%' OR
        nim LIKE '%{$typing}%' OR
        email LIKE '%{$typing}%' OR
        jurusan LIKE '%{$typing}%'
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