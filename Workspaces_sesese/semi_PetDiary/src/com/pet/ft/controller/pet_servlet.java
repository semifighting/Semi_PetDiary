package com.pet.ft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
