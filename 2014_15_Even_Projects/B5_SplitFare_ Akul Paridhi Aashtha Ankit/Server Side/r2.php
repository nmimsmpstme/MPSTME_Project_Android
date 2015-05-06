<?php
$f_name = $_REQUEST['f'];
$pass = $_REQUEST['pass'];

include('config.php');
$sql = "INSERT INTO `a1377599_mstr`.`Temp` (`rid`, `f_name`, `Pass`) VALUES (NULL,'$f_name', '$pass');"; 
$result = $link->query($sql); 
echo('ok');
?>