<%@ page language="java" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<link href="../resources/css/stylesheet.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">

<html>
<head>
    <title>Title</title>
    <script src="https://kit.fontawesome.com/95780683f0.js" crossorigin="anonymous"></script>
  
</head>
<body>
 	<nav class="header">
		<div class="header_logo">
			<i class="fas fa-paw"></i>
			<a href="">Pet Diary</a>
		</div>
		<ul class="header_menu">
    		
       	 		<li><a href="pet.do?command=diary">다이어리</a></li>
        		<li><a href="#">나와 닮은 동물 찾기</a></li>
       			<li><a href="#">병원상담</a></li>
      			<li><a href="#">음식/카페</a></li>
       			<li><a href="#">커뮤니티</a></li>
       		    <li>
          			 <form action="#" method="post">
            	  		 <input type="text" id="searchBox">
            	  		 <input type="submit" value="검색">
          			 </form>
        		</li>
       			
   		</ul>
   		
   		<ul class="header_login">
   			<li><a href="#">로그인</a></li>
   			<li><a href="#">회원가입</a></li>
   		</ul>
		
		<ul class="header_icons">
			
			<li><a href="#"><i class="fas fa-user-circle"></i></a></li>
		
			
		</ul>
		
		
			<a href="#" class="header_toggleBtn">
					<i class="fas fa-bars"></i>
			</a>
		
	</nav>	
</body>

</html>
