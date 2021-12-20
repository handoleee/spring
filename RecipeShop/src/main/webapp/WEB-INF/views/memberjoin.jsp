<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>recipe</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
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
		
		function pwConfirm() {
			var inputPw = document.getElementById('mpassword').value;
			var pwcf = document.getElementById('mpasscf').value;
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
		
		 function phoneCheck() {
			var autoHypenPhone = function(str){
      		str = str.replace(/[^0-9]/g, '');
      		var tmp = '';
      		if(str.length < 4){
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
		 
		var code = ""; 
		function sendEmail() {
			var inputEmail = document.getElementById('memail').value;
			console.log(inputEmail); 
		 
			 $.ajax({
				type : 'get',
				url : 'checkemail?email'+inputEmail,
				data : {'email' : inputEmail}, 
				dataType : 'text',
				success: function(data){
					console.log(data);
					code = data;
				}
				});
				alert("인증번호가 전송되었습니다.") 
				}
		 
		function emailCheck(){
			var inputEmailNum = document.getElementById('memailnum').value;
			var emailconfirmResult = document.getElementById('emailconfirmresult');
			if(inputEmailNum == code){
				emailconfirmResult.style.color = 'green';
				emailconfirmResult.innerHTML = '인증완료되었습니다.'
			} else {
				emailconfirmResult.style.color = 'red';
				emailconfirmResult.innerHTML = '다시 입력해주세요';
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
</head>

<body>
    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                            	<c:if test="${not empty sessionScope.loginMember}">
                                	<li><i class="fa fa-envelope"></i>${sessionScope.loginMember}님 반갑습니다!</li>
                                </c:if>
                            </ul>
                        </div>
                     </div>
                     <div class="col-lg-6 col-md-6">
                     	<div class="header__top__right">
                     		<div class="header__top__right__menu">
                        		<div>menu</div>
                                	<span class="arrow_carrot-down"></span>
                                	<ul>
                                    	<li><a href="#">레시피등록</a></li>
                    					<li><a href="#">찜한레시피</a></li>
                                	</ul>
                          	</div>
                          		<div class="header__top__right__join">
                          			<c:choose>
                            		<c:when test="${empty sessionScope.loginMember}">
               							<a href="memberjoinform">Join</a>
            						</c:when>
            						<c:when test="${sessionScope.loginMember eq ('admin')}">
               							<a href="adminpage">관리자페이지</a>
               						</c:when>
               						<c:otherwise>
               							<a href="mypage">마이페이지</a>
               						</c:otherwise>
            						</c:choose>
            					</div>
                            	<div class="header__top__right__auth">
                         			<c:if test="${empty sessionScope.loginMember}">
               							<a href="memberloginform">Login</a>
            						</c:if>
            						<c:if test="${not empty sessionScope.loginMember}">
            						<a href="memberlogout">로그아웃</a>
                                	</c:if>
                            	</div>
                            </div>
                        </div> 
					</div> 
				</div>	 
           	</div>
       
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="./">Home</a></li>
                            <li><a href="recipelist">Recipe</a>
                            	<ul class="header__menu__dropdown">
                            		<li><a>레시피 등록</a></li>
									<li><a>랭킹</a></li>                            	
                            	</ul>
                            </li>
                           	<li><a href="shoppage">Shop</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                	<c:if test="${sessionScope.loginMember ne ('admin')}">				
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href=""><i class="fa fa-shopping-bag"></i> <span>장바구니</span></a></li>
                        </ul>
                    </div>
                    </c:if>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    <div style="width: 1400px; left: 50%; margin-left: 700px;">
	<h2 style="color: #7fad39"><b>회원가입</b></h2>
	
	<form action="memberjoin" method="post">
		아이디<br>
			<input type="text" name="mid" id="mid" onkeyup="idRegularCheck()">
				<span id="idcheckresult"></span><br>
		비밀번호<br>
			<input type="password" name="mpassword" id="mpassword" onkeyup="pwCheck()" placeholder="8~20자 영문 대 소문자,숫자">
			<span id="pwcheck"></span><br>
		비밀번호 확인<br>
			<input type="password" name="mpasscf" id="mpasscf" onkeyup="pwConfirm()"> 
			<span id="pwconfirmresult"></span><br>
		이름<br>
			<input type="text" name="mname" id="mname"><br>
		전화번호<br>
			<input type="text" name="mphone" id="mphone" maxlength="13" onkeyup="phoneCheck()"><br>
		주소<br>
			<input type="text" name="maddr1" id="maddr1" placeholder="우편번호" readonly>
			<input type="button" onclick="daumPostcode()" value="우편번호 찾기"><br>
			<input type="text" name="maddr2" id="maddr2" placeholder="주소" readonly><br>
			<input type="text" name="maddr3" id="maddr3" placeholder="상세주소"><br>
			<span id="addrcheck"></span>
			<!-- <input type="text" id="sample6_extraAddress" placeholder="참고항목"><br> -->
		이메일<br>
			<input type="text" name="memail" id="memail" placeholder="이메일을 입력해주세요">
			<input type="button" value="전송" onclick="sendEmail()">
			<br>
			<input type="hidden" id="mpoint">
		인증번호<br>
			<input type="text" name="memailnum" id="memailnum" onkeyup="emailCheck()">
			<span id="emailconfirmresult"></span><br>
			<input type="submit" value="가입">
	</form>
	</div>

    <!-- Js Plugins -->
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.nice-select.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
    <script src="resources/js/jquery.slicknav.js"></script>
    <script src="resources/js/mixitup.min.js"></script>
    <script src="resources/js/owl.carousel.min.js"></script>
    <script src="resources/js/main.js"></script>



</body>

</html>