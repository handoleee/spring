<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>myrecipelist.jsp</h2>
	메뉴 사진<br>
	<c:forEach items="${myrecipelist}" var="i">
	
	<a href="recipeview?rnumber=${i.rnumber}"><img src="resources/rfilename/${i.rfilename}" height="150" width="150"></a><br>
	</c:forEach>
</body>
</html>