<?php
$em = $_REQUEST['email'];
$gid = $_REQUEST['g'];
if($em =="" || $gid=="")
{
die('ERR01');
}
include('config.php');
$query = "SELECT id FROM Users WHERE email='".$em."'";
$result = $link->query($query); 
if(mysqli_num_rows($result)==0)
{
die("ERR02");
}
else
{ 
$row = mysqli_fetch_row($result);
$user = $row[0];

$q2 = "SELECT * FROM `a1377599_mstr`.`UserGroups` WHERE uid= $user AND gid=$gid";$result = $link->query($q2); 
if(mysqli_num_rows($result)!=0)
{
die("ERR03");
}
$q2 = "INSERT INTO `a1377599_mstr`.`UserGroups` (`uid`, `gid`) VALUES ('$user','$gid');";
$result = $link->query($q2); 
echo('OK');
}
?>