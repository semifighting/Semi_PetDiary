<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function failedEmail(){ 	
		
		self.close();
	}
	
</script>
</head>
<body>

<% String member_email = (String) request.getAttribute("member_email"); %>

	<div>
		<p><%=member_email %> 은 이미 가입된 이메일입니다.</p>
		<p>다른 이메일을 입력해주세요.</p>
	</div>
	
	<div><input type="button" value="확인" onclick="failedEmail()"/></div>

</body>
</html>