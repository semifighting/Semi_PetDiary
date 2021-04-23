<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/semi_PetDiary/resources/js/script.js"></script>
<style type="text/css">
	
	h2{width:200px; margin: 10px auto;}
	#table {display: table; width: 60%; margin: 20px auto;}
	.row {display: table-row;}
	.main{background-color: salmon; color:white; text-align: center;}
	.cell {display: table-cell; padding: 3px; border: 0.5px solid #DDD; text-align: center;}
	.col1 {width: 1%;}
	.col2 {width: 2%;}
	.col3 {width: 1%;}
	.col4 {width: 2%;}
	.col5 {width: 1%;}
	.col6 {width: 2%;}
	.col7 {width: 1%;}
	
	.paginate{margin: 0px auto; width: 200px; text-align: center;}
	.paginate a	{color:black;}
		
</style>
</head>
<body>

<%@ include file="/main/header.jsp" %>

	<h2>예약 조회</h2>

	<div id="table">
		<div class="row main">
			<span class="cell col1">예약 번호</span>
			<span class="cell col2">예약자 성명</span>
			<span class="cell col3">예약 업체</span>
			<span class="cell col4">예약 시간</span>
		</div>
		
		<c:forEach items="${list }" var="dto" varStatus="stat">
			<div class="row">
				<span class="cell col1">${dto.book_num }</span>
				<span class="cell col2">${dto.memberVO.member_name }</span>
				<span class="cell col3">${dto.businessVO.business_name }</span>
				<span class="cell col4">${dto.book_date}</span>
			</div>
		</c:forEach>
	</div>
	
	<jsp:include page="/main/paging.jsp" flush="true">
		<jsp:param name="servletPath" value="${servletPath }"/>
		<jsp:param name="recordsPerPage" value="${paging.recordsPerPage }"/>
		<jsp:param name="firstPageNo" value="${paging.firstPageNo }"/>
		<jsp:param name="prevPageNo" value="${paging.prevPageNo }"/>
		<jsp:param name="startPageNo" value="${paging.startPageNo }"/>
		<jsp:param name="currentPageNo" value="${paging.currentPageNo }"/>
		<jsp:param name="endPageNo" value="${paging.endPageNo }"/>
		<jsp:param name="nextPageNo" value="${paging.nextPageNo }"/>
		<jsp:param name="finalPageNo" value="${paging.finalPageNo }"/>
	</jsp:include>

<%@ include file="/main/footer.jsp" %>

</body>
</html>