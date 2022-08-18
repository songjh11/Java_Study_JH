<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<form action="./login.do" method="POST">
        <a href= "/"><input type="button" value="메인 페이지로 돌아가기"></a>
        <br><br>
        <div>
            ID  <input type="text" name="userName" value="1234"><br><br>
            PW <input type="password" name="password" value="1234"><br><br>
            
            <input type="submit" value="로그인">
            <input type="reset" value="재입력"><br><br>
            <input type="checkbox">로그인 상태 유지<br><br>
    </div>    
        <input type="button" value="비밀번호 찾기">
        <input type="button" value="아이디 찾기">
        <a href = /study_form_join.html><input type="button" value="회원가입 하기"></a>
        <br><br>
        <img src="../resources/img/sudal.jpg" style="width:600px; height:500px;">
        <img src="../resources/img/headal.jpg" style="width:600px; height:500px;">
    </form>
</body>
</html>