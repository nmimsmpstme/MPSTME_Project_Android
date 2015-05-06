<?php
include('config.php');
$q = $_REQUEST['t'];
if($q == "")
{
die('ERR01');
}
$query = "DELETE FROM Transactions WHERE tid =".$q." LIMIT 1";
$link->query($query);
echo("OK");
?>