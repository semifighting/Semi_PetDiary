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
    <style type="text/css">

        .iframe {
            /*
            높이 넓이를 자식창에 맞도록 변경
            height 값의 경우 100vh가 맞지만 top: -150px 을 해주었기 때문에 비율 만큼 더했다!
            */
            display: block;
            border: none;
            /*상단 숨김 코드*/
            width: 500px;
            height: 500px;
            top: -150px;
        }
        a {
            text-decoration: none; color: black;
        }

        .pet_info{
            float: left;
            width: 500px;
            height: 500px;
            border: 1px solid blue;
            margin-left: 100px;
        }

        .pet_update {
        }
    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../resources/javascript/paging.js"></script>
</head>
<body>

<%@include file="../main/header.jsp"%>
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
    <div class="pet_info_main">
        <div class="pet_info">
            <img id="petImg" src="<%=path%>" alt="반려동물 사진" width="500px" height="500px">
        </div>
        <div class="pet_info">
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
        <div class="pet_info">
            <iframe src="../pet.do?command=calendar_calMain" class="iframe" scrolling="none">

            </iframe>
        </div>
    </div>


    <div class="pet_update">
        <input type="button" value="추가" onclick="window.open('pet/pet_insert.jsp', 'insert', 'left=50, top=50, width=700, height=700')">
        <input type="button" id="petDel" value="삭제" onclick="location.href='../pet_servlet?command=pet_delete&pet_no=<%=petNo%>'">
        <input type="button" id="petUp" value="수정" onclick="window.open('../pet_servlet?command=pet_update_form&pet_no=<%=petNo%>', 'update', 'left=50, top=50, width=700, height=700')">
    <%
        for (int i = 1; i <= totalCount; i++) {
    %>
        <a href="#" class="pet_paging" onclick="pet(<%=i%>)">[<%=i%>]</a>
    <%
            }
        }
    %>
    </div>

<%@include file="../main/footer.jsp"%>
</body>
</html>
