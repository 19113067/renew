
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Login Page</title>
<style>
form, p {
	width: 250px;
	margin: auto;
	font-size: 18px;
	margin-top: 20px;
}

input {
	width: 60%;
	margin-bottom: 10px
}
</style>
</head>
<body>

	<form action="login" method="post">
		<fieldset>
			<legend>Admin Login </legend>
			<input type="text" name="username" placeholder="Enter username" /><br />
			<input type="text" name="password" placeholder="Enter password" /><br />
			<input type="submit" value="Submit" />
		</fieldset>
	</form>
	<p>
		Don't have an account!! <a href="openRegistrationPage">Sign Up</a>
	</p>
	
	<%@include file="message.jsp"%>

	<!--  <script>
		history.pushState(null, document.title, location.href);
		window.addEventListener('popstate', function(event) {
			history.pushState(null, document.title, location.href);
		});
		
	</script>-->
</body>
</html>
    