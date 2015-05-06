<?php
$email = $_REQUEST['e'];
if($email == "")
{
die('ERR01');
}
include('config.php');
$query = "SELECT salt FROM Users WHERE email='".$email."'";
$result = $link->query($query); 
if(mysqli_num_rows($result)==0)
{
die("ERR02");
} 
$row = mysqli_fetch_row($result);
echo($row[0]);
?>