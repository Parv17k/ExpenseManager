<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Expense Tracker</title>
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
		<h1>Manage Your Expenses</h1>
	</div>
	<div class="box">
		<p>Enter Short Description for Expense:
		<INPUT TYPE="text" id="shortdesc" NAME="shortdesc" placeholder="Enter Short Description" id="shortdesc" SIZE="40" maxlength="40" style="width:150px; float:middle;" required="required" >
		</p>
		<p>Enter Long Description for Expense:
		<INPUT TYPE="text" id="longdesc" NAME="longdesc" placeholder="Enter Long Description" id="longdesc" SIZE="40" maxlength="400" style="width:300px; float:middle;" required="required" >
		</p>
		<p>Enter Expense Amount:
		<INPUT TYPE="number" id="cost"  NAME="cost" placeholder="Enter Amount" id="cost" SIZE="10" maxlength="10" style="width:200px; float:middle;" required="required"  >
		</p>
		<p>Enter Expense Type:
		<select id="exptype">
		</select>
		</p>
		<p>Select Employee:
		<select id="empId">
		</select>
		</p>
		<button class="addButton" onclick="addExpense()">Add Expense</button>
	</div>
	<div class="table">
		<table id="table">
			<caption> Expense Detail </caption>
			<tr style="height:60px">
			<th style="width:100px"> Expense ID </th>
			<th style="width:150px"> Short Description </th>
			<th style="width:200px"> Long Description </th>
			<th style="width:150px"> Expense Amount </th>
			<th style="width:150px"> Expense Type </th>
			<th style="width:150px"> Created By </th>
			<th style="width:100px"> Created On </th>
			<th style="width:100px"> Employee ID </th>
			<th style="width:150px"> Edit? </th>
			<th style="width:150px"> Delete Expense? </th>
			</tr>
			<tr>
			<td> Expense ID </td>
			<td> Short Description </td>
			<td> Long Description </td>
			<td> Expense Amount </td>
			<td> Expense Type </td>
			<td> Created By </td>
			<td> Created On </td>
			<td> Employee ID </td>
			<td> Edit ? </td>
			<td> <button class="delButton">Delete</button> </td>
			</tr>
		</table>
	</div>
</body>
<script>
var email= localStorage.getItem("email");
console.log("retirved email",email);
var expenseArray=[];
var companyIdFiller=async function()
{
var user = await fetch('/users/'+email);
const userdata = await user.json();

expenseArray=[];
if(userdata?.companies)
	{
   
	userdata?.expenseTypes.forEach(type=>{
		
		let  sel= document.getElementById("exptype");
		let option = document.createElement("option");
		option.text = "Expense Type : "+type?.type+" , ID : "+type?.id;
		option.value= type?.id;
		sel.add(option);
	})
	let expenses=userdata?.expenses;
	for(let i=0;i<expenses.length;i++)
	{
		let expense=expenses[i];
		var r = await fetch('/expenses/'+expense);
			const expenseresult = await r.json();
		expenseArray.push(expenseresult);
	}
	userdata?.companies.forEach(company=>{
		let  sel= document.getElementById("empId");
		let option = document.createElement("option");
		company.employees.forEach(employee=>{
			option.text = "Employee Name : "+employee?.name+" , ID : "+employee?.empId;
			option.value= employee?.empId;
			sel.add(option);
		})
		
	})
	}
}


var updateTable = async function()
{
			
				 await companyIdFiller();
				 printTable(expenseArray);
}
var  deleteRecord=async function(id){
	let url="/expenses/"+id.target.id;
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
/*
 * 
 
 {"shortDesc":"sa",
	 "expenseCost":"sa",
	 "longDesc":"sa",
	 "createdBy":{"emailID":"parv@parv.com"},
	 "type":{"id":"2"},
	 "employee":{"empId":"1"}}
 **/
	var row = tab.insertRow(-1);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
	var cell8 = row.insertCell(7);
	var cell9 = row.insertCell(8);
	var cell10 = row.insertCell(9);
	cell2.innerHTML = tabledata[i]?.shortDesc;
	cell3.innerHTML = tabledata[i]?.longDesc;
	let id=tabledata[i]?.id;
	cell1.innerHTML = id;
	cell4.innerHTML=tabledata[i]?.expenseCost;
	cell5.innerHTML=tabledata[i]?.type;	
	cell6.innerHTML=tabledata[i]?.createdBy;
	cell7.innerHTML=tabledata[i]?.created;
	cell8.innerHTML=tabledata[i]?.employee;
	cell9.innerHTML = '<a href="/editexpense.jsp?id='+id+'" class="editButton">edit</a> ';
	//cell9.addEventListener("click",(id)=>{ deleteRecord(id)}, false);
	cell10.innerHTML = '<button id="'+id+'" class="delButton">Delete</button> ';
	cell10.addEventListener("click",(id)=>{ deleteRecord(id)}, false);

	}

}

var addExpense= async function(){
	const data = JSON.stringify({
		"shortDesc":document.getElementById("shortdesc").value,
		"expenseCost":document.getElementById("cost").value,
		"longDesc": document.getElementById("longdesc").value,
		"createdBy": {
		"emailID":localStorage.getItem("email")
		},
		"type": {"id": document.getElementById("exptype").value},
		"employee": {"empId":document.getElementById("empId").value},
		});

		const xhr = new XMLHttpRequest();

		xhr.addEventListener("readystatechange", function () {
			 if (this.readyState == 4 && this.status == 200) {
			  alert("Expense Added Successfully!!");
			  updateTable();
		  }	else if (this.readyState == 4 && this.status != 200) {
			  alert("Opps !! Something went wrong !"+this.status);
		}
		});
		xhr.open("POST","/expenses");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(data);
		return false;
	}
</script>
</html>