<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
	form, p {
		width:250px; 
		margin: auto; 
		font-size: 18px;
		margin-top:20px;
	}
	input {
		width:60%;
		margin-bottom:10px
	}
	
</style>
</head>
<body>

	<form action="register" method="post">
		<fieldset>
			<legend>Registration Form</legend>
			<input type="text" name="username" placeholder="Enter username"/><br/>
			<input type="text" name="password" placeholder="Enter password"/><br/>
			<input type="submit" value="Submit"/>
		</fieldset>
	</form>
	<p>Signed!! <a href="openLoginPage">Login</a></p>
	
	<%@include file="message.jsp" %>

</body>
</html>