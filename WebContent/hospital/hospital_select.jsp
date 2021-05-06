<%@page import="com.pet.ft.dto.BusinessDto"%>
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
		 width:100%; background-color:#f8f7f2; min-height:500px; padding:50px 0;
	}
	.hospital_name{
		width:100%; font-size:30px; color:black; font-weight:400; text-align:left; margin-left:120px;
	}
	.detail_box{
		width:100%; margin:30px auto;
	}
	.detail_box_img{
		float:left; width:53%; position:absolute; margin-left:120px; 
	}
	.detail_box_img .himg{
		max-height:270px;min-height:270px; border-radius:20px;
	}
	.detail_box_text{
		float:right; width:52%; border-top:3px solid #646361; position:relative;
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
<%

	BusinessDto dto = (BusinessDto)request.getAttribute("dto");
%>

  <%@include file="../main/header.jsp"%>
  <form action="pet.do" method="post">
		<input type="hidden" name="command" value="counselInsert"/>
		<input type="hidden" name="business_num" value="<%=dto.getBusiness_num()%>"/>
		<input type="hidden" name="member_no" value="<%=dto.getMember_no()%>"/>
		
	<div class="hospital_container">
		<h3 class="hospital_name">${dto.business_name}</h3>
		<div class="detail_box">
			<div class="detail_box_img">
				<img class="himg" src="./resources/image/dodam1.png">
			</div>
			<div class="detail_box_text">
				<ul class="text_wrap">
					<li>
						<dl>
							<dt>상담일자</dt>
							<dd><input type="text" name="book_date"/>  yyyymmdd형식으로 입력해주세요.</dd>
						</dl>
			    	</li>
					<li>
						<dl>
							<dt>상담유형</dt>
							<dd>
								<input type="radio" name="book_counsel" value="화상상담"/>화상상담
								<input type="radio" name="book_counsel" value="챗봇"/>챗봇
							</dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt>예약신청</dt>
							<dd>
								<input type="button"  value="취소" onclick="pet.do?command=hospitalmain"/>
								<input type="submit"  value="예약신청"/>
						    </dd>
						</dl>
					</li>
					
				</ul>
			</div>
		</div>
	
	</div>
	
 </form>

</body>
</html>