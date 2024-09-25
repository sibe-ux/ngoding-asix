var typing = document.getElementById("typing");

typing.addEventListener("keyup", function () {
	$("#data").html("");
	$.get("./data2.php?typing=" + typing.value, function (response) {
		var panjang = response.length;
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
	});
});
