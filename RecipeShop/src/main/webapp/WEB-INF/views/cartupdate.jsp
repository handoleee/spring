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
	function shopUpdate(snumber) {
		location.href="shopupdate?snumber="+snumber;
	}
</script>
<script src="https://kit.fontawesome.com/fb3cf1687b.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>

<body onload="init();">
	<script language="JavaScript">
	var sbprice;
	var sbquantity;

	function init () {
		sbprice = document.form.sbprice.value;
		sbquantity = document.form.sbquantity.value;
		document.form.sum.value = sbprice;
		change();
	}

	function add () {
		hm = document.form.sbquantity;
		sum = document.form.sum;
		hm.value ++ ;

		sum.value = parseInt(hm.value) * sbprice;
	}

	function del () {
		hm = document.form.sbquantity;
		sum = document.form.sum;
			if (hm.value > 1) {
				hm.value -- ;
				sum.value = parseInt(hm.value) * sbprice;
			}
	}

	function change () {
		hm = document.form.sbquantity;
		sum = document.form.sum;

			if (hm.value < 0) {
				hm.value = 0;
			}
		sum.value = parseInt(hm.value) * sbprice;
	}  
	</script>
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
                            <li><a href="basklist?loginMember=${sessionScope.loginMember}"><i class="fa fa-shopping-bag"></i> <span>장바구니</span></a></li>
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
		<h2 style="color: #7fad39"><b>장바구니 수정</b></h2><br>
     	<form action="cartupdateprocess"  name="form" method="post" >
		<img src="resources/upload/shop/${shopview.sfilename}" height="200" width="200"><br>
		<input type="hidden" name="sbmid" value="${sessionScope.loginMember}">
		<input type="hidden" name="sbnumber" value="${cartUpdate.sbnumber}">
		상품이름:<br>
		<input type="text" name="sbname" value="${cartUpdate.sbname}" readonly><br>
		수량 : <input type=hidden name="sbprice" value="${cartUpdate.sbprice}">
		<input type="text" name="sbquantity" value="${cartUpdate.sbquantity}" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
		
		금액 : <input type="text" name="sum"  value="${shopUpdate.sum}" size="11" readonly>원

		<input type="submit" value="수정">
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