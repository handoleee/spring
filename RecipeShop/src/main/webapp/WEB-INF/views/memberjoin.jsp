<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function idCheck(){
			var exp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{8,20}$/;
			var inputId = document.getElementById('id').value;
			var checkResult = document.getElementById('idcheckresult');
			console.log(inputId);
			$.ajax({
				type: 'post',
				url: 'idCheck',
				data: {'id': inputId},
				dataType: 'text',
				success: function(id) {
					console.log('제대로');
					console.log('리턴값'+id);
					if(inputId.match(exp)) {
						if(id == 'ok'){
							checkResult.style.color = 'green';
							checkResult.innerHTML = '사용가능한 아이디입니다.';
						} else{
							checkResult.style.color = 'red';
							checkResult.innerHTML = '이미 사용중인 아이디입니다.';
					} 
					} else {
						checkResult.style.color ='red';
						checkResult.innerHTML = '8~20자리 영문 소문자, 숫자만 사용 가능합니다.';}
				},
				error: function(){
					console.log('제대로 안됨');
				}
			});
		}
		
		function pwCheck() {
			var pw = document.getElementById('password').value;
			var checkResult = document.getElementById('pwcheck');
			var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!#$-])[a-zA-Z\d!#$-]{8,20}$/;
			if(pw.length==0){
				checkResult.style.color = 'red';
				checkResult.innerHTML = '필수입력정보입니다.';
			} else if(!pw.match(exp)){
				checkResult.style.color = 'red';
				checkResult.innerHTML = '유효하지 않은 형식입니다.';
			} else {
				checkResult.style.color = 'green';
				checkResult.innerHTML = '유효한 형식입니다.';
			}
		} 
		
		function pwConfirm() {
			var inputPw = document.getElementById('password').value;
			var pwcf = document.getElementById('passcf').value;
			var pwconfirmResult = document.getElementById('pwconfirmresult');
			console.log(pwcf);
			if(inputPw == pwcf){
				pwconfirmResult.style.color = 'green';
				pwconfirmResult.innerHTML = '비밀번호가 일치합니다.'
			} else {
				pwconfirmResult.style.color = 'red';
				pwconfirmResult.innerHTML = '비밀번호가 일치하지 않습니다.';
			}
			} 
		
		function phon
	</script>
</head>
<body>
	<div style="width: 1400px; left: 50%; margin-left: 700px;">
	<h2>회원가입페이지</h2>
	
	<form action="memberjoin" method="post">
		아이디<br>
			<input type="text" name="id" id="id" onkeyup="idCheck()">
				<span id="idcheckresult"></span><br>
		비밀번호<br>
			<input type="password" name="password" id="password" onblur="pwCheck()" placeholder="8~20자 영문 대 소문자,숫자">
			<span id="pwcheck"></span><br>
		비밀번호 확인<br>
			<input type="password" name="passcf" id="passcf" onkeyup="pwConfirm()"> 
			<span id="pwconfirmresult"></span><br>
		이름<br>
			<input type="text" name="name"><br>
		전화번호<br>
			<input type="text" name="phone"><br>
		주소<br>
			<input type="text" id="sample6_postcode" placeholder="우편번호">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample6_address" placeholder="주소"><br>
			<input type="text" id="sample6_detailAddress" placeholder="상세주소"><br>
			<input type="text" id="sample6_extraAddress" placeholder="참고항목"><br>
		이메일<br> 
			<input type="email" name="email">
			<span>전송</span><br>
			<input type="text" name="emailcheck">
	</form>
	</div>

<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</body>
</html>