<?php

include 'model.php';

$model = new Model();

if (isset($_POST['std']) && isset($_POST['res']) && !empty($_POST['std']) && !empty($_POST['res'])) {
    $std = $_POST['std'];
    $res = $_POST['res'];

    $rows = $model->fetch_filter($std, $res);
} elseif (isset($_POST['std']) && empty($_POST['res'])) {
    $std = $_POST['std'];

    $rows = $model->fetch_std_filter($std);
} elseif (empty($_POST['std']) && isset($_POST['res'])) {
    $res = $_POST['res'];

    $rows = $model->fetch_res_filter($res);
} else {
    $rows = $model->fetch();
}

echo json_encode($rows);