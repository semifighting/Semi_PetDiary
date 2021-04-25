<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	function findId(){
		self.close();
	}
</script>
</head>
<body>
	<br/><br/><br/><br/>
	<div id="wrap">
		<div>회원님의 아이디는 ${member_id } 입니다.</div>
		<br/>
		<div>
			<input type="button" value="확인" onclick="findId();" />
		</div>
	</div>
</body>
</html>