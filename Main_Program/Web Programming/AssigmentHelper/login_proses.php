<?php session_start();

    $koneksi = mysqli_connect("localhost", "root", "", "assigment_helper");

    if (isset($_POST["login"])){
        if (!empty($_POST["username"]) && !empty($_POST["password"])){
            $data = mysqli_query($koneksi, "SELECT * FROM `user` WHERE `username` LIKE '%$_POST[username]%' AND `password` like '%$_POST[password]%'");
            if ($data){
                $d = mysqli_fetch_object($data);

                if (!isset($d->username) || !isset($d->password)){
                    echo "<script>alert('Username atau Password salah!!! Silakan ulangi lagi'); window.location=('login.php');</script>";
                }
                else {
                    $_SESSION["username"] = $d->username;
                    $_SESSION["email"] = $d->email;
                    $_SESSION["password"] = $d->password;
                    $_SESSION["login"] = TRUE;
                    echo "<script>alert('Terima Kasih $_SESSION[username] !! Anda Berhasil Login'); window.location=('ceklogin.php');</script>";
                }
            }
            else {
                echo "<script>alert('Login gagal!!! Silakan ulangi lagi'); window.location=('login.php');</script>";
            }
        }
        else {
            echo "<script>alert('Form tidak boleh kosong!!! Silakan ulangi lagi'); window.location=('login.php');</script>";
        }
    }
?>
