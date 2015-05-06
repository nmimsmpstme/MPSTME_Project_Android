<?php
$dp = $_POST['dp'];
$u = $_POST['u'];
if($dp == "" || $u == "")
{
die("ERR01");	
}
include('config.php');
$q = "SELECT * FROM DP WHERE uid ='$u'";
$r = $link->query($q);
if(mysqli_num_rows($r) != 0)
{
$dp = str_replace('data:image/png;base64,', '', $dp);
$dp = str_replace(' ', '+', $dp);
$data = base64_decode($dp);
$file = 'temp.png';
$success = file_put_contents($file, $data);
$imgData =addslashes(file_get_contents($file));
$q = "UPDATE DP SET dp = '{$imgData}' WHERE uid ='$u'";
$link->query($q);
}
else
{
$dp = str_replace('data:image/png;base64,', '', $dp);
$dp = str_replace(' ', '+', $dp);
$data = base64_decode($dp);
$file = 'temp.png';
$success = file_put_contents($file, $data);
$imgData =addslashes(file_get_contents($file));
$q="INSERT INTO DP (dpid,uid,dp) VALUES (NULL, '$u', '{$imgData}')";
$link->query($q);
}
echo('OK');
?>