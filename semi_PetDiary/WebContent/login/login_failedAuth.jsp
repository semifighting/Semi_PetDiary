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

	function failedAuth(){
			
		self.close();
	}
	
</script>
</head>
<body>


	<div>
		<p>인증번호가 일치하지 않습니다.</p>
		<p>인증번호를 확인해주세요.</p>
	</div>
	<div><input type="button" value="확인" onclick="failedAuth()"/></div>

</body>