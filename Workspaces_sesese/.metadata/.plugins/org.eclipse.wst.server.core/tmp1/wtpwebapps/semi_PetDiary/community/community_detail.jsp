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
#community_detail_contentbox{
	position : relative;
	align-self : center;
	border : 1px solid black;
	height: 800px;
	width: 800px;
	margin: 0 auto;
	margin-top : 50px;
}
#community_detail_title{
	height: 100px;
	text-align: center;
}
#community_comment_input_box{
    margin: 0 auto;
    width: 800px;
    border : 1px solid black;
}

#comment_content_input{
	resize: none;
}

.comment_content_box{
    margin: 0 auto;
    width: 750px;

}

</style>

</head>
<body>
<%@include file="/main/header.jsp"%>
	<div id="community_detail_fullbox">
		<div id ="community_detail_contentbox">
			<div id="community_detail_title">
				아무제목
			</div>	
			<div id="community_detail_writer">
				아무 사람 / 아무 일자
			</div>	
			<div id="community_detail_content">
				아무내용
			</div>
		</div>
		<div id="community_comment_box">
			<div id="community_comment_input_box">
				<form  action="#">
					<div class="comment_content_box">
						<input type="text" name="comment_writer">
						<input type="text" name="comment_password">
					</div>
					<div class="comment_content_box">
						<textarea id="comment_content_input" name="comment_box" rows="10" cols="100"></textarea>
					</div>
					<div class="comment_content_box">
						<input type="submit" value="작성">						
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>