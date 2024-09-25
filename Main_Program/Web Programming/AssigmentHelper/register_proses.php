<?php
// membuat koneksi 
$con = mysqli_connect("localhost","root","","assigment_helper");

// Deklarasi variable
$username = $_POST['username'];
$email = $_POST['email'];
$password = $_POST['password'];
$submit =$_POST['submit'];

if(isset($submit)){

	if(empty($username) or empty($password)){

		echo "<script>alert('Form tidak boleh kosong!!! Silakan ulangi lagi'); window.location=('register.html') </script>";
	}else{

		$pass = ($_POST['password']);
		$ins = mysqli_query($con,"INSERT INTO `user` (`id_user`, `username`, `email`, `password`) VALUES (NULL, '$username', '$email', '$password');");
		echo "<script>alert('Terima kasih sudah bergabung dengan Assigment Helper'); window.location=('login.php');</script>";
	}
}
?>
