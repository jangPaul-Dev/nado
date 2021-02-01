<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
</head>
<style>
    header {
        width:940px;
        height:120px;
        margin:auto;
        background-color: indigo;
    }
    .profile {
        width:940px;
        height:460px;
        margin:auto;
        background-color: gray;
    }
    .mypic {
        width: 300px;
        height: 300px;
        border-radius: 50%;
        margin: 20px 20px;
        display: inline-block;
        position: relative;
        background-color:aquamarine;
    }

    .id {
        display: inline;
        position:absolute;
        width: 600px;
        height: 100px;
        margin: 20px 0px;
        background-color:rgb(248, 184, 160);
    }

    .gender {
        display: inline;
        position:absolute;
        width: 600px;
        height: 100px;
        margin: 120px 0px;
        background-color:rgb(172, 215, 231);
    }

    .location {
        display: inline;
        position:absolute;
        width: 600px;
        height: 100px;
        margin: 220px 0px;
        background-color: rgb(252, 151, 235);
    }

    .interest {
        width: 940px;
        height: 100px;
        margin: 0px 0px;
        background-color: rgb(245, 245, 133);
        text-align:center;
    }
    .mypost {
        width:940px;
        height:400px;
        background-color: burlywood;
        text-align:center;
        margin:auto;
    }
</style>

<body>

    <header>

    </header>
    <container>
        <div class="profile">
            <div class="mypic">
                <img src="">
            </div>
            <div class="id">

            </div>
            <div class="gender">

            </div>
            <div class="location">

            </div>
            <div class="interest">
                이 안에 관심사 카드 삽입
            </div>
        </div>
        <div class="bio">

        </div>
    </container>
    <section>
        <div class="mypost">
            여기에 나의 게시글 모아서 띄우기
        </div>
    </section>
    




</body>

</html>