<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Update</title>
<!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">${board} Update Page</h1>
<br>
<section class="container-fluid col-lg-4">
	<div class="row">
<form action="update.do" method = "POST" enctype="multipart/form-data">
		<table class="table table-bordered border-primary" id="tableAdd">
	  <thead>
	  <tr>
	    <th colspan="2"><input type="hidden" name="num" value="${boardDTO.num}"></th>
	  </tr>
	    <tr>
	      <th scope="col">TITLE</th>
			<td><input type="text" name="title" value="${boardDTO.title}"></td>
	    </tr>
	    <tr>
	      <th scope="col">WRITER</th>
			<td><input type="text" name="writer" readonly value="${sessionScope.member.userName}"></td>
	    </tr>
	  </thead>
	  <tbody id="tbody">
			<tr>
				<th scope="col" colspan="2">CONTENTS</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="15" cols="70" id="contents" name="contents" value="${boardDTO.contents}">${boardDTO.contents}</textarea></td>		
			</tr>
		</tbody>
	</table>
	<c:forEach items="${boardDTO.boardFileDTO}" var="fileDTO">
	<div class="mb-3">
		<span class="form-control">${fileDTO.oriName}</span>
		<button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
	</div>	
	</c:forEach>
	<div id="addFiles">
		<button type="button" class="btn btn-danger" id="fileAdd">파일 추가</button>
	</div>
<br>
		<div class="align-center">
			<a href = "./add.do"><button class="btn btn-primary">QnA 수정</button></a>
		</div>
</form> 
</div>
</section>
<br><br>
<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/JS/board_fileAdd.js"></script>
<script>
	setCount(${boardDTO.boardFileDTO.size()});
</script>
<script type="text/javascript">
	$("#contents").summernote({
		height: 300
	}); 
</script>
</body>
</html>