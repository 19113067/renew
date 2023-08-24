<%@page import="java.util.Base64"%>
<%@page import="spring.project.entities.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Dashboard</title>

<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	p {
		width: 500px;
	
	}
	
	table, p {
		margin: auto;
		font-size: 20px;
	}
	
	caption {
		margin-bottom:20px;
		text-decoration: underline;
		color: violet;
	}
	
	th, td {
		padding:5px;
	}
	
	a {
		text-decoration: none;
		width: 200px;
		background-color: dodgerBlue;
		color: white;
		padding: 5px;
		border-radius: 5px;
		margin-left:10px;
	}
	
	
	
</style>
</head>
<body>
	<% 
		List<Candidate> listOfCandidates = (List)request.getAttribute("listOfCandidates");
	%>
	
	<table>
		<caption>Candidates List</caption>
		<tr>
			<th>Candidate Id</th>
			<th>Full Name</th>
			<th>Nationality</th>
			<th>Party Name</th>
			<th>Party Logo</th>
			<th>Date of Birth</th>
			<th>No of Votes</th>
			
		</tr>
		
		<!-- Dynamic No of rows depending upon records in the database -->
		
		<% 
			int noOfVotes = 0;
			for(Candidate candidate: listOfCandidates) {
				
				
				String base64Image = Base64.getEncoder()
						.encodeToString(candidate.getPartyLogo());
			%>
		<tr>
			<td><%= candidate.getCandidateId() %></td>
			<td><%= candidate.getFullName() %></td>
			<td><%= candidate.getNationality()%></td>
			<td><%= candidate.getPartyName()%></td>
			
			
			
			<td>
				<img src="data:image/jpg;base64, <%= base64Image%>" 
				width="100" height="150"/>
			</td>
			
			<td><%= candidate.getDateOfBirth()%></td>
			<td><%= candidate.getNoOfVotes()%></td>
			
		
		</tr>
		<%} %>
		
		<tr>
			<td colspan = "8" style="padding:10px;text-align:center"><a href="openAddCandidatePage">Add Candidate</a></td>	
		</tr>
	</table>
	<p style="padding:10px;text-align:center"><a href="logout">Logout</a></p>	
	
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