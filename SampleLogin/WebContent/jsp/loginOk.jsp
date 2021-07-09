<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.User,tool.Mutter,java.util.List" %>    
<%    // セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
//リクエストスコープに保存されたエラーメッセージを取得
String register = (String) request.getAttribute("register"); 
String errorMsg = (String) request.getAttribute("errorMsg"); 
List<Mutter> mutterList =
(List<Mutter>) request.getAttribute("mutterList");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/loginOk.css">
<script >
function addAction(){
	
	document.name.action="mutterRegister";
	document.name.submit();
}
function searchAction(){

	document.name.action="mutterSearch";
	document.name.submit();

}
</script>
<meta charset="UTF-8">
<title>メインメニュー</title>
</head>
<body>
<div id="rig">
<%=loginUser.getId() %>さん,ログイン中
<a href="Logout">ログアウト</a>
</div>
<h1>予約画面</h1>
<div id="form">
<form name="name" method="post">
<input type="date" name="data">
<input type="time" name="hour">
<input type="button" value="予約" onclick="addAction()">
<input type="button" value="一覧" onclick="searchAction()">
</form>

<%if (register != null) {%>
    <%=register %>
<%} %>
<%if (errorMsg != null) {%>
    <%=errorMsg %>
<%} %>
</div>
<%if(mutterList != null) {%>
<table>
<tr><th>ユーザーID</th><th>予約日</th><th>予約時間</th><th>削除</th></tr>

<% for(Mutter mutter:mutterList){ %>
<tr>
<td><%= mutter.getId()%></td><td><%=mutter.getData() %></td><td><%=mutter.getHour()%></td>

<td>
<% if(loginUser.getId().equals(mutter.getId())) {%>
<form action="mutterDelete" method="post">
<input type="hidden" name="id" value="<%= mutter.getId() %>">
<input type="submit" value="削除">
</form>
<%} %>
</td></tr>
<%} %>
<%}%>

</table>
</body>
</html>