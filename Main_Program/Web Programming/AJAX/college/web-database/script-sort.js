var milih = document.getElementById("milih");
var data = document.getElementById("data");

milih.addEventListener("change",function () {
    // inisiasi objek ajax
    var ObjAjax = new XMLHttpRequest();
    
    // cek kesiapan ajax
    ObjAjax.onreadystatechange = function () {
        if (ObjAjax.readyState == 4 && ObjAjax.status == 200) {
            // ingin ngapain
            data.innerHTML = ObjAjax.responseText;
        }
    }

    ObjAjax.open("get","./data-sort.php?milih="+milih.value,true);
    ObjAjax.send();
}) 