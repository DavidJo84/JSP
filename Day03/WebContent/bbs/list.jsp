<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.human.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
	<!-- 1. 컨트롤러에서 데이터 받았는지 확인
	2. 데이터를 화면에 맞는 문법으로 출력 
	jsp문법 - 지시자: '<'%'@ (다른 jsp파일 include, 자바 class import 등
	          코드: '<'% (request.getAttribute, if, for, out.print 등-->

	<!-- ${bList}
	${bList.get(0).getName()}
	${bList.get(1).getName()}
	${bList.get(2).getName()} -->
	
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list" style="text-align: center;">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="wrForm">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<%
				ArrayList<BoardVO> bList = (ArrayList) request.getAttribute("bList");
				if(bList.size()==0){
					out.print("<tr class= 'record'>");
					out.print("<td colspan = 5><p>등록된 글이 없습니다.<p></td>");
					out.print("</tr>");
				}else{
					for (int i = 0; i < bList.size(); i++) {
						out.print("<tr class= 'record'>");
						out.print("<td>"+bList.get(i).getNum()+"</td>");
						out.print("<td><a href='" +request.getContextPath()+ "/BoardView?num="+bList.get(i).getNum()+"'>"+bList.get(i).getTitle()+"</a></td>");
						out.print("<td>"+bList.get(i).getName()+"</td>");
						out.print("<td>"+bList.get(i).getIndate()+"</td>");
						out.print("<td>"+bList.get(i).getCnt()+"</td>");
						out.print("</tr>");
					}
				}
				
			%>
		</table>
	</div>
</body>
</html>