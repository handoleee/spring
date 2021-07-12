<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function idoverlap() {
		/* 함수의 역할 
			- 사용자가 입력한 id값을 백엔드로 보내고 DB에서 중복여부를 확인 후 결과를 가져옴
			- 비동기식으로 처리하기 위해 ajax를 사용함
			ajax(Asynchronous javascript and xml)
			- 비동기식 처리를 위한 문법(화면과 주소가 바뀌는 것 없이 백엔드에 요청을 보내고 결과를 받을 수 있음)
			- jquery 문법으로 이용할 예정*/
		var inputId = document.getElementById('mid').value;
		var checkResult = document.getElementById('checkresult');
		console.log(inputId);
		$.ajax({
			type: 'post', // 전송방식(get,post,delete,patch,put)
			url: 'idcheck', // 요쳥주소(컨트롤러에서 받는 주소)
			data: {'mid': inputId}, // 전송할 파라미터(데이터)
			dataType: 'text', // 리턴데이터형식(컨트롤러에서 다시 받아올 때)
			success: function(abcd) { // 성공시 처리할 함수
				console.log('제대로 돌고 있음');
				console.log('리턴값 '+abcd);
				if(abcd =='ok'){
					checkResult.style.color = 'green';
					checkResult.innerHTML = '사용가능한 아이디입니다.';
				} else {
					checkResult.style.color = 'red';
					checkResult.innerHTML = '이미 사용중인 아이디입니다.';
				}
			},
			error: function(){ // 실패시 처리할 함수
				console.log('제대로 안돌고 있음');
			}
		});
	}
</script>
</head>
<body>
	<!-- 동기식 : 주소, 화면이 바뀌면서 DB를 다녀옴
	     비동기식 : 주소, 화면이 바뀌지 않고도 DB를 다녀옴 -->
	     
	<h2>memberjoin.jsp</h2>
	<form action="memberjoin" method="post">
		아이디 : <input type="text" name="mid" id="mid" onkeyup="idoverlap()">
			<span id="checkresult"></span><br>
		비밀번호 : <input type="text" name="mpassword"><br>
		이름 : <input type="text" name="mname"><br>
		이메일 : <input type="text" name="memail"><br>
		
			<input type="submit" value="회원가입">
	
	</form>
</body>
</html>