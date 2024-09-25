$(document).ready(function() {

    var flag = 0;
    $.ajax({
        type: "GET",
        url: "get-data.php",
        data: {
            'offset': 0,
            'limit': 9
        },
        success: function(data) {
            $("body .row").append(data);
            flag += 9;
        }
    });

    $(window).scroll(function() {

        if ($(window).scrollTop() + $(window).height() > $(document).height() - 300) {
            $.ajax({
                type: "GET",
                url: "get-data.php",
                data: {
                    'offset': flag,
                    'limit': 9
                },
                success: function(data) {
                    $("body .row").append(data);
                    flag += 9;
                }
            });
        }
    })
});