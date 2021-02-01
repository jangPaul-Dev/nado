<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

	<h3>나의 게시물 보기</h3>

	<c:forEach var="MeetCard" items="${myMeet}">

		<c:out value="${MeetCard.mno},${MeetCard.mcontent}">
		</c:out>
		<a href='update.do?no=${member.mno}'>${member.name}</a>,
		${member.email},
		${member.createdDate}
		<a href='delete.do?no=${member.no}'>[삭제]</a>
		<br/>
	</c:forEach> 


	<ul>
		<c:forEach var="no" begin="1" end="10">
		</c:forEach>
	</ul>
</body>
</html> 