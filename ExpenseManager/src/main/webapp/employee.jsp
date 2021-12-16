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
		<h1>Manage Your Employees</h1>
	</div>
	<div class="box">
		<p>Enter Employee Name:
		<INPUT TYPE="text" NAME="name" placeholder="Enter Employee Name" id="name" SIZE="40" maxlength="40" style="width:150px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<p>Enter Employee Email:
		<INPUT TYPE="email" NAME="email" placeholder="Enter Employee Email" id="email" SIZE="40" maxlength="40" style="width:300px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<p>Enter Employee Department:
		<INPUT TYPE="text" NAME="dept" placeholder="Enter Employee Department" id="dept" SIZE="40" maxlength="40" style="width:200px; float:middle;" required="required" oninput="this.setCustomValidity('')" >
		</p>
		<p>Enter Employee Company ID:
		<select id="companyid" name="companyid" >
 		
			</select>
		</p>
		<button class="addButton" onclick="addEmployee()">Add Employee</button>
	</div>
	<div class="table">
		<table id="table">
			<caption> Employee Details </caption>
			<tr style="height:60px">
			<th style="width:200px"> Employee ID </th>
			<th style="width:200px"> Employee Name </th>
			<th style="width:200px"> Employee Email </th>
			<th style="width:200px"> Department </th>
			<th style="width:200px"> Company ID </th>
			<th style="width:200px"> Delete Employee? </th>
			</tr>
			<tr>
			<td> Employee ID </td>
			<td> Employee Name </td>
			<td> Employee Email </td>
			<td> Department </td>
			<td> Company ID </td>
			<td> <button class="delButton">Delete</button> </td>
			</tr>
		</table>
	</div>
</body>
<script>
var email= localStorage.getItem("email");
console.log("retirved email",email);
var employeeArray=[];
var companyIdFiller=async function()
{
	
	
var user = await fetch('/users/'+email);
const userdata = await user.json();
employeeArray=[];
if(userdata?.companies)
	{
	var sel= document.getElementById("companyid");
	while (sel.options.length > 0) {                
		sel.remove(0);
    }       
	
	userdata?.companies.forEach(company=>{
		var sel= document.getElementById("companyid");
		var option = document.createElement("option");
		option.text = "Company Name : "+company?.companyName+" , ID : "+company?.id;
		option.value= company?.id;
		sel.add(option);
		
		// employees;
		employeeArray.push(...company.employees);
	})
	}
}

companyIdFiller();


var updateTable = async function()
{
			
				 await companyIdFiller();
				 printTable(employeeArray);
}
var  deleteRecord=async function(id){
	let url="/employees/"+id.target.id;
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
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	cell2.innerHTML = tabledata[i]?.name;
	cell3.innerHTML = tabledata[i]?.email;
	let id=tabledata[i]?.empId;
	cell1.innerHTML = id;
	cell4.innerHTML=tabledata[i]?.department;
	cell5.innerHTML=tabledata[i]?.company
	cell6.innerHTML = '<button id="'+id+'" class="delButton">Delete</button> ';
	cell6.addEventListener("click",(id)=>{ deleteRecord(id)}, false);

	}

}

var addEmployee= async function(){
	const data = JSON.stringify({
		"department": document.getElementById("dept").value,
		 "name":  document.getElementById("name").value,
		 "company": {"id":document.getElementById("companyid").value},
		 "email":document.getElementById("email").value
		});

		const xhr = new XMLHttpRequest();

		xhr.addEventListener("readystatechange", function () {
			 if (this.readyState == 4 && this.status == 200) {
			  alert("Employee Type Added Successfully!!");
			  updateTable();
		  }	else if (this.readyState == 4 && this.status != 200) {
			  alert("Opps !! Something went wrong !"+this.status);
		
		}
		});
		xhr.open("POST","/employees");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(data);
		return false;
	}
</script>
</html>