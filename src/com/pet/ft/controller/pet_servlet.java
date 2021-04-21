package com.pet.ft.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.model.BusinessDao;
import com.pet.ft.model.BusinessDaoImpl;
import com.pet.ft.model.PetBiz;
import com.pet.ft.model.PetBizImpl;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;

@WebServlet("/pet_servlet")
public class pet_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String command = request.getParameter("command");
		System.out.println(command);
		PetDao dao = new PetDaoImpl();
		String communityDirectory = "community/community_";
		
		if("community".equals(command)) {
			List<CommunityDto> list = dao.CommunityList();
			request.setAttribute("list", list);
			request.getRequestDispatcher(communityDirectory+"main.jsp").forward(request, response);
		}

		if("community_insert_form".equals(command)) {
			response.sendRedirect(communityDirectory+"insert.jsp");
		}
		if("community_detail".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			CommunityDto cdto = dao.CommunityOne(seq);
			request.setAttribute("cdto", cdto);
			request.getRequestDispatcher(communityDirectory+"detail.jsp").forward(request, response);
			
		}
		
		
		if("community_insert".equals(command)){
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("content");
			System.out.println(content);
			System.out.println("내부");
			//-----------------------------id 로그인 생기면 마지막파라미터(회원번호)바꾸기
			CommunityDto CDto = new CommunityDto(0, title, content, null, "N", 0, 0, 0, 1);
			int res = dao.CommunityInsert(CDto);
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "작성 성공", communityDirectory+"detail.jsp");
			}else{
				jsResponse(response, "작성 실패", communityDirectory+"insert.jsp");
			}
			
			
		}
		PetBiz biz = new PetBizImpl();
		//병원상담
		if(command.equals("hospitalmain")) {
			List<BusinessDto> list = biz.hospitalList();
			request.setAttribute("list", list);
			dispatch(request, response, "./hospital/hospital_main.jsp");
		}else if(command.equals("hospitalselect")) {
			int business_num = Integer.parseInt(request.getParameter("business_num"));
			BusinessDto dto = biz.hospitalSelect(business_num);
			request.setAttribute("dto", dto);
			dispatch(request,response,"./hospital/hospital_select.jsp");
			
		}
		//식당,카페 리스트
		BusinessDao bdao = new BusinessDaoImpl();
		if(command.equals("foodlist")) {
			List<BusinessDto> list = bdao.BusinessList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("food/food_list.jsp").forward(request, response);
		}
		if(command.equals("bookform")) {
			int business_num = Integer.parseInt(request.getParameter("business_num"));
			BusinessDto bdto = bdao.businessOne(business_num);
			request.setAttribute("bdto", bdto);
			System.out.println(bdto.getBusiness_name());
			dispatch(request, response,"./food/food_book.jsp");
			
		}
//		if(command.equals("bookinsert")) {
//			DateFormat dateFormat = new SimpleDateFormat();
//			Date book_date = null;
//			try {
//				book_date = dateFormat.parse(request.getParameter("book_date"));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			int book_store = Integer.parseInt(request.getParameter("business_num"));
//			String book_time = request.getParameter("book_time");
//			String book_type = request.getParameter("business_role"); //book_type, business_role 둘다 올수 있는 값이 h,s
//			BookDto bokdto = new BookDto(0, book_date, book_time, book_type, book_store, 1, 0, null, null);
//			response.sendRedirect("./food/book_list.jsp");
//			int res = bdao.bookInsert(bokdto); 
//			
//		}
//	
	
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script>"
							+ "alert('"+msg+"');"
							+ "location.href='"+url+"';"
							+ "</script>;";
		response.getWriter().append(responseText);
	}		
}
