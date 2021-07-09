<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// リクエストスコープに保存されたエラーメッセージを取得
String loginUser = (String) request.getAttribute("loginUser");  
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<title>登録画面</title>
</head>
<body>

<form action="login" method="post">
<h1>Login</h1>
<p>ユーザーID：<input type="text" name="id" ></p>
<p>パスワード：<input type="password" name="pass"></p>
<input type="submit" value="login" id="sub">
<a href="register">新規</a>

</form>
<p>
<%if (loginUser != null) {%>
    <%=loginUser %>
<%} %>
</p>
</body>
</html>