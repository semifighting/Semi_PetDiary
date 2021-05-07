<%@ page import="com.pet.ft.model.PetBiz" %>
<%@ page import="com.pet.ft.model.PetBizImpl" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/semi_PetDiary/resources/javascript/script.js"></script>
    <style type="text/css">
        #selectPictureOne > img {
            position: absolute;
            border: 1px solid salmon;
            margin: 100px 100px;
            width: 500px;
            height: 500px;
        }
        #selectPictureOne p a img{
            width: 50px;
            height: 50px;
        }

        #selectPictureList {
            position: absolute;
            width: 700px;
            height: 800px;
        }
        #selectPictureList img {
            margin-top: 10px;
            margin-left: 10px;
            position: relative;
            border: 1px solid salmon;
            width: 200px;
            height: 200px;
        }

        #imageUpload {
            position: absolute;
            text-align: right;
            bottom: 18%;
        }

        #bigPic {
            position: absolute;
            margin-left: 600px;
            bottom: 30%;
            width: 500px;
            height: 500px;
        }
        #request {
            margin-top: 100px;
            text-align: center;
        }

        .picture_paging {
            position: absolute;
            margin-top: 680px;
            margin-left: 250px;
        }
        #selectedPic {
            height: 500px;
            width: 500px;
        }
    </style>
</head>
<body>
<%
    int i = 0;
    PetBiz biz = new PetBizImpl();
    int member_no = (int) session.getAttribute("member_no");
    int count = biz.getPictureCount(member_no);
    int totalPage = count / 6;
    if (count % 6 != 0) {
        totalPage +=1;
    }
%>
<c:choose>
    <c:when test="${empty list }">
        <h1 id="request">사진을 등록 해주세요!</h1>
        <form id="imageUpload" method="post" action="/semi_PetDiary/pet.do?command=picture_upload" enctype="multipart/form-data">
            <input type="file" name="img" id="fileName" accept="image/*" multiple="multiple">
            <input type="submit" id="pictureUpload" value="업로드하기">
        </form>
    </c:when>
    <c:otherwise>
        <div id="selectPictureList">
            <div>
                <form action="/semi_PetDiary/pet.do" method="post">
                    <input type="hidden" name="command" value="picture_delete">
        <c:forEach items="${list }" var="dto">
            <input type="hidden" name="picture_no" value="${dto.picture_no }">
            <img alt="사진" class="smallPic" src="${fn:replace(dto.picture_directory,'..','/semi_PetDiary')}/${dto.picture_name }">
            <input type="submit" value="삭제">
        </c:forEach>
                </form>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<div id="bigPic">
    <img id="selectedPic" src="#" alt="선택된 사진" hidden="hidden" >
</div>
<%
    for (int j = 1; j <= totalPage; j++) {
%>
    <a href="#" class="picture_paging" onclick="location.href='/semi_PetDiary/pet_servlet?command=picture_main&max=<%=j*6%>'">[<%=j%>]</a>
<%
    }
%>
<form id="imageUpload" method="post" action="/semi_PetDiary/pet_servlet?command=picture_upload" enctype="multipart/form-data">
    <input type="file" name="img" accept="image/*" multiple>
    <input type="submit" value="업로드하기">
</form>
</body>
</html>
