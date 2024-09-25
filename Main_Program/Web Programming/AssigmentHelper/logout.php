<?php
session_start();
session_unset();
session_destroy();

unset($_SESSION['username']);
unset($_SESSION['login']);

echo "<script>alert('Logout Sukses'); window.location=('index.php');</script>";

?>