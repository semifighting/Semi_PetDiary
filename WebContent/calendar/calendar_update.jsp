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
<title>일정 수정</title>
<style type="text/css">
	
	#update {
		position : absolute;
		top: 50%;
		left: 50%;
		line-height: 25px;
		transform: translate(-50%, -50%);
	}
	
	#date {
		text-align: center;
		font-size: 18px;
	}

	input[type='text'] { 
	    border:#e4e4e4 1px solid;
	    border-radius:5px;
	    height: 20px;
	    width: 150px;
	}
	
	input[value=' 취소 '] { 
		border: #91dc85 2px solid;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
	
		input[value=' 완료 '] { 
		border: #91dc85 2px solid;
		color: white;
		border-radius:5px;
	    height: 25px;
	    background-color: #91dc85;
	}
	
</style>
<script type="text/javascript">

	function back(){
		history.back();
	}
</script>
</head>
<body>
<%
	String year = (String) request.getAttribute("year");
	String month = (String) request.getAttribute("month");
	String date = (String) request.getAttribute("date");

%>

	<form id="update" action="/semi_PetDiary/pet.do" method="post">
		<div id="date"><%=year %>년 <%=month %>월 <%=date %>일</div>
		<br/>
		<input type="hidden" name="command" value="calendar_calUpdateform"/>
		<input type="hidden" name="calendar_no" value="${dto.calendar_no }"/>
		<input type="hidden" name="member_no" value="${dto.member_no }"/>
		<input type="hidden" name="year" value="<%=year %>"/>
		<input type="hidden" name="month" value="<%=month %>"/>
		<input type="hidden" name="date" value="<%=date %>"/>
		<table>
			<div>일정 : 
				<input type="text" name="calendar_title" value="${dto.calendar_title }"/>
			</div>
			<div> 시작 :
				<input type="text" name="calendar_startdate" 
				value="<%=month %>월 <%=date %>일 <c:out value="${fn:substring(dto.calendar_startdate, 8, 10)}:"/><c:out value="${fn:substring(dto.calendar_startdate, 10, 12)}"/>" readonly="readonly"/>
			</div>
			<div> 종료 :
				<input type="text" name="calendar_startdate" 
				value="<%=month %>월 <%=date %>일 <c:out value="${fn:substring(dto.calendar_enddate, 8, 10)}:"/><c:out value="${fn:substring(dto.calendar_enddate, 10, 12)}"/>" readonly="readonly"/>
			</div>
			<div>필수품 : 
				<input type="text" name="calendar_necessity" value="${dto.calendar_necessity}"/>
			</div>
			<div>세면/화장도구 : 
				<input type="text" name="calendar_item" value="${dto.calendar_item}"/>
			</div>	
			<div>상세 내용 : </div>
				<textarea name="calendar_content" cols="33" rows="10">${dto.calendar_content }</textarea>
			<div>
				<input type="submit" value=" 완료 " />
				<input type="button" value=" 취소 " onclick="back();" />
			</div>
		</table>
	</form>


</body>
</html>