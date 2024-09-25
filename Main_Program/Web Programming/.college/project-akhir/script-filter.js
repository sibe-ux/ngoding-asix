var genre = document.getElementById("genre");
var data = document.getElementById("data");

genre.addEventListener("change",function () {
    // inisiasi objek ajax
    var ObjAjax = new XMLHttpRequest();
    
    // cek kesiapan ajax
    ObjAjax.onreadystatechange = function () {
        if (ObjAjax.readyState == 4 && ObjAjax.status == 200) {
            // ingin ngapain
            data.innerHTML = ObjAjax.responseText;
        }
    }

    ObjAjax.open("get","./controller/filter-siswaApp.php?genre="+genre.value,true);
    ObjAjax.send();
}) 