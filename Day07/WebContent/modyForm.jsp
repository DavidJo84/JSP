<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ page import ="com.hm.VO.*" %>
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
	text-align: center;
}
</style>
</head>
<body>
	<%@ include file="header_nav.jsp"%>
	<section>
		<h1>학생 수정</h1>
		<form id="mody" action="ModyAction" method="get">
		<% StudVO svo = (StudVO)request.getAttribute("svo"); %>
			<table border=1>

				<tr>
					<th>번호</th>
					<td><input id="no" type="text" name="no" value = "${svo.no}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input id="name" type="text" name="name" value = "${svo.name}"></td>
				</tr>
				<tr>
					<th>전화</th>
					<td><input id="tel" type="text" name="tel" value = "${svo.tel}"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input id="address" type="text" name="address" value = "${svo.address}"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input id="joindate" type="text" name="joindate" value = "${svo.joinDate.substring(0,10)}"></td>
				</tr>
				<tr>
					<th>학년</th>
					<% if(svo.getGrade().equals("1")){
						out.print("<td><input class='grade' type='radio' name='grade' value='1' checked> 1학년");
						out.print("<input class='grade' type='radio' name='grade' value='2'> 2학년");
						out.print("<input class='grade' type='radio' name='grade' value='3'> 3학년");
						out.print("<input class='grade' type='radio' name='grade' value='4'> 4학년</td>");
					}else if(svo.getGrade().equals("2")){
						out.print("<td><input class='grade' type='radio' name='grade' value='1'> 1학년");
						out.print("<input class='grade' type='radio' name='grade' value='2' checked> 2학년");
						out.print("<input class='grade' type='radio' name='grade' value='3'> 3학년");
						out.print("<input class='grade' type='radio' name='grade' value='4'> 4학년</td>");
						
					}else if(svo.getGrade().equals("3")){
						out.print("<td><input class='grade' type='radio' name='grade' value='1'> 1학년");
						out.print("<input class='grade' type='radio' name='grade' value='2'> 2학년");
						out.print("<input class='grade' type='radio' name='grade' value='3' checked> 3학년");
						out.print("<input class='grade' type='radio' name='grade' value='4'> 4학년</td>");
						
					}else if(svo.getGrade().equals("4")){
						out.print("<td><input class='grade' type='radio' name='grade' value='1'> 1학년");
						out.print("<input class='grade' type='radio' name='grade' value='2'> 2학년");
						out.print("<input class='grade' type='radio' name='grade' value='3'> 3학년");
						out.print("<input class='grade' type='radio' name='grade' value='4' checked> 4학년</td>");
						
					}
					
					%>
					
				</tr>
				<tr>
					<td colspan="2"><input type="button" onclick="modySubmit()"
						value="수정"></td>
				</tr>

			</table>
		</form>
	</section>
	<%@ include file="footer.jsp"%>
</body>
<script type="text/javascript">
	function modySubmit() {
		let no = document.querySelector("#no").value;
		let name = document.querySelector("#name").value;
		let tel = document.querySelector("#tel").value;
		let address = document.querySelector("#address").value;
		let joindate = document.querySelector("#joindate").value;
		let mody = document.querySelector("#mody");

		
		if (no != "" && name != "" && tel != "" && address != ""
				&& joindate != "") {
			mody.submit();
		} else {
			alert("모든 정보를 입력하세요.");
		}
	};
</script>
</html>