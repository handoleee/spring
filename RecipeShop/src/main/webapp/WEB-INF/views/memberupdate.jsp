<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="../jsp/memberjoin.jsp"></script>
	<style>
		h2{
		color:#db7093;}
	</style>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<div style="width: 1400px; left: 50%; margin-left: 700px;">
	<h2>회원정보수정</h2>
	
	<form action="memberupdateprocess" method="post" name="memberupdateform">
		
		아이디<br>
			<input type="text" name="mid" value="${memberupdate.mid}" readonly><br>
		비밀번호<br>
			<input type="text" name="mpassword" id="mpassword" onkeyup="pwCheck()" placeholder="8~20자 영문 대 소문자,숫자">
			<span id="pwcheck"></span><br>
		이름<br>
			<input type="text" name="mname" value="${memberupdate.mname}" readonly><br>
		전화번호<br> 
			<input type="text" name="mphone" id="mphone" value="${memberupdate.mphone}" maxlength="13" onkeyup="phoneCheck()"><br>
		주소<br>
			<input type="text" name="maddr1" id="maddr1" placeholder="우편번호" readonly>
			<input type="button" onclick="daumPostcode()" value="우편번호 찾기"><br>
			<input type="text" name="maddr2" id="maddr2" placeholder="주소" readonly><br>
			<input type="text" name="maddr3" id="maddr3" placeholder="상세주소"><br>
			<span id="addrcheck"></span>
		<input type="button" onclick="memberUpdatefn()" value="수정">
	</form>
	</div>
</body>
</html>