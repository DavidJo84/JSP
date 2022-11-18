<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ page import="java.util.*"%>
<%@ page import="com.human.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<style type="text/css">
p{margin: 0px;
}
</style>
</head>
<body>
<%BoardVO bvo = (BoardVO)request.getAttribute("bvo"); %>
   <div id="wrap" align="center">
      <h1>QnA 상세보기</h1>
      <table>
         <tr>
            <th>아이디</th>
            <td>${bvo.getId()}</td>
            <th>이름</th>
            <td>${bvo.getName()}</td>
         </tr>
         <tr>
            <th>작성일</th>
            <td>${bvo.getIndate()}</td>
            <th>조회수</th>
            <td>${bvo.getCnt()}</td>
         </tr>
         <tr>
            <th>제목</th>
            <td colspan="3">${bvo.getTitle()}
              <span style="color: red;">  
              <% if(bvo.getChk()!=null){
            	out.print("/*비밀글입니다.");
            }%>
            </span></td>
         </tr>
         <tr>
            <th>내용</th>
            <td colspan="3" style="height: 500px">${bvo.getContent()}</td>
         </tr>
         
      </table>
       
      <table>
      <tr>
      <th>답변</th>
      </tr>
             <%
				ArrayList<ReVO> rList = (ArrayList)request.getAttribute("rList");
				if(rList.size()==0){
					out.print("<tr class= 'record'>");
					out.print("<td><p>등록된 답변이 없습니다.<p></td>");
					out.print("</tr>");
				}else{
					for (int i = 0; i < rList.size(); i++) {
						out.print("<tr class= 'record'>");
						out.print("<td><b>"+rList.get(i).getReId()+"</b><br><p>"+rList.get(i).getReContent()+"</p><p style='font-size: smaller;'>"+rList.get(i).getReIndate()+"</p></td>");
						out.print("</tr>");
					}
				}
			%>
       </table>
      <br> <br> <input type="button" onclick= "location.href = 'QnaMody?num=${bvo.getNum()}'" value="게시글 수정">
      <input type="button" onclick = "del()" value="게시글 삭제">
      <input type="button" onclick="location.href = 'QnaBoardList'" value="목록 보기">
      <input type="button" onclick = "showRe()" value="답변쓰기"> 
      <form action="reAction" method="get">
      <table id = "review" style="display:none;">
      <tr>
      <th rowspan="2">답변달기</th>
      <td colspan="3">아이디: <input type="text" name="reId" size="20px"><input type="hidden" name="num" value="${bvo.getNum()}"></td>
         </tr>
         <tr>
         	<td colspan="3">답변: <input type="text" name="reContent"  style="width: 700px; height: 100px">  <input type="submit" value="답변 등록" style="width: 100px; height: 100px"></td>
         </tr>
      </table>
        </form>
      </div>
</body>
<script type="text/javascript">
	function showRe(){
		document.getElementById("review").style.display = 'block';
	}
	
	function del(){
		if(confirm("게시글을 삭제하시겠습니까??")){
			window.location.href = "QnaDel?num=" + ${bvo.getNum()};
		}		
	}
</script>
</html>