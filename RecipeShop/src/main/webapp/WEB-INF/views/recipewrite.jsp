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
<script>
	function writefn() {
		recipe.submit();
	}
	function canclefn() {
		location.href="recipelist";
	}
</script>
<script src="https://kit.fontawesome.com/fb3cf1687b.js" crossorigin="anonymous"></script>
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
                           	<li><a href="shoplist">Shop</a></li>
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
		<h2 style="color: #7fad39"><b>레시피등록</b></h2><br>
	<form action="recipewrite" method="post" name="recipe" enctype="multipart/form-data">
		작성자:<br>
		<input type="text" name="rname" value="${sessionScope.loginMember}" readonly><br>
		제목:<br>
		<input type="text" name="rtitle"><br>
		내용:<br>
		<textarea cols="50" rows="3" name="rcontents"></textarea><br>
		카테고리:<br>
		<select name="rcategory">
			<option value="" selected>카테고리</option>
			<option value="한식">한식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>
			<option value="중식">중식</option>
			<option value="분식">분식</option>
		</select><br><br>
		인원수:<br>
		<select name="rperson">
			<option value="" selected>인원수</option>
			<option value="1인분">1인분</option>
			<option value="2인분">2인분</option>
			<option value="3인분">3인분</option>
			<option value="4인분">4인분</option>
			<option value="5인분">5인분</option>
			<option value="6인분이상">6인분이상</option>
		</select><br><br>
		난이도:<br>
		<select name="rlevel">
			<option value="" selected>난이도</option>
			<option value="아무나">아무나</option>
			<option value="초급">초급</option>
			<option value="중급">중급</option>
			<option value="고급">고급</option>
			<option value="신의경지">신의경지</option>
		</select><br><br>
		태그:<br>
		<input type="text" name="rtag"><br>
		가격:<br>
		<input type="text" name="rprice"><br>
		대표사진:<br>
		<input type="file" name="rfile"><br>
		<br>
		재료목록<br><br>
		<input type="text" name="mtname1" placeholder="재료이름">
		<input type="text" name="mtvolume1" placeholder="재료용량"><br><br>
		<input type="text" name="mtname2" placeholder="재료이름">
		<input type="text" name="mtvolume2" placeholder="재료용량"><br><br>
		<input type="text" name="mtname3" placeholder="재료이름">
		<input type="text" name="mtvolume3" placeholder="재료용량"><br><br>
		<input type="text" name="mtname4" placeholder="재료이름">
		<input type="text" name="mtvolume4" placeholder="재료용량"><br><br>
		<input type="text" name="mtname5" placeholder="재료이름">
		<input type="text" name="mtvolume5" placeholder="재료용량"><br><br>
		<br>
		<i class="fas fa-plus-square" style="font-size: 30px; margin-left: 70px;"></i>
		<br><br>
		1. 요리순서파일:<br>
		<input type="file" name="ofile1"><br><br>
		<textarea cols="50" rows="3" name="ocontents1" placeholder="내용을 입력하세요"></textarea>
		<br><br>
		2. 요리순서파일:<br>
		<input type="file" name="ofile2"><br><br>
		<textarea cols="50" rows="3" name="ocontents2" placeholder="내용을 입력하세요"></textarea>
		<br><br>
		3. 요리순서파일:<br>
		<input type="file" name="ofile3"><br><br>
		<textarea cols="50" rows="3" name="ocontents3" placeholder="내용을 입력하세요"></textarea>
		<br><br>
		4. 요리순서파일:<br>
		<input type="file" name="ofile4"><br>
		<textarea cols="50" rows="3" name="ocontents4" placeholder="내용을 입력하세요"></textarea>
		<br><br>
		5. 요리순서파일:<br>
		<input type="file" name="ofile5"><br>
		<textarea cols="50" rows="3" name="ocontents5" placeholder="내용을 입력하세요"></textarea>
		<br><br>
		<br>
		<i class="fas fa-plus-square" style="font-size: 30px; margin-left: 70px;"></i>
		<br>	
	</form>
	
	<br>
	<input type="button" value="등록" onclick="writefn()">
	<input type="button" value="돌아가기" onclick="canclefn()">
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