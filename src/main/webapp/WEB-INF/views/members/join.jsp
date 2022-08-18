<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
<h1>Join Page</h1>
<form action="join.do" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="password"></td>
	</tr>	
<tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
</tr>
<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
</tr>
<tr>
		<td>전화번호</td>
		<td><input type="text" name="phone"></td>
</tr>
</table><br>
<button type="submit">회원가입</button>
</form>
</body>
</html>