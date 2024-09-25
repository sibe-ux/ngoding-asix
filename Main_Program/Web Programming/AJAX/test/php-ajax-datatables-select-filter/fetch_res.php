<?php

include 'model.php';

$model = new Model();

$rows = $model->fetch_res();

echo json_encode($rows);