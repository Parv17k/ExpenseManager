<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Expense Tracker</title>
</head>
<link rel="stylesheet" type="text/css" href="home.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">
		<a href="welcome.html" class="logo">Expense Tracker</a>
		<div class="header-right">
			<a href="login.jsp" style="float:right">Logout</a>	
	    	<a href="about.html"style="float:right">About</a>
	 	</div>
	</div>
	<div class="head">
		<h1>Start Tracking Your Expenses</h1>
	</div>
	<div class="box">
		<p> MANAGE COMPANY </p>
	</div>
	<div class="box">
		<p> MANAGE EMPLOYEES </p>
	</div>
	<div class="box">
		<p> MANAGE EXPENSES </p>
	</div>
	<div class="box">
		<p> MANAGE EXPENSE TYPES </p>
	</div>
</body>
<script>
(async function() {
	let url="/username";
	let email="anonymousUser";
	email = await await new Promise(resolve => {
		   var xhr = new XMLHttpRequest();
		   xhr.open("GET", url, true);
		   xhr.onload = function(e) {
			   if (xhr.readyState == 4 && xhr.status == 200) {
				  if(xhr.response!="anonymousUser")
				   localStorage.setItem("email",xhr.response);
				  else
					 document.write("<h1>Login and try again</h1>")
				  }	
		     resolve(xhr.response);  
		   };
		   xhr.onerror = function () {
			   document.write("<h1>Login and try again</h1>");
		     resolve(undefined);
		     alert("Issue with your user, please login and comeback");
		     console.error("** An error occurred during the XMLHttpRequest");
		   };
		   xhr.send();
		}) 
	
	return await await email;
})();


</script>
</html>