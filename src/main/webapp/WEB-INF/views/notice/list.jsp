<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br>
<h1 class="align-center">List Page</h1>
<section class="container-fluid col-lg-8">
	<div class="row">
	<table class="table table-bordered border-primary">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>	
	      <th scope="col">제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">작성일자</th>
	      <th scope="col">조회수</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${noticeList}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail.do?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>	
				<td>${dto.regDate}</td>	
				<td>${dto.hit}</td>		
			</tr>
			</c:forEach>
	   </tbody>
</table>

<br><br>
<a href="./add.do"><button class="btn btn-primary">공지 작성</button></a>
<br><br>
</div>
</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>