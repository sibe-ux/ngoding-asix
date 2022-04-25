<?php
$host   = "localhost";
$user   = "root";
$pass   = "";
$db     = "animo";

$connect = mysqli_connect($host, $user, $pass, $db);
if (!$connect) { // cek koneksi
    die("Connection failed: " . mysqli_connect_error());
}
$fakultas   = "";
$animo      = "";
$sukses = "";
$error = "";


if(isset($_GET['op'])){
    $op = $_GET['op'];
}else{
    $op = "";
}

if($op == 'delete'){
    $id = $_GET['id'];
    $sql = "DELETE FROM animo WHERE id = '$id'";
    $query = mysqli_query($connect, $sql);
    if($query){
        $sukses = "Data berhasil dihapus";
    }else{
        $error = "Data gagal dihapus";
    }
}

if($op == 'edit'){
    $id = $_GET['id'];
    $sql1 = "SELECT * FROM animo WHERE id = '$id'";
    $q1 = mysqli_query($connect, $sql1);
    $r1 = mysqli_fetch_array($q1);
    $fakultas = isset($r1['fakultas']) ? $r1['fakultas'] : '';
    $animo = isset($r1['animo']) ? $r1['animo'] : '';

    if($fakultas == ''){
        $error = "Data tidak ditemukan";
    }
}

if(isset($_POST['simpan'])){ // untuk create
    $fakultas = $_POST['fakultas'];
    $animo = $_POST['animo'];

    if($fakultas && $animo){
        if($op == 'edit'){ // untuk update
            $sql1 = "update animo set fakultas = '$fakultas', animo = '$animo' where id = '$id'";
            $q1 = mysqli_query($connect, $sql1);
            if($q1){
                $sukses = "Data berhasil diubah";
        } else{
            $error = "Data gagal diubah";
        }
        } else{ // untuk insert
            $sql1 = "insert into animo(fakultas, animo) values('$fakultas', '$animo')";
        $q1 = mysqli_query($connect, $sql1);
        if($q1){
            $sukses = "Data berhasil ditambahkan";
    } else{
        $error = "Data gagal ditambahkan";
    }
        }
    }else{
        $error = "Data tidak boleh kosong";
    }
}
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UTS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="/assets/favicon.ico">
    <style>
    .mx-auto {
        width: 800px;
    }

    .card {
        margin-top: 10px;
    }
    </style>
</head>

<body>
    <div class="mx-auto">
        <!-- untuk memasukkan data -->
        <div class="card">
            <h5 class="card-header">Tambah Data</h5>
            
            <div class="card-body">
                <!-- alert error -->
                <?php 
                if($error){
                    ?>
                <div class="alert alert-danger" role="alert">
                    <?php echo $error; ?>
                </div>
                <?php
                }
                
                ?>

                <!-- alert sukses -->
                <?php 
                if($sukses){
                    ?>
                <div class="alert alert-success" role="alert">
                    <?php echo $sukses; ?>
                </div>
                <?php
                
                }
                ?>
                <form action="" method="POST">
                    <div class="mb-3 row">
                        <label for="fakultas" class="col-sm-2 col-form-label">Fakultas</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fakultas" name="fakultas">
                            <!-- value="paan"> untuk mengisi form setelah disubmit -->
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="animo" class="col-sm-2 col-form-label">Animo</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="animo" name="animo">
                            <!-- value="oke"> untuk mengisi form setelah disubmit -->
                        </div>
                    </div>
                    <div class="col-12">
                        <input type="submit" name="simpan" value="Tambah Data" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>

        <!-- untuk mengeluarkan data -->
        <div class="card">
            <h5 class="card-header text-white bg-secondary">Data Animo</h5>
            <div class="card-body">
                <table class="table table-sortable">
                    <thead>
                        <tr>
                            <th class="th-sm" scope="col">No</th>
                            <th scope="col">Fakultas</th>
                            <th scope="col">Animo</th>
                            <th class="th-sm" scope="col">Aksi</th>
                        </tr>
                    <tbody>
                        <?php
                        $sql2 = "select * from animo order by id asc";
                        $q2 = mysqli_query($connect, $sql2);
                        $urut = 1;
                        while($r2 = mysqli_fetch_array($q2)){
                                $id         = $r2['id'];
                                $fakultas   = $r2['fakultas'];
                                $animo      = $r2['animo'];
                                ?>
                        <tr>
                            <!-- row ga akan bisa diklik karena dia pake th bukan td -->
                            <td class="th-sm" scope="row">
                                <?php echo $urut++; ?>
                            </td>
                            <td scope="row">
                                <?php echo $fakultas; ?>
                            </td>
                            <td scope="row">
                                <?php echo $animo; ?>
                            </td>
                            <th scope="row">
                                <a href="edit.php?op=edit&id=<?php echo $id ?>">
                                    <button type="button" class="btn btn-warning">Edit</button>
                                </a>
                                <a href="index.php?op=delete&id=<?php echo $id ?>"
                                    onclick="return confirm('Yakin akan menghapus data?')">
                                    <button type="button" class="btn btn-danger">Delete</button>
                                </a>
                            </th>
                        </tr>
                        <?php
                        }
                        ?>
                    </tbody>
                    </thead>
                </table>
                <div id="pagination"></div>
                <input type="hidden" id="totalPages" value="<?php echo $totalPages; ?>">
            </div>
        </div>
    </div>
    </div>
</body>
<script src="script.js"></script>

</html>