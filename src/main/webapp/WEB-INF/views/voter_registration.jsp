<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Registration Page</title>
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
<script>
function validateForm() {
	
    var nationality = document.getElementsByName("nationality")[0].value;
    var dateOfBirth = new Date(document.getElementsByName("date_of_birth")[0].value);
    var currentDate = new Date();

    if (nationality.toUpperCase() !== "INDIAN" && nationality !== "Indian") {
        alert("Only candidates with Indian nationality are allowed.");
        return false;
    }

    var age = currentDate.getFullYear() - dateOfBirth.getFullYear();
    var birthMonth = dateOfBirth.getMonth();
    var currentMonth = currentDate.getMonth();
    
    if (currentMonth < birthMonth || (currentMonth === birthMonth && currentDate.getDate() < dateOfBirth.getDate())) {
        age--;
    }

    if (age < 18) {
        alert("Voters must be at least 18 years old.");
        return false;
    }

    return true;
}
</script>
</head>
<body>

	<form action="register1" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
		<fieldset>
			<legend>Registration Form</legend>
			<input type="text" name="full_name" placeholder="Enter Full name"/><br/>
			<input type="date" name="date_of_birth" placeholder="mm/dd/yyyy"/><br/>
			<input type="text" name="aadhar_number" placeholder="Enter Aadhar Number"/><br/>
			<input type="text" name="password" placeholder="Enter Password"/><br/>
			<input type="text" name="nationality" placeholder="Enter Nationality"/><br/>
			<input type="text" name="status" placeholder="Enter Status"/><br/>
			<input type="file" name="file" />
			<input type="submit" value="Submit"/>
		</fieldset>
	</form>
	<p>Signed!! <a href="openVoterLoginPage">Login</a></p>
	
	<%@include file="message.jsp" %>

</body>
</html>