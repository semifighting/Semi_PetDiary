<%@page import="com.pet.ft.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	#list tr td {
		padding: 10px;
	}
	
	#list tr td a {
		text-decoration: none;
		color: black;
	}

	#list input[value='삭제'] { 
		border: white 2px solid;
		border-radius:5px;
	    background-color: #91dc85;
	    color: white;
	}
	
	#list input[value='닫기'] { 
		border: #91dc85 2px solid;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
	
	#close{
		text-align: center;
	}

</style>
<script type="text/javascript">
</script>
</head>
<body>
<%
	String year = (String) request.getAttribute("year");
	String month = (String) request.getAttribute("month");
	String date = (String) request.getAttribute("date");
	int member_no = (int) session.getAttribute("member_no");

%>

	<form id="list" action = "/semi_PetDiary/pet.do" method="post">
		<table>
			<col width="150"/>
			<col width="200"/>
			<col width="200"/>
			<col width="20"/>
			<tr>
				<th>일정</th>
				<th>시작</th>
				<th>종료</th>
			</tr>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td><a href="/semi_PetDiary/pet.do?command=calendar_calDetail&&calendar_no=${dto.calendar_no }&year=${year }&month=${month }&date=${date }">${dto.calendar_title }</a></td>
						<td>
						<%=month %>월 <%=date %>일
						<c:out value="${fn:substring(dto.calendar_startdate, 8, 10)}:"/>
						<c:out value="${fn:substring(dto.calendar_startdate, 10, 12)} ~"/>
						</td>
						<td>
						<%=month %>월 <%=date %>일
						<c:out value="${fn:substring(dto.calendar_enddate, 8, 10)}:"/>
						<c:out value="${fn:substring(dto.calendar_enddate, 10, 12)}"/>
						</td>
						<td>
							<input type="button" value="삭제" onclick="location.href='/semi_PetDiary/pet.do?command=calendar_calDelete&calendar_no=${dto.calendar_no }&year=${year }&month=${month }&date=${date }&member_no=<%=member_no%>'"/>
						</td>
					</tr>
				</c:forEach>
		</table>
		<br/>
		<br/>
		<div id="close">
			<input type="button" value="닫기" onclick="window.close()";/>
		</div>	
	</form>
</body>
</html>