<?php

require_once("../../db.php");
// OOP
class Guru{
    private $conn;

    function __construct(){
        // valid connection
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

    function valid($data){
        foreach ($data as $key => $value) {
            $value = is_array($value) ? trim(implode(',', $value)) : trim($value);
            $data[$key] = strlen($value) > 0 ? $value : null;
        }
        // tambahkan data film baru
        $query = "select * from guru where username = '$data[user]' and password = '$data[pass]'";
        $sql = $this->conn->query($query);
        $data = [];
        while ($row = $sql->fetch_assoc()) {
                    array_push($data, $row);
                }
        if (count($data) > 0) {
            return $data;
        } else {
            return false;
        }
        echo $data;
        }
    }

$Guru = new Guru();
switch ($_GET['action']) {
    case 'valid':
        $Guru->valid($_POST);
        break;
    default:
        // $Guru->read();
        break;
}