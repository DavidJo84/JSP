<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${id}</h1>
	<h1>${pass}</h1>
	<h1>${gender}</h1>
	<h1>${job}</h1>
	<% String[] coffe = request.getParameterValues("coffe"); %>
	<% 
	for(int i = 0; i < coffe.length; i++){
	%>
	<%=coffe[i] %>
	<% }; %>
	
	<% String[] hobby = request.getParameterValues("hobby"); %>
	<% 
	for(int i = 0; i < hobby.length; i++){
	%>
	<%=hobby[i] %>
	<% }; %>
</body>
</html>