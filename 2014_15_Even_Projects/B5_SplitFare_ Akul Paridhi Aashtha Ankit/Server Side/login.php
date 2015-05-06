<?php
$email = $_REQUEST['e'];
$pass = $_REQUEST['pass'];
if($email =="" || $pass=="")
{
die('ERR01');
}
include('config.php');
$query = "SELECT id,password FROM Users WHERE email='".$email."'";
$result = $link->query($query); 
if(mysqli_num_rows($result)==0)
{
die("ERR02");
} 
$row = mysqli_fetch_row($result);
if($row[1]==$pass)
echo($row[0]);
else
die("ERR02");
?>