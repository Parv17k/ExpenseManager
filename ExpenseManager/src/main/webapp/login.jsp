

<!DOCTYPE html>
<html lang="en">

  
<body>
<form action="login" method='POST'>
   ${SPRING_SECURITY_LAST_EXCEPTION.message}
    ${status.error}
    <br>
     <br>
      <br>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='email' name="username" value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input  type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>

</html>