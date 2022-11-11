<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form" action="LoginPass" method="get">
		아이디 <input type="text" id="idIn" name="id"> <br> 비밀번호 <input
			type="password" name="pass"><br> 성별<input type="radio"
			name="gender" value="m">남 <input type="radio" name="gender"
			value="w">여<br> 직업 <select name="job">
			<option value="army">군인</option>
			<option value="gener">일반인</option>
		</select><br> 좋아하는 커피 <select multiple name="coffe">
			<option value="espreso">에스트레소</option>
			<option value="caramel">카라멜마끼아또</option>
			<option value="latte">라떼</option>
			<option value="dotch">카라멜마끼아또</option>
		</select><br> 취미 <input type="checkbox" name="hobby" value="trip">
		여행 <input type="checkbox" name="hobby" value="fishing"> 낚시 <input
			type="checkbox" name="hobby" value="hiking"> 등산 <input
			type="checkbox" name="hobby" value="bangkok"> 집콕 <input
			type="button" onclick="chkId()" value="로그인">
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