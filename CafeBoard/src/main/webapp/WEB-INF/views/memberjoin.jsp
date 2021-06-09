<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		function idcheck(){
			var inputId = document.getElementId('mid').value;
			var idcheckResult = document.getElementId('idcheckresult');
			console.log(inputId);
			$.ajax({
				type: 'post',
				url: 'idcheck',
				data: {'mid': inputId},
				dataType: 'text',
				success: function(abcd) {
					console.log('제대로');
					console.log('리턴값'+abcd);
					if(abcd == 'ok'){
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
		
		/* function pwcheck() {
			var inputPw = document.getElementById('mpw').value;
			var mpwcf = document.getElementById('mpwcf').value;
			var pwcheckResult = document.getElementById('pwcheckresult');
			
			if(inputPw == mpwcf){
				pwcheckResult.style.color = 'green';
				pwcheckResult.innerHTML = '비밀번호가 일치합니다.'
			} else {
				pwcheckResult.style.color = 'red';
				pwcheckResult.innerHTML = '비밀번호가 일치하지 않습니다.';
			}
			} */
	</script>
</head>
<body>
<h2>회원가입페이지(memberjoin.jsp)</h2>

<form action="memberjoin" method="post">
아이디 : <input type="text" name="mid" onkeyup="idcheck()">
		<span id="idcheckresult"></span><br>
비밀번호 : <input type="text" name="mpw"><br>
비밀번호 확인 : <input type="text" name="mpwcf" onkeyup="pwcheck()">
			<span id="pw"></span><br>
이름 : <input type="text" name="mname"><br>
전화번호 : <input type="text" name="mphone">
</form>
</body>
</html>