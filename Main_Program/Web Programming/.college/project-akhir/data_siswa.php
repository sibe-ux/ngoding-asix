<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>movie-create-update</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="setel.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container">
    <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxs-graduation'></i>
                <div class="logo_name">FLAREZONE</div>
                <i class='bx bx-menu' id="btn"></i>
            </div>
            <ul class="nav-list">
                <li>
                    <a href="form/siswa_new_form.php">
                        <i class='bx bx-user-plus'></i>
                        <span class="links_name">Tambah Siswa</span>
                    </a>
                    <span class="tooltip">Tambah Siswa</span>
                </li>
                <li>
                    <i class='bx bx-search'></i>
                    <input type="text" placeholder="Cari Nama" id="typing">
                    <span class="tooltip">Cari Nama</span>
                </li>
                <li>
                    <i class='bx bx-sort-alt-2'></i>
                    <select class="form-select" aria-label="Default select example" id="milih">
                        <option selected value="nis ASC">NIS teratas</option>
                        <option value="nis DESC">NIS terbawah</option>
                        <option value="nama_siswa ASC">Nama teratas</option>
                        <option value="nama_siswa DESC">Nama terbawah</option>
                    </select>
                    <span class="tooltip">Sort</span>
                </li>
                <li>
                    <i class='bx bx-filter-alt'></i>
                    <select class="form-select" aria-label="Default select example" id="genre">
                        <option selected value="all">ALL</option>
                        <option value="1">MIPA</option>
                        <option value="2">IPS</option>
                        <option value="3">BAHASA</option>
                        <option value="4">SENI</option>
                        <option value="5">OLAHRAGA</option>
                        <option value="6">MESIN</option>
                    </select>
                    <span class="tooltip">Filter</span>
                </li>
                <li>
                    <a href="menu_teacher.php">
                    <i class='bx bxs-home'></i>
                        <span class="links_name">Menu Utama</span>
                    </a>
                    <span class="tooltip">Menu Utama</span>
                </li>
                <li class="profile">
                    <div class="profile-details">
                        <img src="img/logs.png" alt="profileImg">
                        <div class="name_job">
                            <div class="name">FlareZone</div>
                            <div class="job">School Learning</div>
                        </div>
                    </div>
                    <a href="index.html">
                        <i class='bx bx-log-out' id="log_out"></i>
                    </a>
                </li>
            </ul>
        </div>
        <div class="home">
        <header>
                <div class="header-content">
                    <h1>
                        DATA<span> SISWA</span>
                    </h1>
                </div>
            </header>
            <div class="row" id="data">

            </div>
            <div class="d-grid gap-2 col-2 mx-auto">
                <button class="btn btn-danger center-block loadMore">
                    Load More</button>
            </div>
        </div>
        <footer>
            <div class="footer-content">
                <h3>Flarezone Learning</h3>
                <p>Platform untuk membantu siswa dan guru dalam mengelola
                    tugas harian dan juga rekap nilai!
                </p>
                <ul class="socials">
                    <li><a href="https://www.facebook.com/m.n.wahabi/" target="_blank"><i
                                class="fa fa-facebook"></i></a>
                    </li>
                    <li><a href="https://www.instagram.com/nasrulwahabi" target="_blank"><i
                                class="fa fa-instagram"></i></a>
                    </li>
                    <li><a href="https://www.github.com/sibeux" target="_blank"><i class="fa fa-github"></i></a></li>
                    <li><a href="https://bit.ly/HabiqiYT" target="_blank"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="https://www.linkedin.com/in/m-nasrul-wahabi-a35a97181/" target="_blank"><i
                                class="fa fa-linkedin-square"></i></a></li>
                </ul>
            </div>
            <div class="footer-bottom">
                <p>copyright &copy;2022 FZL. Created by <span>Flarezone Foundation</span></p>
            </div>
        </footer>
    </div>
    <script>
    let sidebar = document.querySelector(".sidebar");
    let closeBtn = document.querySelector("#btn");
    let searchBtn = document.querySelector(".bx-search");
    let sortBtn = document.querySelector(".bx-sort-alt-2");
    let filterBtn = document.querySelector(".bx-filter-alt");
    let submitBtn = document.querySelector(".bx-folder-plus");

    closeBtn.addEventListener("click", () => {
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    searchBtn.addEventListener("click", () => { // Sidebar open when you click on the search iocn
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    sortBtn.addEventListener("click", () => { // Sidebar open when you click on the sort iocn
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    filterBtn.addEventListener("click", () => { // Sidebar open when you click on the filter iocn
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    submitBtn.addEventListener("click", () => { // Sidebar open when you click on the filter iocn
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    // following are the code to change sidebar button(optional)
    function menuBtnChange() {
        if (sidebar.classList.contains("open")) {
            closeBtn.classList.replace("bx-menu", "bx-menu-alt-right"); //replacing the iocns class
        } else {
            closeBtn.classList.replace("bx-menu-alt-right", "bx-menu"); //replacing the iocns class
        }
    }

    function addFilm() {
        location.href = "form/new.php";
    }
    </script>
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
    <script src="js/search-siswa.js"></script>
    <script src="script-sort.js"></script>
    <script src="script-filter.js"></script>
    <script src="js/get_data_siswa.js"></script>
</body>

</html>