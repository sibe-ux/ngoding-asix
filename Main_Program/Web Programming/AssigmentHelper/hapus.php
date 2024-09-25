<?php

include("koneksi.php");

if( isset($_GET['id_dokumen']) ){

    // ambil id dari query string
    $id = $_GET['id_dokumen'];

    // buat query hapus
    $sql = "DELETE FROM dokumen WHERE id_dokumen=$id";
    $query = mysqli_query($koneksi, $sql);

    // apakah query hapus berhasil?
    if( $query ){
        echo "<script>alert('Data dokumen berhasil dihapus!!!'); window.location=('listdokumen_admin.php');</script>";
    } else {
        echo "<script>alert('Data dokumen gagal dihapus!!!'); window.location=('listdokumen_admin.php');</script>";
    }

}
else {
    echo "<script>alert('Akses Dilarang!!!'); window.location=('ceklogin.php');</script>";
}

?>