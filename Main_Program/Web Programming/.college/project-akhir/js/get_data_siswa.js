$(document).ready(function() {

    var flag = 0;
    $.ajax({
        type: "GET",
        url: "get_data_siswa.php",
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
            url: "get_data_siswa.php",
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