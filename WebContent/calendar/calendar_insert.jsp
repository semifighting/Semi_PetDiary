<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>
<style>

	#head {
		font-size: 20px;
		text-align: center;
		padding-bottom: 20px;
	}

	#insert {
		position : absolute;
		top: 50%;
		left: 50%;
		line-height: 30px;
		transform: translate(-50%, -50%);
		text-align: center;
	}
	
	#insert input[type='text'] { 
	    border:#ccc 1px solid;
	    border-radius:5px;
	    height: 25px;
	    width: 250px;

	}
	
	table {
		bordor-collapse: collapse;
	}
	
	th, td {
		border: 1px solid salmon;
		padding: 5px;
	}
	
	#insert input[type='button'] { 
		border: salmon 2px solid;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
	
	#insert input[type='submit'] { 
		border: salmon 2px solid;
		color: white;
		border-radius:5px;
	    height: 25px;
	    background-color: salmon;
	}
	
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%

	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int date = Integer.parseInt(request.getParameter("date"));
	int lastday = Integer.parseInt(request.getParameter("lastday"));
	
	Calendar cal = Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
	
	int member_no = (int) session.getAttribute("member_no");
%>

<form id="insert" action="../pet.do" method="post">
	<input type="hidden" name="command" value="calendar_insert"/>
	<input type="hidden" name="member_no" value="${member_no }"/>
	<!-- 나중에 수정 -->
	<div id="head">일정 등록하기</div>
		<div>
			<input type="text" name="calendar_title" placeholder=" 일정 제목을 입력해 주세요. " required="required"/>
		</div>
		<div>시작일자</div>
		<div>
			<select name="s_year">
				<option value="<%=year%>"><%=year %></option>
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

				<option value="<%=year%>"><%=year %></option>
	
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
			<input type="text" name="calendar_necessity" maxlength="150" placeholder=" 필수품 " required="required"/>
		</div>
		<div>
			<input type="text" name="calendar_item" maxlength="150" placeholder=" 세면/화장도구 " required="required"/>
		</div>
		<div>
			<br/>
			<textarea name="calendar_content" cols="33" rows="10" maxlength="1000" placeholder=" 상세 내용을 입력해주세요. " required="required"/></textarea>
		</div>
		<div>
			<input type="submit" value=" 일정 등록 "/>
			<input type="button" value=" 취소 " onclick="history.back()"/>	
		</div>
	</div>
</form>
</body>
</html>