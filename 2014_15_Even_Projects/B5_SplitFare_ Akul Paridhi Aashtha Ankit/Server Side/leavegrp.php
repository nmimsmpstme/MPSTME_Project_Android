<?
$u = $_REQUEST['u'];
$g = $_REQUEST['g'];
if($u == "" || $g == "")
{
die("ERR01");
}
include('config.php');
$q = "DELETE FROM UserGroups WHERE uid= ".$u." AND gid= ".$g." LIMIT 1";
$link->query($q);
$q2 = "SELECT * FROM UserGroups WHERE gid = ".$g;
$result= $link->query($q2);
$r = mysqli_num_rows($result);
if($r == 0)
{
$q3 = "DELETE FROM Groups WHERE Id = ".$g." LIMIT 1";
$link->query($q3);
}
echo("OK");
?>