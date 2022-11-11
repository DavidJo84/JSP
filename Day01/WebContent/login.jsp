<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id = "form" action="LoginPass" method="get">
		아이디 <input type="text" id="idIn" name="id"> 비밀번호 <input
			type="password" name="pass"> 
			<input type="button"
			onclick="chkId()" value="로그인">
	</form>

</body>
<script>
	function chkId() {
		let id = document.getElementById('idIn').value;
		if (id.length < 4) {
			alert("아이디는 4글자 이상으로 입력하세요");
		} else {
			document.getElementById('form').submit();
		}
	};
</script>
</html>