<?php
$host="localhost"; //replace with database hostname 
$username="root"; //replace with database username 
$password=""; //replace with database password 
$db_name="justorderd"; //replace with database name
 
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
 $device=$_POST['deviceId'];   

if(strcmp($device, "f924e50b-d8c4-3efa-8618-d3e13cfc40e4")==0)
{
$sql="INSERT INTO table1 (name, qty, price)VALUES('$_POST[name]','$_POST[qty]', '$_POST[price]')";
echo "Order added successfully";
if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
}
else if(strcmp($_POST[deviceId],"00000000-1da6-ced3-0033-c5870033c587")==0)
 {
	$sql="INSERT INTO table2 (name, qty, price)VALUES('$_POST[name]','$_POST[qty]', '$_POST[price]')";

if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
}
mysql_close($con);

?> 