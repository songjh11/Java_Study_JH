<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OK</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
    #checkbox{
      display : flex ;
      flex-direction: column;
      justify-content: center;
      width : 100%;
          }
    input{
          margin-left : 10px;
          }        

</style>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">약관 동의 페이지</h1>
<br>
<div class="align-center">
	<img src="/resources/images/hh (2).png">
</div>
<br>

<section class="container-fluid col-lg-3">
	<div class="row">
    <div id="checkbox">
      <p>모두 선택<input type="checkbox" name="box" id="all"></p>
      <p>동의1(필수)<input type="checkbox" name="box" class="cb req"></p>
      <p>동의2(필수)<input type="checkbox" name="box" class="cb req"></p>
      <p>동의3(선택)<input type="checkbox" name="box" class="cb"></p>
      <p>동의4(선택)<input type="checkbox" name="box" class="cb"></p>
    </div>
    
<form action="ok.do" method="post" id="frm">
    <div class="col-12">
  <button type="button" class="btn btn-primary" id="joinBtn">약관 동의</button>
</div>
</form>
</div>

</section>
<script src="/resources/JS/member.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url= "../template/footer.jsp"></c:import>
</body>
</html>