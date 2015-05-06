<?php
$u = $_REQUEST['u'];
if($u == "")
{
die("ERR01");	
}
include('config.php');
$q = "SELECT * FROM DP WHERE uid ='$u'";
$r = $link->query($q);
if(mysqli_num_rows($r) == 0)
{
die('NULL');
}
$rw = mysqli_fetch_row($r);
echo(base64_encode($rw[2]));
?>