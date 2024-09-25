<?php

require_once("../../db.php");
// OOP
class Guru{
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
        $query = "INSERT INTO guru VALUES(NULL, ?, ?, ?, ?)";
        $sql = $this->conn->prepare($query);
        $id = 1;
        $sql->bind_param(
            "sssi", 
            $data['nama'], 
            $data['user'], 
            $data['pass'],
            $id
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

$Guru = new Guru();
switch ($_GET['action']) {
    case 'create':
        $Guru->create($_POST);
        break;
    default:
        // $Guru->read();
        break;
}