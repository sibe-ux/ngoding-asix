document.addEventListener("DOMContentLoaded", function () {
	const pages = document.querySelectorAll(".pagination .page");

	pages.forEach((page) => {
		page.addEventListener("click", function (event) {
			event.preventDefault();
			pages.forEach((p) => p.classList.remove("active"));
			page.classList.add("active");
		});
	});
});
