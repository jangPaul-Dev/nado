<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 팔로잉 한 친구 목록 자세히</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

var uri = location.href
var values = uri.split("?")

var id = values[1]
var sex = values[2]
var birth = values[3]

var food = values[4]

console.log(values)

$(document).ready(function() {
        $('#id').val(id);
        $('#sex').val(sex);
        $('#birth').val(birth);
        $('#food').val(food);
    });

</script>
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
   <input id="id" type="text" class="inputbox" size="100" />
   <input id="sex" type="text" class="inputbox" size="100" />
   <input id="birth" type="text" class="inputbox" size="100" />
   
   <input id="food" type="text" class="inputbox" size="100" />
   
   
   <jsp:include page="FollowingUserLikeList.jsp"></jsp:include>
   </div>

</body>
</html>




