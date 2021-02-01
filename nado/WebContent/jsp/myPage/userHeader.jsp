<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div style="background-color:indigo; color:white; 
		height:120px; width:940px; margin:auto; text-align:center;">


<span style="float:right;">
<a style="color:white;"
		href="<%=request.getContextPath()%>/user/profileEdit.do">나의 프로필 수정</a>
	<a style="color:white;">
		<c:if test="${!empty sessionScope.user and 
				  !empty sessionScope.user.uno}"></c:if>
			${sessionScope.user.uname}님 환영합니다!
			(<a style="color:white;"
				href="<%=request.getContextPath()%>/user/logout.do">
				로그아웃
			</a>)
		</a>
</span>
</div>
