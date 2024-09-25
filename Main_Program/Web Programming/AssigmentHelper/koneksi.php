<?php

    $koneksi = mysqli_connect("localhost", "root", "", "assigment_helper");

    if(!$koneksi){
        echo"koneksi Gagal";
    }
?>