<?php

require_once("../db.php");
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
        
        $max = "select count(*) from siswa";
        $maxsql = $this->conn->query($max);
        $max = $maxsql->fetch_assoc();
        $max = $max['count(*)'];
        // tambahkan data siswa baru
        $query = "INSERT INTO siswa VALUES(?, ?, ?, ?, ?, ?, ?, ?,NULL)";
        $sql = $this->conn->prepare($query);
        $id = 2;
        // 
        $rand = rand(1,500);
        // 
        $strmax = (string) ($max + $rand);
        $maxresult = $max + $rand;
        $username = "20241010100{$strmax}";
        $password = "secret";
        $sql->bind_param(
            "isiisssi",
            $maxresult,
            $data['siswa'], 
            $data['jurusan'], 
            $data['tingkat_kelas'],
            $data['kategori'],
            $username,
            $password,
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

    function update($data){
        foreach ($data as $key => $value) {
            $value = is_array($value) ? trim(implode(',', $value)) : trim($value);
            $data[$key] = strlen($value) > 0 ? $value : null;
        }
        // update siswa
        $id = $_GET['id'];
        $query = "UPDATE siswa SET
        nama_siswa = ?, 
        tingkat = ?,
        id_jurusan = ?,
        kategori = ?
        WHERE nis = {$id}";
        echo $_GET['id'];
        $sql = $this->conn->prepare($query);
        $sql->bind_param(
            "siis", 
            $data['siswa'], 
            $data['tingkat_kelas'],
            $data['jurusan'], 
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

    function delete($data){
        foreach ($data as $key => $value) {
            $value = is_array($value) ? trim(implode(',', $value)) : trim($value);
            $data[$key] = strlen($value) > 0 ? $value : null;
        }
        // update siswa
        $id = $_GET['id'];
        $query = "DELETE FROM siswa
        WHERE nis = {$id}";
        $sql = $this->conn->prepare($query);
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
    case 'update':
        $Siswa->update($_POST);
        break;
    case 'delete':
        $Siswa->delete($_GET['id']);
        break;
    default:
        // $Siswa->read();
        break;
}
// $film->read();