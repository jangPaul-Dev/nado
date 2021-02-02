<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="../css/Header.css?after" />
<link rel="stylesheet" type="text/css" href="../css/myPage.css?after" />
<script type="text/javascript">

var uri = location.href
var values = uri.split("?")

var id = values[1]
var sex = values[2]
var birth = values[3]

console.log(values)

$(document).ready(function() {
        $('#id').val(id);
        $('#sex').val(sex);
        $('#address').val(address);
        
    });

</script>
<html>

<title>My page</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<%
	String value1 = request.getParameter("ulike");
%>
</head>

<body>
<jsp:include page="../main/Header.jsp" />
		<div class="container">
			<h1>My page</h1>
			<div class="profile">
		<input id="id" type="text" class="inputbox" size="50" />
		<input id="sex" type="text" class="inputbox" size="50" />
		<input id="address" type="text" class="inputbox" size="50" />
		<c:out value="${myProfile.uId}" /> 
		
			<div class="mypic">
				<!--<img id="pic">-->
			</div>
			<div class="info">
				<ul>
					<li class="id">
						<c:forEach
							var="user-id" items="${myProfile}">
							<c:out value="${user.uId}" />
						</c:forEach>
					</li>
					<li class="gender">
						<c:forEach
							var="user-gender" items="${myProfile}">
							<c:out value="${user.uSex}>" />
						</c:forEach>
					</li>
					<li class="location">
						<c:forEach
							var="user-address" items="${myProfile}">
							<c:out value="${user.uAddress}" />
						</c:forEach>
					</li>
				</ul>
			</div>
		</div>
			<div class="like">
				<c:forEach var="ulike" items="${myLike}">
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
	
</body>

</html>
