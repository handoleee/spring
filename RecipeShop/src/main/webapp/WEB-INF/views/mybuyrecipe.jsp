<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>mybuyrecipe.jsp</h2>
	<table>
			<tr>
				<th>레시피이름</th>
				<th>레시피사진</th>
			</tr>
			<c:if test="${sessionScope.loginMember} eq ${member.mid}">
		<c:forEach var="buy" items="${mybuyrecipe}">
			<tr>
				<td>${buy.rtitle}</td>
				<td><a href="recipeview?rnumber=${buy.rpnumber}"><img src="resources/rfilename/${buy.rfilename}" height="150" width="150"></a>${buy.rfilename}</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>