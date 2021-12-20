<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 레시피</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
    <script>
    	function memberDelete(id) {
		if(confirm("탈퇴하시겠습니까?") == true){
			alert('탈퇴되었습니다.');
			location.href='memberdelete?mid='+id;
		}
		else{
			location.href='mypage';
		}
		}									
    </script>
</head>
<body>
	<h2 style="color: #7fad39"><b>내 레시피</b></h2>
		<nav class="header__menu" style="cursor:pointer">
	        <ul>
				<li><a href="./">홈</a></li>
				<li class="active"><a href="myrecipelist?rname=${sessionScope.loginMember}">내 레시피</a></li>
				<!-- <li><a href="mybuyrecipe">구매한 레시피</a></li> -->
		 		<li><a href="memberupdate">회원정보수정</a></li>
	 			<li><a href="myreport?rpname=${sessionScope.loginMember}">내 신고내역</a></li>
	 			<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
		     </ul>                       
		</nav>
	메뉴 사진<br>
	<c:forEach items="${myrecipelist}" var="i">
		<%-- <c:if test="${sessionScope.loginMember eq i.rname }"> --%>
			<a href="recipeview?rnumber=${i.rnumber}">
			<img src="resources/upload/recipe_b/${i.rfilename}" height="150" width="150"></a><br>
		<%-- </c:if> --%>
	</c:forEach>
</body>
</html>