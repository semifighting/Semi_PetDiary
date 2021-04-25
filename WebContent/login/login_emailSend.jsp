<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 전송 안내</title>
</head>
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
		 var member_email = opener.document.getElementsByName("member_email")[0].value;
		 document.getElementsByName("member_email")[0].value = member_email;
	}
	
	function confirmEmail(){
		opener.document.getElementsByName("member_email")[0].title = "y";
		self.close();
	}
</script>
<body>
	<br/><br/><br/>
	<div id="wrap">
		 <p>인증 메일이 발송되었습니다.<p>
		 <p>메일함(${member_email }) 확인 후 인증 번호를 입력해주세요.<p>
		 <p><input type="button" value="확인" onclick="confirmEmail()"/></p>
	</div>

</body>
</html>