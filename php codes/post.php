<?php
    
    /*
     * Following code will create a new product row
     * All product details are read from HTTP Post Request
     */
    
    // array for JSON response
    $response = array();
    
    // check for required fields
    if (isset($_GET['id']) && isset($_GET['uname']) && isset($_GET['auth'])&& isset($_GET['postdata'])) {
        $id = $_GET['id'];
        $uname = $_GET['uname'];
        $auth = $_GET['auth'];
        $postdata = $_GET['postdata'];
        
        // include db connect class
        require_once __DIR__ . '/db_connect.php';
        
        // connecting to db
        $db = new DB_CONNECT();
        
        // mysql inserting a new row
        $result = mysql_query("INSERT INTO post(id,uname, auth, postdata) VALUES('$id','$uname', '$auth', '$postdata')");
        
        // check if row inserted or not
        if ($result) {
            // successfully inserted into database
            $response["success"] = 1;
            $response["message"] = "Product successfully created.";
            
            // echoing JSON response
            echo json_encode($response);
        } else {
            // failed to insert row
            $response["success"] = 0;
            $response["message"] = "Oops! An error occurred.";
            
            // echoing JSON response
            echo json_encode($response);
        }
    } else {
        // required field is missing
        $response["success"] = 0;
        $response["message"] = "Required field(s) is missing";
        
        // echoing JSON response
        echo json_encode($response);
    }
    ?>