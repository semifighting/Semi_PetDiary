package com.pet.ft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.model.PetBiz;
import com.pet.ft.model.PetBizImpl;

@WebServlet("/pet_servlet")
public class pet_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		PetBiz biz = new PetBizImpl();
		
		if("community".equals(command)) {
			response.sendRedirect("community/community_main.jsp");
			
		}
		if("community_insert".equals(command)) {
			response.sendRedirect("community/community_insert.jsp");
		}
		
		if("business".equals(command)) {
			response.sendRedirect("business/business_main.jsp");
		} 
		
		/*else if("list".equals(command)) {
			
			List<MemberDto> list = biz.memberList();
			request.setAttribute("list", list);
			dispatch(request, response, "business/memberlist_main.jsp");
			
		} else if("report".equals(command)) {
			
			List<CommunityDto> list = biz.reportList();
			request.setAttribute("list", list);
			dispatch(request, response, "business/reportlist_main.jsp");
			
		} */
		
		else if("change".equals(command)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			String role = request.getParameter("role");
			
			MemberDto dto = new MemberDto();
			dto.setMember_no(no);
			dto.setMember_role(role);
			
			int res = biz.changeRole(dto);
			
			// paging servlet에서 memberList를 보여주고, 권한을 변경하면 pet servlet을 통해 권한 변경 후 paging servelt으로 다시 memberList
			if(res > 0) {
				jsResponse(response, role + " 등급으로 변경", "/semi_PetDiary/paging.do?command=member"); 
			} else {
				jsResponse(response, "변경 실패", "/semi_PetDiary/paging.do?command=member");
			}
		} else if("delete".equals(command)) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.deleteCommnutiy(seq);
			
			// paging servlet에서 reportList를 보여주고, 권한을 변경하면 pet servlet을 통해 삭제 후 paging servelt으로 다시 reportList
			if(res > 0) {
				jsResponse(response, "삭제 성공", "/semi_PetDiary/paging.do?command=report");
			} else {
				jsResponse(response, "삭세 실패", "/semi_PetDiary/paging.do?command=report");
			}
			
		} else if("bookcheck".equals(command)) {
			String date = (String) request.getParameter("test-date"); 
			String time = String.valueOf(request.getParameter("test-time")); 
			
			date = date.replaceAll("[^0-9]", "");
			time = time.replaceAll("[^0-9]", "");
			// 정규 표현식, 0~9의 문자를 제외한 문자는 ""로 치환
			
			List<BookDto> list = biz.totalDateTime();
			String checkout = null;
			for(BookDto dto : list) {
				if(date.equals(dto.getBook_date())) {
					checkout = dto.getBook_date();
					
					int timecheck = Integer.parseInt(dto.getBook_time().replaceAll("[^0-9]", ""));
					int timeall = Integer.parseInt(time);
					int x = 0;
					
					if((timecheck/100) == (timeall/100)) {
						x = timeall - timecheck;
						
					} else {
						x = (timeall - timecheck) - 40;
					}
					
					if(x <= 60 && x >= 10) {
						int y = x / 10;
						String msg = "현재 대기 손님은 " + y + "명 입니다. " + "예샹 대기 시간은 : " + 5 * y + " ~ " + (5 * y + 5) + "분 입니다.";
						
						
						 System.out.println("현재 대기 손님은 " + y + "명 입니다.");
						 System.out.println("예샹 대기 시간은 : " + 5 * y + " ~ " + (5 * y + 5) + "분 입니다.");
						 
						
						jsResponse(response, msg, "pet.do?command=selectBook&booknum="+dto.getBook_num());
					}
					
					
				}
			}
			
			if(!date.equals(checkout)){
				System.out.println("예약 완료되었습니다.");
			}
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script type='text/javascript'>"
						    + "alert('" + msg + "');"
						    + "location.href='" + url + "';"
						    + "</script>";
		response.getWriter().print(responseText);
	}
	
}
