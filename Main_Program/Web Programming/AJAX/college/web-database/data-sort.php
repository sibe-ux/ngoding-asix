<?php

require_once "./db.php";

$milih = $_GET["milih"];

$sql = "SELECT * FROM anime
        ORDER BY {$milih}
";

$result = $db->query($sql);

while ($row =  $result->fetch_assoc()) {
    $genre = explode(" ", $row['genre']);
    $title = ucwords($row['title']);
    echo "
    <div class='col col-lg-6 col-xl-4'>
                        <div class='product-container'>
                            <div class='product-card'>
                                <div class='product-image'>
                                    <img src='img/{$row['title']}.jpg' alt='' />
                                </div>
                                <div class='product-body'>
                                    <h3 class='product-title'>{$title}</h3>
                                    <div class='product-price'>{$row['desk']}
                                    </div>";
                                    echo "<div class='product-discount'>";
                                    foreach ($genre as $value) {
                                        echo "<span class='{$value}'>{$value}</span>" ;
                                    }
                                    echo "</div>
                                    <div class='product-rates'>";
                                    $star = $row['rating'];
                                    for ($i = 0; $i < $star; $i++){
                                        echo "<span class='yellow-star'>&#9733;</span>";
                                    }
                                    for ($i = 0; $i < 5 - $star; $i++){
                                        echo "<span>&#9733;</span>";
                                    }
                                    echo "$star/5";
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