<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script type="text/javascript">
	 onload = function(){
		 var memberid = opener.document.getElementsByName("member_id")[0].value;
		 document.getElementsByName("member_id")[0].value = memberid;
	 }
	 
	 function confirmId(bool){
		 if(bool == "true"){
			 opener.document.getElementsByName("member_id")[0].title = "y";
			 opener.document.getElementsByName("member_pw")[0].focus();
		 } else {
			 opener.document.getElementsByName("member_id")[0].focus();
		 }
		 
		 self.close();
	 }
</script>
</head>
<body>

	<div>
		<div>${member_id }</div>
		<c:choose>
			<c:when test="${idnotused eq 'true' }">
				아이디 생성 가능
			</c:when>
			<c:otherwise>
				중복된 아이디 존재
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<input type="button" value="확인" onclick="confirmId('${idnotused}')" />
	</div>
	
</body>
</html>