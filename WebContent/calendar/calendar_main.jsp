<%@page import="com.pet.ft.dto.CalendarDto"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.pet.ft.model.PetDao"%>
<%@page import="com.pet.ft.model.PetDaoImpl"%>
<%@page import="com.pet.ft.controller.pet_util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title>
<style type="text/css">

	
	table {
		border-collapse:collapse; /*셀 사이 간격 없애기*/
	}
	
	th, td {
		border: 1px solid salmon;
		width: 120px;
		height: 70px;
		text-decoration : none;
		 
	}
	
	caption {
		margin-bottom: 10px;
		font-size: 15px;
	}
	
	#view {
		var color = '#';
		var letters = ['f6c9cc', 'a8c0c0', 'FEBF36', 'FF7238', '6475A0', 'acc7bf', '5e5f67', 'c37070', 'eae160', 'bf7aa3', 'd7d967'];
	
		color += letters[Math.floor(Math.random() * letters.length)];
		document.getElementById('wrap').style.background = color;

	}
	
	
	a{text-decoration: none;
		color: salmon;}
		
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
<%@include file="/main/header.jsp"%>
<%
// 임시
	int member_no = 1;
	pet_util util = new pet_util();
	PetDao dao = new PetDaoImpl();

	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) +1;
	
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	if (paramYear != null && paramYear != "") {
		year = Integer.parseInt(paramYear);
	}
	
	if (paramMonth !=null && paramYear != "") {
		month = Integer.parseInt(paramMonth);
	}
	
	if (month > 12){
		year++;
		month = 1;
	}
	
	if (month < 1){
		year--;
		month = 12;
	}
	
	cal.set(year,month-1,1);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	int lastDay = cal.getActualMaximum(Calendar.DATE);
	
	String yyyyMM = year + util.isTwo(String.valueOf(month));

	List<CalendarDto> list = dao.CalViewList(member_no, yyyyMM);

%>
	<div>
		<form method="post" action="calendar_main.jsp">
			<select name="year">
<%			
				for (int i = year-5; i <= year+5; i++){ //
%>
				<option value="<%=i %>" <%=(year==i)? "selected":"" %> ><%=i %></option>
<%
				}
%>					
				</select>년
				<select name="month">
<%
				for (int i = 1; i < 13; i++) {
%>						
				<option value="<%=i %>" <%=(month==i)? "selected": "" %> ><%=i %></option>
<%
				}
%>
			</select>월
			<input type="submit" value="달력 보기"/>
		</form>
	
		<table>
			<caption>
			<a href="calendar_main.jsp?year=<%=year-1%>&month=<%=month%>">◁</a>
			<a href="calendar_main.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>			
			<%=year %>년 <%=month%>월
			<a href="calendar_main.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
			<a href="calendar_main.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
			</caption>
			<tr>
				<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
			</tr>
			<tr>
				
	<%
		int count = 0;
		for (int i = 0; i < dayOfWeek-1; i++) {
			out.print("<td></td>");
			count++;
		}
			
		for(int d=1; d<=lastDay; d++) {
			count++;
			
			String color="black";
			if (count == 7) {
				color = "blue";
			} else if (count == 1) {
				color = "red";
			}
	%>
				
			<td>
				<a style="color:<%=color%>; cursor: pointer" onclick="location.href='calendar_insert.jsp?year=<%=year%>&month=<%=month%>&date=<%=d%>&lastday=<%=lastDay%>&member_no=<%=member_no%>'"><%=d%></a>
		
				<div id="view">
				<%=util.getCalView(d, list)%>
			</div>	
			</td>
		
	<%
	
		if(count == 7) {
			out.print("</tr><tr>");
			count = 0;
			}
		}
			
		for (int i = 0; i < (7-(dayOfWeek-1 + lastDay)%7)%7; i++){
			out.print("<td></td>");
		}
			
	%>
			</tr>
		</table>
		
		<div>일정 보기</div>
	</div>	
<%@include file="/main/footer.jsp"%>
</body>
</html>