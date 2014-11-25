<?php
$host="localhost"; //replace with database hostname 
$username="root"; //replace with database username 
$password=""; //replace with database password 
$db_name="justorderd"; //replace with database name
 
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$result = mysql_query("Truncate table2");
echo " Order for Table 2 Deleted";

header('Location:load_data.php');


mysql_close($con);
?> 