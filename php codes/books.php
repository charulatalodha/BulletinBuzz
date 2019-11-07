<?php
    
    /*
     * Following code will get single product details
     * A product is identified by product id (id)
     */
    
    // array for JSON response
    $response = array();
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    
    // connecting to db
    $db = new DB_CONNECT();
    
    
    
    // get a product from products table
    $result = mysql_query("SELECT *FROM books ");
    
    if (!empty($result)) {
        // check for empty result
        $response["products"] = array();
        while ($row = mysql_fetch_array($result)) {
            
            //$result = mysql_fetch_array($result);
            
            $product = array();         //temp user ary
            $product["id"] = $row["id"];
            $product["uname"] = $row["uname"];
            $product["auth"] = $row["auth"];
            $product["bookdata"] = $row["bookdata"];
            // success
            
            // user node
            //   $response["product"] = array();   $response["hostels"] = array();
            array_push($response["products"], $product);
            // echoing JSON response
            $response["success"] = 1;
        }
        echo json_encode($response);
        $response["success"] = 1;
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";
        
        // echo no users JSON
        echo json_encode($response);
    }
    
    ?>