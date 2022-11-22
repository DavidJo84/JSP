<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header{
padding-left: 30px;
padding-top: 4px;
width: 1028px;
height: 90px;
background-color: red;
box-sizing: border-box;
}
nav{
width: 1028px;
height: 50px;
background-color: yellow;
display: inline;
float: left;
padding-top: 0px;
}
ul li{
list-style: none;
float: left;
margin-right: 30px;
margin-left: 30px;
}
section{
width: 1028px;
height: 500px;
}
footer{
width: 1028px;
text-align: center;
height: 30px;
background-color: blue;
}
</style>
</head>

<body>
<header>
<h1>학사정보 시스템</h1>
</header>
<nav>
<ul>
<li><a href = "Index">[홈으로]</a></li>
<li><a href = "AddForm">[학생등록]</a></li>
<li><a href = "ViewList">[학생보기]</a></li>
<li><a href = "ViewClass">[학생별 신청내역]</a></li>
</ul>
</nav>

</body>
</html>