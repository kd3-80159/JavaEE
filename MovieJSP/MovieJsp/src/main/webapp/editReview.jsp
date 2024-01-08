<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditReview</title>
</head>
<body>
Hello,${lb.user.firstName}${lb.user.lastName}<hr/>
<h3>EditReview</h3>
<jsp:useBean id ="frd" class="com.sunbeam.beans.FindReview"/>
<jsp:setProperty  name="frd" property="id" param="id"/>
${frd.fetchReview()}
<%-- ${frd.fetchMovie()} --%>
	<form method="post" action="">
<%-- 	  <c:forEach var="c" items="${frd.movieList}">
	  <select>
	  <option value ="%d">%s </option>
	  </select> --%>
		<input type="hidden" name="id" value="${frd.review.movieId}readonly"/> <br/><br/>
		Rating: <input type="text" name="rating" value="${frd.review.rating}"/> <br/><br/>
		Review: <input type="text" name="votes" value="${frd.review.review}" /> <br/><br/>

		<a href="UpdateReview.jsp" >update</a>
		
	</form>
</body>
</html>
