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
<link rel="stylesheet" href="/semi_PetDiary/resources/css/summernote-lite.css">

<style type="text/css">
#community_insert_contentbox{
	position : relative;
	align-self : center;
	border : 1px solid black;
	height: 800px;
	width: 800px;
	margin: 0 auto;
	margin-top : 50px;
}

#community_insert_title{
	height: 100px;
	text-align: center;
}

#community_insert_input_box{
    margin: 0 auto;
    width: 800px;
    border : 1px solid black;
}
</style>
</head>


<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 780,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 3000자까지 쓸 수 있습니다'	//placeholder 설정
          
	});
});

</script>

<body>
<%@include file="/main/header.jsp"%>
	<form action="/semi_PetDiary/pet.do" method="post" >
	<input type="hidden" name="command" value="community_insert">
		<div id="community_insert_fullbox">
			<div id ="community_insert_contentbox">
				<div id="community_insert_title">
					<input style="width:780px;height:50px"type="text" name="title"/>
				</div>	
				<div id="community_insert_content">
<<<<<<< HEAD
					<textarea style="resize: none;" rows="30" cols="108" name="content"></textarea>
=======
					<textarea id="summernote" name="content"></textarea>
>>>>>>> main
				</div>
				<div id="community_insert_button">
					<input type="submit" value="작성">
					<input type="button" value="돌아가기">
				</div>
			</div>
		</div>
	
	</form>

</body>
</html>