<?php
$group = $_REQUEST['g'];
if($group =="")
{
die('ERR01');
}
echo('<xml>');
include('config.php');
$q2 = "SELECT * FROM Transactions WHERE gid = $group;";
$result = $link->query($q2); 
while($row = mysqli_fetch_row($result))
{
$uid = $row[2];
$q1 = "SELECT f_name,l_name FROM Users WHERE id = $row[2] ;";
$res2 = $link->query($q1); 
$r2 = mysqli_fetch_row($res2);
echo('<transaction id="'.$row[0].'" name="'.$r2[0].' '.$r2[1].'" desc="'.$row[3].'" amt="'.$row[4].'" />');
}
echo('</xml>');
