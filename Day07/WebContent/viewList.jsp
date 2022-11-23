<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.*" %>
     <%@ page import ="com.hm.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
section h1{
text-align: center;
}
table{
margin: 0 auto;
}
</style>
</head>
<body>
<%@ include file="header_nav.jsp" %>
<section>
<h1>학생 리스트</h1>
	<table border=1>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>학년</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<% ArrayList<StudVO> sList = (ArrayList)request.getAttribute("sList"); %>
		<%
			for(int i = 0;  i< sList.size(); i++){
			StudVO svo = sList.get(i);
			out.print("<tr>");
			out.print("<td>"+svo.getNo()+"</td>");
			out.print("<td>"+svo.getName()+"</td>");
			out.print("<td>"+svo.getTel()+"</td>");
			out.print("<td>"+svo.getAddress()+"</td>");
			out.print("<td>"+svo.getJoinDate().substring(0, 10)+"</td>");
			out.print("<td>");
			if(svo.getGrade().equals("1")){
					out.print("A");
				}else if(svo.getGrade().equals("2")){
					out.print("B");
				}else if(svo.getGrade().equals("3")){
					out.print("C");
				}else if(svo.getGrade().equals("4")){
					out.print("D");
				}
			out.print("</td>");
			out.print("<td><input type = 'button' onclick=");
				
			out.print("\""+"location.href =");
			out.print("'"+"DelStud?no=");
			out.print(svo.getNo()+"'");
			out.print("\""+ "value='삭제'></td>");
			out.print("</tr>");
			}
		%>
		<tr style = "text-align: center;">
		<td colspan = "7"><input type = 'button' onclick="mody()" value='수정'></td>
		</tr>
		
		</tbody>
	</table>
</section>
<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
function mody(){
	let modyNo = prompt("수정할 번호를 입력하세요.");
	window.location.href = "ModyStud?no="+modyNo;
}
</script>
</html>