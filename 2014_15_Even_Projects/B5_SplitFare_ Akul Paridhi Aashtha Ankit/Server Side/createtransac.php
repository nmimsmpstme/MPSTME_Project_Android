<?php
$gid= $_REQUEST['g'];
$uid= $_REQUEST['u'];
$desc= $_REQUEST['desc'];
$amt = $_REQUEST['amt'];
if($gid == "" || $uid == "" || $desc == "" ||$amt == "")
{
die("ERR01");
}
include('config.php');
$query = "INSERT INTO `a1377599_mstr`.`Transactions` (`tid`, `gid`, `uid`, `desc`, `amt`, `Time`) VALUES (NULL, '$gid', '$uid', '$desc', '$amt', CURRENT_TIMESTAMP);"; 
$result = $link->query($query);
echo($link->insert_id); 
include ('gcm_engine.php');
?>