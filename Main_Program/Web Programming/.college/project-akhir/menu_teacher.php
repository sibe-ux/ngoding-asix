<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>movie-create-update</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="css/menu_teacher.css">
    <link rel="stylesheet" href="card.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
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
                <li class="new">
                    <i class='bx bxs-user' onclick="dataSiswa()"></i>
                    <input type="submit" value="Data Siswa" onclick="dataSiswa()">
                    <span class="tooltip">Data Siswa</span>
                </li>
                <li class="new">
                    <i class='bx bx-book'></i>
                    <input type="submit" value="Tugas Harian">
                    <span class="tooltip">Tugas Harian</span>
                </li>
                <li class="new">
                    <i class='bx bx-trophy'></i>
                    <input type="submit" value="Ranking Nilai">
                    <span class="tooltip">Ranking Nilai</span>
                </li>
                <!-- <li>
                    <a href="#">
                        <i class='bx bx-cog'></i>
                        <span class="links_name">Setting</span>
                    </a>
                    <span class="tooltip">Setting</span>
                </li> -->
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
                        FLARE<span>ZONE</span>
                    </h1>
                </div>
            </header>
            <h1>
                <center mt-12>
                    SELAMAT DATANG DI FLAREZONE LEARNING
                </center>
            </h1>
            <div class="row" id="data">
                <!-- ================================================================================= -->
                <!-- lazy load image -->
                <!-- <?php 
                            if ($lazy < 10){
                            echo    "<img width='95' height='135'
                                    src='https://picsum.photos/95/135?random={$row['film_id']}' alt=''
                                    title='{$row['title']}' />";
                                    $lazy++;
                            }else{
                                echo    "<img width='95' height='135' class='lazy'
                                    data-src='https://picsum.photos/95/135?random={$row['film_id']}' alt=''
                                    title='{$row['title']}' />";
                            }
                            ?> -->
                <!-- ================================================================================= -->
            </div>
            

            <!-- <div class="d-grid gap-2 col-2 mx-auto">
                <button class="btn btn-danger center-block loadMore">
                    Load More</button>
            </div> -->
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

    // function to logout
    function logout(){
        location.href = "index.html";
    }

    function dataSiswa() {
        location.href = "data_siswa.php";
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
    <script src="script.js"></script>
    <script src="script-sort.js"></script>
    <script src="script-filter.js"></script>
    <script src="lazy-load.js"></script>
    <script src="view/get-dataa.js"></script>
</body>

</html>