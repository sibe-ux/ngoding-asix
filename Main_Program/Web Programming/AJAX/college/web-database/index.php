<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="styling.css">
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
                        <option value="rating ASC">Rating ASC</option>
                        <option value="rating DESC">Rating DESC</option>
                    </select>
                    <span class="tooltip">Sort</span>
                </li>
                <li>
                    <i class='bx bx-filter-alt'></i>
                    <select class="form-select" aria-label="Default select example" id="genre">
                        <option selected value="all">ALL</option>
                        <option value="fantasy">Fantasy</option>
                        <option value="demons">Demons</option>
                        <option value="romance">Romance</option>
                        <option value="school">School</option>
                        <option value="drama">Drama</option>
                        <option value="sci-fi">Sci-fi</option>
                        <option value="action">Action</option>
                        <option value="kids">Kids</option>
                        <option value="advanture">Advanture</option>
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
                <?php
                require_once('./db.php');

                $sql = "SELECT * FROM anime";

                $result =  $db->query($sql);

                while ($row = $result->fetch_assoc()) :
                ?>
                <div class="col col-lg-6 col-xl-4">
                    <div class="product-container">
                        <div class="product-card">
                            <div class="product-image">
                                <img src="img/<?=$row['title']?>.jpg" alt="" />
                            </div>
                            <div class="product-body">
                                <h3 class="product-title"><?= ucwords($row['title']) ?></h3>
                                <div class="product-price"><?= $row['desk'] ?>
                                </div>
                                <div class="product-discount">
                                    <?php
                                        $genre = explode(" ", $row['genre']);
                                        for ($i = 0; $i < count($genre); $i++){
                                            echo "<span class='$genre[$i]'>$genre[$i]</span>";
                                        }
                                        ?>
                                </div>
                                <div class="product-rates">
                                    <?php 
                                        $star = $row['rating'];
                                        for ($i = 0; $i < $star; $i++){
                                            echo "<span class='yellow-star'>&#9733;</span>";
                                        }
                                        for ($i = 0; $i < 5 - $star; $i++){
                                            echo "<span>&#9733;</span>";
                                        }
                                        echo "$star/5";
                                        ?>
                                </div>
                                <div class="btn">
                                    <i class='bx bxs-edit-alt'></i>
                                    <i class='bx bxs-trash'></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <?php endwhile; ?>
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
    <!-- <script src="script-search-sort.js"></script> -->
</body>

</html>