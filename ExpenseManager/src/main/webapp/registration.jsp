

<!DOCTYPE html>
<html lang="en">

  
<body>
<form>
   ${SPRING_SECURITY_LAST_EXCEPTION.message}
      <table>
         <tr>
            <td>Email:</td>
            <td><input type='email' id="email" name='email' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' id="password" name='password' /></td>
         </tr>
          <tr>
            <td>Name:</td>
            <td><input type='text' id="name" name='name' /></td>
         </tr>
         <tr>
            <td><button onclick="register();return false;"/>register</button></td>
         </tr>
      </table>
  </form>
</body>
<script>
function register(){
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