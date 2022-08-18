<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
</head>
<body>
<h1>Detail Page</h1>
<table border = "1">
	<thead>
		<tr>
			<td>BOOKNUM</td>
			<td>BOOKNAME</td>
			<td>BOOKRATE</td>
			<td>BOOKSALE</td>
		</tr>
	</thead>
	<tbody>
		<tr>
 			<td>${one.bookNum}</td>
			<td>${one.bookName}</td>
			<td>${one.bookRate}</td>
			<td>${one.bookSale}</td>
		</tr> 
		
	</tbody>
</table>
<br>
<a href = "./list.do">리스트 보기</a>
<br><br>
<a href= "./update.do?bookNum=${one.bookNum}">수정하기</a>
<a href="./delete.do?bookNum=${one.bookNum}">삭제하기</a>
<c:if test="${not empty sessionScope.member}">
<a href="../bankAccount/add.do?bookNum=${one.bookNum}">가입하기</a>
</c:if>

</body>
</html>