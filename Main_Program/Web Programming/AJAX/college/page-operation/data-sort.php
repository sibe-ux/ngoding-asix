<?php

require_once "./db.php";

$milih = $_GET["milih"];

$sql = "SELECT * FROM film
        ORDER BY {$milih}
";

$result = $db->query($sql);

while ($row =  $result->fetch_assoc()) {
    $genre = explode(" ", $row['rating']);
    $title = ucwords($row['title']);
    echo "
    <div class='col col-lg-6 col-xl-4'>
                        <div class='product-container'>
                            <div class='product-card'>
                                <div class='product-image'>
                                    <img src='img/film.png' alt='' />
                                </div>
                                <div class='product-body'>
                                    <h3 class='product-title'>{$title}</h3>
                                    <div class='product-price'>{$row['description']}
                                    </div>";
                                    echo "<div class='product-discount'>";
                                    foreach ($genre as $value) {
                                        echo "<span class='{$value}'>{$value}</span>" ;
                                    }
                                    echo "<br><br>" ;
                                    echo "<span class='cost'>COST : {$row['replacement_cost']}</span>";
                                    echo "</div>
                                    <div class='btn'>
                                        <i class='bx bxs-edit-alt'></i>
                                        <i class='bx bxs-trash'></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
    ";
}