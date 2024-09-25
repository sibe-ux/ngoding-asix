<!-- get variable from php in javascript -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div id="dom-target">
    <?php 
    $output = "42";
    echo htmlspecialchars($output);
    ?>
</div>
<script>
    var div = document.getElementById("dom-target");
    var myData = div.textContent;
    alert(myData)
</script>
</body>
</html>