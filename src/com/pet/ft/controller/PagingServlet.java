package com.pet.ft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.ft.dto.MemberDto;
import com.pet.ft.model.PetBiz;
import com.pet.ft.model.PetBizImpl;
import com.pet.ft.paging.Paging;

@WebServlet("/paging.do")
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int currentPageNo = 1;
		int recordsPerPage = 0;
		String url = null;
		
		PetBiz biz = new PetBizImpl();
		int mRes = biz.totalMember();
		
		if(request.getParameter("pages") != null)
			currentPageNo = Integer.parseInt(request.getParameter("pages"));
		
		if(request.getParameter("lines") != null)
			recordsPerPage = Integer.parseInt(request.getParameter("lines"));
		
		Paging paging = new Paging(currentPageNo, recordsPerPage);
		
		int offset = (paging.getCurrentPageNo() -1) * paging.getRecordsPerPage();
		
		List<MemberDto> list = biz.memberList();
		
		paging.setNumberOfRecords(biz.totalMember());
		
		paging.makePaging();
		
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("paging", paging);
			request.setAttribute("servletPath", "paging.do");
			
			url = "business/memberlist_main.jsp";
		} else {
			request.setAttribute("msg", "Error�� �߻��߽��ϴ�.");
			
			url = "business/business_main.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
