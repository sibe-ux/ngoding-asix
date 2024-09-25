<?php

require_once("./db.php");

$typing = $_GET["typing"];


$sql = "SELECT * FROM mahasiswa
            WHERE 
        nama LIKE '%{$typing}%' OR
        nim LIKE '%{$typing}%' OR
        email LIKE '%{$typing}%' OR
        jurusan LIKE '%{$typing}%'
";

$result = $db->query($sql);

$data = [];
while ($row = $result->fetch_assoc()) {
    array_push($data, $row);
}
header("Content-Type: aplication/json");
echo json_encode($data);
