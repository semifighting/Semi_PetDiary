<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/main/header.jsp" %>
	
	
<%
	int r = Integer.parseInt(request.getParameter("booknum"));

	System.out.println(r);
%>	
	
	
	<%@ include file="/main/footer.jsp" %>

</body>
</html>