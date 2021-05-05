<%@ page language="java" pageEncoding="UTF-8"%> <%
request.setCharacterEncoding("UTF-8"); response.setCharacterEncoding("UTF-8");
%>
<link href="/semi_PetDiary/resources/css/stylesheet.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
<html>
<style>
</style>

  <head>
    <title>Title</title>
    <script  src="https://kit.fontawesome.com/95780683f0.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <nav class="header">
      <div class="header_logo">
        <i class="fas fa-paw"></i>
        <a href="/semi_PetDiary/pet.do?command=myinfo">Pet Diary</a>
      </div>
      <ul class="header_menu">
        <li>
          <a href="/semi_PetDiary/pet.do?command=pet_main&member_no=1">다이어리</a>
        </li>
        <li><a href="#">나와 닮은 동물 찾기</a></li>
        <li>
          <a href="/semi_PetDiary/pet.do?command=hospitalmain">병원상담</a>
        </li>
        <li><a href="/semi_PetDiary/pet.do?command=foodlist">음식/카페</a></li>
        <li><a href="/semi_PetDiary/pet.do?command=community">커뮤니티</a></li>
        <li><a href="/semi_PetDiary/pet.do?command=weather">날씨</a></li>
        <li>
          <form action="#" method="post">
            <input type="text" id="searchBox" />
            <input type="submit" value="검색" />
          </form>
        </li>
      </ul>

      <ul class="header_login">
        <% if(session.getAttribute("member_no") == null) { %>

        <li><a href="/semi_PetDiary/pet.do?command=login_login">로그인</a></li>
        <li>
          <a href="/semi_PetDiary/pet.do?command=login_signup">회원가입</a>
        </li>

        <% } else { %>
        <li>
          <a href="/semi_PetDiary/pet.do?command=login_logout">로그아웃</a>
        </li>
        <% } %>
      </ul>

   		<ul class="header_login">
   			<li><a href="/semi_PetDiary/pet.do?command=login_login">로그인</a></li>
   			<li><a href="/semi_PetDiary/pet.do?command=">회원가입</a></li>
   		</ul>

		<ul class="header_icons">
			<li><a href="/semi_PetDiary/pet.do?command=business"><i class="fas fa-user-circle"></i></a></li>

		</ul>
			<a href="#" class="header_toggleBtn">
					<i class="fas fa-bars"></i>
			</a>

	</nav>	
</body>
</html>
