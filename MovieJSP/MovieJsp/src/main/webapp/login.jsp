<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*" />
	${lb.authenticate()}
		<c:choose>
		<c:when test="${empty lb.user}">
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:otherwise>
		<c:redirect url ="review.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>