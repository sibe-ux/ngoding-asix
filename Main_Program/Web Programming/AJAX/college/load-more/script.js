var typing = document.getElementById("typing");
var data = document.getElementById("data");

typing.addEventListener("keyup",function () {
    // inisiasi objek ajax
    var ObjAjax = new XMLHttpRequest();

    // cek kesiapan ajax
    ObjAjax.onreadystatechange = function () {
        if (ObjAjax.readyState == 4 && ObjAjax.status == 200) {
            // ingin ngapain
            data.innerHTML = ObjAjax.responseText;
        }
    }

    ObjAjax.open("get","./data.php?typing="+typing.value,true);
    ObjAjax.send();
}) 