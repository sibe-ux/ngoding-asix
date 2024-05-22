<?php
require_once("../db.php");

$op = isset($_GET['op']) ? $_GET['op'] : "";
$loc = $op;
$id = isset($_GET['id']) ? $_GET['id'] : '';
$sql = "SELECT * FROM film WHERE film_id = '$id'";
$table_language = "SELECT * FROM language";
$language = "SELECT film.film_id, film.language_id, language.name
                from language
                join film 
                on language.language_id = film.language_id where film.film_id = '$id'";
$query_language = mysqli_query($db, $language) or die(mysqli_error($db));
$query = mysqli_query($db, $sql) or die(mysqli_error($db));
$table_language = mysqli_query($db, $table_language) or die(mysqli_error($db));

$data = [];

while ($row = mysqli_fetch_array($query)) {
    array_push($data, $row);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="confirm.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- pooper js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous">
    </script>
    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous">
    </script>
</head>

<body">
    <!-- form bootstrap -->
    <div class="container">
        <h3>
            <span class="fa-solid fa-pen-to-square"></span>
            Update Existing Film
        </h3>
        <form>

            <!-- <div class="form-group mb-2 required row">
                <label class="col-md-2 control-label">E-mail</label>
                <div class="col-md-4"><input class="form-control" id="id_email" name="email" placeholder="E-mail"
                        required="required" title="" type="email" /></div>
            </div> -->

            <!-- mb = margin bottom -->

            <div class="form-group mb-2 row">
                <!-- <label for="exampleFormControlSelect1" class="col-sm-2 col-form-label control-label">Thumbnail</label> -->
                <!-- kalo pake for="exampleFormControlSelect1", entar labelnya jadi bisa kepencet, harusnya ga bisa diapa2in karena cuma judul -->
                <label for="thumbnail" class="col-sm-2 col-form-label control-label">Thumbnail</label>
                <!-- makanya pake thumbnail biar ga bisa dipencet slebewwww -->
                <div class="col-sm-10">
                    <input class="form-control" type="file" id="thumbnail" name="thumbnail">
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="title" class="col-sm-2 col-form-label control-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="Insert Title" maxlength="30" id="title"
                        name="title" value="<?php echo $row['title']; ?>" required="required">
                    <div id="the-count-title">
                        <span id="current-title"><?php echo strlen($row['title']); ?></span>
                        <span id="maximum-title">/ 30</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="description" class="col-sm-2 col-form-label control-label">Description</label>
                <div class="col-sm-10">
                    <textarea class="form-control" placeholder="Description" id="description" maxlength="150"
                        name="description"
                        value="<?php echo $row['description']; ?>"><?php echo $row['description']; ?></textarea>
                    <div id="the-count">
                        <span id="current"><?php echo strlen($row['description']); ?></span>
                        <span id="maximum">/ 150</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="release_year" class="col-sm-2 col-form-label control-label">Release Year</label>
                <div class="col-sm-10">
                    <input type="number" placeholder="Year" class="form-control"
                        value="<?php echo $row['release_year']; ?>" id="release_year" name="release_year">
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="language_id">Language</label>
                <div class="col-sm-10">
                    <select class="form-select" id="language_id" name="language_id" required>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label class="col-sm-2 col-form-label control-label" for="original_language_id">Original
                    Language</label>
                <div class="col-sm-10">
                    <select class="form-select" id="original_language_id" name="original_language_id">
                        <option value="" selected="selected">-</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="rental_duration" class="col-sm-2 col-form-label control-label">Rental Duration</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Rental Duration"
                            aria-label="Recipient's username" aria-describedby="basic-addon2" required="required"
                            id="rental_duration" name="rental_duration" value="<?php echo $row['rental_duration']; ?>">
                        <span class="input-group-text" id="inputGroup-sizing-default">Days</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="rental_rate" class="col-sm-2 col-form-label control-label">Rental Rate</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <span class="input-group-text" id="inputGroup-sizing-default">$</span>
                        <input type="number" step="0.01" class="form-control" placeholder="Rental Rate"
                            aria-label="Amount (to the nearest dollar)" aria-describedby="basic-addon2"
                            required="required" id="rental_rate" name="rental_rate"
                            value="<?php echo $row['rental_rate']; ?>">
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="length" class="col-sm-2 col-form-label control-label">Length</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Length"
                            aria-label="Amount (to the nearest dollar)" aria-describedby="basic-addon2" id="length"
                            name="length" value="<?php echo $row['length']; ?>">
                        <span class="input-group-text" id="inputGroup-sizing-default">Minutes</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="replacement_cost" class="col-sm-2 col-form-label control-label">Replacement Cost</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <span class="input-group-text" id="inputGroup-sizing-default">$</span>
                        <input type="number" step="0.01" class="form-control" placeholder="Replacement Cost"
                            aria-label="Amount (to the nearest dollar)" aria-describedby="basic-addon2"
                            required="required" id="replacement_cost" name="replacement_cost"
                            value="<?php echo $row['replacement_cost']; ?>">
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="rating">Rating</label>
                <div class="col-sm-10">
                    <select class="form-select" id="rating" name="rating" required>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="special_features" class="col-sm-2 col-form-label control-label">Special Features</label>
                <div class="col-sm-10">
                    <select class="form-select" multiple aria-label="multiple select example" id="special_features"
                        name="special_features[]">
                    </select>
                </div>
            </div>

            <div id="dom-target" style="display: none;">
                <?php
                    $result =  json_encode($data);
                    echo htmlspecialchars($result);
                    ?>
            </div>
            <?php };
            ?>
            <div class="form-group mb-2 mt-md-4 row">
                <label for="inputEmail3" class="col-sm-2 col-form-label control-label"></label>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary" name="submit">
                        <span class="fa-solid fa-paper-plane"></span>
                        Submit
                    </button>

                    <button type="button" class="btn btn-outline-secondary" onclick="backAdd()">
                        <span class="fa-solid fa-arrow-left-long"></span>
                        Back</button>
                </div>
            </div>
        </form>

        <div class="alert hide">
            <span class="fas fa-exclamation-circle"></span>
            <span class="msg">Success: Film has been updated!</span>
            <div class="close-btn">
                <span class="fas fa-times"></span>
            </div>
        </div>
    </div>
    <script src="textareaLimit.js"></script>

    <script>
    var div = document.getElementById('dom-target');
    var myData = div.textContent;
    var data = JSON.parse(myData);

    $(document).ready(function() { // syntax ini berfungsi jika ditambahkan 3 cdn di atas
        $.get("language.php", function(response) {
            idLanguage = data[0]['language_id'];
            $.each(response, function(key, value) {
                if (value.language_id == idLanguage) {
                    $('#language_id').append("<option selected value='" + value.language_id +
                        "'>" +
                        value
                        .name +
                        "</option>");
                    // $("#original_language_id").append("<option selected value='" + value.original_language_id +
                    // "'>" + value
                    // .name +
                    // "</option>");
                } else {
                    $("#language_id").append("<option value='" + value.language_id + "'>" +
                        value
                        .name +
                        "</option>");
                }
            });
        })

        const ratings = ["G", "PG", "PG-13", "R", "NC-17"];
        var rating = data[0]['rating'];
        ratings.forEach(myFunctionRating);

        function myFunctionRating(item, index) {
            if (item == rating) {
                $('#rating').append("<option selected value='" + item + "'>" + item + "</option>");
            } else {
                $('#rating').append("<option value='" + item + "'>" + item + "</option>");
            }
        }

        const features = ["Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes"];
        var special_features = (data[0]['special_features']).split(",");
        console.log(special_features);
        features.forEach(myFunctionFeatures);

        function myFunctionFeatures(item, index) {
            if (special_features.includes(item)) {
                $('#special_features').append("<option selected value='" + item + "'>" + item + "</option>");
            } else {
                $('#special_features').append("<option value='" + item + "'>" + item + "</option>");
            }
        }

        var film_id = data[0]['film_id'];
        $("form").submit(function(event) {
            event.preventDefault();
            var data = $(this).serialize();
            $.post("film.php?action=update&id=" + film_id, data, function(response) {
                // script untuk menampilkan notifikasi
                $('.alert').addClass("show");
                $('.alert').removeClass("hide");
                $('.alert').addClass("showAlert");
                setTimeout(function() {
                    $('.alert').removeClass("show");
                    $('.alert').addClass("hide");
                }, 5000);
            });
        })
    })

    $('.close-btn').click(function() {
        $('.alert').removeClass("show");
        $('.alert').addClass("hide");
    });

    function backAdd() {
        location.href = "../film_detail.php?op=detail&id=" + data[0]['film_id'];
    }

    function submitBtn() {
        location.href = "#myModal";
    }
    </script>
    </body>

</html>