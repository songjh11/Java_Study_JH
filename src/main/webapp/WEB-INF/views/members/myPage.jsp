<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">My Page</h1>
<br><br>

<section class="container-fluid col-lg-4">
	<div class="row">
	<table class="table table-bordered border-primary">
	  <thead>
	    <tr>	
	      <th scope="col">ID</th>
	      <th scope="col">이름</th>
	      <th scope="col">이메일</th>
	      <th scope="col">전화번호</th>
          <th scope="col">계좌번호</th>
	      <th scope="col">상품명</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${pageMember}" var="memberDTO">
	    	<tr>
				<td>${memberDTO.userName}</td>
				<td>${memberDTO.name}</td>	
				<td>${memberDTO.email}</td>	
				<td>${memberDTO.phone}</td>	
				<td>${memberDTO.accountNum}</td>	
				<td>${memberDTO.bookName}</td>			
			</tr>
	  </c:forEach>
	   </tbody>
</table>
</div>
</section>
<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>