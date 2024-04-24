<?php

require_once("./db.php");

if (isset($_GET['offset']) && isset($_GET['limit'])) {

    $limit = $_GET['limit'];
    $offset = $_GET['offset'];

    $connect = mysqli_connect(HOST, SIBEUX, pass, DB);

    $data = mysqli_query($connect, "SELECT jurusan.id_jurusan,
    jurusan.nama_jurusan, siswa.* FROM siswa join jurusan on jurusan.id_jurusan = siswa.id_jurusan ORDER BY urutan LIMIT $limit OFFSET $offset");

    while ($row = mysqli_fetch_array($data)) {
        $nama_siswa = ucwords($row['nama_siswa']);
        $jurusan = ucwords($row['nama_jurusan']);
        $tingkat = ($row['tingkat']);
        $nis = ($row['nis']);
        echo "
    <div class='col col-lg-6 col-xl-4'>
                    <div class='product-container'>
                        <div class='product-card'>
                            <a href='view/detail_siswa.php?op=detail&id={$row['nis']}' style='text-decoration: none'>
                                <img width='95' height='135'
                                    src='img/user.png'
                                    title='$nama_siswa' />
                            </a>
                            <div class='product-body'>
                                <a href='view/detail_siswa.php?op=detail&id={$row['nis']}'
                                    style='text-decoration: none;'>
                                    <span class='product-title'>{$nama_siswa}</span>
                                </a>
                                <div class='product-price'>20241010100{$nis}</div>";
        echo "<a id='biodata' style='text-decoration: none;'>";
        echo "Tingkat\t: {$tingkat}";
        echo "</a>";
        echo "<br>";
        echo "<a id='biodata' style='text-decoration: none;'>";
        echo "Jurusan\t: {$jurusan}";
        echo "</a>";
        echo "<br>";
        echo "<a id='biodata' style='text-decoration: none;'>";
        echo "Kategori\t: {$row['kategori']}";
        $id = $row['nis'];
        echo "<br>";
        echo "<a href='view/detail_siswa.php?op=detail&id={$id}' style='text-decoration: none;'>";
        echo "<span class='detail'>Detail</span>";
        echo "</a>";
        echo "</div>
                                <div class='btn'>
                                    <i class='bx bxs-edit-alt' onclick='edit({$row['nis']})'></i>
                                    <i class='bx bxs-trash' onclick='hapus({$row['nis']})'></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
    ";
    }
}
echo "<script>";
echo "function edit(id){
    location.href = 'form/siswa_edit_form.php?op=update&id=' + id;
}";
echo "</script>";
echo "<script>";
echo "function hapus(id){
    location.href = 'form/siswa_delete_form.php?op=delete&id=' + id;
}";
echo "</script>";
