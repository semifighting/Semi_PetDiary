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

	function failedAuth(){
			
		self.close();
	}
	
</script>
</head>
<body>
	<br/><br/><br/>
	<div id="wrap">
		<div>
			<p>인증번호가 일치하지 않습니다.</p>
			<p>인증번호를 확인해주세요.</p>
		</div>
		<div><input type="button" value="확인" onclick="failedAuth()"/></div>
	</div>
</body>