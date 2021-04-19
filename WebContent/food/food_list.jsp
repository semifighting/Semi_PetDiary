<%@page import="java.util.List"%>
<%@page import="com.pet.ft.dto.BusinessDto"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.foodlist{
    	 border-top: none;
 		 display: grid;
    	 grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
 		 gap: 3rem 1rem;
    	 padding: 3rem 0;
    	 margin: 0 1.5rem;
    	 border-top: 4px solid #ccc;
		
}


</style>
</head>
<body>
 <%@include file="../main/header.jsp"%>
 <%List<BusinessDto> list = (List<BusinessDto>)request.getAttribute("list"); %>

<%
		for(BusinessDto bdto : list){
%>		
		<div class="foodlist">	
		
				
			
			<div class="foodlist_content">
			<img alt="사진" src="">
				<div>이름 : <%=bdto.getBusiness_name() %></div>
				<div>주소 : <%=bdto.getBusiness_addr() %></div>
				<div>전화번호 : <%=bdto.getMember_phone() %></div>
				<div>메뉴 : <%=bdto.getMenu_name() %></div>
				<div>가겨  : <%=bdto.getMenu_price() %></div>
				<div>주차 : <%=bdto.getBusiness_park() %></div>
				<input type="button" value="예약" onclick="location.href='/semi_PetDiary/pet.do?command=bookpage&seq=${bdto.business_num}'" />
			</div>
			
		</div>





<%
		}
%>




</body>
</html>