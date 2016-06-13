<%@page import="actions.LoginAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h1>Welcome. Here is your Profile.</h1>
	<a href="index.jsp">Logout</a>
	<br/>
	
	<form action="update">
	  Account ID: <input type=text name="accountId" value=<s:property value="accountId"/> readonly>
	  <br/>
	  Username: 
	  <input type=text name="username" value=<s:property value="username"/>>
      <br/>
      Password: 
      <input type=text name="password" value=<s:property value="password"/>>
      <br/>
      Name:  
      <input type=text name="name" value=<s:property value="name"/>>
      <br/>
      Address: 
      <input type=text name="address" value=<s:property value="address"/>>
      <br/>
      Phone Number: 
      <input type=text name="pnumber" value=<s:property value="pnumber"/>>
      <br/>
      SSN:  
      <input type=text name="ssn" value=<s:property value="ssn"/>>
      <br/>
      
      <input type="submit" value="Update"/>
	</form>
	 
</body>
</html>