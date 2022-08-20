<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">Detail Page</h1>
<br>

<section class="container-fluid col-lg-5">
	<div class="row">
	<table class="table table-bordered border-primary">
	  <thead>
	    <tr>	
	      <th scope="col">상품번호</th>
	      <th scope="col">상품명</th>
	      <th scope="col">이자율</th>
	      <th scope="col">판매여부</th>
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
<br><br>
<div class="align-center">
<a href = "./list.do"><button class="btn btn-primary">상품 목록 보기</button></a>
<a href= "./update.do?bookNum=${one.bookNum}"><button class="btn btn-primary">상품 수정</button></a>
<a href="./delete.do?bookNum=${one.bookNum}"><button class="btn btn-primary">상품 삭제</button></a>
<c:if test="${not empty sessionScope.member}">
<a href="../bankAccount/add.do?bookNum=${one.bookNum}"><button class="btn btn-primary">상품 가입</button></a>
</c:if>
</div>

</div>
</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>