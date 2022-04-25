<?php
$connect = mysqli_connect("localhost" , "root" , "" , "register_login_db");

$email = $_POST['email'];
$fname = $_POST['first_name'];
$lname = $_POST['last_name'];
$password = $_POST['password'];

$sql = "INSERT INTO `users`(`email`, `first_name`, `last_name`, `password`) VALUES ('$email' , '$fname' , '$lname' , '$password')";
$result = mysqli_query($connect , $sql);
?>