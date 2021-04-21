<<<<<<< HEAD
<%@page import="java.util.List"%>
<%@page import="com.pet.ft.dto.CommunityDto"%>
<%@page import="com.pet.ft.controller.pet_util" %>
=======
>>>>>>> ig
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
<<<<<<< HEAD

.commnunity_entity{
float : left;
margin : 2px;
border : 1px solid black;
width : 230px;
height : 300px;
}
#pagaing {
width: 950px;
height: 50px;
bottom: 0;
text-align: center
}
.paging_number{
	color: black;
	font-size: 12pt;
	text-decoration:none;
}
.community_icon{

}

=======
#community_search{
}
.commnunity_entity{
border : 1px solid black;
width : 250px;
height : 300px;
}
>>>>>>> ig
</style>
</head>
<body>
<%@include file="/main/header.jsp"%>
<<<<<<< HEAD

<%List<CommunityDto> list = (List<CommunityDto>)request.getAttribute("list");
  int paging = Integer.parseInt(request.getParameter("paging"));
%>

	<div>
		<div id="community_search">
			<button onclick="location.href='/semi_PetDiary/pet.do?command=community_insert_form'">글 작성</button>
			<form action="/semi_PetDiary/pet.do?" method="post">			
				<input type="hidden" name="command" value="community_search">
				<select name="filter">
					<option value="title">제목</option>
					<option value="writer">내용</option>
					<option value="comment_content">댓글내용</option>
				</select>			
				<input type="text" name="search_content"/>
				<input type="submit" value="검색">
=======
	<div>
		<div id="community_search">
			<button onclick="location.href='/semi_PetDiary/pet.do?command=community_insert'">글 작성</button>
			<select></select>
			<form action="#">
				<input type="text" name="community_search"/>
				<input type="submit" value="     ">
>>>>>>> ig
			</form>
		</div>
	</div>
	<div id="community_table">
<<<<<<< HEAD
			
		<div class="community_row">
<%
		if(paging*12<list.size()){
			for(int i = (paging-1)*12;i<(paging)*12;i++){
%>
			<div class="commnunity_entity" onclick="location.href='/semi_PetDiary/pet.do?command=community_detail&seq=<%=list.get(i).getCommunity_seq()%>&community_no=<%=list.get(i).getCommunity_no()%>'">
				<div class="commnuity_title">
					<%=list.get(i).getCommunity_title() %>
				</div>
				<div class="commnuity_regdate">
					<%=list.get(i).getCommunity_regdate() %>
				</div>
				<div class="commnuity_content">
					<%=list.get(i).getCommunity_content() %>
				</div>
				<div class="commnunity_picture">
					<a href="#"> <img alt="" src=""> </a>
				</div>
				<div class="community_icon">
				댓글 수 	<a class="" href="#"> <img alt="" src=""> </a><%=pet_util.CommunityCommentCount(list.get(i).getCommunity_no())%>
					좋아요 수  <a class="" href="#"> <img alt="" src=""> </a><%=list.get(i).getCommunity_like() %>
					조회 수  <a class="" href="#"> <img alt="" src=""> </a> <%=list.get(i).getCommunity_views() %>
				</div>
			</div>
<%
			}			
		}else{
			for(int i = (paging-1)*12;i<list.size();i++){
%>
			<div class="commnunity_entity" onclick="location.href='/semi_PetDiary/pet.do?command=community_detail&seq=<%=list.get(i).getCommunity_seq()%>'">
				<div class="commnuity_title">
					<%=list.get(i).getCommunity_title() %>
				</div>
				<div class="commnuity_regdate">
					<%=list.get(i).getCommunity_regdate() %>
				</div>
				<div class="commnuity_content">
					<%=list.get(i).getCommunity_content() %>
				</div>
				
=======
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
>>>>>>> ig
				<div class="commnunity_picture">
					<a href="#"> <img alt="" src=""> </a>
				</div>
				<div class="community_icon">
<<<<<<< HEAD
					댓글 수 <a class="" href="#"> <img alt="" src=""> </a> <%=pet_util.CommunityCommentCount(list.get(i).getCommunity_no())%>
					좋아요 수  <a class="" href="#"> <img alt="" src=""> </a><%=list.get(i).getCommunity_like() %>
					조회 수  <a class="" href="#"> <img alt="" src=""> </a> <%=list.get(i).getCommunity_views() %>
				</div>
			</div>
<%
			}
		}
%>	
		</div>
		<div id="pagaing">
			<%
			for(int i =0; i<list.size()/12+1;i++){
			%>
				<span class="paging_number" onclick="location.href='/semi_PetDiary/pet.do?command=community&paging=<%=(i+1)%>'">  <%=i+1 %>  </span>
			<%
			}
			%>
		</div>
		
=======
					<a class="" href="#"> <img alt="" src=""> </a>
					<a class="" href="#"> <img alt="" src=""> </a>
					<a class="" href="#"> <img alt="" src=""> </a>
				</div>
			</div>
		</div>
>>>>>>> ig
	</div>

</body>
</html>