<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
	<script>
		function reportUpdate() {
			location.href='reportupdate?rpnumber='+${reportview.rpnumber};
		}
	</script>
</head>
<body>
	<h2 style="color: #7fad39"><b>신고상세조회</b></h2>
		<nav class="header__menu">
			<c:choose>
		        <c:when test="${sessionScope.loginMember eq ('admin')}">
					<ul>
						<li><a href="./">홈</a></li>
						<li><a href="memberlist">회원목록/포인트지급</a></li>
						<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
			 			<li class="active"><a href="reportlist">신고내역</a></li>
		 			</ul>     							
		        </c:when>
		        <c:otherwise>
		        	<ul>
						<li><a href="./">홈</a></li>
						<li><a href="myrecipelist?mid=${sessionScope.loginMember}">내 레시피</a></li>
						<li><a href="buyrecipe">구매한 레시피</a></li>
			 			<li><a href="memberupdate">회원정보수정</a></li>
		 				<li class="active"><a href="myreport?rpname=${sessionScope.loginMember}">내 신고내역</a></li>
		 				<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>	
			    	</ul> 
		        </c:otherwise>
	        </c:choose>
		</nav>
		
	<div id="container__list">
		신고번호 : ${reportview.rpnumber}<br>
		레시피번호 : ${reportview.rprnumber}<br>
		신고자 : ${reportview.rpname}<br>
		신고내용 : ${reportview.rpcontents}<br>
		신고답변여부: ${reportview.rpcheck}<br>
		신고답변내용 : ${reportview.rpanswer}<br>
	</div>
	
	<c:choose>
		<c:when test="${sessionScope.loginMember eq ('admin')}">
			<c:if test="${reportview.rpcheck eq ('n')}">
				<button onclick="reportUpdate()">답변하기</button>
			</c:if>
		</c:when>
	</c:choose>
<!-- 	<a href="adminpage">이전화면으로</a> -->
</body>
</html>