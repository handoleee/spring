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
    
    <style>
    	table, tr, td, th {
    		border : 1px black solid;
    		border-collapse : collapse;
    	}
    	
    	th {
    		text-align : center;
    	}
    	
    	.left {
    		float: left;
    		width: 263px;
    		margin-left: 20%;
    	}
    	
    </style>
    <script>
		function shopupdate(snumber) {
			location.href="shopupdate?snumber="+${shopview.snumber};
		}
		
		function shopdelete() {
			location.href='shopdelete?snumber='+${shopview.snumber};
		}	
</script>
<script src="https://kit.fontawesome.com/fb3cf1687b.js" crossorigin="anonymous"></script>
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
                                    	<li><a href="recipewritepage">레시피등록</a></li>
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
                        <a href="./"><img src="resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="./">Home</a></li>
                            <li><a href="recipelist">Recipe</a>
                            	<ul class="header__menu__dropdown">
                            		<li><a href="recipewritepage">레시피 등록</a></li>
									<li><a>랭킹</a></li>                            	
                            	</ul>
                            </li>
                           	<li class="active"><a href="shoplist">Shop</a></li>
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
    
	<!-- <div class="left">
		<div class="hero__categories">
			<div class="hero__categories__all">
				<i class="fa fa-bars"></i>
				<span>종류</span>
			</div>
			<ul>
				<li><a href="categorysearch?keyword=한식">한식</a></li>
				<li><a href="categorysearch?keyword=중식">중식</a></li>
				<li><a href="categorysearch?keyword=디저트">디저트</a></li>
				<li><a href="#">Fresh Berries</a></li>
				<li><a href="#">Ocean Foods</a></li>
				<li><a href="#">Butter & Eggs</a></li>
				<li><a href="#">Fastfood</a></li>
				<li><a href="#">Fresh Onion</a></li>
				<li><a href="#">Papayaya & Crisps</a></li>
				<li><a href="#">Oatmeal</a></li>
				<li><a href="#">Fresh Bananas</a></li>
			</ul>
		</div>
	</div> 
    
    <div class="hero__search__form" style="margin-left: 1000px;">
    	<form action="recipesearch" method="get">
			<input type="text" name="keyword" placeholder="검색하세요">
            <button type="submit" class="site-btn">SEARCH</button>
		</form>
	</div>
    <br><br>
    <!-- 상품목록 -->
<div style="width: 1400px; left: 50%; margin-left: 700px;">
${shopview.snumber}<br>
	<img src="resources/upload/shop_b/${shopview.sfilename}" height="200" width="200"><br>
	상품이름<br>
	${shopview.sname}<br>
	가격<br>
	${shopview.sprice}<br>
	재고<br>
	${shopview.sstock}<br>
	원산지<br>
	${shopview.sorigin}<br>
	구성<br>
	${shopview.sbox}<br>
	제조사<br>
	${shopview.smake}<br>
	유통기한<br>
	${shopview.stime}<br>
	상세정보<br>
	${shopview.scontents}<br>
	<%-- <form method="post" action="cart">
		<input type="hidden" name="sbmid" value="${sessionScope.loginMember}">
		<input type="hidden" name="sbname" value="${shopview.sname}">
		<input type="hidden" name="sbprice" value="${shopview.spprice}">
		<select name="sbquantity">
			<c:forEach begin="1" end="${shopview.sstock}" var="i">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>&nbsp;개
		<input type="submit" value="장바구니에 담기">
	</form> --%>
	<c:if test="${sessionScope.loginMember ne ('admin')}">
	<form  action="cart" name="form" method="get">
		<input type="hidden" name="sbmid" value="${sessionScope.loginMember}">
		<input type="hidden" name="sbname" value="${shopview.sname}">
		<input type="hidden" name="sbsnumber" value="${shopview.snumber}">
		수량 : <input type=hidden name="sbprice" value="${shopview.sprice}">
		<input type="text" name="sbquantity" value="1" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
		
		금액 : <input type="text" name="sum" size="11" readonly>원
		<input type="submit" value="장바구니에 담기">
	</form>
	</c:if>
	
	
	<c:if test="${sessionScope.loginMember eq ('admin')}">
		<button onclick="shopupdate()">수정버튼</button>
		<button onclick="shopdelete()">삭제</button>
	</c:if>
	
	<!-- 댓글 목록출력 부분 -->
	<div id="srcomment-list">
		<table border="1">
			<c:forEach var="srcomment" items="${srcommentList}">
				<tr>
					<td>${srcomment.srname}</td>
					<td>${srcomment.srgrade}</td>
				</tr>
				<tr>
					<td colspan="2">${srcomment.srcontents}</td>
				</tr>
			</c:forEach>
		</table>	
	</div>
	
	<!-- 댓글 등록 부분 -->
		<div id="srcomment-write">
		<input type="text" id="srcontents" placeholder="댓글을 입력하세요" style="width: 500px; height:48px;">
		<select id="srgrade" style="width: 70px; height:50px;">
			<option value="" selected>평점</option>
			<option value="★">★</option>
			<option value="★★">★★</option>
			<option value="★★★">★★★</option>
			<option value="★★★★">★★★★</option>
			<option value="★★★★★">★★★★★</option>
		</select>
		<button id="srcwrite-btn" style="width: 70px; height:50px;">댓글등록</button>
		</div>
</div>
	
<script>
		$(document).ready(function(){
			$("#srcwrite-btn").click(function(){
				var srname = '${sessionScope.loginMember}';
				var srgrade = document.getElementById('srgrade').value;
				var srcontents = document.getElementById('srcontents').value;
				var srsnumber = '${shopview.snumber}';
				console.log(srname);
				console.log(srcontents);
				console.log(srsnumber);
				$.ajax({
					type: 'post',
					url: 'srcommentwrite',
					data: {
						'srname': srname,
						'srgrade': srgrade,
						'srcontents': srcontents,
						'srsnumber': srsnumber},
					dataType: 'json',
					success: function(list){
						console.log(list);
						var output = "<table border='1'>";
						for(var i in list){
							output += "<tr>";
							output += "<td>"+list[i].srname+"</td>";
							output += "<td>"+list[i].srgrade+"</td>";
							output += "</tr>";
							output += "<tr colspan='2'>";
							output += "<td>"+list[i].srcontents+"</td>";
							output += "</tr>";
						}
						output += "</table>";
						document.getElementById('srcomment-list').innerHTML = output;
						document.getElementById('srgrade').value='';
						document.getElementById('srcontents').value='';
					},
					error: function(){
						console.log('문제있음.')
					}
				});
			});
		});
	</script>	
	

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