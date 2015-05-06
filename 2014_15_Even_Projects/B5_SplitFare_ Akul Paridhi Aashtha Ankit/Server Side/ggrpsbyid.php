<?php
$user = $_REQUEST['u'];
if($user =="")
{
die('ERR01');
}
echo('<xml>');
include('config.php');
$q2 = "SELECT gid FROM UserGroups WHERE uid = $user;";
$result = $link->query($q2); 
while($row = mysqli_fetch_row($result))
{
$gid = $row[0];
$q1 = "SELECT Name FROM Groups WHERE Id = $gid ;";
$res2 = $link->query($q1); 
$r2 = mysqli_fetch_row($res2);
echo('<group id="'.$gid.'" name="'.$r2[0].'" />');
}
echo('</xml>');
?>