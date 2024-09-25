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
            Data Siswa Baru
        </h3>
        <form>
            <div class="form-group mb-2 row">
                <label for="username" class="col-sm-2 col-form-label control-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="20241010100..." id="username" name="username"
                        disabled>
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
                        maxlength="30" required="required">
                    <div id="the-count">
                        <span id="current">0</span>
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
                            id="tingkat_kelas" name="tingkat_kelas">
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
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                        <option value="G">G</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 mt-md-4 row">
                <label for="inputEmail3" class="col-sm-2 col-form-label control-label"></label>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">
                        <span class="fa-solid fa-paper-plane"></span>
                        Simpan
                    </button>
                    <button type="button" class="btn btn-outline-secondary" onclick="backAdd()">
                        <span class="fa-solid fa-arrow-left-long"></span>
                        Kembali</button>
                </div>
            </div>

            <div class="alert hide">
                <span class="fas fa-exclamation-circle"></span>
                <span class="msg">Data siswa berhasil ditambahkan!</span>
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

    <script>
    $(document).ready(function() { // syntax ini berfungsi jika ditambahkan 3 cdn di atas
        $.get("../controller/jurusanApp.php", function(response) {
            $.each(response, function(key, value) {
                $("#jurusan").append("<option value='" + value.id_jurusan + "'>" +
                    value
                    .nama_jurusan +
                    "</option>");
            });
        })

        $("form").submit(function(event) {
            event
                .preventDefault(); // syntax ini berfungsi untuk menghentikan fungsi default dari form (singkatnya tidak akan terjadi apa2)
            var data = $(this).serialize();
            $.post("../controller/siswaApp.php?action=create", data, function(response) {
                // script success notification
                $('.alert').addClass("show");
                $('.alert').removeClass("hide");
                $('.alert').addClass("showAlert");
                setTimeout(function() {
                    $('.alert').removeClass("show");
                    $('.alert').addClass("hide");
                }, 5000);
            });
        })
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