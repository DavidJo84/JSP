<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="BoardServlet?command=board_write_form">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
         </tr>
         
            <tr class="record">
               <td>1</td>
               <td><a href="#">즐거운 코딩</a></td>
               <td>홍길동</td>
               <td>2022.11.14</td>
               <td>3</td>
            </tr>
            <tr class="record">
               <td>2</td>
               <td><a href="#">오늘 점심은 계란</a></td>
               <td>조하영</td>
               <td>2022.11.14</td>
               <td>14</td>
            </tr>
      </table>
   </div>
</body>
</html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
   <div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="BoardServlet?command=board_write_form">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
         </tr>
         
            <tr class="record">
               <td></td>
               <td><a href="#"></a></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
      </table>
   </div>
</body>
</html> -->