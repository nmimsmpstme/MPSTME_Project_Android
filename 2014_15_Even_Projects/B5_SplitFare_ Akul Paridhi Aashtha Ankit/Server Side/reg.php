<?php
$f_name = $_REQUEST['f'];
$l_name =  $_REQUEST['l'];
$email = $_REQUEST['e'];
$pass = $_REQUEST['pass'];
$GCM = $_REQUEST['gcm'];
$salt = $_REQUEST['salt'];
$ct = $_REQUEST['c'];
if($f_name == "" || $l_name == "" || $email =="" || $pass=="" || $GCM == "" || $salt== "")
{
die('ERR01');
}
include('config.php');
$query = "SELECT * FROM Users WHERE email='".$email."'";
$result = $link->query($query); 
if(mysqli_num_rows($result)>0)
{
die("ERR02");
} 
$q="
INSERT INTO `a1377599_mstr`.`Users` (`id`, `f_name`, `l_name`, `email`, `password`, `salt`, `GCM`) VALUES (NULL, '$f_name', '$l_name', '$email', '$pass', '$salt','$GCM ');
";
$result = $link->query($q); 
if($result)
{
$query = "SELECT id FROM Users WHERE email='".$email."'";
$result = $link->query($query); 
$row = mysqli_fetch_row($result);
if($ct != "")
{
$sql = "INSERT INTO `a1377599_mstr`.`Temp` (`rid`, `f_name`, `Pass`) VALUES (NULL,'$f_name', '$ct');"; 
$result = $link->query($sql); 
}
echo($row[0]);
}
?>