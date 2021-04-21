<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>
<style>
	table {
		bordor-collapse: collapse;
	}
	
	th, td {
		border: 1px solid salmon;
		padding: 5px;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@include file="/main/header.jsp"%>
<%
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int date = Integer.parseInt(request.getParameter("date"));
	int lastday = Integer.parseInt(request.getParameter("lastday"));
	
	Calendar cal = Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
%>

<form action="/semi_PetDiary/pet.do" method="post">
	<input type="hidden" name="command" value="calendar_insert"/>
	<input type="hidden" name="member_no" value="1"/>
	<!-- 나중에 수정 -->
	<div>일정 등록</div>
		<div>
			<input type="text" name="calendar_title" placeholder=" 일정 제목을 입력해 주세요. "/>
		</div>
		<div>시작일자</div>
		<div>
			<select name="s_year">
<%			
				for (int i = year-5; i <= year+5; i++){ //
%>
				<option value="<%=i %>" <%=(year==i)? "selected":"" %> ><%=i %></option>
<%
				}
%>					
				</select>년
				<select name="s_month">
<%
				for (int i = 1; i < 13; i++) {
%>						
				<option value="<%=i %>" <%=(month==i)? "selected": "" %> ><%=i %></option>
<%
				}
%>
			</select>월
			<select name="s_date">
<%
				for (int i = 0; i < lastday; i++) {
%>
				<option value="<%=i %>" <%=(date==i)? "selected": "" %>><%=i %></option>	
<%
				}
%>
			</select>일
			<select name="s_hour">
<%
				for (int i = 0; i < 24; i++) {
						
%>					
				<option value="<%=i %>" <%=(hour==i)? "selected":"" %>><%=i %></option>
<%
				}
%>	
			</select>시
			<select name="s_min">
<%
				for (int i = 0; i < 60; i++) {
%>					
				<option value="<%=i %>" <%=(min==i)? "selected":"" %>><%=i %></option>
<%
				}
%>
			</select>분
	</div>
	<div>
		<div>종료 일자</div>
		<div>
			<select name="e_year">
<%			
				for (int i = year-5; i <= year+5; i++){ // 선택 기준 5년전~5년후
%>
				<option value="<%=i %>" <%=(year==i)? "selected":"" %> ><%=i %></option>
<%
				}
%>					
				</select>년
				<select name="e_month">
<%
				for (int i = 1; i < 13; i++) {
%>						
				<option value="<%=i %>" <%=(month==i)? "selected": "" %> ><%=i %></option>
<%
				}
%>

			</select>월
			<select name="e_date">
<%
				for (int i = 0; i < lastday; i++) {
%>
				<option value="<%=i %>" <%=(date==i)? "selected": "" %>><%=i %></option>	
<%
				}
%>
			</select>일
			<select name="e_hour">
<%
				for (int i = 0; i < 24; i++) {
						
%>					
				<option value="<%=i %>" <%=(hour==i)? "selected":"" %>><%=i %></option>
<%
				}
%>	
			</select>시
			<select name="e_min">
<%
				for (int i = 0; i < 60; i++) {
%>					
				<option value="<%=i %>" <%=(min==i)? "selected":"" %>><%=i %></option>
<%
				}
%>
			</select>분
		</div>
		<div>
			<input type="text" name="calendar_necessity" maxlength="150" placeholder=" 필수품 "/>
		</div>
		<div>
			<input type="text" name="calendar_item" maxlength="150" placeholder=" 아이템 "/>
		</div>
		<div>
			<textarea name="calendar_content" maxlength="1000" placeholder=" 상세 내용을 입력해주세요. "/></textarea>
		</div>
		<div>
			<input type="submit" value=" 일정 등록 "/>
			<input type="button" value=" 취소 " onclick="history.back()"/>	
		</div>
	</div>
</form>
<%@include file="/main/footer.jsp"%>
</body>
</html>