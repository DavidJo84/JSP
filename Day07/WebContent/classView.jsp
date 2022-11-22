<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hm.VO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
section h1 {
	text-align: center;
}

table {
	margin: 0 auto;
}
</style>
</head>
<body>
	<%@ include file="header_nav.jsp"%>
	<section>
		<h1>학생별 신청내역</h1>
		<table border=1>
			<thead>
				<tr>
					<th>학생이름</th>
					<th>클래스이름</th>
					<th>교수명</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<% ArrayList<ClassVO> cList = (ArrayList)request.getAttribute("cList"); %>
				<%
			for(int i = 0;  i< cList.size(); i++){
				ClassVO cvo = cList.get(i);
			out.print("<tr>");
			out.print("<td>"+cvo.getName()+"</td>");
			out.print("<td>"+cvo.getClass_name()+"</td>");
			out.print("<td>"+cvo.getClass_pro()+"</td>");
			out.print("<td>"+cvo.getIndate().substring(0,10)+"</td>");
				out.print("</tr>");
			}
		%>

			</tbody>
		</table>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>