<%@page import="com.pet.ft.dto.BusinessDto"%>
<%@page import="com.pet.ft.model.PetBizImpl"%>
<%@page import="com.pet.ft.model.PetBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 모드</title>

<style type="text/css">

	.viewMember, .viewBorder{
		position: fixed	;
		border-bottom : 2px solid black;	
		width:180px;
		height:20px;
		margin : 50px;
		background-color: skyblue;
		text-align: center;
		border-radius: 6px;
	}
	
	.viewMember:hover, .viewBorder:hover{
		background-color:mistyrose;
	}
	
	.viewBorder {
		margin: 100px 50px;
		background-color: #ff6670;
	}
	
</style>

</head>
<body>

<%@ include file="/main/header.jsp" %>

<%
	PetBiz biz = new PetBizImpl();
	int mRes = biz.totalMember();
	int rRes = biz.totalReport();
	
%>

	<!-- <div class="viewMember" onclick="location.href='/semi_PetD	iary/pet.do?command=list'"> -->
	<div class="viewMember" onclick="location.href='/semi_PetDiary/paging.do?'">
		<span>전체 회원 조회 : </span>&nbsp;
		<span class="dot"><%=mRes %></span>
	</div>

	<div class="viewBorder" onclick="location.href='/semi_PetDiary/pet.do?command=report'">
		<span>신고 글 조회 : </span>&nbsp;
		<span class="dot"><%=rRes %></span>
	</div>

<%@ include file="/main/footer.jsp" %>

</body>
</html>