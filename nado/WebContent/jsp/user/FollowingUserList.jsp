<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="http://example.com/myicon.png">

<meta charset="UTF-8">
<title>내가 팔로잉 한 친구 목록</title>
<link rel="stylesheet" type="text/css" href="../css/Following.css?after"/>
</head>
<body> 
	<jsp:include page="../main/Header.jsp"/>
		<div class="container">
	<h1>내가 팔로잉한 친구</h1>
					
        <nav class="nav">
            <ul>
                <li><a href="#">홈으로</a></li>
                <li><a href="../jsp/myPage/myPage.jsp">마이페이지</a></li>
            </ul>
        </nav>
        <section class="content">
        	<ul>
				<c:forEach var="user" items="${users}">
					<li>
						<c:out value=" ${user.uId}"/>
						<a href="more.do?no="${user.uId}"><br>${user.uName}</a>
							<!--<c:out value="${user.uId}"/>--
						
						<!--<a href="jstl0${user.uId}"></a>-->
		                <button id="more" onclick='location.href="../user/more.do?uId="'${user.uId}>클릭</button><br/>
                	</li>
				</c:forEach>
			</ul>
        </section>
    </div>
</body>
</html>





