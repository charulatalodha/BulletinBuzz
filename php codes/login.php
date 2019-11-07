

<?php

 
/*
 * Following code will list all the products
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
//require_once 'DB_Connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 	
if (isset($_GET["uname"])&& isset($_GET["pwd"]))  {

  $username =  $_GET["uname"];
  $password = $_GET["pwd"];
    //	Write Query To Get Data 

    $result = mysql_query("SELECT * FROM login WHERE uname = '$username' AND pwd = '$password' ") or die(mysql_error());
	
	// check for empty result
	if (mysql_num_rows($result) > 0) {
	
	
		// this to pass output into java class 
		$response["login_array"] = array();
 
		while ($row = mysql_fetch_array($result)) {
			$Login_List = array();
			$Login_List["id"] = $row["id"];
			
			$Login_List["username"] = $row["uname"];
			$Login_List["password"] = $row["pwd"];
			
         	array_push($response["login_array"], $Login_List);
		}	
		// success
	    $response["success"] = 1;
 
		// echoing JSON response
		echo json_encode($response);
	}
	else {
		// no products found
		$response["success"] = 0;
		$response["message"] = "No Recipe found";
 
		// echo no users JSON
		echo json_encode($response);
	}

}
?>