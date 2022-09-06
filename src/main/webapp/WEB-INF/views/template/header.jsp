<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <header>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"><img width=60 height=60 alt="토곰이" src="/resources/images/6f257201751a95c37eb3493912e25cdf8f324a0b9c48f77dbce3a43bd11ce785.png"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <div class="navbar-nav">
                        <a class="nav-link" href="../">Home</a>
                        <a class="nav-link" href="/notice/list.do">공지사항</a>
                        <a class="nav-link" href="/qna/list.do">QnA</a>
                        <a class="nav-link" href="/bankbook/list.do">상품리스트</a>
                        
                        <c:choose>
	                        	<c:when test="${not empty member}">                        
		                        <a class="nav-link" href="/members/logout.do">Logout</a>
		                        <a class="nav-link" href="/members/myPage.do?userName=${sessionScope.member.userName}">My Page</a>
	                        </c:when>
	                        <c:otherwise>
		                        <a class="nav-link" href="/members/login.do">로그인</a>
		                        <a class="nav-link" href="/members/ok.do">회원가입</a>
	                        </c:otherwise>	
                        </c:choose>
		                        <a class="nav-link" href="/members/search.do">회원검색</a>
                    </div>
           		 </div>
            </div>
        </nav>
 </header>
