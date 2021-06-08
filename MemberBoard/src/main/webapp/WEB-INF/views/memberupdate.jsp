<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function updatefn() {
		var passwordConfirm = document.getElementById('pwd').value;
		var password = '${memberup.mpassword}';
		if(password == passwordConfirm) {
				updateform.submit();
		} else {
			alert('비밀번호 불일치');
		}
	}
	</script>
</head>
<body>
	<h2>회원정보수정</h2>
	<form action="mupdateprocess" method="post" name="updateform" enctype="multipart/form-data">
		아이디 : <input type="text" name="mid" value="${memberup.mid}" readonly><br>
		비밀번호 : <input type="text" name="mpassword" id="pwd"><br> 
		이름 : <input type="text" name="mname" value="${memberup.mname}"><br>
		전화번호 : <input type="text" name="mphone" value="${memberup.mphone}"><br>
		이메일 : <input type="text" name="memail" value="${memberup.memail}"><br>
		프로필사진 : <input type="file" name="mprofile" value="${memberup.mprofilename}"><br>
		<input type="button" value="회원정보수정" onclick="updatefn()">
	</form>
</body>
</html>