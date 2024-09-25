var typing = document.getElementById("typing");

typing.addEventListener("keyup", function () {
	$.ajax({
		url: "./data2.php",
		method: "get",
		data: { typing: typing.value },
		dataType: "json",
		success: function (response) {
			var panjang = response.length;
			$("#data").html("");
			if (panjang == 0) {
				$("#data").html(
					"<tr><td>" +
						"data tidak ditemukan" +
						"</td>" +
						"<td>" +
						"data tidak ditemukan" +
						"</td>" +
						"<td>" +
						"data tidak ditemukan" +
						"</td>" +
						"<td>" +
						"data tidak ditemukan" +
						"</td></tr>"
				);
			} else {
				for (var i = 0; i < panjang; i++) {
					$("#data").append(
						"<tr><td>" +
							response[i]["nama"] +
							"</td>" +
							"<td>" +
							response[i]["nim"] +
							"</td>" +
							"<td>" +
							response[i]["email"] +
							"</td>" +
							"<td>" +
							response[i]["jurusan"] +
							"</td></tr>"
					);
				}
			}
		},
	});
});
