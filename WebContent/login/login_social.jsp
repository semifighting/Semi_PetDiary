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

	var nameExp = /^[가-힣]{2,15}$/;

	function searchAddr() {
		  var pop = window.open("login/login_addrChk.jsp","pop","width=570,height=420"); 
	}
	
	function jusoCallBack(roadAddrPart1, roadAddrPart2,addrDetail){
			// 팝업페이지에서 주소입력한 정보를 받아서 현 페이지에 정보를 등록함
			document.getElementById("member_addr").value = roadAddrPart1;
			document.getElementById("member_addr_detail").value = roadAddrPart2 +" "+ addrDetail;
	}
	
	function checkForm(){
		var name = document.getElementsByName("member_name")[0];
		var addrDetail = document.getElementsByName("member_addr_detail")[0];
		if (addrDetail.value.trim() == "" || addrDetail.value == null) {
			alert("주소를 정확히 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
<%@include file="/main/header.jsp"%>

<%
	String member_id = (String) request.getAttribute("member_id");
	String member_email = (String) request.getAttribute("member_email");
	String member_name = (String) request.getAttribute("member_name");
	String member_phone = (String) request.getAttribute("member_phone");

%>

	<div>회원가입 진행을 위한 추가 정보를 입력해 주세요.</div>
	
	<form id="login_social" action="/semi_PetDiary/login.do" method="get" onsubmit="return checkForm()">
		<input type="hidden" name="command" value="social_signUp"/>
		<input type="hidden" name="member_id" value="<%=member_id%>"/>
		<input type="hidden" name="member_name" value="<%=member_name%>"/>
		<input type="hidden" name="member_email" value="<%=member_email%>"/>
		<input type="hidden" name="member_phone" value="<%=member_phone%>"/>
		
		<div>주소</div>
		<div>
			<input type="text" name="member_addr" id="member_addr" placeholder=" 기본 주소" required="required" readonly="readonly" onclick=""/>
			<input type="button" value=" 주소 검색 " onclick="searchAddr();"/> <br/>
			<input type="text" name="member_addr_detail" id="member_addr_detail" placeholder=" 상세 주소" required="required" readonly="readonly" onclick=""/>
		</div>
		<div>
			<div id="signup">
				<input type="submit" value=" 회원가입 "/>
				<input type="button" value=" 취소 "/>
			</div>
		</div>
	</form>
	
<%@include file="/main/footer.jsp"%>
</body>
</html>