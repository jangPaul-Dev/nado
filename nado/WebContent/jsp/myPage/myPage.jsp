<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="../css/Header.css?after" />
<link rel="stylesheet" type="text/css" href="../css/myPage.css?after" />

<html>

<title>나의 정보</title>
<jsp:include page="../main/Header.jsp" />
<%
	String value1 = request.getParameter("ulike");
%>
</head>

<body>

		<div class="container">
			<div class="profile">
				<!--  <div class="mypic">
				<img src="${meetCard.mimg}">
				</div> 유저프로필 사진이 없어ㅠ-->
				<ul>
					<c:forEach var="user" items="${myProfile}">
						<c:out value="${user.uId}, ${user.uSex}, ${user.uaddress}" />

					</c:forEach>
				</ul>
			</div>
			<div class="like">
				<c:forEach var="ulike" items="${ulike}">
					<c:if test="${ulike.food eq 'y'}">
        	맛집
         </c:if>
					<c:if test="${ulike.travel eq 'y'}">
       	 	여행
         </c:if>
					<c:if test="${ulike.photo eq 'y'}">
          	사진
         </c:if>
					<c:if test="${ulike.movie eq 'y'}">
          	영화
         </c:if>
					<c:if test="${ulike.volunteer eq 'y'}">
          	봉사활동
         </c:if>
					<c:if test="${ulike.health eq 'y'}">
         	 건강/운동
         </c:if>
					<c:if test="${ulike.buying eq 'y'}">
          	공동구매
         </c:if>
					<c:if test="${ulike.game eq 'y'}">
          	게임
         </c:if>
					<c:if test="${ulike.etc eq 'y'}">
          	기타
         </c:if>
					<c:if test="${ulike.developement eq 'y'}">
         	자기개발
         </c:if>
					<c:if test="${ulike.concert eq 'y'}">
          	공연
         </c:if>
					<c:if test="${ulike.reading eq 'y'}">
          	독서
         </c:if>
				</c:forEach>
			</div>
			<section>
				<div class="mymeetcard">
					<c:forEach var="MeetCard" items="${meetCard}">
						<c:out value="${meetCard.mno},${meetCard.mdate},${meetCard.mcontent},${meetCard.mimg},
						${meetCard.maxuser},${meetCard.endyn}">
						</c:out>
						<br />
					</c:forEach>
					<!--<jsp:include page="../myPage/myLike.jsp" />-->
					여기에 나의 게시글 모아서 띄우기
				</div>
			</section>
		</div>
	</form>
</body>

</html>