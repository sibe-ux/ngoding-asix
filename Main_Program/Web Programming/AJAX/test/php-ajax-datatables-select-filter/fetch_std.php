<?php

include 'model.php';

$model = new Model();

$rows = $model->fetch_std();

echo json_encode($rows);