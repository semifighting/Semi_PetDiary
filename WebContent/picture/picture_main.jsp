<%@ page import="java.util.List" %>
<%@ page import="com.pet.ft.dto.PictureDto" %>
<%@ page import="com.pet.ft.biz.PetBizImpl" %>
<%@ page import="com.pet.ft.biz.PetBiz" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/semi_PetDiary/resources/css/stylesheet.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/semi_PetDiary/resources/javascript/script.js">

    </script>
</head>
<body>
<%
    PetBiz biz = new PetBizImpl();
    List<PictureDto> list = biz.selectPictureList(1);

%>
<%@include file="/main/header.jsp"%>
    <form action="/semi_PetDiary/pet.do" method="post">
        <input type="hidden" name="command" value="picture_delete">
        <div id="selectPictureList">
        <%
            for (PictureDto dto : list) {
        %>
            <input type="checkbox" name="picture_no" value="<%=dto.getPicture_no()%>"><img alt="사진" class="smallPic" src="<%=dto.getPicture_directory()%>/<%=dto.getPicture_name()%>">
        <%
            }
        %>
        </div>
        <input type="submit" value="삭제">
    </form>
    <div id="bigPic">
    </div>

    <form id="imageUpload" method="post" action="/semi_PetDiary/pet.do?command=picture_upload" enctype="multipart/form-data">
        <input type="file" name="img" accept="image/*" multiple>
        <input type="submit" value="업로드하기">
    </form>
<%@include file="/main/footer.jsp"%>
</body>
</html>