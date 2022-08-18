<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
</head>
<body>
<h1>List Page</h1>
	<table border="1">
		<tr>
			<td>계좌 이름</td>
			<td>이자율</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="./detail.do?bookNum=${dto.bookNum}">${dto.bookName}</a> </td>
			<td>${dto.bookRate}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	
	<a href="add.do">상품 등록</a> 
</body>
</html>