async function refreshAccessToken(refreshToken) {
	const clientId = "a13366c52a89450f938ad5964e4976fc";
	const clientSecret = "5259fd47c2a64c6ab2c16138fbcaa8d8";

	const tokenEndpoint = "https://accounts.spotify.com/api/token";

	const basicAuth = Buffer.from(`${clientId}:${clientSecret}`).toString(
		"base64"
	);

	const requestBody = new URLSearchParams();
	requestBody.append("grant_type", "refresh_token");
	requestBody.append("refresh_token", refreshToken);

	const response = await fetch(tokenEndpoint, {
		method: "POST",
		headers: {
			Authorization: `Basic ${basicAuth}`,
			"Content-Type": "application/x-www-form-urlencoded",
		},
		body: requestBody,
	});

	if (!response.ok) {
		throw new Error("Failed to refresh access token");
	}

	const responseData = await response.json();
	return responseData.access_token;
}

// Contoh penggunaan:
const refreshToken =
	"AQBI38smNBN4Xka0G9wn0LnUq6QqASg_rS3_ZufpWe7i0MJrqrPknQre21m22sUMLMDktkLrKOJQZYF3gMzWpBxqsIUd7MS5fGuKJ4cYP9qcVvJnxvx31RcRB4mXYzSoz9Y";

	refreshAccessToken(refreshToken)
	.then((accessToken) => {
		console.log("Access token:", accessToken);
	})
	.catch((error) => {
		console.error("Error refreshing access token:", error);
	});
