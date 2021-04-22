<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/semi_PetDiary/resources/javascript/script.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String src = request.getParameter("src");
%>
<form method="post" action="/semi_PetDiary/pet.do">
    <input type="hidden" name="command" value="pet_insert">
<table border="1">
    <col width="100"/>
    <col width="100"/>
    <col width="100"/>
    <col width="100">
    <tr>
        <td colspan="2">
            <input type="button" name="picture" value="사진 선택하기" onclick="location.href='/semi_PetDiary/pet.do?command=picture_insert_select'">
            <img id="selectedPic" src="<%=src%>" alt="선택된 사진" width="500" height="500">
            <input type="hidden" name="path" value="<%=src%>">
        </td>
    </tr>
    <tr>
        <th>이름</th>
        <td colspan="2"><input type="text" name="name"></td>
    </tr>
    <tr>
        <th>종</th>
        <td colspan="2">
            <select name="species">
                <option value="강아지">강아지</option>
                <option value="고양이">고양이</option>
            </select>
        </td>
    </tr>
    <tr>
        <th>품종</th>
        <td colspan="2"><input type="text" name="breed"></td>
    </tr>
    <tr>
        <th>생년월일</th>
        <td colspan="2"><input type="date" name="birthday"></td>
    </tr>
    <tr>
        <th>성별</th>
        <td><input type="radio" name="gender" value="M">M</td>
        <td><input type="radio" name="gender" value="F">F</td>
    </tr>
    <tr>
        <th>예방 접종 일자</th>
        <td><input type="date" name="vaccination"></td>
    </tr>
     <tr>
        <td colspan="3" align="right">
            <input type="submit" value="작성">
        </td>
    </tr>
</table>
</form>
</body>
</html>
