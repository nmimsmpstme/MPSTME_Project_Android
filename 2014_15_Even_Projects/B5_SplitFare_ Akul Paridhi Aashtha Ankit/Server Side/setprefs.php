<?php
$d = $_REQUEST['d'];
$u = $_REQUEST['u'];
$acc = $_REQUEST['acc'];
$curr = $_REQUEST['curr'];
if($d == "" || $u == "" || $acc == "" || $curr == "")
{
die("ERR01");
}
$q1 = "SELECT * FROM Preferences WHERE uid = '$u'";
include('config.php');
$r = $link->query($q1);
if(mysqli_num_rows($r) == 0)
{
$q1 = "INSERT INTO Preferences (pid, uid, curr, acc, d) VALUES (NULL, '$u', '$curr', '$acc', '$d');";
$link->query($q1);
}
else
{
$q2 = "UPDATE Preferences SET curr = '$curr', acc = '$acc', d = '$d' WHERE uid = '$u'";
$link->query($q2);
}
echo('OK');
?>