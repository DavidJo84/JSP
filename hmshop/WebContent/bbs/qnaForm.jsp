<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
	<div id="wrap">
		<h1>QnA 등록</h1>
		<form id="go" name="frm" method="post" action="QnaAction">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>글번호</th>
					<td><input type="hidden" name="jsp" value = "qnaForm">
					<input type="hidden" name="num" value = "${num}">${num}</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input id="idchk" type="text" name="id"> * 필수 <span
						id="idchkOut"></span></td>
				</tr>

				<tr>
					<th>이름</th>
					<td><input id="namechk" type="text" name="name"> * 필수
						<span id="namechkOut"></span></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input id="passchk" type="password" name="pass"> *
						필수 (게시물 수정 삭제시 필요합니다.) <span id="passchkOut"></span></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="50" name="title"><input
						type="checkBox" name="chk">*비밀글</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br> <br> <input type="button" onclick="allChk()"
				value="등록"> <input type="reset" value="다시 작성"> <input
				type="button" value="목록">
		</form>
	</div>
</body>
<script type="text/javascript">
	document.getElementById('idchk').onchange = function() {
		var a = document.getElementById('idchk').value;
		const regExp = /^(?=.*[$`~!@$!%*#^.?&\\(\\)\-_=+]).{8,10}$/;
		if (regExp.test(a)) {
			document.getElementById('idchkOut').innerHTML = '*사용가능한 id 입니다.';
			document.getElementById('idchkOut').style.color = 'green';
			document.getElementById('idchkOut').style.fontSize = '10px';
		} else {
			document.getElementById('idchkOut').innerHTML = '*특수문자 포함, 8~10글자 사이로 입력해주세요';
			document.getElementById('idchkOut').style.color = 'red';
			document.getElementById('idchkOut').style.fontSize = '10px';
		}
	}

	document.getElementById('namechk').onblur = function() {
		var a = document.getElementById('namechk').value;
		if (a === '') {
			document.getElementById('namechkOut').innerHTML = '*필수 입력 사항입니다.';
			document.getElementById('namechkOut').style.color = 'red';
			document.getElementById('namechkOut').style.fontSize = '10px';
		} else {
			document.getElementById('namechkOut').innerHTML = '';
		}
	}

	document.getElementById('passchk').onblur = function() {
		var a = document.getElementById('passchk').value;
		if (a === '') {
			document.getElementById('passchkOut').innerHTML = '*필수 입력 사항입니다.';
			document.getElementById('passchkOut').style.color = 'red';
			document.getElementById('passchkOut').style.fontSize = '10px';
		} else {
			document.getElementById('passchkOut').innerHTML = '';
		}
	}

	function allChk() {
		let id = document.getElementById('idchk').value;
		let name = document.getElementById('namechk').value;
		let pass = document.getElementById('passchk').value;
		const regExp = /^(?=.*[$`~!@$!%*#^.?&\\(\\)\-_=+]).{8,10}$/;
		if (regExp.test(id) && name !== '' && pass !== '') {
			document.getElementById('go').submit();
		} else {
			alert("필수사항을 확인해주세요.")
		}
	}
</script>
</html>