<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ucr" class="com.sunbeam.beans.UpdateReviewBean"></jsp:useBean>
<jsp:setProperty name="ucr" property="*"/>
${ucr.updateReview()};
<jsp:forward page="review.jsp"></jsp:forward>
</body>
</html>