<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		function idCheck(){
			var inputId = document.getElementById('mid').value;
			var idcheckResult = document.getElementById('idcheckresult');
			console.log(inputId);
			$.ajax({
				type: 'post',
				url: 'idcheck',
				data: {'mid': inputId},
				dataType: 'text',
				success: function(id) {
					console.log('제대로');
					console.log('리턴값'+id);
					if(id == 'ok'){
						idcheckResult.style.color = 'green';
						idcheckResult.innerHTML = '사용가능한 아이디입니다.';
					} else{
						idcheckResult.style.color = 'red';
						idcheckResult.innerHTML = '이미 사용중인 아이디입니다.';
					}
				},
				error: function(){
					console.log('제대로 안됨');
				}
			});
		}
		
		 function pwConfirm() {
			var inputPw = document.getElementById('mpassword').value;
			var mpwcf = document.getElementById('mpasscf').value;
			var pwconfirmResult = document.getElementById('pwconfirmresult');
			console.log(mpwcf);
			if(inputPw == mpwcf){
				pwconfirmResult.style.color = 'green';
				pwconfirmResult.innerHTML = '비밀번호가 일치합니다.'
			} else {
				pwconfirmResult.style.color = 'red';
				pwconfirmResult.innerHTML = '비밀번호가 일치하지 않습니다.';
			}
			} 
	</script>
	<style>
		h2{
			color: #db7093;}
	</style>
</head>
<body>
	<h2>회원가입페이지</h2>

	<form action="memberjoin" method="post">
		아이디 : <input type="text" name="mid" id="mid" onkeyup="idCheck()">
				<span id="idcheckresult"></span><br>
		비밀번호 : <input type="text" name="mpassword" id="mpassword"><br>
		비밀번호 확인 : <input type="text" name="mpasscf" id="mpasscf" onkeyup="pwConfirm()">
				<span id="pwconfirmresult"></span><br> 
		이름 : <input type="text" name="mname"><br>
		전화번호 : <input type="text" name="mphone"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>