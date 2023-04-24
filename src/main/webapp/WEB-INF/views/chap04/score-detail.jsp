<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
    .head {
        margin: 200px auto;
        border: 1px solid orange;
        text-align: left;
        width: fit-content;
    
    }
    .main{
        margin-left: 50px;
    }
    #title{
        margin: 15px;
    }

    #list {
        margin-left: 30px;
        margin-bottom: 10px;
        background: green;
        float: left;
        color: white;
       text-decoration: none;
    }
    .foot{
        margin: 20px 0;
  

    }

    #update{
        color : white;
        background: blue;
        margin-left: 10px;
        margin-bottom: 10px;
        text-decoration: none;
    }
</style>

<body>
    <div class="head" >
        <h1 id="title">${s.name} 님 성적 정보</h1>
        <div class="main">
        <div># 국어 : ${s.kor}</div>
        <div># 영어 : ${s.eng}</div>
        <div># 수학 : ${s.math}</div>
        <div># 총점 : ${s.total}</div>
        <div># 평균 : ${s.average}</div>
        <div># 학점 : ${s.grade}</div>

    </div>
        <div class="foot">
            <a href="/score/list" id="list">목록</a>
            <a href="/score/modify/?stuNum=${s.stuNum}" id="update">수정</a>
        </div>
    </div>
</body>

</html>