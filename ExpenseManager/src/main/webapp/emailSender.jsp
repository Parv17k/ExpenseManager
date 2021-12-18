<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Expense Tracker</title>
</head>
<link rel="stylesheet" type="text/css" href="employee.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">
		<a href="welcome.html" class="logo">Expense Tracker</a>
		<div class="header-right">
			<a href="login.jsp" style="float:right">Logout</a>	
	    	<a href="about.html"style="float:right">About</a>
	    	<a href="home.jsp"style="float:right">Home</a>
	 	</div>
	</div>
	<div class="head">
		<h1>Send Email</h1>
	</div>
	<form>
	<div class="box">
		<p>TO:
		<INPUT TYPE="email"  placeholder="email" id="to" SIZE="40" maxlength="40" style="width:150px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<p>Enter Text:
		<textarea id="text"  placeholder="Enter text" ></textarea>
		</p>
		<button class="addButton" type="submit" onclick="sendEmail();return false;">Send Email</button>
	</div>
		</form>
	</body>
	<script>
	let sendEmail=async function(){
		
		let to= document.getElementById("to").value;
		let text= document.getElementById("text").value;
		var email = document.getElementById("to").value;
	    var chk = email.match(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/);
		if(!chk){
			alert("Enter a valid email address");
			return false;
		}
		 fetch('/sendemail/?text='+text+'&to='+to).then(res => {
			alert("Sent")
				}) 
		.catch(e=>{
			alert("error");
		});
	}
	</script>
	</html>