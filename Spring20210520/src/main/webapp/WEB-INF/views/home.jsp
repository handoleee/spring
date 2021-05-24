<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<a href="insertpage">insert.jsp로 이동</a>
	<!-- STUDYTABLE에 저장된 모든 데이터를 select.jsp에 출력 -->
	<!-- 아래 링크클릭 StudyController 요청 => StudyService => StudyDAO => mapper에서 끝이 아니라
	mapper => StudyDAO =>StudyService => StudyController => select.jsp--> 
	
	<!-- 주소를 요청하면 Controller가 요청에 대한 반응을 한다. -->
	<a href="select">DB 조회</a>
</body>
</html>
