<%@ page import="java.util.List" %>
<%@ page import="com.pet.ft.dto.petDto" %>
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
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../resources/javascript/paging.js"></script>
</head>
<body>
<%
    //int member_no = Integer.parseInt(request.getParameter("member_no"));
    int member_no = 1;
    petBiz biz = new petBizImpl();
    int totalCount = biz.getCount(1);     //member_no가 들어가야함

%>
<div>
  <img id="petImg" src="${dto.pet_path }" alt="반려동물 사진" width="500px" height="500px">
</div>
<div>
    <div class="myPetInfo">
        <p id = "petName">
            이름 ${dto.pet_name }
        </p>
        <p id = "petSpecies">
            종   ${dto.pet_species }
        </p>
        <p id = "petBreed">
            품종 ${dto.pet_breed }
        </p>
        <p id="petBirthday">
            생년월일 ${dto.pet_birthday}
        </p>
        <p id="petGender">
            성별 ${dto.pet_gender }
        </p>
        <p id="petVaccination">
            예방 접종 예정일 ${dto.pet_vaccination }
        </p>
    </div>
    <input type="button" id="petDel" value="삭제" onclick="">
    <input type="button" id="petUp" value="수정" onclick="">
    <button class="pet1" value="1">1</button>
</div>
</body>
</html>
