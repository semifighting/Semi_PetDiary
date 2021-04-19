<%@page import="java.util.List"%>
<%@page import="com.pet.ft.dto.CommunityDto"%>
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
float : left;
margin-left : 10px;
border : 1px solid black;
width : 230px;
height : 300px;
}



</style>
</head>
<body>
<%@include file="/main/header.jsp"%>

<%List<CommunityDto> list = (List<CommunityDto>)request.getAttribute("list"); %>

	<div>
		<div id="community_search">
			<button onclick="location.href='/semi_PetDiary/pet.do?command=community_insert_form'">글 작성</button>
			<select></select>
			<form action="#">
				<input type="text" name="community_search"/>
				<input type="submit" value="     ">
			</form>
		</div>
	</div>
	<div id="community_table">
			
		<div class="community_row">
<%
		for(CommunityDto cdto : list){
%>
			<div class="commnunity_entity" onclick="location.href='/semi_PetDiary/pet.do?command=community_detail&seq=<%=cdto.getCommunity_seq()%>'">
				<div class="commnuity_title">
					<%=cdto.getCommunity_title() %>
				</div>
				<div class="commnuity_regdate">
					<%=cdto.getCommunity_regdate() %>
				</div>
				<div class="commnuity_content">
					<%=cdto.getCommunity_content() %>
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
<%
			}
%>	
		</div>
	</div>

</body>
</html>