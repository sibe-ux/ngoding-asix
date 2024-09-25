<?php
	session_start();
	$koneksi = mysqli_connect("localhost", "root", "", "assigment_helper");
?>
<html>
<head>
	<title>Assigment Helper</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="icon" href="gambar/AssigmentHelperLogo.png"/>
	<style>
		#gam {
			float:right;
			width:75;
			border:1px solid #eee;
			border-radius:100%;
		}
		#icon {
			width:10;
		}
		#h {
			font-size:26px;
			font-weight: normal;
			color:#1642a0;
			font-family: Georgia;
		}
		input[type=text] {
			padding:6px;
			width:75%;
			border-radius:5px;
			margin-top:17.5px;
			border:1px solid #ccc;
			font-size:10px;
			font-family:raleway;
		}

		input[type=submit] {
			padding:1px;
			background-color:#00af8c;
			color:#fff;
			border:1px solid #999;
			padding:5px;
			font-size:10px;
			cursor:pointer;
			border-radius:3px;
			margin-top:24px;
			font-family:Georgia;
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
					<a href="index.php">Home</a>
				</li>
				<li>
					<a href="listdokumen.php">Semua Dokumen</a>
				</li>
				<li>
					<a href="ceklogin.php">Upload Dokumen</a>
				</li>
				<li>
					<form action="listdokumen.php" method="POST">
					<input type="text" name="cari" placeholder="Search..."> <input type="submit" name="search" value="Cari">
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
				<h1>Pendahuluan Assigment Helper</h1>
				<div class="post-info">
					Oleh <b>Assigment Helper</b>
				</div>
				<hr>
				<img src="gambar/banner.jpg">
				<p align="justify">
					Assigment Helper adalah web yang tercipta untuk membantu teman teman di luar sana yang memiliki masalah dalam menyelesaikan tugasnya. Di sini kami menyediakan file dokumen dari berbagai kalangan. Kami disini tidak hanya menyediakan, tetapi juga sebagai wadah bagi teman teman yang ingin membagikan dokumen nya. Dengan membagiakan file di web kami, maka teman teman bisa mambantu teman teman yang lain dakam menyelesaikan malahnya.
				</p>
				<p align="justify">
					Kebaikan akan selalu dibalas dengan kebaikan pula. Maka jangan pernah lelah dan malas berbuat kebaikan.
				</p>
				<!-- <a href="#" class="continue-lendo">Selengkapnya →</a> -->
			</div>
		</div>
		<!-- akhir bagian konten Blog -->
	</div>

</body>
</html>