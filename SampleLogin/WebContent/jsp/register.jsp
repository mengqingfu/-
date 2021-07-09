<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// リクエストスコープに保存されたエラーメッセージを取得
String register = (String) request.getAttribute("register");  
String a="Register成功しました";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<form action="register" method="post">
<h1>register</h1>
<p>ユーザーID：<input type="text" name="id" ></p>
<p>パスワード：<input type="password" name="pass"></p>
<input type="submit" value="確定" id="sub">
<a href="login">戻る</a>
</form>

<p>
<%if (register != null) {%>
<%if (register.equals(a)) {%>
   <a href="login">Register成功しました、Login画面へ</a>
<%}else{ %>
    <%=register %>
    <%} %>
<%} %>
</p>
</body>
</html>