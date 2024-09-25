<html>
<head>
    <title>Login - Assigment Helper</title>
	<link rel="stylesheet" type="text/css" href="style1.css">
	<link rel="icon" href="gambar/AssigmentHelperLogo.png"/>
    <style>
        body {
			background-color:rgb(205, 230, 255);
		}
        h3 {
            font-family:'Times New Roman', Times, serif;
        }
        fieldset {
			background-color:rgb(234, 251, 255);
		}
        input[type=submit], input[type=reset] {
			background-color:#1663d6;
			color:#fff;
			border:1px solid #999;
			padding:5px;
			font-size:18px;
			cursor:pointer;
			border-radius:3px;
			margin-top:15px;
			margin-bottom:15px;
			margin-right:5px;
			font-family:Georgia; }
    </style>
</head>
<body>
    <div id="main">
        <h1><center>Login Assigment Helper</center></h1>
        <fieldset><legend><h3>Login Form</h3></legend>
            <form action="login_proses.php" method="POST">

                <label>Username</label>
                <input type="text" name="username" id="TPDF" placeholder="Username">

                <label>Password</label>
                <input type="password" name="password" id="TPDF" placeholder="••••••••••">

                <input type="submit" name="login" id="" value="Login"><input type="reset" name="reset" id="" value="Reset"><br>
                <a href="register.html">Belum Punya Account? Daftar</a>

            </form>
        </fieldset>
    </div>
</body>
</html>