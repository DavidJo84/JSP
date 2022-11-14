<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/main.css" rel="stylesheet">
</head>
<body>
	<h1>오늘의 로또번호는!
	<% ArrayList<Integer> lottoAll = (ArrayList<Integer>)request.getAttribute("lottoAll"); %>
	<% 
	for(int i = 0; i < lottoAll.size(); i++){
	%>
	<b><%=lottoAll.get(i) %></b>
	<% }; %></h1>
	<hr>
	<form action = "LottoView" method = "get">
	<input type="submit" value = "모두자동추첨">
	<br>
	
	<hr>
	<p>1~45 사이의 번호 두개 선택</p>
	<input type = "text" name = "num1" size = "1px">
	<input type = "text" name = "num2" size = "1px">
	<input type="submit" value = "자동추첨">
	</form>
	
</body>
</html>