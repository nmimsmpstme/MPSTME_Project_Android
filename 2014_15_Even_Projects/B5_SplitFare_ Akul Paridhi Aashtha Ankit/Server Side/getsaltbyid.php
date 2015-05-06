<?php
$u = $_REQUEST['u'];
if($u == "")
{
die('ERR01');
}
include('config.php');
$query = "SELECT salt FROM Users WHERE id= '$u'";
$result = $link->query($query); 
$row = mysqli_fetch_row($result);
echo($row[0]);
?>