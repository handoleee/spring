<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function mypage() {
			if(${sessionScope.loginMember} != null){
			location.href="mypage";}
		}
		
	</script>
</head>
<body>
	<h2>메뉴 contentslist</h2>
	로그인 아이디 : ${sessionScope.loginMember}
	<br>
	<c:if test="${not empty sessionScope.loginMember}">
		<a href="logout">로그아웃</a>
	<!-- <button onclick="logout()">로그아웃</button> -->
		<a href="mypage">마이페이지</a>
	</c:if>
	<c:if test="${sessionScope.loginMember eq ('admin')}">
		<a href="adminmenupage">메뉴 추가, 삭제</a><br><br>
	</c:if>
		<input type="checkbox" value="${contents.cbrand}">
	<%-- <c:forEach var="contents" items="${contents}">
	<!-- 체크박스 넣기 -->	
	</c:forEach> --%>
	<c:if test="${!empty contentsList}">
		<select name="selectBox" id="selectBox" class="select">
			<c:forEach var="contentsList" items="${contentsList}" varStatus="i">
				<option value="${contentsList.cbrand}">${contentsList.cbrand}</option>
			</c:forEach>
		</select>
	</c:if>
	<!--사진 띄우고 마우스 위에다가 올리면 상세설명 뜨게 -->
	<!--크기 맞춰서 메뉴 이름 적어놓고..? -->
</body>
</html>