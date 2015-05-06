<?php
$column = array();
$link = mysqli_connect("mysql11.000webhost.com","a1377599_mstr","GANDU@123","a1377599_mstr");
$q1 = "SELECT Name FROM Groups where Id=".$gid;
$result = $link->query($q1);
$row = mysqli_fetch_row($result);
$message = '$0%'.$row[0];
$query = "SELECT uid FROM UserGroups where gid=".$gid." AND uid <> ".$uid;
$result = $link->query($query);
if(mysqli_num_rows($result) == 0)
{
die();
}
while($row = mysqli_fetch_row($result))
{
 	$q2 = "SELECT GCM FROM Users where id=".$row[0];
	$r2 = $link->query($q2);
	$row2 = mysqli_fetch_row($r2);
	$column[] = $row2[0];
}

$url = 'https://android.googleapis.com/gcm/send';
 
$fields = array(
                'registration_ids'  => $column,
                'data'              => array( "message" => 

$message ),
                );
 
$headers = array( 
                    'Authorization: key=' . 

"AIzaSyD2DqRnOiJbkk9ZD-39UmEYncjK6erVG5g",
                    'Content-Type: application/json'
                );
 
$ch = curl_init();
curl_setopt( $ch, CURLOPT_URL, $url );
curl_setopt( $ch, CURLOPT_POST, true );
curl_setopt( $ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true );
curl_setopt( $ch, CURLOPT_POSTFIELDS, json_encode( $fields ) );
$result = curl_exec($ch);
curl_close($ch);
echo $result;

?>
