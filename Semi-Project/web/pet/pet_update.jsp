<%@ page import="com.pet.ft.dto.petDto" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String src = request.getParameter("src");
    petDto dto = (petDto) request.getAttribute("dto");
    if (src == null) {
        src = dto.getPet_path();
    }
%>
<form method="post" action="../pet.do">
    <input type="hidden" name="command" value="pet_update_res">
    <input type="hidden" name="pet_no" value="<%=dto.getPet_no()%>">
    <table border="1">
        <col width="100"/>
        <col width="100"/>
        <col width="100"/>
        <col width="100">
        <tr>
            <td colspan="2">
                <input type="button" name="picture" value="사진 선택하기" onclick="location.href='pet.do?command=picture_update_select'">
                <img id="selectedPic" src="<%=src%>" alt="선택된 사진" width="500" height="500">
                <input type="hidden" name="path" value="<%=src%>">
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td colspan="2">${dto.pet_name }</td>
        </tr>
        <tr>
            <th>종</th>
            <td colspan="2">${dto.pet_species }</td>
        </tr>
        <tr>
            <th>품종</th>
            <td colspan="2">${dto.pet_breed }</td>
        </tr>
        <tr>
            <th>생년월일</th>
            <td colspan="2">${dto.pet_birthday }</td>
        </tr>
        <tr>
            <th>성별</th>
            <td colspan="2">${dto.pet_gender }</td>
        </tr>
        <tr>
            <th>예방 접종 일자</th>
            <td colspan="2"><input type="date" name="vaccination"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
