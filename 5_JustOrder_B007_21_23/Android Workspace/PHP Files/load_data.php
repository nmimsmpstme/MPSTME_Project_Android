<meta http-equiv="refresh" content="5;url=load_data.php">
<?php
$host="localhost"; //replace with database hostname 
$username="root"; //replace with database username 
$password=""; //replace with database password 
$db_name="justorderd"; //replace with database name
 
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$result = mysql_query("SELECT * FROM table1");
echo "<b><u> Table Number 1 Order</u></b> ";
echo "<br />";
echo "<br />";
while($row = mysql_fetch_array($result))
  {
  echo "<span style='color:red'>Item:</span> " . $row['name'] . " <span style='color:red'>Quantity:</span> " . $row['qty']."  <span style='color:red'>Price:</span> ".$row['price'];
  echo "<br />";
  }
  ?>
  <html>
  </br>
  <form name="input" action="deletetable1.php" method="get">
<input type="submit" value="Clear Table - 1 Entries" />
</form> 
</html>
<?php
echo "<br />";
echo "<br />";
echo "<br />";
echo "<b><u>Table Number 2 Order</u></b>";
echo "<br />";
echo "<br />";
$result = mysql_query("SELECT * FROM table2");

while($row = mysql_fetch_array($result))
  {
  echo $row['name'] . " " . $row['qty']." ".$row['price'];
  echo "<br />";
  }

?> 
<html>
<form name="input" action="deletetable2.php" method="get">	
<br>
<input type="submit" value="Clear Table - 2 Entries" />
</form> 
</html>


