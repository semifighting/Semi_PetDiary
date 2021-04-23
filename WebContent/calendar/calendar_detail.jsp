<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 확인</title>
<style type="text/css">

	#wrap {
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
	
	input[value=' 뒤로가기 '] { 
		border: salmon 2px solid;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
	
	input[value=' 수정 '] { 
		border: salmon 2px solid;
		color: white;
		border-radius:5px;
	    height: 25px;
	    background-color: salmon;
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
	int member_no = (int) session.getAttribute("member_no");
%>

	<div id="wrap">
		<div id="date"><%=year %>년 <%=month %>월 <%=date %>일</div>
		<br/>
		<div>일정 : <input type="text" name="calendar_title" value="${dto.calendar_title }" readonly="readonly"/></div>
		<div> 시작 :
			<input type="text" name="calendar_startdate" 
			value="<%=month %>월 <%=date %>일 <c:out value="${fn:substring(dto.calendar_startdate, 8, 10)}:"/><c:out value="${fn:substring(dto.calendar_startdate, 10, 12)}"/>" readonly="readonly"/>
		</div>
		<div> 종료 :
			<input type="text" name="calendar_startdate" 
			value="<%=month %>월 <%=date %>일 <c:out value="${fn:substring(dto.calendar_enddate, 8, 10)}:"/><c:out value="${fn:substring(dto.calendar_enddate, 10, 12)}"/>" readonly="readonly"/>
		</div>
		<div>필수품 : <input type="text" name="calendar_necessity" value="${dto.calendar_necessity }" readonly="readonly"/></div>
		<div>세면/화장도구 : <input type="text" name="calendar_item" value="${dto.calendar_item }" readonly="readonly"/></div>
		<div>상세 내용 :</div>
		<textarea name="calendar_content" cols="33" rows="10" placeholder="${dto.calendar_content }" readonly="readonly"></textarea>
		<br/>
		<input type="button" value=" 수정 " onclick="location.href='/semi_PetDiary/pet.do?command=calendar_calUpdate&calendar_no=${dto.calendar_no }&year=${year }&month=${month }&date=${date }&member_no=${member_no }'"/>
		<input type="button" value=" 뒤로가기 " onclick="back();" />
	</div>
	
</body>
</html>