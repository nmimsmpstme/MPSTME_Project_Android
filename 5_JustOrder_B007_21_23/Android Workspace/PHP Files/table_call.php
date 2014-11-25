<meta http-equiv="refresh" content="5;url=table_call.php">
<?php
$host="localhost"; //replace with database hostname 
$username="root"; //replace with database username 
$password=""; //replace with database password 
$db_name="justorderd"; //replace with database name
 
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$result = mysql_query("Select * From waiterCall");
while($row = mysql_fetch_array($result))
  {
  echo $row['tablecall']." at ". $row['callTime'];	
  echo "<br />";
  }
  mysql_close($con);
  ?>
<html>
  </br>
  <form name="input" action="clearcallentries.php" method="get">
<input type="submit" value="Clear Waiter Call Entries" />
</form> 
</html>

 