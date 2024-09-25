<?php
require_once "../db.php";

if(isset($_GET['op'])){
    $op = $_GET['op'];
}else{
    $op = "";
}

if($op == 'detail'){
    $id = $_GET['id'];
    $sql = "SELECT jurusan.id_jurusan,
    jurusan.nama_jurusan, siswa.* FROM siswa join jurusan on jurusan.id_jurusan = siswa.id_jurusan where nis='$id'";
    $jurusan = "SELECT siswa.nis, siswa.id_jurusan, jurusan.nama_jurusan
    from jurusan
    join siswa 
    on jurusan.id_jurusan = siswa.id_jurusan where siswa.nis = '$id'";
    $query_jurusan = mysqli_query($db, $jurusan) or die( mysqli_error($db));
    $query = mysqli_query($db, $sql) or die( mysqli_error($db));
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/detail_siswa.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <header>
        <div class="header-content">
            <h1>
                DATA<span> SISWA</span>
            </h1>
        </div>
    </header>
    <section class="vh-100" style="background-color: salmon;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-6 mb-4 mb-lg-0">
                    <div class="card mb-3" style="border-radius: .5rem;">
                        <div class="row g-0">
                            <div class="col-md-4 gradient-custom text-center text-white"
                                style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                <img src="../img/logs.png" alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
                                <?php
                    while ($row = $query->fetch_assoc()) :
                    ?>
                                <h5><?php echo $row['nama_siswa']?></h5>
                                <p><?php echo $row['tingkat'] ?> <?php echo $row['nama_jurusan'] ?>
                                    <?php echo $row['kategori'] ?></p>
                                <i class="far fa-edit mb-5" onclick="edit(<?php echo $row['nis']?>)"></i>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body p-4">
                                    <h6>Informasi</h6>
                                    <hr class="mt-0 mb-4">
                                    <div class="row pt-1">
                                        <div class="col-6 mb-3">
                                            <h6>Jurusan</h6>
                                            <p class="text-muted"><?php echo $row['nama_jurusan']?></p>
                                        </div>
                                        <div class="col-6 mb-3">
                                            <h6>NIS</h6>
                                            <p class="text-muted">20241010100<?php echo $row['nis'] ?></p>
                                        </div>
                                    </div>
                                    <h6>Ranking</h6>
                                    <hr class="mt-0 mb-4">
                                    <div class="row pt-1">
                                        <div class="col-6 mb-3">
                                            <h6>Sekolah</h6>
                                            <p class="text-muted">SMAN 1 SRENGAT</p>
                                        </div>
                                        <div class="col-6 mb-3">
                                            <h6>Nilai</h6>
                                            <p class="text-muted">Belum Ada Nilai</p>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-start">
                                        <button type="button" class="btn btn-outline-secondary" onclick="backAdd()">
                                            <span class="fa-solid fa-arrow-left-long"></span>
                                            Kembali</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <?php endwhile; ?>
    <footer>
        <div class="footer-content">
            <h3>Flarezone Learning</h3>
            <p>Platform untuk membantu siswa dan guru dalam mengelola
                tugas harian dan juga rekap nilai
            </p>
            <ul class="socials">
                <li><a><i class="fa fa-facebook"></i></a>
                </li>
                <li><a><i class="fa fa-instagram"></i></a>
                </li>
                <li><a href="https://www.github.com/sibeux" target="_blank"><i class="fa fa-github"></i></a></li>
                <li><a><i class="fa fa-youtube"></i></a></li>
                <li><a><i class="fa fa-linkedin-square"></i></a></li>
            </ul>
        </div>
        <div class="footer-bottom">
            <p>copyright &copy;2022 FZL. Created by <span>Flarezone Foundation</span></p>
        </div>
    </footer>
</body>
<script>
    function backAdd() {
        location.href = "../data_siswa.php";
    }

    function edit(id){
        location.href = "../form/siswa_edit_form.php?id="+id;
    }
</script>
</html>