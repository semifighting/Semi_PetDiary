<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫 다이어리 : 로그인</title>
<style type="text/css">

	#wrap {
		float: left;
		position : absolute;
		top: 50%;
		left: 50%;
		line-height: 40px;
		transform: translate(-50%, -50%);
		width: 700px;
	}
	#login  {
		float: left;
	}
	
	#social {
		float: right;
	}

	#login input[type='text'] { 
	    border:#ccc 1px solid;
	    border-radius:20px;
	    height: 25px;
	    width: 250px;
	}
	
	#login input[type='password'] { 
	    border:#ccc 1px solid;
	    border-radius:20px;
	    height: 25px;
	    width: 250px;
	}
	
	#login input[value='로그인']{
		width: 250px;
		height: 35px;
		background-color: #ffe3bf;
		color: #4f3a19;
		font-weight: bold;
		font-size: 14px;
		border: white 1px solid;
		margin-top: 10px; 
	}
	
	#others {
		width: 250px;
	}
	
	#d_find {
		float: left;
	}
	
	#find {
		cursor: pointer;
		color: black;
		font-size: 13px;
	}
	
	#d_signup {
		text-align: right;
	}
	
	#signup {
		cursor: pointer;
		color: black;
		font-size: 13px;
	}

</style>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">

	function registForm(){
		location.href="/semi_PetDiary/pet.do?command=login_signup";
	}
	
	function checkForm(){
		var id = document.getElementsByName("member_id")[0];
		var pw = document.getElementsByName("member_pw")[0];
		
		if (id.value.trim() == "" || id.value == null) {
			alert("아이디를 입력해 주세요.");
			return false;
		} else if (pw.value.trim() == "" || pw.value == null) {
			alert("비밀번호를 입력해 주세요.");
			return false;
		} else {
			return true;
		}
	}

</script>
</head>
<body>
<%@include file="/main/header.jsp"%>

<div id="wrap">
	<div id="login">
		<form action="/semi_PetDiary/pet.do" method="post" onsubmit="return checkForm()">
			<input type="hidden" name="command" value="login_loginForm"/>
				<div id="select_login" style="display:inline-block">일반 로그인</div>
				<div>
					<input type="text" name="member_id" maxlength="20" placeholder="  아이디를 입력해 주세요." required="required" /></br/>
					<input type="password" name="member_pw" maxlength="20" placeholder="  비밀번호를 입력해 주세요." required="required" /><br/>
					<input type="submit" value="로그인"/>
				</div>
		</form>
		<div id="others">
			<div id="d_find"><a id="find" onclick="location.href='/semi_PetDiary/login/login_find.jsp'">아이디 | 비밀번호 찾기</a></div>
			<div id="d_signup"><a id="signup" onclick="registForm();">회원 가입</a></div>
		</div>
	</div>			
	<div id="social">
		<div id="select_login">간편 로그인</div>
		<div id="naverLogin">
<%
	    String clientId = "n8OVzf4XjGNAd8jAA6Hi";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode("http://localhost:8787/semi_PetDiary/login.do?command=naver_login", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    session.setAttribute("state", state);
%>
	  		<a href="<%=apiURL%>"><img width="250px" height="40px" src="${pageContext.request.contextPath}/resources/image/naverlogo.png"/></a>			
		</div>
		
		<div id="kakaoLogin">
<%
		String client_id = "39cbfc25bdd943573118565016e1297d";
		String redirect_uri = URLEncoder.encode("http://localhost:8787/semi_PetDiary/login.do?command=kakao_login", "UTF-8");
		String prompt = "login";
		String kakao_apiURL = "https://kauth.kakao.com/oauth/authorize?client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&response_type=code&" + "&state=" + state + "&prompt=" + prompt;
%>
			<a href="<%=kakao_apiURL %>" id="kakao-login-btn">
	    <img src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="250px;"/>
	    </a>
		</div>
	</div>
</div>

  <%@include file="/main/footer.jsp"%>
</body>
</html>