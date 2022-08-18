<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<h1>List Page</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.userName}</td>
			<td>${dto.password}</td>	
			<td>${dto.name}</td>	
			<td>${dto.email}</td>	
			<td>${dto.phone}</td>		
		</tr>
		</c:forEach>
	</table>

</body>
</html>