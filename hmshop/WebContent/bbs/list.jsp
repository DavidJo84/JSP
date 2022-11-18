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
	<div id="wrap" align="center">
		<h1>QnA 게시판</h1>
		<form action="QnaDel" method="get">
			<table id="list" style="text-align: center;">
				<tr>
					<td colspan="6" style="border: white; text-align: right"><a
						href="QnaForm">질의응답 등록</a></td>
				</tr>
				<tr>
					<th class="chkB"><input type="checkbox" id="allChk"
						onchange="allChk1()"></th>
					<th>번호</th>
					<th>제목</th>
					<th>아이디</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>

				<%
					ArrayList<BoardVO> bList = (ArrayList) request.getAttribute("bList");
					if (bList.size() == 0) {
						out.print("<tr class= 'record'>");
						out.print("<td colspan = 6><p>등록된 글이 없습니다.<p></td>");
						out.print("</tr>");
					} else {
						for (int i = 0; i < bList.size(); i++) {
							out.print("<tr class= 'record'>");
							out.print("<td class='chkB'><input type='checkbox' name = 'num' value = '" + bList.get(i).getNum()
									+ "'></td>");
							out.print("<td>" + bList.get(i).getNum() + "</td>");
							if (bList.get(i).getChk() != null) {
								out.print("<td><a href='" + request.getContextPath() + "/QnaBoardView?num="
										+ bList.get(i).getNum() + "&cnt=" + bList.get(i).getCnt() + "'>"
										+ bList.get(i).getTitle() + "*</a>");
							} else {
								out.print("<td><a href='" + request.getContextPath() + "/QnaBoardView?num="
										+ bList.get(i).getNum() + "&cnt=" + bList.get(i).getCnt() + "'>"
										+ bList.get(i).getTitle() + "</a>");
							}
							if (bList.get(i).getRevCnt() != 0) {
								out.print("<b style='color:red;'> [" + bList.get(i).getRevCnt() + "]</b>" + "</td>");
							} else {
								out.print("</td>");
							}
							out.print("<td>" + bList.get(i).getId() + "</td>");
							out.print("<td>" + bList.get(i).getIndate() + "</td>");
							out.print("<td>" + bList.get(i).getCnt() + "</td>");
							out.print("</tr>");
						}
					}
				%>

			</table>
			<input type="submit" value="선택삭제"
				style="margin-top: 10px; float: left;">
		</form>
	</div>
</body>
<script type="text/javascript">
	function allChk1() {
		const table = document.getElementById('list');
		for (let i = 0; i < table.rows.length; i++) {
			if (document.getElementById('allChk').checked) {
				table.rows[i].cells[0].childNodes[0].checked = true;
			} else {
				table.rows[i].cells[0].childNodes[0].checked = false;
			}
		}
	}
</script>
</html>