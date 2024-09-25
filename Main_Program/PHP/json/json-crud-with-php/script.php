<?php 
	require("user.class.php");
	
	// I have an associative array with the user's details.
	$new_user = [
		"username" => "Peter",
		"password" => "1234",
		"status" => "active"
	];

	// I create a new user object.
	require("user.class.php");
	$user = new User('users.json');
	