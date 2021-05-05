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
    	 padding: 30px;
    	 margin: 10px;
    	 border-top: 4px;
		
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
				<div>번호 : <%=bdto.getBusiness_num() %></div>			
				<div>번호 : <%=bdto.getBusiness_role() %></div>			
			

				<div>이름 : <%=bdto.getBusiness_name() %></div>
				<div>주소 : <%=bdto.getBusiness_addr() %></div>
				<div>전화번호 : <%=bdto.getMember_phone() %></div>
				<div>메뉴 : <%=bdto.getMenu_name() %></div>
				<div>가격  : <%=bdto.getMenu_price() %></div>
				<div>주차 : <%=bdto.getBusiness_park() %></div>
				<input type="button" value="예약" onclick="location.href='/semi_PetDiary/pet.do?command=bookform&business_num=<%=bdto.getBusiness_num() %>'" />
			</div>
		</div>

<%
		}
%>




</body>
</html>