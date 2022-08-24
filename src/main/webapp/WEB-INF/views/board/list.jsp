<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">${board} Board</h1>
<br>
<section class="container-fluid col-lg-5">
	<div class="row">
	<table class="table table-bordered border-primary">
	  <thead>
	    <tr>
	      <th scope="col">#</th>	
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">DATE</th>
	      <th scope="col">HIT</th>
	    </tr>
	  </thead>
<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail.do?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hit}</td>
			</tr>
</c:forEach>
</table>
</div>
</section>
<br>
<div>
<c:choose>
	<c:when test="${board eq 'Notice'}">
		<c:if test="${sessionScope.member.userName eq 'Manager'}">
		<div class="align-center">
			<a href = "./add.do"><button class="btn btn-primary">공지 작성</button></a>
		</div>
		</c:if>
	</c:when>	
	<c:otherwise>
		<c:if test="${not empty sessionScope.member}">
		<div class="align-center">
			<a href = "./add.do"><button class="btn btn-primary">QnA 작성</button></a>
		</div>
		</c:if>
	</c:otherwise>
</c:choose>
</div>
<br><br>
<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>