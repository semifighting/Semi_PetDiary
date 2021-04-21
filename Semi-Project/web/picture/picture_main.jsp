<%@ page import="java.util.List" %>
<%@ page import="com.pet.ft.dto.pictureDto" %>
<%@ page import="com.pet.ft.biz.petBizImpl" %>
<%@ page import="com.pet.ft.biz.petBiz" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resources/css/stylesheet.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../resources/javascript/script.js">

    </script>
</head>
<body>
<%
    petBiz biz = new petBizImpl();
    List<pictureDto> list = biz.selectPictureList(1);

%>
<%@include file="../main/header.jsp"%>
    <form action="../pet.do" method="post">
        <input type="hidden" name="command" value="picture_delete">
        <div id="selectPictureList">
        <%
            for (pictureDto dto : list) {
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

    <form id="imageUpload" method="post" action="../pet.do?command=picture_upload" enctype="multipart/form-data">
        <input type="file" name="img" accept="image/*" multiple>
        <input type="submit" value="업로드하기">
    </form>
<%@include file="../main/footer.jsp"%>
</body>
</html>
