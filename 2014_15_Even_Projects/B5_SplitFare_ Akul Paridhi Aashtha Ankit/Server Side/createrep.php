<?php
$fu = $_REQUEST['fu'];
$tu = $_REQUEST['tu'];
$g = $_REQUEST['g'];
$a = $_REQUEST['a'];
if($fu== "" || $tu == "" || $g == "" || $a =="")
{
die("ERR01");
}
include('config.php');
$q= "INSERT INTO Repayments (rpid, fuid, tuid, gid, amt, Time) VALUES (NULL, '$fu', '$tu', '$g', '$a', CURRENT_TIMESTAMP)";
$link->query($q);
echo("OK");
?>
