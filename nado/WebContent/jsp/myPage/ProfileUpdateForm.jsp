<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보 수정</title>
</head>
<body>
<h1>나의 정보 수정</h1>
	<form action='update.do' method='post'>
		회원번호: ${user.uno}<br>
		이름: <input type='text' name='name' value='${user.uname}'><br>
		아이디: <input type='text' name='id' value='${user.uid}'><br>
		비밀번호: <input type='text' name='password' value='${user.upwd}'><br>
		이메일: <input type='text' name='email' value='${user.uemail}'><br>
		생년월일: ${user.ubirth}<br>
		성별: ${user.usex}<br>
		전화번호: <input type='text' name='phone' value='${user.uphonenum}'><br>
		거주지: <input type='text' name='add' value='${user.uaddress}'><br>
		<input type='submit' value='저장'>
		<input type='button' value='삭제'
			onclick='location.href="delete?no=${user.uno}";'>
		<input type='button' value='취소' onclick='location.href="../user/mypage.do"'>
	</form>
</body>
</html>