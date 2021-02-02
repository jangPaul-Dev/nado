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
<script type="text/javascript">
</script>
<body> 
   <jsp:include page="../main/Header.jsp"/>
      <div class="container">
   <h1>내가 팔로잉한 친구</h1>
               
        <nav class="nav">
            <ul>
                <li><a href="../main/main.do">홈으로</a></li>
                <li><a href="../jsp/myPage/myPage.jsp">마이페이지</a></li>
            </ul>
        </nav>
        <section class="content">
           <ul>
           <c:forEach var="ulike" items="${ulikes}">	
	
			<c:if test="${ulike.food eq 'y'}">food</c:if>
			<c:if test="${ulike.travel eq 'y'}">travel</c:if>			
			<c:if test="${ulike.photo eq 'y'}">photo</c:if>	
			<c:if test="${ulike.movie eq 'y'}">movie</c:if>			
			<c:if test="${ulike.volunteer eq 'y'}">volunteer</c:if>			
			<c:if test="${ulike.health eq 'y'}">health</c:if>			
			<c:if test="${ulike.buying eq 'y'}">buying</c:if>
			<c:if test="${ulike.game eq 'y'}">game</c:if>
			<c:if test="${ulike.etc eq 'y'}">etc</c:if>
			<c:if test="${ulike.development eq 'y'}">development</c:if>
			<c:if test="${ulike.concert eq 'y'}">concert</c:if>
			<c:if test="${ulike.reading eq 'y'}">reading</c:if>				
			<br/>		
			</c:forEach>
			
            <c:forEach var="user" items="${users}">
            
               <li>
                  <c:out value=" ${user.uId}"/>
                  <a href="more.do?no="${user.uId}></a>
                      <button id="more" onclick='location.href="../user/more.do?${user.uId}?${user.uSex}?${user.uBirth}?${ulike.food}"'>클릭</button><br/>
                   </li>
            </c:forEach>
            
            
         </ul>
        </section>
    </div>
</body>
</html>




