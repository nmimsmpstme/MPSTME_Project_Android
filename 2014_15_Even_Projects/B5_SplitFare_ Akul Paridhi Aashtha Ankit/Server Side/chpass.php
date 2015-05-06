<?php
$u = $_REQUEST['u'];
$op = $_REQUEST['op'];
$np = $_REQUEST['np'];
if($u == "" || $op == "" || $np == "")
{
die('ERR01');
}
include('config.php');
$q1="SELECT password FROM Users WHERE id= '$u'";
$r1=$link->query($q1);
$row1 = mysqli_fetch_row($r1);
if($op != $row1[0])
{
die("ERR02");
}
$q2 = "UPDATE Users SET password = '$np' WHERE id= '$u' LIMIT 1";
$r2 = $link->query($q2);
echo("OK");
?>
