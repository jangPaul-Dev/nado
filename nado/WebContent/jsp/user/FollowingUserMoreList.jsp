<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 팔로잉 한 친구 목록 자세히</title>
<style type="text/css">
body{
    margin: 0 auto;
}
.content{
    width: 636px;
    height: 100vh;
    border-style: solid;
    margin: 0 auto;
    max-width: 600px;
    position: relative;
    width: 100%
}
 .content ul li{
    border:1px solid #ccc;
    border-radius:5px;
    width: 500px;
    margin: 20px;
    height: auto;
    background-color:#d9d4e2;
    display: inline-block;
}

#more{
    margin-left: 440px;
}
</style>
</head>
<body>
	<jsp:include page="../main/Header.jsp" />
		<div class="container">
	<h1>내 친구 목록 더보기</h1>
	<section class="content">
	
		<!--<form action="list.do" method="get">-->
		<c:forEach var="user" items="${uid_user}">
		<ul>
			<li>
				${uid_user.uId}
				</br>
				<c:out value="${uid_user.uBirth}" />
				</br>
				<c:out value="${uid_user.uSex}" />
				
				</br>
				<jsp:include page="FollowingUserLikeList.jsp"></jsp:include>
			
			<button id="unfollowing"
				onclick='location.href="../user/unfollwing.do"'>언팔로우</button>
			</li>
			</ul>
			</c:forEach>
			</br>
			</form>
		</section>
	
	</div>

</body>
</html>





