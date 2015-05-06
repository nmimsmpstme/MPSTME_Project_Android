<?php
$u = $_REQUEST['u'];
$q1 = "SELECT * FROM Preferences WHERE uid = '$u'";
include('config.php');
$res = $link->query($q1);
if(mysqli_num_rows($res) == 0)
{
die('NULL');
}
?>
<xml>
<?php
$row = mysqli_fetch_row($res);
echo('<Preference d="'.$row[4].'" curr="'.$row[2].'" acc="'.$row[3].'"/>');
?>
</xml>