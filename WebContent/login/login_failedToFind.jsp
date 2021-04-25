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
	function confirm(){
		self.close();
	}
</script>
</head>
<body>
	<div id="wrap">
		<br/><br/><br/><br/>
		<div>
			정보가 일치하는 회원이 없습니다.
		</div>
		<br/>
		<div>
			<input type="button" value="확인" onclick="confirm();" />
		</div>
	</div>
</body>
</html>