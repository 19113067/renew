<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Voting System</title>
<style>
body{
  font-family: Arial, sans-serif;
    text-align: center;
  }
  .container {
    margin-top: 50px;
  }
  .option {
    display: inline-block;
    margin: 0 20px;
    font-size: 20px;
  }
  button {
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
  }
 
</style>
</head>
<body>
<div class="container">
  <h1>Welcome to the online Voting System Portal</h1>
  <div class="option">
    <button onclick="openAdminPage"><a href="openAdminPage">Admin Portal</a></button>
  </div>
  <div class="option">
    <button onclick="openVoterLoginPage"><a href="openVoterLoginPage">Voter Portal</a></button>
  </div>
</div>

</body>
</html>
