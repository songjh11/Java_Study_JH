<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">Join Page</h1>
<br>
<div class="align-center">
	<img src="/resources/images/hh (1).png">
</div>
<br>

<section class="container-fluid col-lg-3">
	<div class="row">
<form action="join.do" method="post" enctype="multipart/form-data" id="joinFrm">

<div class="input-group mb-3">
  <input type="text" name="userName" id="userName" class="form-control" placeholder="ID" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div id="userNameHelp" class="form-text">아이디를 입력하세요</div>


<div class="input-group mb-3">
  <input type="password" name="password" id="joinPw" class="form-control" placeholder="Password" aria-label="Username">
</div>
<div id="passwordHelp" class="form-text">패스워드를 입력하세요</div>

<div class="input-group mb-3">
  <input type="password" class="form-control" id="passwordCheck" placeholder="Password" aria-label="Username">
</div>
<div id="passwordError" class="form-text"></div>


<div class="input-group mb-3">
  <input type="text" class="form-control" name="name" id="name" placeholder="Name" aria-label="Username">
</div>
<div class="form-text" id="nameCheck"></div>

<div class="input-group mb-3">
  <input type="text" class="form-control" name="email" id="email" placeholder="E-mail" aria-label="Username">
</div>
<div class="form-text" id="emailCheck"></div>

<div class="input-group mb-3">
  <input type="text" class="form-control" name="phone" id="phone" placeholder="Phone" aria-label="Username">
</div>
<div class="form-text" id="phoneCheck"></div>

<div class="input-group mb-3">
  <input type="file" class="form-control" id="files" name="photo" placeholder="photo" aria-label="files">
</div>

 <div class="col-12">
    <button type="button" id="joinBtn" class="btn btn-primary">Sign in</button>
  </div>

</form>
</div>

</section>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url= "../template/footer.jsp"></c:import>
<script src="/resources/JS/member.js"></script>
<script>
  joinCheck(); 

</script>

</body>
</html>