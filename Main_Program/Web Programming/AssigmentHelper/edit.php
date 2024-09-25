<?php
	session_start();
	$koneksi = mysqli_connect("localhost", "root", "", "assigment_helper");
?>
<html>
<head>
	<title>Assigment Helper</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="style1.css">
	<link rel="icon" href="gambar/AssigmentHelperLogo.png"/>
	<style>
		#gam {
			float:right;
			width:75;
			border:1px solid #eee;
			border-radius:100%;
		}
		#h {
			font-size:26px;
			font-weight: normal;
			color:#1642a0;
			font-family: Georgia;
		}
	</style>
</head>
<body>
	
	<!-- bagian header template -->
	<header>
		<h1 class="judul">Assigment Helper</h1>
		<p class="deskripsi">Kiblat bantuan dalam mengerjakan tugas dan laporan.</p>
	</header>
	<!-- akhir bagian header template -->
	
	<div class="wrap">
		<!-- bagian menu		 -->
		<nav class="menu">
            <ul>
				<li>
					<a href="member_admin.php">Member</a>
				</li>
				<li>
					<a href="listdokumen_admin.php">All Dokumen</a>
				</li>
				<li>
					<a href="formupload_admin.php">Upload Dokumen</a>
				</li>
				<li>
					<form action="listdokumen_admin.php" method="POST">
					<input type="text" name="cari" id="tex" placeholder="Search..."> <input type="submit" name="search" id="sub" value="Cari">
					</form>
				</li>
			</ul>
		</nav>
		<!-- akhir bagian menu -->

		<!-- bagian sidebar website -->
		<aside class="sidebar">
			<div class="widget">
				<?php
					if (isset($_SESSION['login'])){
						echo "<h2><center>Selamat Datang</center></h2>";
						echo "<hr>";
						echo "<img id=gam src=gambar/user.png>";
						echo "<h1 id=h>$_SESSION[username]</h1>";
						echo "<p><i><a href=logout.php>Logout</a></i></p>";
					}
					else {
						echo "<h2>Anda Belum Login</h2>";
						echo "<p>Silahkan login untuk menikmati semua fitur dari Assigment Helper. >>><i><a href=login.php>Login</a></i></p>";
					}
				?>
			</div>
			<div class="widget">
				<h2><center>Tentang Kami</center></h2>
				<hr>
				<p align="justify">Assigment Helper ada untuk membantu teman-teman dalam menangani pengerjaan tugas. Web ini menyediakan berbagai macam tugas serta laporan dari berbagai macam kalangan pelajar.</p>
				<p align="justify">Teman-teman bisa menghubungi kami melalui :</p>
				<p align="justify"><img src="gambar/gmail.png" width=13> > <a target="_blank" href="https://mail.google.com/mail/u/0/">Email</a></p>
				<p align="justify"><img src="gambar/fb.png" width=13> > <a target="_blank" href="https://m.facebook.com/profile.php?id=100009430728967">Facebook</a></p>
				<p align="justify"><img src="gambar/ig.png" width=13> > <a target="_blank" href="https://www.instagram.com/zulfiaditya.s/">Instagram</a></p>
				<p align="justify"><img src="gambar/wa.png" width=13> > <a target="_blank" href="http://wa.me/6285336760133">WhatsApp</a></p>
			</div>
		</aside>
		<!-- akhir bagian sidebar website -->

		<!-- bagian konten Blog -->
		<div class="blog">
			<div class="conteudo">
				<h1>Upload Dokumen</h1>
				<div class="post-info">
					Oleh <b>Assigment Helper</b>
				</div>
				<hr>

                <?php
                    $id = $_GET['id_dokumen'];
                    $data = mysqli_query($koneksi, "SELECT * FROM dokumen WHERE id_dokumen = $id");
                    $d = mysqli_fetch_object($data);
                ?>
				<form action="" method="POST" enctype="multipart/form-data">
					<table border="0" style="width:100%;">
						<tr>
							<td>Judul</td>
							<td><input type="text" id="TPDF" name="judul" value=<?php echo "$d->judul" ?>></td>
						</tr>
						<tr>
							<td>Tanggal Dibuat</td>
							<td><input type="date" id="TPDF" name="buat" value=<?php echo "$d->tanggal_dibuat" ?>></td>
						</tr>
						<tr>
							<td>File <i>(pdf)</i></td>
							<td><input type="file" id="TPDF" name="file"></td>
						</tr>
						<tr>
							<td><input type="submit" id="S" name="upload" value="Upload"></td>
				            <input type="hidden" name="id" value="<?php echo $_GET['id_dokumen'] ?>"/>
						</tr>
					</table>
				</form>

				<!-- <a href="#" class="continue-lendo">Selengkapnya →</a> -->
			</div>
		</div>
		<!-- akhir bagian konten Blog -->
	</div>
    <?php
        if (isset($_POST['upload'])){
            $file_name  = $_FILES['file']['name'];
            $boleh      = array ('pdf','docx');
            $exp        = explode('.',$file_name);
            $tipe_file  = strtolower(end($exp));
            $size       = $_FILES['file']['size'];
            $tmp        = $_FILES['file']['tmp_name'];

            $tgl        = date("Y/m/d");
            $judul      = $_POST["judul"];
            $buat       = $_POST["buat"];
            $upload     = $_POST["upload"];

            if (in_array($tipe_file, array ('pdf','docx'))===true){
                if ($size < 11044070){
                    $lokasi = "file/".$judul.'.'.$tipe_file;
                    move_uploaded_file($tmp, $lokasi);
                    $upload = mysqli_query($koneksi, "UPDATE `dokumen` SET `judul` = '$judul', `tanggal_dibuat` = '$buat', `tanggal_upload` = '$tgl' WHERE `dokumen`.`id_dokumen` = $id");
                    if ($upload){
                        echo "<script>window.alert('Terima Kasih. Dokumen telah Terdata!'); window.location=('listdokumen_admin.php');</script>";
                    }
                    else {
                        echo "<script>window.alert('Mohon Maaf, Upload gagal!');</script>";
                    }
                }
                else {
					echo "<script>window.alert('Mohon Maaf, Ukuran file harus < 10 MB !');</script>";
                }
            }
            else {
				echo "<script>window.alert('Mohon Maaf, Tipe file tidak diizinkan!');</script>";
            }
        }
    ?>

</body>
</html>