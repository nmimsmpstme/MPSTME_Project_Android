<?php
include('config.php');
if($_REQUEST['desc'] == "" || $_REQUEST['amt'] == "" || $_REQUEST['t'] == "")
{
die("ERR01");
}
$query="UPDATE Transactions SET Transactions.desc = '".$_REQUEST['desc']."', Transactions.amt = '".$_REQUEST['amt']."' WHERE tid = ".$_REQUEST['t']." LIMIT 1 ;";
$link->query($query);
echo("OK");
?>