<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
   <h1>Login</h1>
   <form action="login">
   	  Username: <br/>
      <input type="text" name="username"/> 
      <br/>
      Password: <br/>
      <input type="password" name="password"/>
      <br/>
      <input type="submit" value="Login"/>
   </form>
   <br/>
  
   Don't have an account?  
   
   <a href="register.jsp">Register</a>
</body>
</html>