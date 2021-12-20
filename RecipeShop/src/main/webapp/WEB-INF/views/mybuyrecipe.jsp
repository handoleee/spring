<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매한 레시피</title>
</head>
<body>
	<h2 style="color: #7fad39"><b>구매한 레시피</b></h2>
		<nav class="header__menu">
	        <ul>
				<li><a href="./">홈</a></li>
				<li><a href="myrecipelist?mid=${sessionScope.loginMember}">내 레시피</a></li>
				<li class="active"><a href="mybuyrecipe">구매한 레시피</a></li>
		 		<li><a href="memberupdate">회원정보수정</a></li>
	 			<li><a href="myreport?mid=${sessionScope.loginMember}">내 신고내역</a></li>
	 			<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
		     </ul>                       
		</nav>
	<table>
			<tr>
				<th>레시피이름</th>
				<th>레시피사진</th>
			</tr>
			<c:if test="${sessionScope.loginMember eq member.mid }">
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