<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<link href="../resources/css/stylesheet.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../resources/javascript/paging.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
    <div id="myPet">
        <div id="myPetImg">
            <img src="../resources/image/4.jpg" width="500px" height="500px">
        </div>
        <div id="myPetInfo">
            1
        </div>
        <div id="myPetWeightGraph">
            <input type="button" id="left" value="왼">
            <input type="button" id="right" value="오">
        </div>
    </div>

<%@include file="../main/footer.jsp"%>
</body>
</html>
