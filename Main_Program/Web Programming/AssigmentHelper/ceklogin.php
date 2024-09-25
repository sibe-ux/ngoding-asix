<?php session_start();

	$koneksi = mysqli_connect("localhost", "root", "", "assigment_helper");

	if (isset($_SESSION['login'])){
		if ($_SESSION['username'] == "Adminweb" && $_SESSION['password'] == "asdf1234"){

			header("location:listdokumen_admin.php");
		}
		else {
			header("location:formupload.php");
		}
	}
	else {
		echo "	<script>
					var konfirmasi=confirm('Anda harus login terlebih dahulu. Lanjutkan..?');
					if (konfirmasi==true){
						window.location=('login.php');
					}
					else {
						window.location=('listdokumen.php');
					}
				</script>";
	}
?>
