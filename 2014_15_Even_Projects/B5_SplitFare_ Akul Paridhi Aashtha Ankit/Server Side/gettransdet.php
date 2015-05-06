<?php
if($_REQUEST['t'] == "")
{
die("ERR01");
}
include('config.php');
$query = "SELECT *FROM Transactions WHERE tid = ".$_REQUEST['t'];
$result = $link->query($query);
$row = mysqli_fetch_row($result);
//echo($row[5]);
//date_default_timezone_set('Europe/London');
$datetime = new DateTime($row[5]);
$la_time = new DateTimeZone('Asia/Kolkata');
$datetime->setTimezone($la_time);
echo $datetime->format('d/m/Y H:i:s');
?>
