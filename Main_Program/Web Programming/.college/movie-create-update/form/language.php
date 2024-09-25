<?php

require_once("../db.php");

// ambil data langauge 
$query = "SELECT * FROM language";
$sql = $db->query($query);
$data = [];
while ($row = $sql->fetch_assoc()) {
    array_push($data, $row);
}

// tampilkan dalam format json
header("Content-Type: application/json");
echo json_encode($data);