<%@ page import="java.util.List" %>
<%@ page import="com.pet.ft.dto.PetDto" %>
<%@ page import="com.pet.ft.model.PetBizImpl" %>
<%@ page import="com.pet.ft.model.PetBiz" %>
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
    PetBiz biz = new PetBizImpl();
    List<PetDto> list = biz.selectPetList(member_no);

    if (list.isEmpty()) {
%>
    <h1>반려 동물을 등록해주세요</h1>
    <input type="button" value="추가" onclick="window.open('../pet_servlet?command=pet_insert_form&pet_no='<%=member_no%> + ',update', 'left=50, top=50, width=700, height=700')">

<%
    }
    else {
        int totalCount = biz.getCount(1);     //member_no가 들어가야함
        int petNo = list.get(0).getPet_no();
        String petName = list.get(0).getPet_name();
        String petSpecies = list.get(0).getPet_species();
        String petBreed = list.get(0).getPet_breed();
        String petBirth = list.get(0).getPet_birthday().substring(0, 10);
        String petGender = list.get(0).getPet_gender();
        String petVaccin = list.get(0).getPet_vaccination().substring(0, 10);
        String path = list.get(0).getPet_path();
%>
<div>
    <img id="petImg" src="<%=path%>" alt="반려동물 사진" width="500px" height="500px">
</div>
<div>
    <div class="myPetInfo">
        <p id = "petName">
            이름 <%=petName%>
        </p>
        <p id = "petSpecies">
            종   <%=petSpecies%>
        </p>
        <p id = "petBreed">
            품종 <%=petBreed%>
        </p>
        <p id="petBirthday">
            태어난 날 <%=petBirth%>
        </p>
        <p id="petGender">
            성별 <%=petGender%>
        </p>
        <p id="petVaccination">
            예방 접종 예정일 <%=petVaccin%>
        </p>
    </div>
    <input type="button" value="추가" onclick="window.open('pet/pet_insert.jsp', 'insert', 'left=50, top=50, width=700, height=700')">
    <input type="button" id="petDel" value="삭제" onclick="location.href='../pet_servlet?command=pet_delete&pet_no=<%=petNo%>'">
    <input type="button" id="petUp" value="수정" onclick="window.open('../pet_servlet?command=pet_update_form&pet_no=<%=petNo%>', 'update', 'left=50, top=50, width=700, height=700')">
<%
        for (int i = 1; i <= totalCount; i++) {
%>
            <a href="#" onclick="pet(<%=i%>)">[<%=i%>]</a>
<%
        }
    }
%>
</div>
</body>
</html>
