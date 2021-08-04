<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="../jsp/recipelist.jsp"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
	<style>
	#div_main{
	width:100%;
	height:500px;
	float:left;
	}
	
		h2{
		color:#db7093;
		}
	</style>
	<script>
	
		$(function() {
			$("#member_get").click(function() {
			$("#member").load("./memberlist #container");
			});
		});
		
		$(function() {
			$("#report_get").click(function() {
			$("#report").load("./reportlist");
			});
		});
	</script>
</head>
<body>
	<h2>관리자페이지</h2>
		<nav class="header__menu">
        	<ul>
				<li class="active"><a href="./">홈</a></li>
				<li><a id="member_get">회원목록</a></li>
				<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
	 			<li><a id="report_get">신고내역</a></li>
 				<li><a href="memberlist">포인트지급</a></li>
	      	<!-- <ul class="header__menu__dropdown">
	      <li><a href="memberlist">회원목록</a></li>
	   <li><a href="memberview">회원상세조회</a></li>
	   <li><a href="reportlist">회원신고내역</a></li> -->
	     </ul>                       
		</nav>
	<ul>
		<li><a href="memberlist">회원목록</a></li>
		<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
		<li><a href="reportlist">신고내역</a></li>
		<li><a href="memberlist">포인트 지급</a></li>
		<li><a href="./">홈</a></li>
	</ul>
	<div id="div_main">
	<div>
	<div id="member"></div>
	<!-- <button id="member_get">회원목록</button> -->
	<div id="report">
	<!-- <button id="report_get">신고내역</button></div> -->
	</div>
	</div>
	<%-- <jsp:include page="/WEB-INF/views/memberlist.jsp"/> --%>
	

	</div>
</body>
</html>