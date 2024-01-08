<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 

<body>
<jsp:useBean id="pb" class="beans.PlayerBean" scope="session" ></jsp:useBean>
<jsp:setProperty property="*" name="pb"/>
 ${sessionScope.pb.validateAndPlayer()}
 <h1>Hi</h1>
</body>
</html>