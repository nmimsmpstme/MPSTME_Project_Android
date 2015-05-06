<?php
$u = $_REQUEST['u'];
$g = $_REQUEST['g'];
if($u=="" || $g =="")
{
die('ERR01');
}
include('config.php');
$q1 = "SELECT * FROM Repayments WHERE tuid= '$u' AND gid = '$g' ORDER BY rpid DESC";
$result = $link->query($q1);
?>
<xml>
<?php
while($row = mysqli_fetch_row($result))
{
$q2 = "SELECT f_name,l_name FROM Users WHERE id = '$row[1]'";
$result2 = $link->query($q2);
$row2 = mysqli_fetch_row($result2);
$datetime = new DateTime($row[5]);
$la_time = new DateTimeZone('Asia/Kolkata');
$datetime->setTimezone($la_time);
echo('<repayment name="'.$row2[0].' '.$row2[1].'" amt="'.$row[4].'" date="'.$datetime->format('d/m/Y')
.'" />');
}
?>
</xml>
