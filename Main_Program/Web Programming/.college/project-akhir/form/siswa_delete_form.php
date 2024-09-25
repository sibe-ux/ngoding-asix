<?php
require_once("../db.php");

$op = isset($_GET['op']) ? $_GET['op'] : "";
                $loc = $op;
                $id = isset($_GET['id']) ? $_GET['id'] : '';
                $sql = "SELECT jurusan.id_jurusan,
                jurusan.nama_jurusan, siswa.* FROM siswa join jurusan on jurusan.id_jurusan = siswa.id_jurusan where nis='$id'";
                $query = mysqli_query($db, $sql) or die( mysqli_error($db));
                
                $data = [];
                
                while ($row = mysqli_fetch_array($query)) {
                    array_push($data, $row);
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>

<body>
    <div class="home">
        <header>
            <div class="header-content">
                <h1>
                    DATA<span> SISWA</span>
                </h1>
            </div>
        </header>
    </div>
    <!-- form bootstrap -->
    <div class="container">
        <h3>
            <span class="fa-solid fa-pen-to-square"></span>
            Ubah Data Siswa
        </h3>
        <form>
            <div class="form-group mb-2 row">
                <label for="username" class="col-sm-2 col-form-label control-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="<?php echo $row['username']; ?>" id="username"
                        name="username" disabled>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="pass" class="col-sm-2 col-form-label control-label">Password</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="secret" id="pass" name="pass" disabled>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="siswa" class="col-sm-2 col-form-label control-label">Nama Siswa</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="Nama Siswa" id="siswa" name="siswa"
                        maxlength="30" value="<?php echo $row['nama_siswa']; ?>" required="required">
                    <div id="the-count">
                        <span id="current"><?php echo strlen($row['nama_siswa']); ?></span>
                        <span id="maximum">/ 30</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="tingkat_kelas" class="col-sm-2 col-form-label control-label">Tingkat</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Tingkat Kelas"
                            aria-label="Recipient's username" aria-describedby="basic-addon2" required="required"
                            id="tingkat_kelas" value="<?php echo $row['tingkat']; ?>" name="tingkat_kelas">
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="jurusan">Jurusan</label>
                <div class="col-sm-10">
                    <select class="form-select" id="jurusan" name="jurusan" required>
                        <option value="" selected="selected">--</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="kategori">Kategori</label>
                <div class="col-sm-10">
                    <select class="form-select" id="kategori" name="kategori" required>
                        <option value="" selected="selected">--</option>
                    </select>
                </div>
            </div>

            <div id="dom-target" style="display: none;">
                <?php 
                    $result =  json_encode($data);
                    echo htmlspecialchars($result);
                ?>
            </div>
            <?php };
            ?>

            <div class="alert hide">
                <span class="fas fa-exclamation-circle"></span>
                <span class="msg">Data siswa berhasil diubah!</span>
                <div class="close-btn">
                    <span class="fas fa-times"></span>
                </div>
            </div>
        </form>
    </div>
    <!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- pooper js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous">
    </script>
    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous">
    </script>
    <script src="textareaLimit.js"></script>
    <script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>
    <script>
    var div = document.getElementById('dom-target');
    var myData = div.textContent;
    var data = JSON.parse(myData);

    $(document).ready(function() { // syntax ini berfungsi jika ditambahkan 3 cdn di atas
        $.get("../controller/jurusanApp.php", function(response) {
            idjurusan = data[0]['id_jurusan'];
            $.each(response, function(key, value) {
                if (value.id_jurusan == idjurusan) {
                    $('#jurusan').append("<option selected value='" + value.id_jurusan +
                        "'>" +
                        value
                        .nama_jurusan +
                        "</option>");
                } else {
                    $("#jurusan").append("<option value='" + value.id_jurusan + "'>" +
                        value
                        .nama_jurusan +
                        "</option>");
                }
            });
        })

        const kategories = [
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G"
        ];
        var kategori = data[0]['kategori'];
        kategories.forEach(kategoris);

        function kategoris(item, index) {
            if (item == kategori) {
                $('#kategori').append("<option selected value='" + item + "'>" + item + "</option>");
            } else {
                $('#kategori').append("<option value='" + item + "'>" + item + "</option>");
            }
        }

        var nis = data[0]['nis'];
            swal({
                    title: "Apakah Anda Yakin?",
                    text: "Data Akan dihapus Secara permanen!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                .then((willDelete) => {
                    swal("Data berhasil dihapus!", {
                        icon: "success",
                    }).then((value) => {
                    location.href = '../data_siswa.php';
                });;
                    if (willDelete) {
                        var data = $(this).serialize();
                        $.post("../controller/siswaApp.php?action=delete&id=" + nis, data, function(
                            response) {});
                    }
                });
        })
    
    $('.close-btn').click(function() {
        $('.alert').removeClass("show");
        $('.alert').addClass("hide");
    });

    function backAdd() {
        location.href = "../data_siswa.php";
    }
    </script>
</body>

</html>