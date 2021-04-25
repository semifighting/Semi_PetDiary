<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% request.setCharacterEncoding("UTF-8"); %> <%
response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>펫 다이어리 : 회원 가입</title>
    <link href="/semi_PetDiary/resources/css/stylesheet.css" rel="stylesheet" />
    <style type="text/css">
      table {
        display: flex;
        display: -webkit-box;
        display: -ms-flexbox;
        overflow-x: auto;
        overflow-y: hidden;
      }

      tbody {
        display: flex;
      }

      th {
        width: 100px;
        text-align: left;
        font-weight: normal;
      }

      th,
      td {
        display: block;
      }

      #wrapform {
        position: absolute;
        top: 50%;
        left: 50%;
        line-height: 40px;
        transform: translate(-50%, -50%);
      }
      #h1 {
        position: absolute;
        padding-bottom: 50px;
        left: 50%;
        transform: translate(-50%, -50%);
      }

      #join input[type="text"] {
        border: #ccc 1px solid;
        border-radius: 5px;
        height: 25px;
        width: 250px;
      }

      #join input[type="password"] {
        border: #ccc 1px solid;
        border-radius: 5px;
        height: 25px;
        width: 250px;
      }

      #join input[type="button"] {
        border: salmon 2px solid;
        border-radius: 5px;
        height: 25px;
        background-color: white;
      }

      #join input[type="submit"] {
        border: salmon 2px solid;
        color: white;
        border-radius: 5px;
        height: 25px;
        background-color: salmon;
      }

      #signup {
        margin: auto;
        width: 50%;
      }
    </style>
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.6.0.min.js"
    ></script>
    <script type="text/javascript">
      var idpwExp = /^[a-zA-Z0-9]{5,20}$/;
      var phoneExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
      var nameExp = /^[가-힣]{2,15}$/;

      function idCheckConfirm() {
        var n1 = document.getElementsByName("member_id")[0].title;
        if (n1 == "n") {
          alert("아이디 중복체크를 해주세요.");
          document.getElementsByName("member_id")[0].focus();
        }
      }

      function idCheck() {
        var id = document.getElementsByName("member_id")[0];

        if (id.value.trim() == "" || id.value == null) {
          alert("아이디를 입력해 주세요.");
        } else if (!idpwExp.test(id.value)) {
          alert("아이디는 5~20자의 영문 대소문자와 숫자로만 입력해 주세요.");
        } else {
          open(
            "/semi_PetDiary/pet.do?command=login_idchk&member_id=" + id.value,
            "",
            "width=350, height=280"
          );
        }
      }

      function idCheckInit(form) {
        var n1 = document.getElementsByName("member_id")[0].title;
        if (n1 == "y") {
          $("#member_Id").attr("title", "n");
        }
      }

      function emailCheck() {
        var email = document.getElementsByName("member_email")[0];
        var emailExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;

        if (email.value.trim() == "" || email.value == null) {
          alert("이메일을 입력해 주세요.");
        } else if (!emailExp.test(email.value)) {
          alert("이메일 형식이 올바르지 않습니다.");
        } else {
          open(
            "/semi_PetDiary/pet.do?command=login_emailchk&member_email=" +
              email.value,
            "",
            "width=500, height=280"
          );
        }
      }

      function emailauthCheck() {
        var emailauth = document.getElementsByName("member_email_auth")[0];

        if (emailauth.value.trim() == "" || emailauth.value == null) {
          alert("인증번호를 입력해 주세요.");
        } else {
          open(
            "/semi_PetDiary/pet.do?command=login_emailAuth&member_email_auth=" +
              emailauth.value,
            "",
            "width=350, height=280"
          );
        }
      }

      function emailCheckInit(form) {
        var n2 = document.getElementsByName("member_email")[0].title;
        if (n2 == "y") {
          $("#member_email").attr("title", "n");
        }
      }

      function emailauthCheckInit(form) {
        var n3 = document.getElementsByName("member_email_auth")[0].title;
        if (n3 == "y") {
          $("#member_email_auth").attr("title", "n");
        }
      }

      function searchAddr() {
        var pop = window.open(
          "login_addrChk.jsp",
          "pop",
          "width=570,height=420"
        );
      }

      function jusoCallBack(roadAddrPart1, roadAddrPart2, addrDetail) {
        // 팝업페이지에서 주소입력한 정보를 받아서 현 페이지에 정보를 등록함
        document.getElementById("member_addr").value = roadAddrPart1;
        document.getElementById("member_addr_detail").value =
          roadAddrPart2 + " " + addrDetail;
      }

      function checkForm() {
        var n1 = document.getElementsByName("member_id")[0].title;
        var n2 = document.getElementsByName("member_email")[0].title;
        var n3 = document.getElementsByName("member_email_auth")[0].title;
        var pw = document.getElementsByName("member_pw")[0];
        var name = document.getElementsByName("member_name")[0];
        var phone = document.getElementsByName("member_phone")[0];
        var addrDetail = document.getElementsByName("member_addr_detail")[0];
        if (n1 == "n") {
          alert("아이디 중복체크를 해주세요.");
          return false;
        } else if (n2 == "n") {
          alert("이메일 인증이 필요합니다.");
          return false;
        } else if (n3 == "n") {
          alert("인증번호를 확인해 주세요.");
          return false;
        } else if (pw.value.trim() == "" || pw.value == null) {
          alert("비밀번호를 입력해 주세요.");
          return false;
        } else if (!idpwExp.test(pw.value)) {
          alert("비밀번호는 6~20자의 영문 대소문자와 숫자로만 입력해 주세요.");
          return false;
        } else if (name.value.trim() == "" || name.value == null) {
          alert("이름을 입력해 주세요.");
          return false;
        } else if (!nameExp.test(name.value)) {
          alert("이름은 2~15자의 한글로만 입력해 주세요.");
          return false;
        } else if (phone.value.trim() == "" || phone.value == null) {
          alert("전화번호를 입력해 주세요.");
          return false;
        } else if (!phoneExp.test(phone.value)) {
          alert("전화번호 형식을 확인해 주세요.");
          return false;
        } else if (addrDetail.value.trim() == "" || addrDetail.value == null) {
          alert("주소를 정확히 입력해주세요.");
          return false;
        } else {
          return true;
        }
      }
    </script>
  </head>
  <body>
    <%@include file="/main/header.jsp"%>

    <form
      id="join"
      name="join"
      action="/semi_PetDiary/pet.do"
      method="post"
      onsubmit="return checkForm()"
    >
      <input type="hidden" name="command" value="login_signupForm" />
      <div id="wrapform">
        <br />
        <h1 id="h1">회원가입</h1>
        <table>
          <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>&nbsp;</th>
            <th>전화번호</th>
            <th>주소</th>
          </tr>
          <tr>
            <td>
              <input
                type="text"
                name="member_id"
                id="member_Id"
                maxlength="20"
                placeholder="  아이디"
                title="n"
                required="required"
                onkeyup="idCheckInit(join);"
              />
              <input type="button" value=" 중복 체크 " onclick="idCheck();" />
            </td>
            <td>
              <input
                type="password"
                name="member_pw"
                maxlength="20"
                placeholder="  비밀번호"
                required="required"
                onclick="idCheckConfirm();"
              />
            </td>
            <td>
              <input
                type="text"
                name="member_name"
                placeholder="  이름"
                required="required"
                onclick="idCheckConfirm();"
              />
            </td>
            <td>
              <input
                type="text"
                name="member_email"
                id="member_email"
                placeholder="  이메일"
                title="n"
                required="required"
                onclick="idCheckConfirm();"
                onkeyup="emailCheckInit(join);"
              />
              <input
                type="button"
                value=" 이메일 인증 "
                onclick="emailCheck();"
              />
              <br />
              <input
                type="text"
                name="member_email_auth"
                id="member_email_auth"
                placeholder="  인증번호를 입력하세요."
                title="n"
                required="required"
                onclick="idCheckConfirm(); emailCheckConfirm();"
                onkeyup="emailauthCheckInit(join);"
              />
              <input
                type="button"
                value=" 인증번호 확인 "
                onclick="emailauthCheck();"
              />
            </td>
            <td>
              <input
                type="text"
                name="member_phone"
                placeholder="  ex) 010-1234-5678"
                maxlength="13"
                required="required"
                onclick="idCheckConfirm();"
              />
            </td>
            <td>
              <input
                type="text"
                name="member_addr"
                id="member_addr"
                placeholder="  기본 주소"
                required="required"
                readonly="readonly"
              />
              <input
                type="button"
                value=" 주소 검색 "
                onclick="searchAddr();"
              />
              <br />
              <input
                type="text"
                name="member_addr_detail"
                id="member_addr_detail"
                placeholder="  상세 주소"
                required="required"
                readonly="readonly"
              />
            </td>
          </tr>
        </table>
        <br />
        <div id="signup">
          <input type="submit" value=" 회원가입 " />
          <input
            type="button"
            value=" 취소 "
            onclick="location.href='/semi_PetDiary/main/main.jsp'"
          />
        </div>
      </div>
    </form>

    <%@include file="/main/footer.jsp"%>
  </body>
</html>
