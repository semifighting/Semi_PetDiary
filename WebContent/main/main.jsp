<% request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); %> <%@ page
contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>펫 다이어리</title>
    <link
      href="/semi_PetDiary/resources/css/main_view.css"
      rel="stylesheet"
      type="text/css"
    />
    <script type="text/javascript">
      function registForm() {
        location.href = "/semi_PetDiary/pet.do?command=login_Signup";
      }

      function checkForm() {
        var id = document.getElementsByName("member_id")[0];
        var pw = document.getElementsByName("member_pw")[0];

        if (id.value.trim() == "" || id.value == null) {
          alert("아이디를 입력해 주세요.");
          return false;
        } else if (pw.value.trim() == "" || pw.value == null) {
          alert("비밀번호를 입력해 주세요.");
          return false;
        } else {
          return true;
        }
      }
    </script>
  </head>
  <body>
    <%@include file="/main/header.jsp"%>
    <div id="welcome">
      <img alt="동물" src="/semi_PetDiary/resources/image/4.jpg" />
      <div>
        우리의 동물들과 행복한 시간을 보내보세요<br />
        병원예약도 가능하고 지도를 통해 여행 계획을 세워보세요<br />
        물론 동물 친구들과 함께 식사를 할 수 있는 식당에 대한 정보도
        제공한답니다.<br />
        동물친구들이 아파요 병원에 가기 힘들때 간단히 원격진료로 해결하세요!<br />
      </div>
    </div>
    <% if(session.getAttribute("member_no") == null) { // 로그인 상태가 아닐 때 로그인 폼 뜨기 %>
    <form
      action="/semi_PetDiary/pet.do"
      action="/semi_PetDiary/pet.do"
      method="post"
      onsubmit="return checkForm()"
    >
      <input type="hidden" name="command" value="login_loginForm" />
      <table id="logbox">
        <tr>
          <td align="center">
            <input type="text" name="member_id" placeholder="아이디" />
          </td>
        </tr>
        <tr>
          <td align="center">
            <input type="password" name="member_pw" placeholder="비밀번호" />
          </td>
        </tr>
        <tr>
          <td align="center">
            <input id="logbutton" type="submit" value="로그인" />
          </td>
        </tr>
      </table>
    </form>

    <% } else { // 로그인 상태일 때 로그인 폼 제거 // 어떤게 들어가야 할지 ? %>
    <% } %> <%@include file="/main/footer.jsp"%>
  </body>
</html>
