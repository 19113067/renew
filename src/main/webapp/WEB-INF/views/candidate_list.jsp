<%@page import="java.util.Base64"%>
<%@page import="spring.project.entities.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>

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
	
	.success {
		display: none;
		text-align: center;
		padding: 10px;
		background-color: #4CAF50;
		color: white;
		border-radius: 5px;
		margin-top: 10px;
	}

	.error {
		display: none;
		text-align: center;
		padding: 10px;
		background-color: #f44336;
		color: white;
		border-radius: 5px;
		margin-top: 10px;
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
			<th>Candidate Name</th>
			<th>Party Name</th>
			<th>Party Logo</th>
			<th>Action</th>
		</tr>
		
		<% 
			for(Candidate candidate: listOfCandidates) {
				String base64Image = Base64.getEncoder()
						.encodeToString(candidate.getPartyLogo());
		%>
		<tr>
			<td><%= candidate.getFullName() %></td>
			<td><%= candidate.getPartyName()%></td>
			<td>
				<img src="data:image/jpg;base64, <%= base64Image%>" 
				width="100" height="150"/>
			</td>
			<td>
				<a href="#" onclick="confirmVote('<%= candidate.getCandidateId()%>')">Vote</a>
			</td>
		</tr>
		<%} %>
	</table>
	
	<p style="padding:10px;text-align:center"><a href="logout1">Logout</a></p>
	
	<div id="successMessage" style="display: none; color: green;">
        Your vote has been successfully recorded!
    </div>

    <div id="errorMessage" style="display: none; color: red;">
        Sorry, there was an error recording your vote. Please try again later.
    </div>
    <span class="voteCount" id="voteCount_">0 votes</span>
	<script>
    function confirmVote(candidateId) {
        var confirmed = confirm("Are you sure you want to vote for this candidate?");
        if (confirmed) {
            updateVoterStatus(candidateId);
        }
    }

    function updateVoterStatus(candidateId) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "<%= application.getContextPath() %>confirmVote?candidate=" + candidateId, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // Update was successful
                    document.getElementById("successMessage").style.display = "block";
                    document.getElementById("errorMessage").style.display = "none";
                    incrementVoteCount(candidateId);
                    
                } else {
                    // Update failed
                    document.getElementById("successMessage").style.display = "none";
                    document.getElementById("errorMessage").style.display = "block";
                }
                // Scroll to the message
                window.location.hash = (xhr.status === 200) ? "#successMessage" : "#errorMessage";
            }
        };
        xhr.send();
    }
    function incrementVoteCount(candidateId) {
        var voteCountElement = document.getElementById("voteCount_" + candidateId);
        if (voteCountElement) {
            var currentVotes = parseInt(voteCountElement.innerText);
            voteCountElement.innerText = (currentVotes + 1) + " votes";
        }
    }
</script>


</body>
</html>
