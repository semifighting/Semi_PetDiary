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

	function registForm(){
		location.href="/semi_PetDiary/pet.do?command=login_toSignup";
	}

</script>
</head>
<body>
<%@include file="/main/header.jsp"%>

	<div>
		<form action="/semi_PetDiary/pet.do" method="post" onsubmit="return checkForm()">
			<input type="hidden" name="command" value="login_loginForm"/>
				<div>일반 로그인</div>
				<div>
					<input type="text" name="member_id" maxlength="20" placeholder="아이디를 입력해 주세요." required="required" />
					<input type="text" name="member_pw" maxlength="20" placeholder="비밀번호를 입력해 주세요." required="required" />
					<input type="submit" value="로그인"/>
				</div>
		</form>		
		<div>아이디 | 비밀번호 찾기</div>
		<div onclick="registForm();">회원가입</div>
	</div>			
	
	<div>간편 로그인</div>
			
<%@include file="/main/footer.jsp"%>
</body>
</html>