<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="expense.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">
		<a href="welcome.html" class="logo">Expense Tracker</a>
		<div class="header-right">
			<a href="/logout" style="float:right">Logout</a>	
	    	<a href="about.html"style="float:right">About</a>
	    	<a href="home.jsp"style="float:right">Home</a>
	 	</div>
	</div>
	<div class="head">
		<h1>Edit Expenses</h1>
	</div>
	<div class="box">
		<p>ID:
		<span id="id"> </span>
		</p>
		<p>Enter Short Description for Expense:
		<INPUT TYPE="text" id="shortdesc" NAME="shortdesc" placeholder="Enter Short Description" id="shortdesc" SIZE="40" maxlength="40" style="width:150px; float:middle;" required="required" >
		</p>
		<p>Enter Long Description for Expense:
		<INPUT TYPE="text" id="longdesc" NAME="longdesc" placeholder="Enter Long Description" id="longdesc" SIZE="40" maxlength="400" style="width:300px; float:middle;" required="required" >
		</p>
		<p>Enter Expense Amount:
		<INPUT TYPE="number" id="cost"  NAME="cost" placeholder="Enter Amount" id="cost" SIZE="10" maxlength="10" style="width:200px; float:middle;" required="required"  >
		</p>
		<button class="addButton" onclick="updateExpense()">Update Expense</button>
	</div>
</body>
<script>
var  id= window.location.href;
id=id.split("id=")[1];
let expensedata={};
let initial=async function(){
	var expense = await fetch('/expenses/'+id);
	 expensedata = await expense.json();
	if(expensedata?.id)
		{
		console.log("data retrived");
		document.getElementById("id").innerHTML=expensedata?.id;
		document.getElementById("shortdesc").value=expensedata?.shortDesc;
		document.getElementById("longdesc").value=expensedata?.longDesc;
		document.getElementById("cost").value=expensedata?.expenseCost;
		}
}
initial();
let updateExpense = async function(){
	expensedata.shortDesc=document.getElementById("shortdesc").value;
	expensedata.expenseCost=document.getElementById("cost").value;
	expensedata.longDesc=document.getElementById("longdesc").value;
	expensedata.type={"id":expensedata.type};
	expensedata.employee={"empId":expensedata.employee};
	expensedata.createdBy={"emailID":expensedata.createdBy};
	fetch('/expenses', {
		  "method": 'PUT',
		  headers: {
              'Accept': 'application/json, text/plain',
              'Content-Type': 'application/json;charset=UTF-8'
          },
		  "body": JSON.stringify(expensedata)
		})
		.then(res => {
			console.log(res);
			alert("Updated")}) 
		.catch(e=>{
			alert("error");
		})
}
</script>

</html>