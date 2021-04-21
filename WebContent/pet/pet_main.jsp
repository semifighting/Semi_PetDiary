<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<link href="../resources/css/stylesheet.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../resources/javascript/script.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/main/header.jsp"%>
<input type="button" value="추가" onclick="window.open('pet/pet_insert.jsp','insert', 'left=50, top=50, width=700, height=700')">
            <c:choose>
                <c:when test="${empty petlist }">
                    반려동물을 등록해주세요.
                </c:when>
                <c:otherwise>
                    <c:forEach items="${petlist }" var="petdto">
                        <div class="myPet">
                            <div class="myPetImg">
                            </div>
                            <div class="myPetInfo">
                                <p>
                                    이름 ${petdto.pet_name }
                                </p>
                                <p>
                                    종   ${petdto.pet_species }
                                </p>
                                <p>
                                    품종 ${petdto.pet_breed }
                                </p>
                                <p>
                                    생년월일 ${petdto.pet_birthday}
                                </p>
                                <p>
                                    성별 ${petdto.pet_gender }
                                </p>
                                <p>
                                    예방 접종 예정일 ${petdto.pet_vaccination }
                                </p>
                            </div>
                            <input type="button" value="삭제" onclick="location.href='pet.do?command=pet_delete&pet_no=${petdto.pet_no }'">
                            <input type="button" value="수정" onclick="window.open('pet.do?command=pet_update_form&pet_no=${petdto.pet_no }', 'update', 'left=50, top=50, width=700, height=700')">
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
<%@include file="/main/footer.jsp"%>
</body>
</html>
