<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>쇼핑몰 상품등록</b></h2>
		<nav class="header__menu">
	        <ul>
				<li><a href="./">홈</a></li>
				<li><a href="memberlist">회원목록/포인트지급</a></li>
				<li class="active"><a href="addshoppage">쇼핑몰 상품등록</a></li>
		 		<li><a href="reportlist">신고내역</a></li>
	 		</ul>
		</nav>
	<div>
		<form action="shopadd" method="post" enctype="multipart/form-data">
			상품이름:<br>
			<input type="text" name="sname"><br>
			가격:<br>
			<input type="text" name="sprice"><br>
			재고:<br> 
			<input type="text" name="sstock"><br>
			대표사진:<br>
			<input type="file" name="sfile"><br>
			원산지:<br>
			<input type="text" name="sorigin"><br>
			제조사:<br>	
			<input type="text" name="smake"><br>
			구성:<br>
			<input type="text" name="sbox"><br>
			유통기한:<br>
			<input type="text" name="stime"><br>
			상세정보:<br>
			<textarea name="scontents" rows="10"></textarea><br>	
			<input type="submit" value="작성"><br>
		</form>
	</div>
</body>
</html>