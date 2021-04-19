<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	.hospital_container{
		float: left; width:100%; background-color:#f8f7f2; min-height:500px; padding:50px 0;
	}
	.hospital_name{
		width:100%; font-size:30px; color:black; font-weight:400; text-align:left;
	}
	.detail_box{
		width:100%; margin:30px auto;
	}
	.detail_box_img{
		float:left; width:53%;
	}
	.detail_box_text{
		float:right; width:52%; border-top:3px solid #646361;
	}
	.text_wrap{
		width:100%; padding:0px 0;
	}
	.text_wrap li{
		float:left; width:100%; padding:18px 0; border-bottom:1px solid #dddbd6; 
	}
	.text_wrap li:first-child{
		margin-top:1.7px;
	}
	.text_wrap li dl{
		width:100%;
	}
	.text_wrap li dt{
		float:left; width:21%; font-size:16px; font-style:strong; color:#626262; padding-left:30px; 
	}
	.text_wrap li dd{
		font-size:14px; color: #a1a1a1; line-height:18px; text-align:left; overflow:hidden;
		text-overflow:ellipsis; -webkit-line-clamp:1; -webkit-box-orient:vertical;
		word-break:break-all; display:-webkit-box;
	
	
	}
	
</style>
</head>
<body>

  <%@include file="../main/header.jsp"%>
  <form action="pet.do" method="post">
		<input type="hidden" name="command" value="counselinsertres"/>
	<div class="hospital_container">
		<h3 class="hospital_name">${dto.business_name}</h3>
		<div class="detail_box">
			<div class="detail_box_img"></div>
			<div class="detail_box_text">
				<ul class="text_wrap">
					<li>
						<dl>
							<dt>이름</dt>
							<dd><input type="text" name="member_name"/></dd>
						</dl>
			    	</li>
					<li>
						<dl>
							<dt>연락처</dt>
							<dd><input type="text" name="member_phone"/></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt>상담유형</dt>
							<dd><input type="radio" name="book_type" value="화상상담"/>화상상담</dd>
							<dd><input type="radio" name="book_type" value="챗봇"/>챗봇</dd>
						</dl>
					</li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	
	</div>
	
 </form>

</body>
</html>