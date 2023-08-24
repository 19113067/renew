<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Add</title>
<style>
	form {
		width: 400px;
		margin:auto;
	}
	
	input {
		margin-bottom: 10px;
	}
	
	legend 
	{
        width: 110px;
        padding: 5px;
        margin-left: calc(50% - 25px - 10px);
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

    if (age < 35) {
        alert("Candidates must be at least 35 years old.");
        return false;
    }

    return true;
}
</script>

</head>
<body>
	<form action="add" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
		<fieldset>
			<legend>Add Candidate Form</legend>
			<input type="text" name="full_name" placeholder="Enter Full Name"/><br/>
			<input type="date" name="date_of_birth" placeholder="mm/dd/yyyy"/><br/>
			<input type="text" name="nationality" placeholder="Enter your Nationality"/><br/>
			<input type="text" name="party_name" placeholder="Enter your Party Name"/><br/>
			<input type="text" name="no_of_votes" placeholder="Enter your Votes to zero"/><br/>
			
			<input type="file" name="party_logo"/>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
	<h3><a href="openCandidateDashBoardPage">Go to Candidates List</a></h3>

	<p>
		<% 
			String message = (String)request.getAttribute("message"); 
			if(message!=null) {
				out.print(message);
			}
		%>
	
	</p>
</body>
</html>