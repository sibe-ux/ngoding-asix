<?php

require_once "./db.php";

if(isset($_GET['op'])){
    $op = $_GET['op'];
}else{
    $op = "";
}

if($op == 'detail'){
    $id = $_GET['id'];
    $sql = "SELECT * FROM film WHERE film_id = '$id'";
    $language = "SELECT film.film_id, film.language_id, language.name
    from language
    join film 
    on language.language_id = film.language_id where film.film_id = '$id'";
    $query_language = mysqli_query($db, $language) or die( mysqli_error($db));
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
    <!-- bootstrap css -->
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="style-detil.css">
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
                    <input type="text" placeholder="Search...">
                    <span class="tooltip">Search</span>
                </li>
                <li>
                    <i class='bx bx-sort-alt-2'></i>
                    <select class="form-select" aria-label="Default select example">
                        <option selected value="title ASC">Title ASC</option>
                        <option value="title DESC">Title DESC</option>
                        <option value="replacement_cost ASC">Cost ASC</option>
                        <option value="replacement_cost DESC">Cost DESC</option>
                    </select>
                    <span class="tooltip">Sort</span>
                </li>
                <li>
                    <i class='bx bx-filter-alt'></i>
                    <select class="form-select" aria-label="Default select example">
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
                <?php
                    while ($row = $query->fetch_assoc()) :
                    ?>
                <div class="col">
                    <div class="product-container">
                        <div class="product-card">
                            <a style="text-decoration: none">
                                <img width="237" height="337"
                                    src='https://picsum.photos/237/337?random=<?=$row['film_id']?>' alt=""
                                    title="<?= ucwords($row['title']) ?>" />
                            </a>
                            <div class="product-body">
                                <a style="text-decoration: none;">
                                    <span class="product-title"><?= ucwords($row['title']) ?></span>
                                    <span class='year'><?=$row['release_year'] ?></span>
                                    <div class="product-discount">
                                        <?php
                                            $genre = explode(" ", $row['rating']);
                                            for ($i = 0; $i < count($genre); $i++){
                                                echo "<a style='text-decoration: none;'>";
                                                echo "<span class='$genre[$i]'>$genre[$i]</span>";
                                                echo "</a>";
                                            }
                                            echo "<span class='features'>• $row[special_features] • </span>";
                                            $length = $row['length'];
                                            $id = $row['film_id'];
                                            $duration_minute = $length % 60;
                                            $duration_hour = ($length - $duration_minute) / 60;
                                            echo "<span class='cost'>{$duration_hour}h {$duration_minute}m</span>";
                                            ?>
                                    </div>
                                </a>
                                <br>
                                <span class="overview">Overview</span>
                                <div class="product-price"><?= $row['description'] ?></div>
                                <br>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="row" class="text-center">Language</th>
                                            <th scope="row" class="text-center">Rental Duration</th>
                                            <th scope="row" class="text-center">Rental Rate</th>
                                            <th scope="row" class="text-center">Replacement Cost</th>
                                        </tr>
                                    <tbody>
                                        <tr>
                                            <td style="text-align:center">
                                            <?php 
                                            while ($row2 = $query_language->fetch_assoc()) :
                                                ?>
                                                <?php echo "<span class='language'>{$row2['name']}</span>"; ?>
                                            <?php endwhile; ?>
                                            </td>
                                            <td style="text-align:center">
                                                <?php echo "<span class='duration'>{$row['rental_duration']} Days</span>"; ?>
                                            </td>
                                            <td style="text-align:center">
                                                <?php echo "<span class='rate'>$ {$row['rental_rate']}</span>"; ?></td>
                                            <td style="text-align:center">
                                                <?php echo "<span class='cost'>$ {$row['replacement_cost']}</span>"; ?>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="button" style="text-align:center" colspan="2">
                                                <div class="input-group" style="width: 100%; height: 100%;">
                                                <br><br>
                                                <div class="spacer"></div>
                                                <a href="index.php">
                                                    <input type="button" style="width: 100%; height: 100%;"
                                                        value="<-  Back" />
                                                </a>
                                                </div>
                                            </td>
                                            <td class="button" style="text-align:center;">
                                                <div class="input-group" style="width: 100%; height: 100%;">
                                                <br><br>
                                                <div class="spacer"></div>
                                                    <input type="button" class="edit" style="width: 100%; height: 100%;"
                                                        value="Edit" />

                                                </div>
                                            </td>
                                            <td class="button" style="text-align:center;">
                                                <div class="input-group" style="width: 100%; height: 100%;">
                                                <br><br>
                                                <div class="spacer"></div>
                                                    <input type="button" class="delete" style="width: 100%; height: 100%;"
                                                        value="Remove" />
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                    </thead>
                                </table>
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
</body>
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

</html>