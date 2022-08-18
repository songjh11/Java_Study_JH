<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<h1>Search Page</h1>
<form action = "search.do" method="post">
	<table border="1">
		<tr>
			<td>아이디 입력</td>
			<td><input type="text" name="search"></td>
		</tr>
	</table>
	<br>
	<button type="submit">검색하기</button>
</form>
</body>
</html>