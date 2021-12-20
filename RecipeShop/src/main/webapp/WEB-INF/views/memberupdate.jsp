<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function memberDelete(id) {
			if(confirm("탈퇴하시겠습니까?") == true){
				alert('탈퇴되었습니다.');
				location.href='memberdelete?mid='+id;
			}
			else{
				location.href='mypage';
			}
		}
	
		function idRegularCheck(){
			var exp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{8,20}$/; 
			var inputId = document.getElementById('mid').value;
			var checkResult = document.getElementById('idcheckresult');
			console.log(inputId);
			$.ajax({
				type: 'post',
				url: 'idcheck',
				data: {'mid': inputId},
				dataType: 'text',
				success: function(id) {
					console.log('제대로');
					console.log('리턴값'+id);
					if(inputId.match(exp)) {
						if(id == 'ok'){
							checkResult.style.color = 'green';
							checkResult.innerHTML = '사용가능한 아이디입니다.';
						} else if(id == 'no') {
							checkResult.style.color = 'red';
							checkResult.innerHTML = '이미 사용중인 아이디입니다.';
						}
					} 
					else {
						checkResult.style.color = 'red';
						checkResult.innerHTML = '8~20자리 영문 소문자, 숫자만 사용 가능합니다.';}
				},
				error: function(){
					console.log('제대로 안됨');
				}
			});
		}
		
		function pwCheck() {
			var pw = document.getElementById('mpassword').value;
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
		
		function phoneCheck() {
			var autoHypenPhone = function(str){
      		str = str.replace(/[^0-9]/g, '');
      		var tmp = '';
      		if( str.length < 4){
          		return str;
      		} else if(str.length < 7){
          	tmp += str.substr(0, 3);
          	tmp += '-';
          	tmp += str.substr(3);
         	 return tmp;
      	}	else if(str.length < 11){
          	tmp += str.substr(0, 3);
         	 tmp += '-';
         	 tmp += str.substr(3, 3);
         	 tmp += '-';
         	 tmp += str.substr(6);
          	return tmp;
      	} else{              
          	tmp += str.substr(0, 3);
          	tmp += '-';
          	tmp += str.substr(3, 4);
          	tmp += '-';
          	tmp += str.substr(7);
          	return tmp;
      	}
		return str;
	}
			var phoneNum = document.getElementById('mphone');
			phoneNum.onkeyup = function(){
  			console.log(this.value);
  			this.value = autoHypenPhone(this.value);  
		}
		} 
		
		function daumPostcode() { 
			new daum.Postcode({ 
				oncomplete: function(data) { 
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
			// 도로명 주소의 노출 규칙에 따라 주소를 조합한다. 
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
				var fullRoadAddr = data.roadAddress; // 도로명 주소 변수 
				var extraRoadAddr = ''; 
			// 도로명 조합형 주소 변수 // 법정동명이 있을 경우 추가한다. (법정리는 제외) 
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다. 
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){ 
					extraRoadAddr += data.bname; } 
			// 건물명이 있고, 공동주택일 경우 추가한다. 
				if(data.buildingName !== '' && data.apartment === 'Y'){ 
					extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName); } 
			// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다. 
				if(extraRoadAddr !== ''){ 
					extraRoadAddr = ' (' + extraRoadAddr + ')'; 
				} 
			// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다. 
				if(fullRoadAddr !== ''){ 
					fullRoadAddr += extraRoadAddr; 
				} 
			// 우편번호와 주소 정보를 해당 필드에 넣는다. 
				console.log(data.zonecode); 
				console.log(fullRoadAddr); 
			/* var a = console.log(data.zonecode); var b = console.log(fullRoadAddr);
			if(a == null || b = null){ alert("주소를 확인하세요."); return false; } */ 
			$("[name=maddr1]").val(data.zonecode); 
			$("[name=maddr2]").val(fullRoadAddr); 
			document.getElementById('maddr1').value = data.zonecode; //5자리 새우편번호 사용 
			document.getElementById('maddr2').value = fullRoadAddr; 
			
			//document.getElementById('mem_detailaddress').value = data.jibunAddress; 
			} 
		}).open(); 
	}
	</script>
	<style>
		h2{
		color:#db7093;}
	</style>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>회원정보수정</b></h2>
		<nav class="header__menu" style="cursor:pointer">
	        <ul>
				<li><a href="./">홈</a></li>
				<li><a href="myrecipelist?rname=${sessionScope.loginMember}">내 레시피</a></li>
				<!-- <li><a href="mybuyrecipe">구매한 레시피</a></li> -->
		 		<li class="active"><a href="memberupdate">회원정보수정</a></li>
	 			<li><a href="myreport?rpname=${sessionScope.loginMember}">내 신고내역</a></li>
	 			<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
		     </ul>                       
		</nav>
		
	<div style="width: 1400px; left: 50%; margin-left: 700px;">
	<form action="memberupdateprocess" method="post" name="memberupdateform">
		
		아이디<br>
			<input type="text" name="mid" value="${memberupdate.mid}" readonly><br>
		비밀번호<br>
			<input type="password" name="mpassword" id="mpassword" onkeyup="pwCheck()" placeholder="8~20자 영문 대 소문자,숫자">
			<span id="pwcheck"></span><br>
		이름<br>
			<input type="text" name="mname" value="${memberupdate.mname}" readonly><br>
		전화번호<br> 
			<input type="text" name="mphone" id="mphone" value="${memberupdate.mphone}" maxlength="13" onkeyup="phoneCheck()"><br>
		주소<br>
			<input type="text" name="maddr1" id="maddr1" value="${memberupdate.maddr1}" placeholder="우편번호">
			<input type="button" onclick="daumPostcode()" value="우편번호 찾기"><br>
			<input type="text" name="maddr2" id="maddr2" value="${memberupdate.maddr2}" placeholder="주소"><br>
			<input type="text" name="maddr3" id="maddr3" value="${memberupdate.maddr3}" placeholder="상세주소"><br>
			<span id="addrcheck"></span>
			
			<input type="submit" value="수정">
	</form>
	</div>
</body>
</html>