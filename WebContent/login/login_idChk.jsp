<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<style type="text/css">
		
	#wrap {
		text-align: center;
	}
		
	input[type='button'] { 
		border: salmon 2px solid;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
</style>
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
	<br/><br/><br/><br/>
	<div id="wrap">
		<div>	
			<c:choose>
				<c:when test="${idnotused eq 'true' }">
					${member_id } 는 생성 가능한 아이디입니다.
				</c:when>
				<c:otherwise>
					중복된 아이디가 존재합니다.
				</c:otherwise>
			</c:choose>
		</div>
		<br/>
		<div>
			<input type="button" value="확인" onclick="confirmId('${idnotused}')" />
		</div>
	</div>
	
</body>
</html>