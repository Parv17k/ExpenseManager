

<!DOCTYPE html>
<html lang="en">

  
<body>
<form action="registration" method='POST'>
   ${SPRING_SECURITY_LAST_EXCEPTION.message}
      <table>
         <tr>
            <td>Email:</td>
            <td><input type='text' name='email' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
          <tr>
            <td>Name:</td>
            <td><input type='text' name='name' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>

</html>