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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">

	body{
		background-color: #FFF6E3;
	}
	
	.viewMember, 
	.viewReport,
	.member-profile,
	.viewA,
	.viewB{
		position: relative;
	    border: 1px solid lightslategrey;
		cursor:pointer;
		width:150px;
		height:150px;
		border-radius:75px;
		line-height:150px;
		vertical-align:middle;
		font-size:12px;
		text-align:center;
	}
	
	.viewMember{
		background-color: skyblue;
	    margin: 150px 900px;
	    top: 120px;	
	}
	
	.viewReport {
		margin: 150px 1200px;
		background-color: #ff6670;
	}
	
	.member-profile{
   	    background-color: ghostwhite;
	    margin: auto;
	    top: 195px;
	    width: 50px;
	    height: 50px;
	    left: 60px;
	    z-index: 1;
	}
	
	.viewA{
		margin: 250px 1200px;
	    background-color: green;
	    bottom: 1400px;
	    left: 220px;
	}
	
	.viewB{
		margin: 350px 1700px;
		background-color: gray;
		bottom: 1500px;
	}
	
	.viewMember:hover, 
	.viewReport:hover, 
	.viewBook:hover{
		background-color:mistyrose;
	}
	
	.member-box{
	    width: 350px;
	    height: 600px;
	    background-color: whitesmoke;
	    position: relative;
	    left: 300px;
        bottom: 550px;
	    border-radius: 15px;
	    box-shadow: 2px 2px 20px #aaa;
	}
	
	.profile-box{
	    width: 200px;
    	height: 230px;
    	margin: 0px 0px 0px 150px;
	}
	
	.text-box{
	    width: 350px;
	    height: 370px;
	    background-color: white;
	    position: relative;
	    margin: 0px auto;
	    border-radius: 0px 0px 15px 15px;
	}
	
	.profile-camera{
	    width: 100%;
	    height: 100%;
	    object-fit: cover;
	    border-radius: 200px;
	    position: relative;
	    bottom: 30px;
	}
	
	#top { 
	    position: relative;
	    color: #4D3417;
	    font-size: 40px;
	    font-weight: 700;
	    top: 150px;
	    left: 355px;
	}
	
	
	
	#main-background{width: 100%; height: 1219px;}
	
</style>

</head>
<body>

<%@ include file="/main/header.jsp" %>


<%
	PetBiz biz = new PetBizImpl();
	int mRes = biz.totalMember();
	int rRes = biz.totalReport();
	
	System.out.println((int)session.getAttribute("member_no"));
	
%>

	<div id="main-background">
	
		<div id="top"><i class="fas fa-paw"></i>&nbsp;<span>Pet Diary</span></div>
		
		<div class="viewMember" onclick="location.href='/semi_PetDiary/paging.do?command=member'">
			<span>전체 회원 조회 : </span>&nbsp;
			<span class="dot"><%=mRes %></span>
		</div>
	
		<div class="viewReport" onclick="location.href='/semi_PetDiary/paging.do?command=report'">
			<span>신고 글 조회 : </span>&nbsp;
			<span class="dot"><%=rRes %></span>
		</div>
		
		<div class="member-box">
			<div class="profile-box">
				<div class="member-profile">
					<img class="profile-camera" alt="" src="/semi_PetDiary/resources/image/profile-camera.jpg">
				</div>
			</div>
			<div class="text-box">
				
			</div>
		</div>
		
		<div class="viewA" onclick="#">
			<span>조회 : </span>&nbsp;
			<span class="dot"><%=rRes %></span>
		</div>
		
		<div class="viewB" onclick="#">
			<span>조회 : </span>&nbsp;
			<span class="dot"><%=rRes %></span>
		</div>
	</div>
	
	
	
	
<%@ include file="/main/footer.jsp" %>

</body>
</html>