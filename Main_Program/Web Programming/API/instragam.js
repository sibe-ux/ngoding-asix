var url = "https://www.instagram.com/nasrulwahabi";
$.get(url, function (err, response, body) {
	if (response.body.indexOf('meta property="og:description" content="') != -1) {
		console.log(
			"followers:",
			response.body
				.split('meta property="og:description" content="')[1]
				.split("Followers")[0]
		);
	}
});
