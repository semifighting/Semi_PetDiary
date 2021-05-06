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
	function findPw(){
		self.close();
	}
</script>
</head>
<body>
	<div id="wrap">
		<br/><br/><br/><br/>
		<div>
			<c:choose>
				<c:when test="${resCheck eq 'true' }">
					임시 비밀번호를 메일로 전송했습니다. 메일함을 확인해 주세요.
				</c:when>
				<c:otherwise>
					메일 발송에 오류가 발생했습니다. 다시 시도해주세요.
				</c:otherwise>
			</c:choose>
		</div>
		<br/>
		<div>
			<input type="button" value="확인" onclick="findPw();" />
		</div>
	</div>

</body>
</html>