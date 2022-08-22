
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Update</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">Notice Update Page</h1>
<br>
<form action="update.do" method = "POST">
<section class="container-fluid col-lg-4">
	<div class="row">
		<table class="table table-bordered border-primary">
	  <thead>
	  <tr>
	    <th colspan="2"><input type="hidden" name="num" value="${updateText.num}"></th>
	  </tr>
	    <tr>
	      <th scope="col">제목</th>
			<td><input type="text" name="title" value="${updateText.title}"></td>
	    </tr>
	    <tr>
	      <th scope="col">작성자</th>
			<td><input type="text" name="writer" readonly value="${sessionScope.member.userName}"></td>
	    </tr>
	  </thead>
	  <tbody>
			<tr>
				<th scope="col" colspan="2">내용</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="30" cols="70" name="contents" value="${updateText.contents}">${updateText.contents}</textarea></td>		
			</tr>
	   </tbody>
</table>
<button type="submit" class="btn btn-primary">공지 수정</button>
</div>
</section>
<br><br>
</form> 
<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>