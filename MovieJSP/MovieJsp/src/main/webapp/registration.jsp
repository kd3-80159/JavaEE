

<%@page import="com.sunbeam.beans.RegistrationBean"%>
<%@page import="com.sunbeam.pojos.User"%>
<%@page import="com.sunbeam.daos.UserDaoImpl"%>
<%@page import="com.sunbeam.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
   <jsp:useBean id="rb"  class ="com.sunbeam.beans.RegistrationBean"/>
   	<jsp:setProperty name="rb" property="*" />  	
   <% rb.saveUser();%>
   	<%
		if(rb.getStatus()) //if(status)
			out.println("Added Successfully!");
		else
			out.println("Not Added!");
	%>
   
</body>
</html>













