<?php include("koneksi.php"); ?>

<html>
    <head>
        <title>Baca Dokumen</title>
        <link rel="icon" href="gambar/AssigmentHelperLogo.png"/>
    </head>
    <body>
    <?php
        
        $sql = "SELECT * FROM dokumen WHERE id_dokumen = '$_GET[id_dokumen]'";
        $query = mysqli_query($koneksi, $sql);
        $d = mysqli_fetch_object($query);

        //memanggil file example.pdf yang berada di folder bernama file
        $filePath ="file/$d->judul.pdf";
        //Membuat kondisi jika file tidak ada
        if (!file_exists($filePath)) {
            echo "<script>alert('File $d->judul does not exist'); window.location=('listdokumen.php');</script>";
            die();
        }
        //nama file untuk tampilan
        $filename="$d->judul.pdf";
        header('Content-type:application/pdf');
        header('Content-disposition: inline; filename="'.$filename.'"');
        header('content-Transfer-Encoding:binary');
        header('Accept-Ranges:bytes');
        //membaca dan menampilkan file
        readfile($filePath);
    ?>
    </body>
</html>

<?php
