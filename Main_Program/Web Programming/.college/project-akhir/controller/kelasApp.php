<?php

require_once("../db/db.php");
// OOP
class Siswa{
    private $conn;

    function __construct(){
        // Create connection
        $this->conn = new mysqli(HOST, SIBEUX, pass, DB);
        // Check connection
        if ($this->conn->connect_error) {
            http_response_code(500);
            die("Connection failed: " . $this->conn->connect_error);
}
    }

    function __destruct()
    {
        // tutup koneksi
        $this->conn->close();
    }

    function create($data){
        foreach ($data as $key => $value) {
            $value = is_array($value) ? trim(implode(',', $value)) : trim($value);
            $data[$key] = strlen($value) > 0 ? $value : null;
        }
        // tambahkan data film baru
        $query = "INSERT INTO kelas VALUES(NULL, ?, ?, ?)";
        $sql = $this->conn->prepare($query);
        $sql->bind_param(
            "iis", 
            $data['tingkat'], 
            $data['id_jurusan'], 
            $data['kategori']
        );
            try{
                $sql->execute();
            } catch (Exception $e) {
                $sql->close();
                http_response_code(500);
                die($e->getMessage());
            }
            $sql->close();
        }
    }

$Siswa = new Siswa();
switch ($_GET['action']) {
    case 'create':
        $Siswa->create($_POST);
        break;
    default:
        // $Siswa->read();
        break;
}