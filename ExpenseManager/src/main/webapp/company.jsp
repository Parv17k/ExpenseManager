<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Expense Tracker</title>
</head>
<link rel="stylesheet" type="text/css" href="company.css">
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
		<h1>Manage Your Companies</h1>
	</div>
	<div class="box">
		<p>Enter Company Name:
		<INPUT TYPE="text" id="name" NAME="name" placeholder="Enter Company Name" id="name" SIZE="20" maxlength="20" style="width:150px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<p>Enter Company Description:
		<INPUT TYPE="text" id= "desc" NAME="desc" placeholder="Enter Company Description" id="desc" SIZE="20" maxlength="200" style="width:300px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<button class="addButton" onclick="addCompany()">Add Company</button>
	</div>
	<div class="table">
		<table id="table">
			<caption> Company Details </caption>
			<tr style="height:60px">
			<th style="width:250px"> Company Name </th>
			<th style="width:250px"> Company Description </th>
			<th style="width:250px"> Delete Company? </th>
			</tr>
		</table>
	</div>
</body>
<script>
var tableContent=[];
var email= localStorage.getItem("email");
console.log("retirved email",email);
if(email=""||email=="anonymousUser")
	{
	document.write("Issue with your session try again");
	}
	
var updateTable = async function()
{
	console.log("Update Table");
	let url="/users/"+localStorage.getItem("email");

	let result = await new Promise(resolve => {
		   var xhr = new XMLHttpRequest();
		   xhr.open("GET", url, true);
		   xhr.onload = function(e) {
			 tableContent=xhr.response?JSON.parse(xhr.response)?.companies:[];
			 if(tableContent!=[])
				 {
				 printTable(tableContent)
				 }
		     resolve(xhr.response);
		    
		   };
		   xhr.onerror = function () {
			   alert("Issue with your user, please login and comeback");
			     console.error("** An error occurred during the XMLHttpRequest");
			
		     resolve(undefined);
		       };
		   xhr.send();
		}) 
	return await await result;
}
var  deleteRecord=async function(id){
	let url="/companies/"+id.target.id;
	res = await new Promise(resolve => {
		   var xhr = new XMLHttpRequest();
		   xhr.open("DELETE", url, true);
		   xhr.onload = function(e) {
			 alert("Deleted Record with id: "+id.target.id);
			 updateTable();
		     resolve(xhr.response);
		   
		   };
		   xhr.onerror = function () {
			   alert("Unable to Delete Record with id: "+id.target.id);
			     alert("Issue with your user, please login and comeback");
			     console.error("** An error occurred during the XMLHttpRequest");
		     resolve(undefined);
		    
		   };
		   xhr.send();
		}) 
	return await await res;
}


updateTable();
function printTable(tabledata){
	let tab=document.getElementById("table");
	console.log("Table len",document.getElementById("table").rows.length);
	while(document.getElementById("table").rows.length>1)
		{
		document.getElementById("table").deleteRow(-1);
		}
for(let i=0;i<tabledata.length;i++)
	{
	var row = tab.insertRow(-1);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	cell1.innerHTML = tabledata[i]?.companyName;
	cell2.innerHTML = tabledata[i]?.desc;
	let id=tabledata[i]?.id;
	cell3.innerHTML = '<button id="'+id+'" class="delButton">Delete</button> ';

	console.log("passing id : "+id);
	cell3.addEventListener("click",(id)=>{ deleteRecord(id)}, false);
	console.log(row);
	}

}

var addCompany= async function(){
	const data = JSON.stringify({
		  "companyName": document.getElementById("name").value,
		  "owner": {
			  "emailID":localStorage.getItem("email")
		  },
		  "desc":  document.getElementById("desc").value
		});

		const xhr = new XMLHttpRequest();

		xhr.addEventListener("readystatechange", function () {
			 if (this.readyState == 4 && this.status == 200) {
			  alert("Company Added Successfully!!");
			  updateTable();
		  }	else if (this.readyState == 4 && this.status != 200) {
			  alert("Opps !! Something went wrong");
		  }
		
		});
		xhr.open("POST","/companies");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(data);
		return false;
	}
</script>
</html>