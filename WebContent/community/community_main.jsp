<%@page import="java.util.List"%>
<%@page import="com.pet.ft.dto.CommunityDto"%>
<%@page import="com.pet.ft.controller.pet_util" %>
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

.commnunity_entity{
float : left;
margin : 2px;
border : 1px solid black;
width : 230px;
height : 300px;
}
<<<<<<< HEAD
=======
img{ 

}

>>>>>>> main
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

</style>
</head>
<body>
<%@include file="/main/header.jsp"%>

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
			</form>
		</div>
	</div>
	<div id="community_table">
			
		<div class="community_row">
<%
		if(paging*12<list.size()){
			for(int i = (paging-1)*12;i<(paging)*12;i++){
				CommunityDto dto = list.get(i);
%>

			<div class="commnunity_entity" onclick="location.href='/semi_PetDiary/pet.do?command=community_detail&seq=<%=dto.getCommunity_seq()%>&community_no=<%=dto.getCommunity_no()%>'">
				<div class="commnuity_title">
					<%=dto.getCommunity_title() %>
				</div>
				<div class="commnuity_regdate">
					<%=dto.getCommunity_regdate() %>
				</div>
				<div class="commnuity_content">
<<<<<<< HEAD
					<%=list.get(i).getCommunity_content() %>
=======
			<%if(dto.getCommunity_content().indexOf("<img")>0){ %>
				
				<%if(dto.getCommunity_content().split("<img")[0].length()>30){%>
					<%=dto.getCommunity_content().split("<img")[0].substring(0,30)+"..."%>
				 <%}else{%>
					<%=dto.getCommunity_content().split("<img")[0]%>
					<%} %>
					<%="<img style='width : 230px; height : 140px; object-fit : cover;' "+dto.getCommunity_content().split("<img")[1].split(">")[0]+">" %>
			<%}else{ %>
				<%if(dto.getCommunity_content().length()>140){%>
					<%=dto.getCommunity_content().substring(0,140)+"..."%>
				  <%}else{%>
					<%=dto.getCommunity_content() %>
				<%} %>  	
			<%} %>
>>>>>>> main
				</div>
				<div class="commnunity_picture">
					<a href="#"> <img alt="" src=""> </a>
				</div>
				<div class="community_icon">
				댓글 수 	<a class="" href="#"> <img alt="" src=""> </a><%=pet_util.CommunityCommentCount(dto.getCommunity_no())%>
					좋아요 수  <a class="" href="#"> <img alt="" src=""> </a><%=dto.getCommunity_like() %>
					조회 수  <a class="" href="#"> <img alt="" src=""> </a> <%=dto.getCommunity_views() %>
				</div>
			</div>
<%
			}			
		}else{
			for(int i = (paging-1)*12;i<list.size();i++){
				CommunityDto dto = list.get(i);
%>
			<div class="commnunity_entity" onclick="location.href='/semi_PetDiary/pet.do?command=community_detail&seq=<%=dto.getCommunity_seq()%>'">
				<div class="commnuity_title">
					<%=dto.getCommunity_title() %>
				</div>
				<div class="commnuity_regdate">
					<%=dto.getCommunity_regdate() %>
				</div>
				<div class="commnuity_content">
			<%if(dto.getCommunity_content().indexOf("<img")>0){ %>
				
				<%if(dto.getCommunity_content().split("<img")[0].length()>30){%>
					<%=dto.getCommunity_content().split("<img")[0].substring(0,30)+"..."%>
				 <%}else{%>
					<%=dto.getCommunity_content().split("<img")[0]%>
					<%} %>
					<%="<img style='width : 230px; height : 140px; object-fit : cover;' "+dto.getCommunity_content().split("<img")[1].split(">")[0]+">" %>
			<%}else{ %>
				<%if(dto.getCommunity_content().length()>140){%>
					<%=dto.getCommunity_content().substring(0,140)+"..."%>
				  <%}else{%>
					<%=dto.getCommunity_content() %>
				<%} %>  	
			<%} %>
				</div>
				
				<div class="commnunity_picture">
					<a href="#"> <img alt="" src=""> </a>
				</div>
				<div class="community_icon">
					댓글 수 <a class="" href="#">  </a> <%=pet_util.CommunityCommentCount(dto.getCommunity_no())%>
					좋아요 수  <a class="" href="#">> </a><%=dto.getCommunity_like() %>
					조회 수  <a class="" href="#">  </a> <%=dto.getCommunity_views() %>
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
		
	</div>

</body>
</html>