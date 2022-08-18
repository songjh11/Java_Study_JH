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
        <a href= "../"><input type="button" value="메인 페이지로 돌아가기"></a>
        <br><br>
        <div>
            ID  <input type="text" name="userName" value="1234"><br><br>
            PW <input type="password" name="password" value="1234"><br><br>
            
            <input type="submit" value="로그인">
            <input type="reset" value="재입력"><br><br>
      </div>    
        <a href = "./join.do"><input type="button" value="회원가입 하기"></a>
        <br><br>
        </form>
</body>
</html>