<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">QnA Detail Page</h1>
<br><br>
<section class="container-fluid col-lg-5">
	<div class="row">
	<table class="table table-bordered border-primary">
	    <tr>	
	      <td>#</td>
	      <td>TITLE</td>
	      <td>WRITER</td>
	      <td>DATE</td>
	      <td>HIT</td>
	    </tr>
	    	<tr>
				<td>${qnaDTO.num}</td>
				<td>${qnaDTO.title}</td>		
				<td>${qnaDTO.writer}</td>
				<td>${qnaDTO.regDate}</td>	
				<td>${qnaDTO.hit}</td>		
			</tr>
		    <tr>	
		      <td colspan="5">CONTENTS</td>
		    </tr>
			<tr>
				<td colspan="5">${qnaDTO.contents}</td>						
			</tr>
</table>
<br><br>
</div>
</section>

<div class="align-center">
<a href = "./list.do"><button class="btn btn-primary">QnA 목록 보기</button></a>
	<c:if test="${sessionScope.member.userName eq qnaDTO.writer}">
	<a href= "./update.do?num=${qnaDTO.num}"><button class="btn btn-primary">QnA 수정</button></a>
	<a href="./delete.do?num=${qnaDTO.num}"><button class="btn btn-primary">QnA 삭제</button></a>
	</c:if>
</div>
<br><br>

<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>