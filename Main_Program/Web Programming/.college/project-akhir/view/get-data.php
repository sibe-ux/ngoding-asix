<?php

require_once("db.php");

if(isset($_GET['offset']) && isset($_GET['limit'])){

    $limit = $_GET['limit'];
    $offset = $_GET['offset'];

    $connect = mysqli_connect(HOST, SIBEUX, pass, DB);

    $data = mysqli_query($connect, "SELECT * FROM film ORDER BY title LIMIT $limit OFFSET $offset");

    while($row = mysqli_fetch_array($data)){
    $genre = explode(" ", $row['rating']);
    $title = ucwords($row['title']);
    echo "
    <div class='col col-lg-6 col-xl-4'>
                    <div class='product-container'>
                        <div class='product-card'>
                            <a href='film_detail.php?op=detail&id={$row['film_id']}' style='text-decoration: none'>
                                <img width='95' height='135'
                                    src='https://picsum.photos/95/135?random={$row['film_id']}'
                                    title='{ $title }' />
                            </a>
                            <div class='product-body'>
                                <a href='film_detail.php?op=detail&id={$row['film_id']}'
                                    style='text-decoration: none;'>
                                    <span class='product-title'>{$title}</span>
                                </a>
                                <div class='product-price'>{$row['description']}</div>";
                                echo "<div class='product-discount'>";
                                        for ($i = 0; $i < count($genre); $i++){
                                            echo "<a style='text-decoration: none;'>";
                                            echo "<span class='$genre[$i]'>$genre[$i]</span>";
                                            echo "</a>";
                                        }
                                        $year = $row['release_year'];
                                        $length = $row['length'];
                                        $id = $row['film_id'];
                                        echo "<span class='year'>$year</span>";
                                        $duration_minute = $length % 60;
                                        $duration_hour = ($length - $duration_minute) / 60;
                                        echo "<span class='cost'>{$duration_hour}h {$duration_minute}m</span>";
                                        echo "<br><br>";
                                        echo "<a href='film_detail.php?op=detail&id={$id}' style='text-decoration: none;'>";
                                        echo "<span class='detail'>Detail</span>";
                                        echo "</a>";
                                echo "</div>
                                <div class='btn'>
                                    <i class='bx bxs-edit-alt' onclick='edit({$id})'></i>
                                    <i class='bx bxs-trash'></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
    ";
    }
}

echo "<script>";
echo "function edit(id){
    location.href = 'form/edit.php?op=update&id=' + id;
}";
echo "</script>";