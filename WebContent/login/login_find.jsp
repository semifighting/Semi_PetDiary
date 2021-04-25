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
<title>아이디 / 비밀번호 찾기</title>
<style type="text/css">

	#wrap {
		position : absolute;
		top: 50%;
		left: 50%;
		line-height: 40px;
		transform: translate(-50%, -50%);
	}
	
	table{
		display:flex;
		display: -webkit-box;
		display: -ms-flexbox;
		overflow-x: auto;
		overflow-y: hidden;
	}

	tbody
	{display:flex}
	
	table tr th {
		font-size: 14px;
	}
	
	th {width: 100px;
		text-align: left;
		font-weight: normal;
		}
	
	th,td{display:block}
	
	input[type='button']{
		cursor: pointer;
	}
	
	input[type='text'] { 
	    border:#ccc 1px solid;
	    border-radius:15px;
	    height: 25px;
	    width: 200px;
	}

	input[value=' 입력 '], input[value= ' 임시 비밀번호 발송 '] { 
		border: salmon 2px solid;
		color: white;
		border-radius:5px;
	    height: 25px;
	    background-color: salmon;
	}
	
	input[value=' 로그인 페이지로 이동 '] { 
		border: salmon 2px solid;
		color: black;
		border-radius:5px;
	    height: 25px;
	    background-color: white;
	}
	
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	function findId(){
		var name = document.getElementsByName("member_name")[0].value;
		var email = document.getElementsByName("member_email")[0].value;
		if (name.trim() == "" || name == null){
			alert("아이디를 입력해 주세요.");
		} else if (email.trim() == "" || email == null) {
			alert("이메일을 입력해 주세요.");
		} else {
			open("/semi_PetDiary/login.do?command=login_findId&member_name="+name+"&member_email="+email, "", "width=350, height=280");
		}
	}
	
	function findPw(){
		var name = document.getElementsByName("member_name")[1].value;
		var email = document.getElementsByName("member_email")[1].value;
		var id = document.getElementsByName("member_id")[0].value;
		if (name.trim() == "" || name == null) {
			alert("이름을 입력해 주세요.");
		} else if (email.trim() == "" || email == null) {
			alert("이메일을 입력해 주세요.");
		} else if (id.trim() == "" || id == null) {
			alert("아이디를 입력해 주세요.");
		} else {
			open("/semi_PetDiary/login.do?command=login_findPw&member_name="+name+"&member_email="+email+"&member_id="+id, "", "width=350, height=280");
		}
	}

	
</script>
</head>
<body>
<%@include file="/main/header.jsp"%>
<br/>
<div id="wrap">	
	<br/>
	<div>아이디 찾기</div>
	<table>
		<tr>
			<th>이름 :</th>
			<th>이메일 :</th>
			<th>&nbsp;</th>
		</tr>
		<tr>
			<td><input type="text" name="member_name" id="member_name"/></td>
			<td><input type="text" name="member_email" id="member_email"/></td>
			<td>
				<input type="button" value=" 입력 " onclick="findId();"/>
				<input type="button" value=" 로그인 페이지로 이동 " onclick="location.href='/semi_PetDiary/login/login_login.jsp'"/>
			</td>
		</tr>
	</table>
	<div id="idResult"></div>
	<br/>
	<div>비밀번호 찾기</div>
	<table>
		<tr>
			<th>이름 :</th>
			<th>아이디 :</th>
			<th>이메일 :</th>
			<th>&nbsp;</th>
		</tr>
		<tr>
			<td><input type="text" name="member_name"/></td>
			<td><input type="text" name="member_id"/></td>
			<td><input type="text" name="member_email"/></td>
			<td><input type="button" id="" value=" 임시 비밀번호 발송 " onclick="findPw();"></td>
		</tr>
	</table>
	<div id="idResult"></div>
</div>

<%@include file="/main/footer.jsp"%>
</body>
</html>