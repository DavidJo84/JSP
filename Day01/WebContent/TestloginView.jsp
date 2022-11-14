<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>아이디: ${id}</b><br>
	<b>비밀번호: ${pass}</b><br>
	<b>성별: ${gender}</b><br>
	<b>직업: ${job}</b><br>
	<b>커피: </b>
	
	<% String[] coffe = request.getParameterValues("coffe"); %>
	<% 
	for(int i = 0; i < coffe.length; i++){
	%>
	<b><%=coffe[i] %></b>
	<% }; %><br>
	
	<b>취미: </b>
	<% String[] hobby = request.getParameterValues("hobby"); %>
	<% 
	for(int i = 0; i < hobby.length; i++){
	%>
	<b><%=hobby[i] %></b>
	<% }; %><br>
</body>
</html>