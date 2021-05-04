<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="../resources/css/main_view.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="../main/header.jsp"%>
<div id="welcome">
    <img alt="동물" src="../resources/image/4.jpg">
    <div>
        우리의 동물들과 행복한 시간을 보내보세요<br>
        병원예약도 가능하고 지도를 통해 여행 계획을 세워보세요<br>
        물론 동물 친구들과 함께 식사를 할 수 있는 식당에 대한 정보도 제공한답니다.<br>
        동물친구들이 아파요 병원에 가기 힘들때 간단히 원격진료로 해결하세요!<br>
    </div>
</div>

<button type="button" onclick="window.open('../teachable/teachable_webCam.jsp', 'update', 'left=50, top=50, width=700, height=700')">나와 닮은 동물 찾기</button>

<table id = "logbox">
    <tr>
        <td align="center"><input type="text" placeholder="아이디"></td>
    </tr>
    <tr>
        <td align="center"><input type="text" placeholder="비밀번호"></td>
    </tr>
    <tr>
        <td align="center"><input id="logbutton" type="button" value="로그인"></td>
    </tr>
</table>
<%@include file="../main/footer.jsp"%>
</body>
</html>
