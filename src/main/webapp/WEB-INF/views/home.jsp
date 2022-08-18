<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href="./members/login.do">로그인</a><br>
<a href="./members/join.do">회원가입</a><br>
<a href="./members/search.do">회원 검색</a><br>

<hr>

<a href="./bankbook/list.do">List</a><br>
<a href="./bankbook/add.do">Add</a><br>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
