<?php
$user = $_REQUEST['u'];
$grp = $_REQUEST['grp'];
if($user =="" || $grp=="")
{
die('ERR01');
}
include('config.php');
$q = "INSERT INTO `a1377599_mstr`.`Groups` (`Id`, `Name`) VALUES (NULL, '$grp');";
$result = $link->query($q); 
$gid = $link->insert_id;
$q2 = "INSERT INTO `a1377599_mstr`.`UserGroups` (`uid`, `gid`) VALUES ('$user','$gid');";
$result = $link->query($q2); 
echo('OK');
?> 