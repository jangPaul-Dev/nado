<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../css/Ulike.css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
 <script type="text/javascript">
      $(document).ready(function(){
       $("input[type='checkbox']").on("click", function(){
           $("input[type='checkbox']").val("N");
           let count = $("input:checked[type='checkbox']").size();
            
           if(count>3){
               $(this).prop("checked", false);
               $(this).prop("value", "N")
               alert("3개까지 선택 가능합니다.");
           }
           $("input:checked[type='checkbox']").val("Y");
        });
      });
 </script>
</head>
<body>

<body>
	<!-- <h1>${user.uNo}</h1>
	<h1>${user.uId}</h1> -->
    <section>
        <div class="container">
            <div class="contentBox">
                <div class="logoPic">

                </div>
                <div class="intro">
                    <p>나의 관심사를 설정해주세요</br>
                     (최대 3개까지 설정 가능)</p>
                </div>
                <div class="ulikeInfo">
                    <form  action="ulikeAdd.do" method="post" id="ulikeForm">
                     <input type="hidden" name="ulike_uno" value="${user.uNo}">
                        <div class="databox" id="dataBoxWrap">
                            <span class="smallcheck">
                                <label for="food" class="checklabel">맛집</label>
                                <input class="checkbox" id="food" type="checkbox" name="food" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="travel" class="checklabel">여행</label>
                                <input class="checkbox" id="travel" type="checkbox" name="travel" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="photo" class="checklabel">사진</label>
                                <input class="checkbox" id="photo" type="checkbox" name="photo" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="movie" class="checklabel">영화</label>
                                <input class="checkbox" id="movie" type="checkbox" name="movie" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="reading" class="checklabel">독서</label>
                                <input class="checkbox" id="reading" type="checkbox" name="reading" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="volunteer" class="checklabel">봉사활동</label>
                                <input class="checkbox" id="volunteer" type="checkbox" name="volunteer" value="N">
                            </span> 
                            <span class="smallcheck">
                                <label for="health" class="checklabel">건강/운동</label>
                                <input class="checkbox" id="health" type="checkbox" name="health" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="buying" class="checklabel">공동구매</label>
                                <input class="checkbox" id="buying" type="checkbox" name="buying" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="game" class="checklabel">게임</label>
                                <input class="checkbox" id="game" type="checkbox" name="game" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="etc" class="checklabel">기타</label>
                                <input class="checkbox" id="etc" type="checkbox" name="etc" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="development" class="checklabel">자기개발</label>
                                <input class="checkbox" id="development" type="checkbox" name="development" value="N">
                            </span>
                            <span class="smallcheck">
                                <label for="concert" class="checklabel">공연</label>
                                <input class="checkbox" id="concert" type="checkbox" name="concert" value="N">
                            </span>
                        </div>
                      
                        <div class="databox">
                            <div class="btn">
                                <input id="signup_btn" type="submit" value="가입완료">
                                <input id="reset_btn" type="reset" value="취소">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <footer>
         <p>COPYRIGHT © 2021 NADO.<br/> ALL RIGHTS RESERVED.</p>
    </footer>
</body>
</html>