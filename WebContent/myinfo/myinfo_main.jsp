<%@page import="com.pet.ft.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<<<<<<< HEAD
#myinfo_list{

}

.myinfo_content{
	float : left;
	border : 1px solid black;
	width : 230px;
	height : 300px;
}

=======

.title {
    color: salmon;
    font-weight: 600;
    overflow: hidden;
    text-overflow: ellipsis;
  	white-space: nowrap;
  	font-size: 15pt;
 }
.content {
    margin-top: 15px;
     overflow: hidden;
}

.myinfo_content{
    float: left;
    border: 1px solid #bbb;
    width: 400px;
    height: 200px;
    background-color: white;
    margin: 20px;
    margin-left: 0;
    margin-bottom: 0;
    padding: 50px;

}

.myinfo_content:active{
background-color: #bbb;
}


.container{
	width: 1047px;
    height: 954px;
    margin: 0 auto;
}

#myinfo_list{
	background-color: #f5f6f8;

}
.title_container{
 	padding-bottom: 20px;
    background-color: white;
    height: 24px;
    border-bottom: 1px solid #bbb;
}
.myinfo_content_mid{
	margin: auto;
}

.myinfo_button{
    border: 2px solid salmon;
    background-color: white;
    color: salmon;
    padding: 5px;
    margin-top: 10px;
    border-radius: 4px;

}

.myinfo_button:hover{
    background-color: salmon;
    color: white;
}
.link{
	color:black;
}
.content_in{
	color: #828282;

}
img{
background: transparent;
}



>>>>>>> main
</style>
</head>
<body>
<%@include file="/main/header.jsp"%>
<%
HashMap<String, Integer> map= (HashMap<String, Integer>)request.getAttribute("map");
MemberDto dto = (MemberDto)request.getAttribute("dto");
%>

<div id="myinfo_list">
<<<<<<< HEAD
		<h1 style="text-align: center">내 정보</h1>

		<div class="myinfo_content">내 다이어리
			<table>
				<tr>
					<th>내 반려 동물 수</th>
					<td><%=map.get("CountMyinfoPet") %>
				<tr>
				<tr>
					<th>내가 세운 여행 계획 수
					<td><%=map.get("CountMyinfoCalendar") %>
				<tr>
				<tr>
					<th>내 00 00 000
					<td>000
				<tr>
					
			</table>
		</div>
		
		<div class="myinfo_content">내 게시글
			<table>
				<tr>
					<th>내가 쓴 게시글
					<td><%=map.get("CountMyinfoCommunity") %>
				<tr>
				<tr>
					<th> 내가 쓴 댓글
					<td><%=map.get("CountMyinfoComment") %>
				<tr>
				<tr>
					<th>내가 좋아하는 게시글
					<td>00
				<tr>
					
			</table>
		</div>
		
		<div class="myinfo_content">내 예약 현황 및 결제 내역
			<table>
				<tr>
					<th>내 예약 현황
					<td><%=map.get("CountMyinfoBook") %>
				<tr>
				<tr>
					<th>내 결제 내역
					<td>00
				<tr>
				<tr>
					<th> 내가 갔던 가게와 병원
					<td>00
				<tr>
					
			</table>
		</div>
		
		<div class="myinfo_content">내 정보 수정
			<table>
				<tr>
					<th>아이디
					<td><%=dto.getMember_id()%>
				</tr>
				<tr>
					<th>이름
					<td><%=dto.getMember_name()%>
				</tr>
				<tr>
					<th>전화번호
					<td><%=dto.getMember_phone() %>
				</tr>
				<tr>
					<th>이메일
					<td><%=dto.getMember_email() %>
				</tr>
				<tr>
					<td colspan="2">	
					<input type="button" value="수정" onclick="location.href='/semi_PetDiary/pet.do?command=myinfo_update'">
					<input type="button" value="Business계정 신청" onclick="location.href='/semi_PetDiary/pet.do?command=myinfobusup&member_no=<%=dto.getMember_no()%>'">
					
					</td>
				</tr>
					
			</table>
		</div>
		
		
		
=======
	<div class="title_container">
		<div class="container" style="height : 50px">
				<h3>마이페이지</h3>
		</div>	
	</div>
	<div class="container">
		<div class="myinfo_content">
				<div class="title">내 정보</div>
				<div class="content"><b>아이디</b>   <sapn class="content_in"><%=dto.getMember_id()%></sapn></div>
				<div class="content"><b>이름</b>    <sapn class="content_in"><%= dto.getMember_name()%></sapn></div>
				<div class="content"><b>전화번호</b>    <sapn class="content_in"><%=dto.getMember_phone() %></sapn></div>
				<div class="content"><b>이메일</b>    <sapn class="content_in"><%=dto.getMember_email() %></sapn> </div>
				<input class="myinfo_button" type="button" value="수정" onclick="location.href='/semi_PetDiary/pet.do?command=myinfo_update'">
				<input class="myinfo_button" type="button" value="Business계정 신청" onclick="location.href='/semi_PetDiary/pet.do?command=myinfobusup&member_no=<%=dto.getMember_no()%>'">
		</div>
		<div class="myinfo_content">
				<div class="title"><b>내 다이어리</b></div>
				<div class="content"><b>내 반려 동물 수</b>   <span class="content_in"><%=map.get("CountMyinfoPet") %></span></div>
				<br/>
				<div class="content"><b> 내가 세운 여행 계획</b>   <span class="content_in"><%=map.get("CountMyinfoCalendar") %></span></div>
		</div>
		<div class="myinfo_content" onclick="location.href='/semi_PetDiary/pet.do?command=MyCommunityList'">
				<div class="title"><b>내 게시글</b></div>
				<div class="content"><b>내가 쓴 글</b>   <span class="content_in"><%=map.get("CountMyinfoCommunity")%></span></div>
				<br/>
				<div class="content"><b>내가 쓴 댓글</b>   <span class="content_in"><%=map.get("CountMyinfoComment") %></span></div>
		</div>
		<div class="myinfo_content">
				<div class="title"><b>내 예약현황 및 결제내역</b>   </div>
				<div class="content"><b>내 예약현황</b>   <span class="content_in"><%=map.get("CountMyinfoBook") %></span></div>
				<br/>				
				<div class="content"><b>내 결제내역</b>   <span class="content_in"><%=map.get("CountMyinfoOrder") %></span></div>
		</div>
		
		<div class="myinfo_content" onclick="location.href='#'">
				<div class="title"><b>내 사진첩</b>   </div>
				
		</div>
		
	</div>
>>>>>>> main
 </div>



<%@include file="/main/footer.jsp"%>

</body>
</html>