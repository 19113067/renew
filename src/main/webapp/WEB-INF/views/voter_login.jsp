<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Login Page</title>
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

	<form action="login1" method="post">
		<fieldset>
			<legend>Voter Login </legend>	

			<input type="text" name="aadharNumber" placeholder="Enter Aadhar Number"/><br/>
			<input type="password" name="password" placeholder="Enter Password"/><br/>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
	<p>
		Don't have an account!! <a href="openVoterRegistrationPage">Sign Up</a>
	</p>
	<%@include file="message.jsp"%>
	 <p id="loginResult"></p>

    <script>
    document.getElementById("loginForm").addEventListener("submit", function(event) {
        event.preventDefault();
        const form = event.target;
        const formData = new FormData(form);

        fetch(form.action, {
            method: 'POST',
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            if (data === "success") {
                window.location.href = "openCandidateListPage";
            } else {
                document.getElementById("loginResult").textContent = "Invalid credentials. Please try again.";
            }
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById("loginResult").textContent = "An error occurred. Please try again later.";
        });
    });
    </script>

</body>
</html>