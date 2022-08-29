<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">${board} Detail Page</h1>
<br>
<section class="container-fluid col-lg-5">
	<div class="row">
	
<div class="text-center">
	<table class="table table-bordered border-primary">
		<tr><td>
	<c:forEach items="${boardDTO.boardFileDTO}" var="file">
  		<a href="../resources/upload/${board}/${file.fileName}">
  		<img width=200 height=200 src="../resources/upload/${board}/${file.fileName}" class="rounded" alt="...">
  		</a>
	</c:forEach>
		</td></tr>
	</table>
</div>
	
	<table class="table table-bordered border-primary">
	    <tr>	
	      <td>#</td>
	      <td>TITLE</td>
	      <td>WRITER</td>
	      <td>DATE</td>
	      <td>HIT</td>
	    </tr>
	    	<tr>
				<td>${boardDTO.num}</td>
				<td>${boardDTO.title}</td>		
				<td>${boardDTO.writer}</td>
				<td>${boardDTO.regDate}</td>	
				<td>${boardDTO.hit}</td>		
			</tr>
		    <tr>	
		      <td colspan="5">CONTENTS</td>
		    </tr>
			<tr>
				<td colspan="5">${boardDTO.contents}</td>						
			</tr>
</table>
</div>
</section>
<br>
<div class="align-center">
<a href = "./list.do"><button class="btn btn-primary">목록 보기</button></a>
	<c:choose>
		<c:when test="${board eq 'Notice'}">
			<c:if test="${sessionScope.member.userName eq 'Manager'}">
			<a href= "./update.do?num=${boardDTO.num}"><button class="btn btn-primary">공지 수정</button></a>
			<a href="./delete.do?num=${boardDTO.num}"><button class="btn btn-primary">공지 삭제</button></a>
			</c:if>
		</c:when>
		<c:otherwise>
			<c:if test="${sessionScope.member.userName eq boardDTO.writer}">
			<a href= "./update.do?num=${boardDTO.num}"><button class="btn btn-primary">QnA 수정</button></a>
			<a href="./delete.do?num=${boardDTO.num}"><button class="btn btn-primary">QnA 삭제</button></a>
			</c:if>
			<c:if test="${not empty sessionScope.member}">
			<a href="./reply.do?num=${boardDTO.num}" class="btn btn-primary">reply</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>
<br><br>

<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>