<!DOCTYPE html>
<html>
    <!-- DOCUMENT HEAD SECTION -->
    <head>
        <!-- UTF-8 CHARSET META -->
        <meta charset = "UTF-8" >
        <!-- SITE TITLE -->
        <title>News article site</title>
        <!-- STYLE FILE LINK -->
        <link rel = "stylesheet" type = "text/css" href = "style.css" >
        <!-- SCRIPT WITH DATEFIX FUNCTION DEFINITION -->
        <script>
            function dateFix(){
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth()+1; //Adding one because January is month 0!
                var yyyy = today.getFullYear();

                if(dd<10){
                    dd='0'+dd
                } 
                if(mm<10){
                    mm='0'+mm
                } 

                today = yyyy + '-' + mm + '-' + dd;
                document.getElementById("datefield").setAttribute("max", today);
                document.getElementById("datefield2").setAttribute("max", today);
            }
        </script>
    </head>
    <!-- DOCUMENT BODY SECTION -->
    <body>
        <!-- HEADER SECTION -->
        <header>
            <h1>News article prototype site</h1>
        </header>


        <!-- AUTHORS SECTION -->
        <section class = "authors">
            <h2>Article authors:</h2>
            <!-- NUMERIC AUTHORS LIST-->
            <ol>
                <!-- PHP CODE -->
                <?php
                    //Connection variables
                    $host = "localhost";
                    $username = "root";
                    $password = "";
                    $database = "news";
                    //Connection variable
                    // $connect = mysqli_connect($host, $username, $password, $database);
                    //SQL query variable
                    $query = "SELECT id, name, surname from authors";
                    //Result for authors list
                    $result = mysqli_query($connect, $query);
                    //Reading lines returned from database
                    while($row = mysqli_fetch_array($result)){
                        echo "$row[id]. $row[name] $row[surname]<br>";
                    }
                    //Closing connection
                    // mysqli_close($connect);
                ?>
            </ol>
        </section>


        <!-- ARTICLES SECTION -->
        <section class = "articles">
            <h2>Articles list:</h2>
            <!-- NUMERIC ARTICLES LIST-->
            <ol>
                <!-- PHP CODE -->
                <?php
                    //Connection variables
                    $host = "localhost";
                    $username = "root";
                    $password = "";
                    $database = "news";
                    //Connection variable
                    $connect = mysqli_connect($host, $username, $password, $database);
                    //SQL query variable
                    $query = "SELECT id, title from articles";
                    //Result for articles list
                    $result = mysqli_query($connect, $query);
                    //Reading lines returned from database
                    while($row = mysqli_fetch_array($result)){
                        echo "$row[id]. $row[title]<br>";
                    }
                    //Closing connection
                    mysqli_close($connect);
                ?>
            </ol>
        </section>


        <!-- GETTING ARTICLES BY ID SECTION -->
        <section class = "getArticleById">
            <h2>Search for articles</h2>
            <!-- FORM FOR SEARCHING ARTICLES -->
            <form method = "POST">
                <!-- ARTICLE ID INPUT -->
                Article id:&emsp;<input type = "number" name = "id"/>&emsp;
                <!-- SEARCH BUTTON -->
                <button type = "submit">SEARCH</button>
            </form>
            <!-- PHP CODE -->
            <?php
                //Getting rid of errors (undefined index etc.)
                error_reporting(0);
                //Connection variables
                $host = "localhost";
                $username = "root";
                $password = "";
                $database = "news";
                //Connection variable
                $connect = mysqli_connect($host, $username, $password, $database);
                //Getting variables from form
                $id = $_POST['id'];
                //Checking if form is filled
                if(isset($id)){
                    //SQL query variable for article
                    $query = "SELECT title, article, article_date FROM articles WHERE id = $id";
                    //SQL query variable for authors
                    $query2 = "SELECT name, surname FROM authors au RIGHT JOIN articles_authors aa ON (au.id = aa.author_id) LEFT JOIN articles a ON (a.id = aa.article_id) WHERE a.id = $id";
                    //Result for article
                    $result = mysqli_query($connect, $query);
                    //Result for authors
                    $result2 = mysqli_query($connect, $query2);
                    //Article database row
                    $row = mysqli_fetch_array($result);

                    //PRINTING RESULTS
                    echo "ARTICLE WITH ID $id:";
                    echo "<h4>$row[title]</h4><br>$row[article]<br><br>";

                    //Authors database row loop
                    while($row2 = mysqli_fetch_array($result2)){
                        echo "$row2[name] $row2[surname]<br>";
                    }
                    //PRINTING RESULTS
                    echo "<br><br>$row[article_date]";
                }
                //Closing connection
                mysqli_close($connect);
            ?>
        </section>


        <!-- GETTING ALL ARTICLES BY AUTHOR -->
        <section class = "allArticles">
            <h2>Search for every article written by specific author</h2>
            <!-- FORM FOR SEARCHING ALL ARTICLES BY AUTHOR -->
            <form method = "POST">
                <!-- AUTHOR ID INPUT -->
                Author id:&emsp;<input type = "number" name = "id2"/>&emsp;
                <!-- SEARCH BUTTON -->
                <button type = "submit">SEARCH</button>
            </form>
            <!-- NUMERIC ALL ARTICLES BY AUTHOR LIST -->
            <ol>
                <!-- PHP CODE -->
                <?php
                    //Getting rid of errors (undefined index etc.)
                    error_reporting(0);
                    //Connection variables
                    $host = "localhost";
                    $username = "root";
                    $password = "";
                    $database = "news";
                    //Connection variable
                    $connect = mysqli_connect($host, $username, $password, $database);
                    //Getting variables from form
                    $id = $_POST['id2'];
                    //Checking if form is filled
                    if(isset($id)){
                        //SQL query variable for article
                        $query = "SELECT title, article_date FROM articles a RIGHT JOIN articles_authors aa ON (a.id = aa.article_id) LEFT JOIN authors au ON (au.id = aa.author_id) WHERE au.id = $id";
                        //Result for article
                        $result = mysqli_query($connect, $query);
                        //PRINTING RESULTS
                        echo "ARTICLES WITH DATES WRITTEN BY AUTHOR WITH ID $id:<br><br>";
                        //Authors database row loop
                        while($row = mysqli_fetch_array($result)){
                            echo "<li>$row[title], $row[article_date]<br>";
                        }
                    }
                    //Closing connection
                    mysqli_close($connect);
                ?>
            </ol>
        </section>


        <!-- TOP 3 AUTHORS LAST WEEK -->
        <section class = "topAuthors">
            <h2>TOP 3 authors who posted most articles last week</h2>
            <!-- NUMERIC ALL ARTICLES BY AUTHOR LIST -->
            <ol>
                <!-- PHP CODE -->
                <?php
                    //Getting rid of errors (undefined index etc.)
                    //error_reporting(0);
                    //Getting dates of previus monday and sunday to check if article wast posted bettwen them
                    $lastMonday = date("Y-m-d", strtotime('monday last week'));
                    $lastSunday = date("Y-m-d", strtotime('sunday last week'));
                    //Connection variables
                    $host = "localhost";
                    $username = "root";
                    $password = "";
                    $database = "news";
                    //Connection variable
                    $connect = mysqli_connect($host, $username, $password, $database);
                    //SQL query variable for top 3 authors
                    $query = "SELECT name, surname, COUNT(name) as 'Articles_written' FROM authors au RIGHT JOIN articles_authors aa ON (au.id = aa.author_id) LEFT JOIN articles a ON (a.id = aa.article_id) WHERE (a.article_date BETWEEN '$lastMonday' AND '$lastSunday') GROUP BY NAME ORDER BY COUNT(name) DESC LIMIT 3";
                    //Result for article
                    $result = mysqli_query($connect, $query);
                    //Authors database row loop
                    while($row = mysqli_fetch_array($result)){
                        echo "<li>$row[name] $row[surname] $row[Articles_written]<br>";
                    }
                    //Closing connection
                    mysqli_close($connect);
                ?>
            </ol>
        </section>


        <!-- ADDING ARTICLES -->
        <section class = "addArticle">
            <h2>Add new article:</h2>
            <!-- FORM FOR ADDING ARTICLES -->
            <form method = "POST">
                <!-- TITLE INPUT -->
                Title:&emsp;<input type = "text" name = "title"/>
                <!-- ARTICLE INPUT -->
                <br><br>Article:&emsp;<textarea name = "article">YOUR ARTICLE</textarea>
                <!-- ARTICLE DATE INPUT -->
                <br><br>Date:&emsp;<input id = "datefield" type = "date" name = "date" max = "2021-12-12"/>&emsp;
                 <!-- SCRIPT PREVENTING FROM PICKING DATE HIGHER THAN TODAY -->
                <script>
                    dateFix();
                </script>
                <!-- ADD BUTTON -->
                <button type = "submit">ADD</button>
            </form>
            <!-- PHP CODE -->
            <?php 
                //Getting rid of errors (undefined index etc.)
                error_reporting(0);
                //Connection variables
                $host = "localhost";
                $username = "root";
                $password = "";
                $database = "news";
                //Connection variable
                $connect = mysqli_connect($host, $username, $password, $database);
                //Getting variables from form
                $title = $_POST['title'];
                $article = $_POST['article'];
                $date = $_POST['date'];
                //Checking if form is filled
                if(isset($title) && isset($article) && isset ($date)){
                    //SQL query variable for article
                    $query = "INSERT INTO articles(title, article, article_date) VALUES ('$title', '$article', '$date')";
                    //Sending data to database
                    mysqli_query($connect, $query);
                    echo "<br>Added article to database";
                }
                //Closing connection
                mysqli_close($connect);
            ?>
        </section>


        <!-- ADDING AUTHORS -->
        <section class = "addAuthor">
            <h2>Add authors to article:</h2>
            <!-- FORM FOR ADDING AUTHORS -->
            <form method = "POST">
                <!-- ARTICLE ID INPUT -->
                Article id:&emsp;<input type = "number" name = "articleId"/>
                <!-- AUTHOR ID INPUT -->
                <br><br>Author id:&emsp;<input type = "number" name = "authorId"/>&emsp;
                <!-- ADD BUTTON -->
                <button type = "submit">ADD</button>
            </form>
            <!-- PHP CODE -->
            <?php 
                //Getting rid of errors (undefined index etc.)
                error_reporting(0);
                //Connection variables
                $host = "localhost";
                $username = "root";
                $password = "";
                $database = "news";
                //Connection variable
                $connect = mysqli_connect($host, $username, $password, $database);
                //Getting variables from form
                $article_id = $_POST['articleId'];
                $author_id = $_POST['authorId'];
                //Checking if form is filled
                if(isset($article_id) && isset($author_id)){
                    //SQL query variable for article
                    $query = "INSERT INTO articles_authors(article_id, author_id) VALUES ('$article_id', '$author_id')";
                    //Sending data to database
                    mysqli_query($connect, $query);
                    echo "<br>Added author to database";
                }
                //Closing connection
                mysqli_close($connect);
            ?>
        </section>


        <!-- EDIT ARTICLE -->
        <section class = "editArticle">
            <h2>Edit article:</h2>
            <!-- FORM FOR EDITING ARTICLES -->
            <form method = "POST">
                <!-- ID INPUT -->
                Article id:&emsp;<input type = "text" name = "articleId2"/>
                <!-- TITLE INPUT -->
                <br><br>Title:&emsp;<input type = "text" name = "title2"/>
                <!-- ARTICLE INPUT -->
                <br><br>Article:&emsp;<textarea name = "article2">YOUR ARTICLE</textarea>
                <!-- ARTICLE DATE INPUT -->
                <br><br>Date:&emsp;<input id = "datefield2" type = "date" name = "date2" max = "2021-12-12"/>&emsp;
                <!-- SCRIPT PREVENTING FROM PICKING DATE HIGHER THAN TODAY -->
                <script>
                    dateFix();
                </script>
                <!-- EDIT BUTTON -->
                <button type = "submit">EDIT</button>
            </form>
            <!-- PHP CODE -->
            <?php 
                //Getting rid of errors (undefined index etc.)
                error_reporting(0);
                //Connection variables
                $host = "localhost";
                $username = "root";
                $password = "";
                $database = "news";
                //Connection variable
                $connect = mysqli_connect($host, $username, $password, $database);
                //Getting variables from form
                $article_id = $_POST['articleId2'];
                $title = $_POST['title2'];
                $article = $_POST['article2'];
                $date = $_POST['date2'];
                //Checking if form is filled
                if(isset($title) && isset($article) && isset ($date)){
                    //SQL query variable for article
                    $query = "UPDATE articles SET title = '$title', article = '$article', article_date = '$date' WHERE id = $article_id";
                    //Sending data to database
                    mysqli_query($connect, $query);
                    echo "<br>Modified article!";
                }
                //Closing connection
                mysqli_close($connect);
            ?>
        </section>


        <!-- DELETE ARTICLE -->
        <section class = "deleteArticle">
            <h2>Delete article:</h2>
            <!-- FORM FOR DELETING ARTICLES -->
            <form method = "POST">
                <!-- ARTICLE ID INPUT -->
                Article id:&emsp;<input type = "number" name = "articleId3"/>&emsp;
                <!-- DELETE BUTTON -->
                <button type = "submit">DELETE</button>
            </form>
            <!-- PHP CODE -->
            <?php 
                //Getting rid of errors (undefined index etc.)
                error_reporting(0);
                //Connection variables
                $host = "localhost";
                $username = "root";
                $password = "";
                $database = "news";
                //Connection variable
                $connect = mysqli_connect($host, $username, $password, $database);
                //Getting variables from form
                $article_id = $_POST['articleId3'];
                //Checking if form is filled
                if(isset($article_id)){
                    //SQL query variable for article
                    $query = "DELETE FROM articles WHERE id = $article_id";
                    $query2 = "DELETE FROM articles_authors WHERE article_id = $article_id";
                    //Sending data to database
                    mysqli_query($connect, $query);
                    mysqli_query($connect, $query2);
                    echo "<br>Deleted article!";
                }
                //Closing connection
                mysqli_close($connect);
            ?>
        </section>
    </body>
</html>