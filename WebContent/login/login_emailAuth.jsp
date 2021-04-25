<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫 다이어리</title>
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
		 var memberemailauth = opener.document.getElementsByName("member_email_auth")[0].value;
		 document.getElementsByName("member_email_auth")[0].value = memberemailauth;
	}
	
	function confirmEmail(){
		opener.document.getElementsByName("member_email_auth")[0].title = "y"; 	
		
		self.close();
	}
	
</script>
</head>
<body>
	<br/><br/><br/>
	<div id="wrap">
		<div>
			<p>이메일 인증이 완료되었습니다.</p>
			<p>회원가입을 계속 진행해 주세요.</p>
		</div>
		<div><input type="button" value="확인" onclick="confirmEmail()"/></div>
	</div>
</body>
</html>