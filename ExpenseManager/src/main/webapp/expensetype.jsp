<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Expense Type</title>
</head>
<link rel="stylesheet" type="text/css" href="expensetype.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">
		<a href="/index" class="logo">Expense Manager</a>
		<div class="header-right">
			<a href="/logout" style="float:right">Logout</a>	
	    	<a href="about.html"style="float:right">About</a>
	    	<a href="/index"style="float:right">Home</a>
	 	</div>
	</div>
	<div class="head">
		<h1>Manage Expense Types</h1>
	</div>
	<div class="box">
		<p>Enter Expense Type:
		<INPUT TYPE="text" NAME="name" placeholder="Enter Expense Type" id="expensetype"  style="width:150px; float:middle;" >
		</p>
		<p>Enter Expense Description:
		<INPUT TYPE="text" NAME="desc" placeholder="Enter Expense Description" id="desc"  style="width:200px; float:middle;"  >
		</p>
		<button class="addButton" onclick="addExpense()">Add Expense Type</button>
	</div>
	<div class="table">
		<table id="table">
			<caption> Expense Type Details </caption>
			<tr style="height:60px">
			<th style="width:250px"> Expense Type ID </th>
			<th style="width:250px"> Expense Type </th>
			<th style="width:250px"> Expense Description </th>
			<th style="width:250px"> Delete Expense Type? </th>
			</tr>
	
		</table>
	</div>
</body>
<script>
var tableContent=[];
var email= localStorage.getItem("email");
console.log("retirved email",email);
/*var user=const response = fetch('/users/'+email);
const json = response.json();
console.log(json);*/
if(email=""||email=="anonymousUser")
	{
	document.write("Issue with your session try again");
	}
	
var updateTable = async function()
{
	let url="/users/"+localStorage.getItem("email");

	let result = await new Promise(resolve => {
		   var xhr = new XMLHttpRequest();
		   xhr.open("GET", url, true);
		   xhr.onload = function(e) {
			 tableContent=xhr.response?JSON.parse(xhr.response)?.expenseTypes:[];
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
	let url="/expensetype/"+id.target.id;
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
	var cell4 = row.insertCell(3);
	cell2.innerHTML = tabledata[i]?.type;
	cell3.innerHTML = tabledata[i]?.desc;
	let id=tabledata[i]?.id;
	cell1.innerHTML = id;
	cell4.innerHTML = '<button id="'+id+'" class="delButton">Delete</button> ';
	cell4.addEventListener("click",(id)=>{ deleteRecord(id)}, false);

	}

}

var addExpense= async function(){
	const data = JSON.stringify({
		"type": document.getElementById("expensetype").value,
		 "desc":  document.getElementById("desc").value,
		 "user":{
			 "emailID":localStorage.getItem("email")
			 }
		});

		const xhr = new XMLHttpRequest();

		xhr.addEventListener("readystatechange", function () {
			 if (this.readyState == 4 && this.status == 200) {
			  alert("Expense Type Added Successfully!!");
			  updateTable();
		  }	else if (this.readyState == 4 && this.status != 200) {
			  alert("Opps !! Something went wrong !"+this.status);
		
		}
		});
		xhr.open("POST","/expensetype");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(data);
		return false;
	}
</script>
</html>