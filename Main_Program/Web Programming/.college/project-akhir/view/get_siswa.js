$(document).ready(function() {

    var flag = 0;
    $.ajax({
        type: "GET",
        url: "get_siswa.php",
        data: {
            'offset': 0,
            'limit': 6
        },
        success: function(data) {
            $("body .row").append(data);
            flag += 6;
        }
    });

    $(".loadMore").click(function() {
        $.ajax({
            type: "GET",
            url: "get_siswa.php",
            data: {
                'offset': flag,
                'limit': 6
            },
            success: function(data) {
                $("body .row").append(data);
                flag += 6;
            }
        });
    });
    
});

// $(document).ready(function() {

//     $(".col col-lg-6 col-xl-4").slice(0,3).show(); 
//     // menampilkan 3 div

//     $(".loadMore").on('click', function() {
//         $(".col col-lg-6 col-xl-4:hidden".slice(0,3)).show();
//         // menampilkan 3 hidden on lcick

//         if($(".col col-lg-6 col-xl-4:hidden").length == 0)
//         {
//             $(".loadMore").fadeOut(); // will hide 
//             // button when length is 0
//         }
//     })
// });