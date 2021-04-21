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
.book{
width: 30%;
border: 1px dotted red;
margin-left:730px;
margin-top: 50px;
align-content: center;

}
.book_content{
margin-left:70px;
height: 50px;

}



</style>
</head>
<body>
<%@include file="../main/header.jsp"%>
<%BusinessDto bdto = new BusinessDto(); %>

	<form action="/semi_PetDiary/pet.do" method="post">
	<input type="hidden" name="command" value="bookinsert"/>

	<input type="hidden" name="role" value="<%=bdto.getBusiness_role() %>">
	<input type="hidden" name="num" value="<%=bdto.getBusiness_num() %>">
	<input type="hidden" name="member_no" value="<%=bdto.getMember_no() %>">
		<div class="book">
		<h3><%=bdto.getBusiness_name() %></h3><!-- 왜 데이터를 못받아온거지?왜 null이지... -->
		<h3>예약페이지 입니다.</h3>
			<div>
				<div class="book_content"><span>예약일자</span><input type="text" name="book_date"></div>
			</div>		
			<div>
				<div class="book_content"><span>예약시간</span><input type="text" name="book_time"></div>
			</div>		
			<div>
				<input type="submit" value="예약확인">
				<input type="button" value="취소" onclick="">
			</div>		
		</div>
	
	</form>


</body>
</html>