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
Hello,${lb.user.firstName} ${lb.user.lastName};
<jsp:useBean id="rv" class="com.sunbeam.beans.ReviewBean"/>
${rv.fetchReview()}

<table border="1">
<thead>
<tr>
<th>Id</th>
<th>MovieId</th>
<th>Review</th>
<th>Rating</th>
<th> userId</th>
<th>Date</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach var="c" items="${rv.review}">
<tr>
<td>${c.id }</td>
<td>${c.movieId }</td>
<td>${c.review}</td>
<td>${c.rating}</td>
<td>${c.userId}</td>
<td>${c.modified}</td>
<td><a href="editReview.jsp?id=${c.id}">Edit</a></td>
<td><a href="delrRview.jsp">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="logout.jsp">signOut</a>
</body>
</html>