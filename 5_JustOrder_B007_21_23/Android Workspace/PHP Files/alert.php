<?php
$host="localhost"; //replace with database hostname 
$username="root"; //replace with database username 
$password=""; //replace with database password 
$db_name="justorderd"; //replace with database name
 
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

if(strcmp($_POST[deviceId], "ffffffff-bbf9-72c6-41d9-851e0033c587")==0)
{
$sql="INSERT INTO waiterCall (tablecall, callTime)VALUES('Call from Table 1', NOW())";

if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
}
else if(strcmp($_POST[deviceId],"00000000-4748-feb1-ffff-fffffed9ded7")==0)
 {
	$sql="INSERT INTO waiterCall (tablecall, callTime)VALUES('Call from Table 2', NOW())";
	if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }

 }
 mysql_close($con);
?>