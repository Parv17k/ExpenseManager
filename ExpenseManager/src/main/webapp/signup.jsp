<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Sign Up</title>
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
		<h1>Sign Up to Start Tracking Your Expenses</h1>
	</div>
	<div class="log">
		<form >
			<p>Enter Name:
	    	<INPUT TYPE="text" NAME="name" placeholder="Enter Name" id="name" SIZE="20" maxlength="20" style="width:100px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
	    	</p>
	    	<p>Enter Email:
	    	<INPUT TYPE="email" NAME="email" placeholder="Enter Email" id="email" SIZE="20" maxlength="20" style="width:100px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
	    	</p>
	    	<p>Enter password:
	    	<INPUT TYPE="password" NAME="password" placeholder="Enter password" id="password" SIZE="8" maxlength="8" style="width:100px; float:middle;" required="required" oninput="this.setCustomValidity('')">
	    	</p>

   		</form>
   		<button class="loginButton" onclick="register();false;">Register</button>
       	<p> Already a user? <a href="login.jsp"> Click here to login </a> </p>
	</div>
</body>
<script type="text/javascript">
function register(){
	var email = document.getElementById("email").value;
    var chk = email.match(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/);

	if(!chk){
		window.alert("Enter a valid email address");
		window.location.href = "signup.jsp";
	}
	
	const data = JSON.stringify({
		  "emailID": document.getElementById("email").value,
		  "id": Date.now(),
		  "name":  document.getElementById("name").value,
		  "password":  document.getElementById("password").value
		});

		const xhr = new XMLHttpRequest();
		

		xhr.addEventListener("readystatechange", function () {
			 if (this.readyState == 4 && this.status == 200) {
			  alert("Success");
		  }	else if (this.readyState == 4 && this.status != 200) {
			  alert("Opps !! Something went wrong");
		  }
		
		});

		xhr.open("POST","/registration");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(data);
		return false;
	}
</script>
</html>