<?php
$u = $_REQUEST['u'];
$g = $_REQUEST['g'];
if($u == "" || $g == "")
{
die("ERR01");
}
$q = "SELECT SUM(amt) FROM Repayments WHERE tuid = '$u' AND gid = '$g'";
include('config.php');
$r = $link->query($q);
$row = mysqli_fetch_row($r);
echo($row[0]==0?0:$row[0]);
?>