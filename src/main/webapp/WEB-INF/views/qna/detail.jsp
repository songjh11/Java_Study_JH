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
<br>

<section class="container-fluid col-lg-5">
	<div class="row">
	<table class="table table-bordered border-primary">
	    <tr>	
	      <td>글 번호</td>
	      <td>글 제목</td>
	      <td>작성자</td>
	      <td>작성일자</td>
	      <td>조회수</td>
	    </tr>
	    	<tr>
				<td>${qText.num}</td>
				<td>${qText.title}</td>		
				<td>${qText.writer}</td>	
				<td>${qText.regDate}</td>
				<td>${qText.hit}</td>		
			</tr>
	    <tr>	
	      <td colspan="5">내용</td>
	    </tr>
			<tr>
				<td colspan="5">${qText.contents}</td>						
			</tr>
	   </tbody>
</table>
<br><br>
<div class="align-center">
<a href = "./list.do"><button class="btn btn-primary">QnA 목록 보기</button></a>

<c:if test="${sessionScope.member.userName eq qText.writer}">
<a href= "./update.do?num=${qText.num}"><button class="btn btn-primary">QnA 수정</button></a>
<a href="./delete.do?num=${qText.num}"><button class="btn btn-primary">QnA 삭제</button></a>
</c:if>
</div>

</div>
</section>
<br><br>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>