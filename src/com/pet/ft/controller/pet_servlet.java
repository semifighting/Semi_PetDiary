package com.pet.ft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;
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
			List<Integer> commentcount = new ArrayList<Integer>();
			for(CommunityDto cdto : list) {
				commentcount.add(dao.CommunityCommentCount(cdto.getCommunity_no())-1);
			}
			request.setAttribute("commentcount", commentcount);
			if(request.getParameter("paging")==null){
				request.getRequestDispatcher(communityDirectory+"main.jsp?paging="+1).forward(request, response);
			}else {
				request.getRequestDispatcher(communityDirectory+"main.jsp?paging="+request.getParameter("paging")).forward(request, response);
			}	
		}
		
		if("community_search".equals(command)) {
			String filter = request.getParameter("filter");
			String search_content = request.getParameter("search_content");
			System.out.println(search_content+filter);
			
			List<CommunityDto> list = dao.CommunitySearchList(filter, search_content);
			request.setAttribute("list", list);

			if(request.getParameter("paging")==null){
				request.getRequestDispatcher(communityDirectory+"search.jsp?&filter="+filter+"&search_content="+search_content+"&paging="+1).forward(request, response);				
			}else {
				request.getRequestDispatcher(communityDirectory+"search.jsp?&filter="+filter+"&search_content="+search_content+"&paging="+request.getParameter("paging")).forward(request, response);				
			}
		}
		
		if("community_report".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int no = Integer.parseInt(request.getParameter("no"));
			CommunityDto olddto = dao.CommunityOne(seq);
			int res = dao.CommunityReport(seq);
			List<CommunityDto> CommentList= dao.CommentList(olddto.getCommunity_no()); 
			request.setAttribute("cdto", dao.CommunityOne(seq));
			request.setAttribute("commentList", CommentList);
			if(res>0) {
				jsResponse(response, "신고가 정상처리 되었습니다", "pet.do?command=community_detail&seq="+no+"&community_no="+olddto.getCommunity_no());
				
			}else {
				request.setAttribute("cdto", dao.CommunityOne(seq));
				jsResponse(response, "신고가 처리가 실패했습니다", "pet.do?command=community_detail&seq="+no+"&community_no="+olddto.getCommunity_no());
			}
		}

		if("community_updateform".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			request.setAttribute("cdto", dao.CommunityOne(seq));
			request.getRequestDispatcher(communityDirectory+"update.jsp").forward(request, response);		
		}
		if("community_insert_form".equals(command)) {
			response.sendRedirect(communityDirectory+"insert.jsp");
		}
		if("community_detail".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			dao.CommunityViews(seq);
			CommunityDto cdto = dao.CommunityOne(seq);
			List<CommunityDto> CommentList= dao.CommentList(cdto.getCommunity_no()); 
			request.setAttribute("cdto", cdto);
			request.setAttribute("commentList", CommentList);
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
				List<CommunityDto> list = dao.CommunityList();
				request.setAttribute("list", list);
				request.getRequestDispatcher(communityDirectory+"main.jsp?paging="+1).forward(request, response);
		
			}else{
				jsResponse(response, "작성 실패", communityDirectory+"insert.jsp");
			}
		}
		if("community_comment".equals(command)) {
			String content = request.getParameter("comment");
			int community_no = Integer.parseInt(request.getParameter("community_no"));
			CommunityDto CDto = new CommunityDto(0, " ", content, null, "N", 0, community_no, 0, 1);
			int res = dao.CommentInsert(CDto);
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "작성 성공", "pet.do?command=community_detail&seq="+request.getParameter("seq")+"&community_no="+request.getParameter("community_no"));
			}else{
				jsResponse(response, "작성 실패", "pet.do?command=community_detail&seq="+request.getParameter("seq")+"&community_no="+request.getParameter("community_no"));
			}
			
		}
		if("community_update".equals(command)) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int seq = Integer.parseInt(request.getParameter("seq"));
			int community_no = Integer.parseInt(request.getParameter("community_no"));
			CommunityDto CDto = new CommunityDto(seq, title, content, null, "N", 0, community_no, 0, 1);
			int res = dao.CommunityUpdate(CDto);
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "수정 성공", "pet.do?command=community_detail&seq="+seq+"&community_no="+community_no);
			}else{
				jsResponse(response, "수정 실패", "pet.do?command=community_detail&seq="+seq+"&community_no="+community_no);
			}
		}

		if("community_comment_update".equals(command)) {
			String content = request.getParameter("content");
			int seq = Integer.parseInt(request.getParameter("seq"));
			int community_no = Integer.parseInt(request.getParameter("community_no"));
			CommunityDto CDto = new CommunityDto(seq, "댓글", content, null, "N", 0, community_no, 0, 1);
			int res = dao.CommunityUpdate(CDto);
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "수정 성공", "pet.do?command=community_detail&seq="+request.getParameter("community_seq")+"&community_no="+community_no);
			}else{
				jsResponse(response, "수정 실패", "pet.do?command=community_detail&seq="+request.getParameter("community_seq")+"&community_no="+community_no);
			}
		}
		
		if("community_update".equals(command)) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int seq = Integer.parseInt(request.getParameter("seq"));
			int community_no = Integer.parseInt(request.getParameter("community_no"));
			CommunityDto CDto = new CommunityDto(seq, title, content, null, "N", 0, community_no, 0, 1);
			int res = dao.CommunityUpdate(CDto);
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "수정 성공", "pet.do?command=community_detail&seq="+seq+"&community_no="+community_no);
			}else{
				jsResponse(response, "수정 실패", "pet.do?command=community_detail&seq="+seq+"&community_no="+community_no);
			}
			
		}
		
		if("community_delete".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int res = dao.CommunityDelete(seq);	
			
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "삭제 성공", "pet.do?command=community");
			}else{
				jsResponse(response, "삭제 실패", "pet.do?command=community");
			}
			
		}

		if("community_comment_delete".equals(command)) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int community_seq = Integer.parseInt(request.getParameter("community_seq"));
			int res = dao.CommunityDelete(seq);				
			if(res>0) {
				//해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
				jsResponse(response, "삭제 성공", "pet.do?command=community_detail&seq="+community_seq);
			}else{
				jsResponse(response, "삭제 실패", "pet.do?command=community_detail&seq="+community_seq);
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
