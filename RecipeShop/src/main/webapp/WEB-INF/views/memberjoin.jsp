<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>memberjoin.jsp</h2>
<form action="memberjoin" method="post">
아이디 : <input type="text" name="id" id="id" onkeyup="idRegularCheck()">
		<span id="idcheckresult"></span><br>
비밀번호 : <input type="password" name="passwordcheck" id="password"><br>
비밀번호 확인 : <input type="password" name="passcf" id="passcf" onkeyup="passwordConfirm"> 
			<span id="passwordconfirmresult"></span><br>
이름 : <input type="text" name="name"><br>
전화번호 : <input type="text" name="phone"><br> 
주소: <br>
이메일 : <input type="email" name="email">
<span>전송</span><br>
<input type="text" name="emailcheck">
</form>

</body>
</html>