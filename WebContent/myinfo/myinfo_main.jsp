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
#myinfo_list{

}

.myinfo_content{
	float : left;
	border : 1px solid black;
	width : 230px;
	height : 300px;
}

</style>
</head>
<body>
<%@include file="/main/header.jsp"%>
<%
HashMap<String, Integer> map= (HashMap<String, Integer>)request.getAttribute("map");
MemberDto dto = (MemberDto)request.getAttribute("dto");
%>

<div id="myinfo_list">
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
					<td>
						<a style="color:black;" href="/semi_PetDiary/pet.do?command=listmycommnunity" ><%=map.get("CountMyinfoCommunity") %></a>
					</td>
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
					<td>
						<a style="color:black;" href="/semi_PetDiary/paging.do?command=book" ><%=map.get("CountMyinfoBook") %></a>
					</td>
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
		
		
		
 </div>



<%@include file="/main/footer.jsp"%>

</body>
</html>