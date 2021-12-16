<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login</title>
</head>
<link rel="stylesheet" type="text/css" href="login.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">
		<a href="welcome.html" class="logo">Expense Tracker</a>
		<div class="header-right">
	    	<a href="about.html"style="float:right">About</a>
	 	</div>
	</div>
	<div class="head">
		<h1>Login to Track Your Expenses</h1>
	</div>
	<div class="log">
		<form action="login" method='POST' name="loginForm">
	    	<p>Enter Email:
	    	<INPUT TYPE="email" NAME="username" placeholder="Enter Email" id="email" SIZE="20" maxlength="20" style="width:100px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
	    	</p>
	    	<p>Enter password:
	    	<INPUT TYPE="password" NAME="password" placeholder="Enter password" id="password" SIZE="8" maxlength="8" style="width:100px; float:middle;" required="required" oninput="this.setCustomValidity('')">
	    	</p>
	    	<button class="loginButton" type="submit">Login</button>
   		</form>
   		
       	<p> New User? <a href="signup.jsp"> Click here to register </a> </p>
	</div>
</body>
<script type="text/javascript">
function validateCredentials(){
	var email=document.loginForm.email.value;
	var pass=document.loginForm.password.value;
	if (email == "test" && pass == "1234"){
		
	}
	else{
		window.alert("Wrong email/password. Please check and try again.");
	}
}
</script>
</html>
</html>