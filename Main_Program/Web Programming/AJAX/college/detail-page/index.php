<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="style.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container">
        <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxs-camera-movie icon'></i>
                <div class="logo_name">CbuxCinema</div>
                <i class='bx bx-menu' id="btn"></i>
            </div>
            <ul class="nav-list">
                <li>
                    <i class='bx bx-search'></i>
                    <input type="text" placeholder="Search..." id="typing">
                    <span class="tooltip">Search</span>
                </li>
                <li>
                    <i class='bx bx-sort-alt-2'></i>
                    <select class="form-select" aria-label="Default select example" id="milih">
                        <option selected value="title ASC">Title ASC</option>
                        <option value="title DESC">Title DESC</option>
                        <option value="replacement_cost ASC">Cost ASC</option>
                        <option value="replacement_cost DESC">Cost DESC</option>
                    </select>
                    <span class="tooltip">Sort</span>
                </li>
                <li>
                    <i class='bx bx-filter-alt'></i>
                    <select class="form-select" aria-label="Default select example" id="genre">
                        <option selected value="all">ALL</option>
                        <option value="PG">PG</option>
                        <option value="R">R</option>
                        <option value="G">G</option>
                        <option value="PG-13">PG-13</option>
                        <option value="NC-17">NC-17</option>
                    </select>
                    <span class="tooltip">Filter</span>
                </li>
                <li>
                    <a href="https://youtu.be/dQw4w9WgXcQ" target="_blank">
                        <i class='bx bxl-facebook'></i>
                        <span class="links_name">Facebook</span>
                    </a>
                    <span class="tooltip">Facebook</span>
                </li>
                <li>
                    <a href="https://youtu.be/dQw4w9WgXcQ" target="_blank">
                        <i class='bx bxl-youtube'></i>
                        <span class="links_name">Youtube</span>
                    </a>
                    <span class="tooltip">Youtube</span>
                </li>
                <li>
                    <a href="https://youtu.be/dQw4w9WgXcQ" target="_blank">
                        <i class='bx bxl-instagram'></i>
                        <span class="links_name">Instagram</span>
                    </a>
                    <span class="tooltip">Instagram</span>
                </li>
                <li>
                    <a href="https://www.github.com/sibeux" target="_blank">
                        <i class='bx bxl-github'></i>
                        <span class="links_name">Github</span>
                    </a>
                    <span class="tooltip">Github</span>
                </li>
                <li>
                    <a href="https://youtu.be/dQw4w9WgXcQ" target="_blank">
                        <i class='bx bxl-linkedin'></i>
                        <span class="links_name">LinkedIn</span>
                    </a>
                    <span class="tooltip">LinkedIn</span>
                </li>
                <li>
                    <a href="https://youtu.be/dQw4w9WgXcQ" target="_blank">
                        <i class='bx bxl-google'></i>
                        <span class="links_name">wahabinasrul</span>
                    </a>
                    <span class="tooltip">Google</span>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-cog'></i>
                        <span class="links_name">Setting</span>
                    </a>
                    <span class="tooltip">Setting</span>
                </li>
                <li class="profile">
                    <div class="profile-details">
                        <img src="img/sibeux.jpg" alt="profileImg">
                        <div class="name_job">
                            <div class="name">SibeUX</div>
                            <div class="job">Movie Cinema</div>
                        </div>
                    </div>
                    <i class='bx bx-log-out' id="log_out"></i>
                </li>
            </ul>
        </div>
        <div class="home">
            <header>
                <div class="header-content">
                    <h1>
                        Cbux<span>Cinema</span>
                    </h1>
                </div>
            </header>
            <div class="row" id="data">
                <!-- ================================================================================= -->
                <!-- lazy load omage -->
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
        </div>
        <footer>
            <div class="footer-content">
                <h3>Sibeux Platform</h3>
                <p>Tempat streaming film terbaru dan terkeren dengan
                    pengalaman menonton yang lebih seru!
                </p>
                <ul class="socials">
                    <li><a href="https://www.facebook.com/m.n.wahabi/" target="_blank"><i
                                class="fa fa-facebook"></i></a></li>
                    <li><a href="https://www.instagram.com/nasrulwahabi" target="_blank"><i
                                class="fa fa-instagram"></i></a></li>
                    <li><a href="https://www.github.com/sibeux" target="_blank"><i class="fa fa-github"></i></a></li>
                    <li><a href="https://bit.ly/HabiqiYT" target="_blank"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="https://www.linkedin.com/in/m-nasrul-wahabi-a35a97181/" target="_blank"><i
                                class="fa fa-linkedin-square"></i></a></li>
                </ul>
            </div>
            <div class="footer-bottom">
                <p>copyright &copy;2022 Sibeux. Created by <span>Nasrul Wahabi</span></p>
            </div>
        </footer>
    </div>
    <script>
    let sidebar = document.querySelector(".sidebar");
    let closeBtn = document.querySelector("#btn");
    let searchBtn = document.querySelector(".bx-search");
    let sortBtn = document.querySelector(".bx-sort-alt-2");
    let filterBtn = document.querySelector(".bx-filter-alt");

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

    // following are the code to change sidebar button(optional)
    function menuBtnChange() {
        if (sidebar.classList.contains("open")) {
            closeBtn.classList.replace("bx-menu", "bx-menu-alt-right"); //replacing the iocns class
        } else {
            closeBtn.classList.replace("bx-menu-alt-right", "bx-menu"); //replacing the iocns class
        }
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
    <script src="get-data.js"></script>
</body>

</html>