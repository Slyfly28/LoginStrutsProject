<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register</h1>
<br/>
  <form action="register">
   	  Username: <br/>
      <input type="text" name="username"/> 
      <br/>
      Password: <br/>
      <input type="password" name="password"/>
      <br/>
      Name: <br/>
      <input type="text" name="name"/>
      <br/>
      Address: <br/>
      <input type="text" name="address"/>
      <br/>
      Phone Number: <br/>
      <input type="text" name="pnumber"/>
      <br/>
      SSN: <br/>
      <input type="text" name="ssn"/>
      <br/>
      
      <input type="submit" value="Register"/>
   </form>
</body>
</html>