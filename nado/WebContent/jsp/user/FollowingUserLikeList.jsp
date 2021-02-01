<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String value1 = request.getParameter("ulike"); %> 
</head>
<!--  <script>
var column = ["food","travel","photo","movie","reading","volunteer","health","buying","game","etc","developement","concert"];
for(int i=0; i<column.length; i++){
	if(column[i].equals('y'))
}
</script>-->

<body>
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
			<c:if test="${ulike.developement eq 'y'}">developement</c:if>
			<c:if test="${ulike.concert eq 'y'}">concert</c:if>
			<c:if test="${ulike.reading eq 'y'}">reading</c:if>				
			<br/>		
	</c:forEach>
		
</body>

</html>