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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>

<body>
    <!-- form bootstrap -->
    <div class="container">
        <h3>
            <span class="fa-solid fa-pen-to-square"></span>
            Add New Film
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
                    <input type="text" class="form-control" placeholder="Insert Title" id="title" name="title"
                        maxlength="30" required="required">
                    <div id="the-count-title">
                        <span id="current-title">0</span>
                        <span id="maximum-title">/ 30</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="description" class="col-sm-2 col-form-label control-label">Description</label>
                <div class="col-sm-10">
                    <textarea class="form-control" placeholder="Description" id="description" name="description"
                        maxlength="150"></textarea>
                    <div id="the-count">
                        <span id="current">0</span>
                        <span id="maximum">/ 150</span>
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="release_year" class="col-sm-2 col-form-label control-label">Release Year</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" placeholder="Year" id="release_year" name="release_year">
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="language_id">Language</label>
                <div class="col-sm-10">
                    <select class="form-select" id="language_id" name="language_id" required>
                        <option value="" selected="selected">--</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label class="col-sm-2 col-form-label control-label" for="original_language_id">Original
                    Language</label>
                <div class="col-sm-10">
                    <select class="form-select" id="original_language_id" name="original_language_id">
                        <option value="" selected="selected">--</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label for="rental_duration" class="col-sm-2 col-form-label control-label">Rental Duration</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Rental Duration"
                            aria-label="Recipient's username" aria-describedby="basic-addon2" required="required"
                            id="rental_duration" name="rental_duration">
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
                            required="required" id="rental_rate" name="rental_rate">
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="length" class="col-sm-2 col-form-label control-label">Length</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Length"
                            aria-label="Amount (to the nearest dollar)" aria-describedby="basic-addon2" id="length"
                            name="length">
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
                            required="required" id="replacement_cost" name="replacement_cost">
                    </div>
                </div>
            </div>

            <div class="form-group mb-2 required row">
                <label class="col-sm-2 col-form-label control-label" for="rating">Rating</label>
                <div class="col-sm-10">
                    <select class="form-select" id="rating" name="rating" required>
                        <option>--</option>
                        <option value="G">G</option>
                        <option value="PG">PG</option>
                        <option value="PG-13">PG-13</option>
                        <option value="R">R</option>
                        <option value="NC-17">NC-17</option>
                    </select>
                </div>
            </div>

            <div class="form-group mb-2 row">
                <label for="special_features" class="col-sm-2 col-form-label control-label">Special Features</label>
                <div class="col-sm-10">
                    <select class="form-select" multiple aria-label="multiple select example" id="special_features"
                        name="special_features[]">
                        <option value="Trailers">Trailers</option>
                        <option value="Commentaries">Commentaries</option>
                        <option value="Deleted Scenes">Deleted Scenes</option>
                        <option value="Behind the Scenes">Behind the Scenes</option>
                    </select>
                </div>
            </div>
            <div class="form-group mb-2 mt-md-4 row">
                <label for="inputEmail3" class="col-sm-2 col-form-label control-label"></label>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">
                        <span class="fa-solid fa-paper-plane"></span>
                        Submit
                    </button>
                    <button type="button" class="btn btn-outline-secondary" onclick="backAdd()">
                        <span class="fa-solid fa-arrow-left-long"></span>
                        Back</button>
                </div>
            </div>

            <div class="alert hide">
                <span class="fas fa-exclamation-circle"></span>
                <span class="msg">Success: Film has been added!</span>
                <div class="close-btn">
                    <span class="fas fa-times"></span>
                </div>
            </div>
        </form>
    </div>
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
    <script src="textareaLimit.js"></script>

    <script>
    $(document).ready(function() { // syntax ini berfungsi jika ditambahkan 3 cdn di atas
        $.get("language.php", function(response) {
            $.each(response, function(key, value) {
                $("#language_id").append("<option value='" + value.language_id + "'>" +
                    value
                    .name +
                    "</option>");
                // $("#original_language_id").append("<option value='" + value.language_id +
                //     "'>" + value
                //     .name +
                //     "</option>");
            });
        })

        $("form").submit(function(event) {
                event
            .preventDefault(); // syntax ini berfungsi untuk menghentikan fungsi default dari form (singkatnya tidak akan terjadi apa2)
                var data = $(this).serialize();
                $.post("film.php?action=create", data, function(response) {
                    // script success notification
                    $('.alert').addClass("show");
                    $('.alert').removeClass("hide");
                    $('.alert').addClass("showAlert");
                    setTimeout(function() {
                        $('.alert').removeClass("show");
                        $('.alert').addClass("hide");
                    }, 5000);
                });
            })
    });
    
    $('.close-btn').click(function() {
        $('.alert').removeClass("show");
        $('.alert').addClass("hide");
    });

    function backAdd() {
        location.href = "../index.php";
    }
    </script>
</body>

</html>