<?php
$gid = $_REQUEST['g'];
$nn = $_REQUEST['n'];
if($gid == "" || $nn == "")
{
die('ERR01');
}
include('config.php');
$query = "UPDATE Groups SET Name = '".$nn."' WHERE Id = ".$gid;
$link->query($query);
echo('OK');
?>