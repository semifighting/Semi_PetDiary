<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/semi_PetDiary/resources/css/stylesheet.css" rel="stylesheet">
<style type="text/css">
#community_update_contentbox{
	position : relative;
	align-self : center;
	border : 1px solid black;
	height: 800px;
	width: 800px;
	margin: 0 auto;
	margin-top : 50px;
}

#community_update_title{
	height: 100px;
	text-align: center;
}

#community_update_input_box{
    margin: 0 auto;
    width: 800px;
    border : 1px solid black;
}
</style>
</head>


<body>
<%@include file="/main/header.jsp"%>
	<form action="#" method="post" >
		<div id="community_update_fullbox">
			<div id ="community_update_contentbox">
				<div id="community_update_title">
					<input style="width:780px;height:50px"type="text" name="title">
				</div>	
				<div id="community_update_content">
					<textarea style="resize: none;" rows="30" cols="108"></textarea>
				</div>
				<div id="community_update_button">
					<input type="submit" value="작성">
					<input type="button" value="돌아가기">
				</div>
			</div>
		</div>
	
	</form>

</body>
</html>