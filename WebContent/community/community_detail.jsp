<%@page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript">

<%
CommunityDto cdto =(CommunityDto)request.getAttribute("cdto");
List<CommunityDto> list = (List<CommunityDto>)request.getAttribute("commentList");
%>

	$(function(){
		$('.comment_update').click(function(){
			var seq =$(this).siblings("input[name=seq]").val();
			var content =$(this).siblings("input[name=comment_content]").val();
			var community_no =<%=cdto.getCommunity_no()%>;
			var community_seq =<%=cdto.getCommunity_seq()%>;
			$(this).parent().replaceWith("<form action='/semi_PetDiary/pet.do' method='get'> <input type='hidden' name='community_seq' value='"+community_seq+"'>  <input type='hidden' name='command' value='community_comment_update'> <input type='hidden' name='community_no' value='"+community_no+"'> <input type='hidden' name='seq' value='"+seq+"'> <textarea class='comment_content_input' name='content' rows='10' cols='100'>"+content+"</textarea> <input type='submit' value='작성'> </form>");
		})
	})
	
</script>

<link href="/semi_PetDiary/resources/css/stylesheet.css" rel="stylesheet">
<style type="text/css">

#community_detail_contentbox{
	position : relative;
	align-self : center;
	border : 2px solid salmon;
	height: 800px;
	width: 800px;
	margin: 0 auto;
	margin-top : 20px;
	border-bottom: 1px solid #bbb;
}

#community_detail_content{

    margin: 20px;
    margin-right:0px;
    overflow: auto;
    height: 705px;
}	

#community_detail_title{
margin-top : 15px;
	height: 30px;
	text-align: center;	
    font-weight: 600;
    font-size: 15pt;
}

#community_detail_writer{
	text-align: right;	
    font-weight: 600;
    font-size: 10pt;
    border-bottom: 1px solid #ddd;
}

#community_comment_input_box{
    margin: 0 auto;
    width: 800px;
    border: 2px solid salmon;
    height: 210px;
	border-top: none;
	border-bottom: 1px solid #ddd
}

#community_comment_List{
    margin: 0 auto;
    width: 800px;
	border : 2px solid salmon; 
	border-top: none;
}

.comment_content_input{
	resize: none;
}

.comment_content_box{
    margin: 0 auto;
    width: 750px;
}
.comment_input_box{
	margin-top : 20px
}
.detail_button{
	position: absolute;
    border: 2px solid salmon;
    background-color: white;
    color: salmon;
    padding: 5px;
    margin-top: 2px;
    margin-left: 10px;
    border-radius: 4px;
}

.detail_button:hover{
    background-color: salmon;
    color: white;
}


</style>

</head>
<body>
<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm"); //원하는 데이터 포맷 지정 
String strDate = simpleDateFormat.format(cdto.getCommunity_regdate());%> 
<%@include file="/main/header.jsp"%>
	<div id="community_detail_fullbox">
		<div id ="community_detail_contentbox">
			<%if(session.getAttribute("member_no")!=null){ %>
			<div >
				<input class="detail_button" type="button" value="신고" onclick="location.href='/semi_PetDiary/pet.do?command=community_report&seq=<%=cdto.getCommunity_seq()%>&no=<%=cdto.getCommunity_seq()%>'">
					<%if((int)session.getAttribute("member_no")==cdto.getMember_no()){ %>
				<input class="detail_button" style="left:50px" type="button" value="수정" onclick="location.href='/semi_PetDiary/pet.do?command=community_updateform&seq=<%=cdto.getCommunity_seq()%>'"> 
				<input class="detail_button "style="left:100px"  type="button" value="삭제" onclick="location.href='/semi_PetDiary/pet.do?command=community_delete&seq=<%=cdto.getCommunity_seq()%>'"> 
			</div>			
				<%} %>
			<%} %>
			<div id="community_detail_title">
				<%=cdto.getCommunity_title() %>
			</div>	
			<div id="community_detail_writer">
				작성자 : <%=pet_util.FromMemberNoTogetName(cdto.getMember_no()) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 작성일자 : <%=strDate %>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>	
			<div id="community_detail_content">
				<%=cdto.getCommunity_content() %>
			</div>
		</div>
		<%if(session.getAttribute("member_no")!=null) {%>
		<div id="community_comment_box">
			<div id="community_comment_input_box">
				<form  action="/semi_PetDiary/pet.do" method="post">
					<input type='hidden' value="community_comment" name="command" >
					<input type='hidden' value="<%=cdto.getCommunity_no() %>" name="community_no" >
					<input type='hidden' value="<%=cdto.getCommunity_seq() %>" name="seq" >
					<input type='hidden' value="<%=(int)session.getAttribute("member_no") %>" name="member_no" >
					<div class="comment_content_box">
						<textarea class="comment_input_box" class="comment_content_input" name="comment" rows="10" cols="100"></textarea>
					</div>
					<div style="margin-left: 15px;"class="comment_button_box">
						<input class="detail_button" type="submit" value="작성">						
					</div>
				</form>
			</div>
		</div>
		<%} %>
		<div id="community_comment_List">
		<%
			for(CommunityDto commentdto : list){
		%>		
			<div><%=pet_util.FromMemberNoTogetName(commentdto.getMember_no()) %>/<%=simpleDateFormat.format(commentdto.getCommunity_regdate())%>/<%=commentdto.getCommunity_content() %>
				<%if(session.getAttribute("member_no")!=null){ %>
				<input type="button" value="신고" onclick="location.href='/semi_PetDiary/pet.do?command=community_report&seq=<%=commentdto.getCommunity_seq()%>&no=<%=cdto.getCommunity_seq()%>'">
					<%if((int)session.getAttribute("member_no")==commentdto.getMember_no()){ %>
				<input class="comment_update" type="button" value="수정""> 
				<input class="detail_button" type="button" value="삭제" onclick="location.href='/semi_PetDiary/pet.do?command=community_comment_delete&seq=<%=commentdto.getCommunity_seq()%>&community_seq=<%=cdto.getCommunity_seq() %>'"> 			
				<input class="detail_button" type="hidden" name="seq"class="comment_seq" value="<%=commentdto.getCommunity_seq()%>"> 
				<input class="detail_button" type="hidden" name="comment_content"class="comment_content" value="<%=commentdto.getCommunity_content()%>"/> 
					<%} %>
				<%} %>
			</div>
			<%
			}
			%>					
		</div>
		
	</div>
</body>
</html>