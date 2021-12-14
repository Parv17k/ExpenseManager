<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<p>${status}</p>
<form method="POST" action="addUser">

Name:<input name="name" />
Password:<input name="password" />
Bio:<input name="bio" />
Email:<input name="emailID" />
<button type="submit">Add User</button>
</form>
</head>
<body>
</body>
</html>