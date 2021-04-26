<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/semi_PetDiary/resources/css/stylesheet.css" rel="stylesheet">
<style type="text/css">
#community_search{
}
.commnunity_entity{
border : 1px solid black;
width : 250px;
height : 300px;
}
</style>
</head>
<body>
<%@include file="/main/header.jsp"%>
	<div>
		<div id="community_search">
			<button onclick="location.href='/semi_PetDiary/pet.do?command=community_insert'">글 작성</button>
			<select></select>
			<form action="#">
				<input type="text" name="community_search"/>
				<input type="submit" value="     ">
			</form>
		</div>
	</div>
	<div id="community_table">
		<div class="community_row">
			<% %>
			<div class="commnunity_entity">
				<div class="commnuity_title">
				아무말 대잔치 아무말
				</div>
				<div class="commnuity_regdate">
				언제언제언제언제
				</div>
				<div class="commnuity_content">
				아무말 대잔치 아무말 대잔치아무말 대잔치아무말 대잔치아무말 대잔치아무말 대잔치아무말 대잔치아무말 대잔치
				</div>
				<div class="commnunity_picture">
					<a href="#"> <img alt="" src=""> </a>
				</div>
				<div class="community_icon">
					<a class="" href="#"> <img alt="" src=""> </a>
					<a class="" href="#"> <img alt="" src=""> </a>
					<a class="" href="#"> <img alt="" src=""> </a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>