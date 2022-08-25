<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
	table{
		margin-top: 20px;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>

<section class="container-fluid col-lg-7">
	<div class="row">
<h1 class="align-center">${board} Board</h1>
	<form action="./list.do" class="row row-cols-lg-auto g-3 align-items-center">
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name= "kind" class="form-select" id="kind">
      <option value="contents">Contents</option>
      <option value="title">Title</option>
      <option value="writer">Writer</option>
    </select>
  </div>
  
  <div class="col-12">
    <label class="visually-hidden" for="search">검색어</label>
    <div class="input-group">
      <input type="text" class="form-control" id="search" name="search">
    </div>
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>	


<div class="mb-16">
	<table class="table table-bordered border-primary">
	  <thead>
	    <tr>
	      <th scope="col">#</th>	
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">DATE</th>
	      <th scope="col">HIT</th>
	    </tr>
	  </thead>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>
						<c:catch>
						<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
						</c:catch>
							<a href="./detail.do?num=${dto.num}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
		</table>
</div>
	</div>
</section>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item ${pager.pre?'':'disabled'}">
      <a class="page-link" href="./list.do?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
    </li>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link" href="./list.do?page=${i}&kind=${pager.kind}&search=${pager.search}"> ${i}</a> </li>
		</c:forEach>
	
<%-- 	<c:choose>
		<c:when test="${pager.next}">	
	    	<li class="page-item">
	    </c:when>
	    <c:otherwise>
	    	<li class="page-item disabled">
	    </c:otherwise>
	</c:choose> --%>
	<li class="page-item ${pager.next?'':'disabled'}">
      <a class="page-link" href="./list.do?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
    </li>
  </ul>
</nav>

<br>
<div >
<c:choose>
	<c:when test="${board eq 'Notice'}">
		<c:if test="${sessionScope.member.userName eq 'Manager'}">
		<div class="align-center">
			<a href = "./add.do"><button class="btn btn-primary">공지 작성</button></a>
		</div>
		</c:if>
	</c:when>	
	<c:otherwise>
		<c:if test="${not empty sessionScope.member}">
		<div class="align-center">
			<a href = "./add.do"><button class="btn btn-primary">QnA 작성</button></a>
		</div>
		</c:if>
	</c:otherwise>
</c:choose>
</div>
<br><br>
<c:import url="../template/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>