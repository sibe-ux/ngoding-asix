# News article page prototype - PHP
 1. Commands needed for creation of basic database (which allow to fully use site) for this project are in file commands.sql
 2. Code was written in Visual Studio Code
 3. I used xaamp packet for database operations (MySQL database). Specifically Apache web server and MySQL.
 
 4. On top of the site there are 2 list of articles and authors. Site contains 9 different sections, every sections is responsible for different action.
 5. Number next to the name or the article title is id number. Every section of site is described in each point below:
 
 6. Search for articles: This section allows to show article which has id number put in the text input, returns full articles with authors and dates
 
 7. Search for every article written by specific author: This section allows to search all of the articles written by author with id which was put into text input, returns list of articles (titles and dates)
 
 8. Top 3 authors who posted most articles last week: This section shows 3 best authors in terms of posted articles in the last week from current day
 
 9. Add new article: This section allows to add a new article to the base, IMPORTANT: it doesn't add the article authors
 
 10. Add authors to article: Due to many to many relations in database I hade to put authors of the articles in different table. This section allows us to sent information about authors of articles to database
 
 11. Edit article: This section allows us to edit existing articles, IMPORTANT: it doesn't allow to change authors
 
 12. Delete article: This section allows us to delete the article from articles and articles_authors tables, which basically means that article will dissapear from the whole database.
