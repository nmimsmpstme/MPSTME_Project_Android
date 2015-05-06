<?php
$uid = $_REQUEST['id'];
if($uid == "")
{
die('ERR01');
}
include('config.php');
$query = "SELECT f_name FROM Users WHERE id=".$uid;
$result = $link->query($query); 
if(mysqli_num_rows($result)==0)
{
die("ERR02");
} 
$row = mysqli_fetch_row($result);
echo($row[0]);
?>