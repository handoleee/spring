<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function pointUpdatefn() {
			pointupdateform.submit();
		}
	</script>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>회원목록/포인트지급</b></h2>
		<nav class="header__menu">
        	<ul>
				<li><a href="./">홈</a></li>
				<li class="active"><a href="memberlist">회원목록/포인트지급</a></li>
				<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
	 			<li><a href="reportlist">신고내역</a></li>
 			</ul>
		</nav>
	
	<form action="adminpointprocess" method="post" name="pointupdateform">
		아이디<br>
			<input type="text" name="mid" value="${adminpoint.mid}" readonly><br>
		포인트<br>
			<input type="text" name="mpoint" value="${adminpoint.mpoint}">
			
			<input type="submit" value="지급">
	</form>
</body>
</html>