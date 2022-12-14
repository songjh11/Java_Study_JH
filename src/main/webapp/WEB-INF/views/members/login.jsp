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
<h1 class="align-center">Login page</h1>
<br>
<div class="align-center">
	<img src="/resources/images/6f257201751a95c37eb3493912e25cdf2df16ed7012359e344d47930e49e9310.png">
</div>
<br>
<section class="container-fluid col-lg-3">
	<div class="row">
		<form action="login.do" method="post" id="loginForm">
		  <div class="mb-3">
		    <label for="id" class="form-label">ID</label>
		    <input type="text" class="form-control" name="userName" id="id" aria-describedby="emailHelp">
		    <div id="idHelp" class="form-text">아이디를 입력하세요</div>
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">Password</label>
		    <input type="password" class="form-control" name="password" id="password">
			<div id="pwHelp" class="form-text">패스워드를 입력하세요</div>
		  </div>
		  <div class="mb-3 form-check">
		    <input type="checkbox" class="form-check-input" id="exampleCheck1">
		    <label class="form-check-label" for="exampleCheck1">Check me out</label>
		  </div>
		  <div class="align-center">
		  <button type="button" class="btn btn-primary" id="btn">로그인</button>
		  </div>
		</form>
		<h1 id="fail"></h1>
	</div>
</section>

<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/JS/member.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script>
	loginCheck();
</script>
</body>
</html>