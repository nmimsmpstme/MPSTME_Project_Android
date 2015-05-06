<?php
$group = $_REQUEST['g'];
if($group =="")
{
die('ERR01');
}
echo('<xml>');
include('config.php');
$q2 = "SELECT uid FROM UserGroups WHERE gid = $group;";
$result = $link->query($q2); 
while($row = mysqli_fetch_row($result))
{
$uid = $row[0];
$q1 = "SELECT f_name,l_name FROM Users WHERE id = $uid ;";
$res2 = $link->query($q1); 
$r2 = mysqli_fetch_row($res2);
echo('<user id="'.$uid.'" name="'.$r2[0].' '.$r2[1].'" />');
}
echo('</xml>');
?>