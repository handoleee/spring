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
	
	<c:if test="${empty sessionScope.loginMember}">
		<a href="./">홈으로</a><br>
	</c:if>
		
	메뉴 사진<br>
	<c:forEach items="${contents}" var="i">
	
	<a href="menuview?cnumber=${i.cnumber}"><img src="resources/menupicture/${i.cpicname}" height="150" width="150"></a>
	</c:forEach>
	
	 <c:choose>
		<c:when test="${paging.page<=1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="paging?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="paging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${paging.page>=paging.maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="paging?page=${paging.page+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
</body>
</html>