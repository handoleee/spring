<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl : jsp에서 제공하는 문법으로 if, for 등과 같은 제어문 문법을 사용할 수 있도록 함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>select.jsp</h2>
	<!-- jstl에서 제공하는 반복문 문법을 활용하여 dbList 담긴 내용 출력 -->
	<c:forEach var="test" items="${dbList}">
	
	<!-- var 속성 : 현 위치에서 사용할 변수이름(반복용변수)
	items 속성 : mav에 담을 때 지정한 이름 -->
		${test}<br>
	</c:forEach> 
	<!-- 기본주소(/) 요청 링크 -->
	<a href="./">홈으로</a>
</body>
</html>