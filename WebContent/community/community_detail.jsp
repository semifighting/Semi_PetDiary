<%@page import="java.util.List"%>
<%@page import="com.pet.ft.dto.CommunityDto"%>
<%@page import="com.pet.ft.controller.pet_util" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<%
CommunityDto cdto =(CommunityDto)request.getAttribute("cdto");
List<CommunityDto> list = (List<CommunityDto>)request.getAttribute("commentList");
%>
<script type="text/javascript">

	$(function(){
		$('.comment_update').click(function(){
			var seq = $(this).siblings(".comment_seq").val();
			var content = $(this).siblings(".comment_content").val();
			var community_no = <%=cdto.getCommunity_no()%>;
			var community_seq = <%=cdto.getCommunity_seq()%>;
			$(this).parent().replaceWith("<form action='/semi_PetDiary/pet.do' method='get'> <input type='hidden' name='community_seq' value='"+community_seq+"'>  <input type='hidden' name='command' value='community_comment_update'> <input type='hidden' name='community_no' value='"+community_no+"'> <input type='hidden' name='seq' value='"+seq+"'> <textarea id='comment_content_input' name='content' rows='10' cols='100'>"+content+"</textarea> <input type='submit' value='작성'> </form>");
		})
	})
</script>

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

#community_comment_List{
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
			<input type="button" value="신고" onclick="location.href='/semi_PetDiary/pet.do?command=community_report&seq=<%=cdto.getCommunity_seq()%>&no=<%=cdto.getCommunity_seq()%>'">
			<input type="button" value="수정" onclick="location.href='/semi_PetDiary/pet.do?command=community_updateform&seq=<%=cdto.getCommunity_seq()%>'"> 
			<input type="button" value="삭제" onclick="location.href='/semi_PetDiary/pet.do?command=community_delete&seq=<%=cdto.getCommunity_seq()%>'"> 
			<div id="community_detail_title">
				<%=cdto.getCommunity_title() %>
			</div>	
			<div id="community_detail_writer">
				 <%=pet_util.FromMemberNoTogetName(cdto.getMember_no()) %>/<%=cdto.getCommunity_regdate() %>
			</div>	
			<div id="community_detail_content">
				<%=cdto.getCommunity_content() %>
<<<<<<< HEAD
			</div>
			<div onclick="location.href='/semi_PetDiary/pet_sms_servlet'">
				문자 테스트
				
=======
>>>>>>> main
			</div>
		</div>
		<div id="community_comment_box">
			<div id="community_comment_input_box">
				<form  action="/semi_PetDiary/pet.do" method="post">
					<input type='hidden' value="community_comment" name="command" >
					<input type='hidden' value="<%=cdto.getCommunity_no() %>" name="community_no" >
					<input type='hidden' value="<%=cdto.getCommunity_seq() %>" name="seq" >
					<div class="comment_content_box">
						<textarea id="comment_content_input" name="comment" rows="10" cols="100"></textarea>
					</div>
					<div class="comment_content_box">
						<input type="submit" value="작성">						
					</div>
				</form>
			</div>
		</div>
		<div id="community_comment_List">
		<%
			for(CommunityDto commentdto : list){
		%>		
			<div><%=pet_util.FromMemberNoTogetName(commentdto.getMember_no()) %>/<%=commentdto.getCommunity_regdate()%>/<%=commentdto.getCommunity_content() %>
				<input type="button" value="신고" onclick="location.href='/semi_PetDiary/pet.do?command=community_report&seq=<%=commentdto.getCommunity_seq()%>&no=<%=cdto.getCommunity_seq()%>'">
				<input class="comment_update" type="button" value="수정" onclick="comment_update(this, <%=commentdto.getCommunity_seq()%>)"> 
				<input type="button" value="삭제" onclick="location.href='/semi_PetDiary/pet.do?command=community_comment_delete&seq=<%=commentdto.getCommunity_seq()%>&community_seq=<%=cdto.getCommunity_seq() %>'"> 			
				<input type="hidden" class="comment_seq"value="<%=commentdto.getCommunity_seq()%>"> 
				<input type="hidden" class="comment_content"value="<%=commentdto.getCommunity_content()%>"> 
		</div>
			<%
			}
			%>					
		</div>
		
	</div>
</body>
</html>