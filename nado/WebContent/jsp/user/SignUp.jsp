<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../css/SignUp.css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
        <div class="signupContainer">
            <div class="signupBox">
                <div class="logoPic">

                </div>
                <div class="intro">
                    <p>새로운 친구, 새로운 만남을 위해<br>nado에 가입하세요.</p>
                </div>
                <div class="singupInfo">
                    <form  action="signup.do" method="post" id="signupForm">
                        <div class="databox"><input class="inputData" id="userId" type="text" name="uId" 
                                placeholder="ID"></div>
                        <div class="databox"><input class="inputData" id="userPwd" type="password" name="uPwd" 
                                placeholder="password"></div>
                        <div class="databox"><input class="inputData" id="userName" type="text" name="uName"
                                placeholder="이름"></div>
                        <div class="databox"><input class="inputData" id="userBirth" type="text" name="uBirth" maxlength="10"
                                placeholder="생년월일 예)XXXX-XX-XX"></div>
                        <div class="databox" id="dataBoxWrap">
                            <span class="smallcheck">
                                <label for="userSexF" class="checklabel">여성</label>
                                <input class="checkbox" id="userSexF" type="radio" value="F" name="uSex" checked>
                            </span>
                            <span class="smallcheck" id="smallcheck_M">
                                <label for="userSexM" class="checklabel">남성</label>
                                <input class="checkbox" id="userSexM" type="radio" value="M" name="uSex">
                            </span>
                        </div>
                        <div class="databox"><input class="inputData" id="phoneNum" type="text" name="uphoneNum" maxlength="11"
                                size="50" placeholder="휴대전화번호( - 없이 숫자만 입력)"></div>
                        <div class="databox"><input class="inputData" id="email" type="text" name="uemail" size="50"
                                placeholder="이메일"></div>
                        <div class="databox"><input class="inputData" id="address" type="text" name="uaddress" size="50"
                                placeholder="거주지 예)연남동"></div>
                        <div class="databox">
                            <div class="btn">
                                <input id="signup_btn" type="submit" value="다음">
                                <input id="reset_btn" type="reset" value="취소">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <h1>nado</h1>
    </footer>
</body>
</html>