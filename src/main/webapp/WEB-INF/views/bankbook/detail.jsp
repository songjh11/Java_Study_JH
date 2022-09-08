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

<!-- comment start-->
<div class="row">
	<div class="mb-3">
		<label for="writer" class="form-label">ID</label>
		<input type="text" class="form-control" id="writer" name="writer">
	</div>
	<div class="mb-3">
		<label for="contents" class="form-label">textarea</label>
		<textarea class="form-control" id="contents" rows="3"></textarea>
	</div>
	<div class="mb-3">
		<button type="button" id="comment" class="btn btn-primary" data-book-num="${one.bookNum}">댓글 작성</button>
	</div>

</div>
<!-- comment end-->

<!-- comment List -->
<div>
	<table class="table table-bordered border-primary">
		<thead>
			<tr>	
				<th scope="col">댓글 내용</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일자</th>
			</tr>
		</thead>
		<tbody id="commentList">
			
		</tbody>
	</table>
	<button type="button" id="more" class="btn btn-primary">더 보기</button>
</div>
<!-- comment List end -->
</div>

<div>

	<button type="button" id="up" class="btn btn-primary" style="display: none;" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@fat">댓글 수정</button>

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
			<div class="modal-header">
			  <h5 class="modal-title" id="exampleModalLabel">댓글 수정</h5>
			  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
			  <form>
				<input type="hidden" id="num">
				<div class="mb-3">
				  <label for="recipient-name" class="col-form-label">User Name: </label>
				  <input type="text" class="form-control" id="updateWriter">
				</div>
				<div class="mb-3">
				  <label for="message-text" class="col-form-label">Contents: </label>
				  <textarea class="form-control" id="updateContents"></textarea>
				</div>
			  </form>
			</div>
			<div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			  <button type="button" id="updateCommentButton" class="btn btn-primary" data-bs-dismiss="modal">댓글 수정</button>
			</div>
		  </div>
		</div>
	  </div>

</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/JS/bankbookcomment.js"></script>
</body>
</html>