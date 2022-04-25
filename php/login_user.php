<?php 
$connect = mysqli_connect("localhost" , "root" , "" , "register_login_db");

$st_check = $connect -> prepare("SELECT * FROM users WHERE email=? and password=? ");
$st_check -> bind_param("ss" , $_POST['email'] , $_POST['password']);
$st_check -> execute();
$result = $st_check -> get_result();

if ($result -> num_rows == 0) {
	echo "Invalid user";
} else {
	echo "Success";
}
?>