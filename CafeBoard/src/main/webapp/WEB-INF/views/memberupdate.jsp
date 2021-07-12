<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function memberupdatefn() {
			var passwordConfirm = document.getElementById('pwd').value;
			var password = '${memberUpdate.mpassword}';
			if(password == passwordConfirm){
				memberupdateform.submit();
			} else {
				alert('비밀번호가 틀립니다.');
			}
		}
	</script>
	<style>
		h2{
		color:#db7093;}
	</style>
</head>
<body>
	<h2>회원정보수정</h2>
	<form action="memberupdateprocess" method="post" name="memberupdateform">
		아이디 : <input type="text" name="mid" value="${memberupdate.mid}" readonly><br>
		비밀번호 : <input type="text" name="mpassword" id="pwd"><br>
		이름 : <input type="text" name="mname" value="${memberupdate.mname}" readonly><br>
		전화번호 : <input type="text" name="mphone" value="${memberupdate.mphone}"><br>
		<input type="button" onclick="memberupdatefn()" value="수정">
	</form>
</body>
</html>