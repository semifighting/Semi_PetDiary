package com.pet.ft.controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;
import com.pet.ft.model.PetBiz;
import com.pet.ft.model.PetBizImpl;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.model.BusinessDao;
import com.pet.ft.model.BusinessDaoImpl;

import com.pet.ft.model.PetBizImpl;
import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;
import com.pet.ft.paging.Paging;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/pet_servlet")
public class pet_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String command = request.getParameter("command");
		System.out.println(command);
		
		HttpSession session = request.getSession();
		
		PetDao dao = new PetDaoImpl();
		String communityDirectory = "community/community_";
		String CalendarDirectory = "calendar/calendar_";
		String loginDirectory = "login/login_";


		PetBiz biz = new PetBizImpl();


		if("business".equals(command)) {
			response.sendRedirect("business/business_main.jsp");
		} else if("list".equals(command)) {

			List<MemberDto> list = biz.memberList();
			request.setAttribute("list", list);
			dispatch(request, response, "business/memberlist_main.jsp");

		} else if("change".equals(command)) {

			int no = Integer.parseInt(request.getParameter("no"));
			String role = request.getParameter("role");

			MemberDto dto = new MemberDto();
			dto.setMember_no(no);
			dto.setMember_role(role);

			int res = biz.changeRole(dto);

			if(res > 0) {
				jsResponse(response, role + "등급으로 변경", "/semi_PetDiary/pet.do?command=list");
			} else {
				jsResponse(response, "변경 실패", "/semi_PetDiary/pet.do?command=business");
			}
		} else if("report".equals(command)) {

			List<CommunityDto> list = biz.reportList();
			request.setAttribute("list", list);
			dispatch(request, response, "business/reportlist_main.jsp");

		} else if("delete".equals(command)) {

			int seq = Integer.parseInt(request.getParameter("seq"));

			int res = biz.deleteCommnutiy(seq);

			if(res > 0) {
				jsResponse(response, "삭제 성공", "/semi_PetDiary/pet.do?command=report");
			} else {
				jsResponse(response, "삭제 실패", "/semi_PetDiary/pet.do?command=report");
			}
		}


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


		//병원상담
		int currentPageNo = 1;
		int recordsPerPage = 0;
		if(command.equals("hospitalmain")) {


			if(request.getParameter("pages") != null)
				currentPageNo = Integer.parseInt(request.getParameter("pages"));

			if(request.getParameter("lines") != null)
				recordsPerPage = Integer.parseInt(request.getParameter("lines"));
				Paging paging = new Paging(currentPageNo, recordsPerPage);
				int offset = (paging.getCurrentPageNo()-1)*paging.getRecordsPerPage();

				List<BusinessDto> list = biz.hospitalList(offset, paging.getRecordsPerPage()*currentPageNo);
				paging.setNumberOfRecords(biz.totalHospital());
				paging.makePaging();
				
			if(list != null) {
				request.setAttribute("list", list);
				request.setAttribute("paging", paging);
				dispatch(request,response,"./hospital/hospital_main.jsp");
			}else {
				jsResponse(response, "에러", "pet.do?command=hospitalmain");
			}


			

		}else if(command.equals("hospitalselect")) {
			int business_num = Integer.parseInt(request.getParameter("business_num"));
			BusinessDto dto = biz.hospitalSelect(business_num);
			request.setAttribute("dto", dto);
			dispatch(request,response,"./hospital/hospital_select.jsp");



		}else if(command.equals("counselinsert")) {
			String book_date = request.getParameter("book_date");
			String book_counsel = request.getParameter("book_counsel");
			int business_num = Integer.parseInt("business_num");
			int member_no = Integer.parseInt("member_no");

			BookDto dto = new BookDto();
			dto.setBook_date(book_date);
			dto.setBook_counsel(book_counsel);
			dto.setBusiness_num(business_num);
			dto.setMember_no(member_no);


			int res = biz.hospitalBookInsert(dto);
			if(res>0) {
				jsResponse(response, "예약성공", "pet.do?command=hospitalmain");
			}else {
				jsResponse(response, "예약실패", "./hospital/hospital_select.jsp");

			}
		}
		// 내가 작성
		// 회원가입 페이지로 이동
		if("login_signup".equals(command)) {
			response.sendRedirect(loginDirectory+"signup.jsp");
		}
		if("login_idchk".equals(command)) {
			String member_id = request.getParameter("member_id");
			MemberDto dto = dao.SignUpIdChk(member_id);
			boolean idnotused = true;
			if (dto != null) {
				idnotused = false;
			}
			System.out.println(idnotused);
			request.setAttribute("member_id", member_id);
			request.setAttribute("idnotused", idnotused);
			dispatch(request, response, loginDirectory+"idChk.jsp");
		}


		// 회원가입 메일 발송 smtp
		if ("login_emailchk".equals(command)) {
			String member_email = request.getParameter("member_email");
			MemberDto dto = dao.SighUpEmailChk(member_email);
			if(dto == null){

			String from = "semiproject.pet@gmail.com";
			String fromName = "관리자";
			String to = request.getParameter("member_email");

			Properties props = new Properties();
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			StringBuffer temp =new StringBuffer();
			Random ran = new Random();
			for(int i=0;i<10;i++)
			{
				int rIndex = ran.nextInt(3);
				switch (rIndex) {
					case 0:
					// a-z
					temp.append((char)((int)(ran.nextInt(26)) + 97));
					break;
					case 1:
					// A-Z
					temp.append((char)((int)(ran.nextInt(26)) + 65));
					break;
					case 2:
					// 0-9
					temp.append((ran.nextInt(10)));
					break;
				}
			 }

			String AuthenticationKey = temp.toString(); // 인증번호 인증을 위한 키 등록



			

					
					
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from,"testpet03");
					}
			});
			
			// 이메일 전송
			try {
				InternetAddress addr = new InternetAddress();
				addr.setPersonal(fromName, "UTF-8");
				addr.setAddress(from);


				Message msg = new MimeMessage(mailSession);


				msg.setFrom(addr);

				msg.setSubject(MimeUtility.encodeText("[펫 다이어리] 회원가입 이메일 인증번호", "UTF-8","B"));

				msg.setContent("이메일 인증번호는 [" + temp + "] 입니다.", "text/html; charset=UTF-8");
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				Transport.send(msg);

			} catch (Exception e) {
				e.printStackTrace();
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('오류가 발생했습니다.');");
				script.println("history.back();");
				script.println("</script>");
				script.close();
				return;
			}

			HttpSession saveKey = request.getSession();
			saveKey.setAttribute("AuthenticationKey", AuthenticationKey);

			request.setAttribute("member_email", member_email);
			dispatch(request, response, loginDirectory+"emailSend.jsp");

			} else {
					// 중복된 이메일이 있을 때
					request.setAttribute("member_email", member_email);
					dispatch(request,response, loginDirectory+"failedEmail.jsp");
				}

		}

		// 회원가입 이메일 인증번호 확인
		if("login_emailAuth".equals(command)) {
			String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
			String memberemailauth = request.getParameter("member_email_auth");

			if(AuthenticationKey.equals(memberemailauth)){
				request.setAttribute("AuthenticationKey", AuthenticationKey);
				request.setAttribute("memberemailauth", memberemailauth);
				dispatch(request, response, loginDirectory+"emailAuth.jsp");
			} else {
				response.sendRedirect(loginDirectory+"failedAuth.jsp");
			}
		}

		// 회원가입 insert
		if("login_signupForm".equals(command)) {
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			String member_name = request.getParameter("member_name");
			String member_email = request.getParameter("member_email");
			String member_phone = request.getParameter("member_phone");
			String member_addr = request.getParameter("member_addr");
			String member_addr_detail = request.getParameter("member_addr_detail");

			String memberaddress = member_addr + " " + member_addr_detail;

			MemberDto dto = new MemberDto();

			dto.setMember_id(member_id);
			dto.setMember_pw(member_pw);
			dto.setMember_name(member_name);
			dto.setMember_email(member_email);
			dto.setMember_phone(member_phone);
			dto.setMember_address(memberaddress);

			int res = dao.MemberInsert(dto);
			// 수정할지 보기
			if (res > 0) {
				jsResponse(response, "회원가입이 완료되었습니다.", "main/main.sjp");
			} else {
				jsResponse(response, "회원가입 실패", "history.back();");
			}
		}


		// 일정 리스트
		if("calendarlist".equals(command)) {

		}
		//식당,카페 리스트
		BusinessDao bdao = new BusinessDaoImpl();
		if(command.equals("foodlist")) {
			List<BusinessDto> list = bdao.BusinessList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("food/food_list.jsp").forward(request, response);
		}
		if(command.equals("bookform")) {//-------------------------------------------------------
			int business_num = Integer.parseInt(request.getParameter("business_num"));
			System.out.println(business_num);
			BusinessDto bdto = bdao.businessOne(business_num);
			request.setAttribute("bdto", bdto);
			System.out.println(bdto.getBusiness_name());
			dispatch(request, response,"./food/food_book.jsp");

		}

		if(command.equals("bookinsert")) {
	         String book_date = request.getParameter("book_date").replaceAll("-", "");//예약날짜.
	         System.out.println("1. book_date : "+book_date);      //출력구문 1. 예약날짜
	         String book_time = request.getParameter("book_time");//.replaceAll(":", "");
	         System.out.println("2. book_time : "+book_time);

	         int book_store = Integer.parseInt(request.getParameter("book_store"));
	         //book_store: 예약업체 번호 / business_num: 회사번호
	         System.out.println("3. book_store : "+book_store);//출력구문 2. 예약업체 번호.

	         String book_type = request.getParameter("book_type"); //book_type, business_role 둘다 올수 있는 값이 h,s
	         System.out.println(book_type);


	         BookDto bokdto = new BookDto(0, book_date, book_time, book_type, book_store, 1, 0, null, null, null);
	         int res = bdao.bookInsert(bokdto); 

	         if(res>0) {
	            //해당 유저가 가장 최근에 작성한 번호 가져와서 해당 게시글로 이동
	            jsResponse(response, "작성 성공", "./food/book_list.jsp");
	         }else{
	            jsResponse(response, "작성 실패", "./food/food_book.jsp");
	         }

	      }

		

		// 일정 등록
		if("calendar_insert".equals(command)) {
			String calendar_title = request.getParameter("calendar_title");
			String s_year = request.getParameter("s_year");
			String s_month = request.getParameter("s_month");
			String s_date = request.getParameter("s_date");
			String s_hour = request.getParameter("s_hour");
			String s_min = request.getParameter("s_min");
			String e_year = request.getParameter("e_year");
			String e_month = request.getParameter("e_month");
			String e_date = request.getParameter("e_date");
			String e_hour = request.getParameter("e_hour");
			String e_min = request.getParameter("e_min");
			String calendar_necessity = request.getParameter("calendar_necessity");
			String calendar_item = request.getParameter("calendar_item");
			String calendar_content = request.getParameter("calendar_content");

			int member_no = Integer.parseInt(request.getParameter("member_no"));
			pet_util util = new pet_util();

			String calendar_startdate = s_year + util.isTwo(s_month) + util.isTwo(s_date) + util.isTwo(s_hour) + util.isTwo(s_min);
			String calendar_enddate = e_year + util.isTwo(e_month) + util.isTwo(e_date) + util.isTwo(e_hour) + util.isTwo(e_min);

			CalendarDto CalDto = new CalendarDto();
			CalDto.setCalendar_title(calendar_title);
			CalDto.setCalendar_startdate(calendar_startdate);
			CalDto.setCalendar_enddate(calendar_enddate);
			CalDto.setCalendar_necessity(calendar_necessity);
			CalDto.setCalendar_item(calendar_item);
			CalDto.setCalendar_content(calendar_content);
			CalDto.setMember_no(member_no);
			int res = dao.CalendarInsert(CalDto);


			if (res > 0) {
				jsResponse(response, "일정이 등록되었습니다.", CalendarDirectory + "main.jsp");
			} else {
				jsResponse(response, "일정이 등록되지 않았습니다.", "history.back();");
			}
		}

        if (command.equals("pet_main")) {
            int member_no = Integer.parseInt(request.getParameter("member_no"));
            List<PetDto> petlist = biz.selectPetList(member_no);
            request.setAttribute("petlist", petlist);
            dispatch(request, response, "pet/pet_main.jsp");


        }  else if (command.equals("picture_insert_select")) {
            int member_no = 1;
            List<PictureDto> list = biz.selectPictureList(member_no);
            request.setAttribute("list", list);
            dispatch(request, response, "pet/pet_insert_select.jsp");

        } else if (command.equals("picture_update_select")) {
            int member_no = 1;
            List<PictureDto> list = biz.selectPictureList(member_no);
            request.setAttribute("list", list);
            dispatch(request, response, "pet/pet_update_select.jsp");

        } else if (command.equals("pet_update_form")) {
            int member_no = 1;
            int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            PetDto dto = biz.selectPetOne(member_no, pet_no);
            System.out.println(dto.getPet_path());
            request.setAttribute("dto", dto);
            dispatch(request, response, "pet/pet_update.jsp");

        } else if (command.equals("pet_update_res")) {
            int member_no = 1;
            int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            String path = request.getParameter("path");
            String vaccination = request.getParameter("vaccination");
            PetDto dto = new PetDto();

            dto.setPet_no(pet_no);
            dto.setPet_path(path);
            dto.setPet_vaccination(vaccination);

            int res = biz.updatePet(dto);
            if (res > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }

        } else if (command.equals("pet_insert")) {

            int member_no = 1;
            String name = request.getParameter("name");
            String species = request.getParameter("species");
            String breed = request.getParameter("breed");
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String path = request.getParameter("path");
            String vaccination = request.getParameter("vaccination");

            PetDto dto = new PetDto(0, species, breed, name, birthday, gender, member_no, path, vaccination);
            int res = biz.insertPet(dto);
            if (res > 0) {
                System.out.println("추가 성공");
            } else {
                System.out.println("추가 실패");
            }

        } else if (command.equals("pet_delete")) {
            int member_no = 1;
            int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            int res = biz.deletePet(member_no, pet_no);
            if (res > 0) {
                System.out.println("삭제 성공");
                dispatch(request, response, "pet/pet_main.jsp?member_no=1");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "pet/pet_main.jspmember_no=1");
            }
        } else if (command.equals("picture_main")) {
            response.sendRedirect("picture/picture_main.jsp");

        } else if (command.equals("picture_upload")) {

            int member_no = 1;
            Util.MakeFolder(member_no);
            String path = request.getSession().getServletContext().getRealPath("resources/Upload/" + member_no);
            int size = 1024 * 1024 * 10;
            String file = "";
            String originalFile = "";

            PictureDto dto = new PictureDto();

            try {
                MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

                Enumeration files = multi.getFileNames();

                String str = (String) files.nextElement();
                System.out.println(str);

                file = multi.getFilesystemName(str);
                originalFile = multi.getOriginalFileName(str);

                dto.setPicture_name(file);
                dto.setPicture_directory("../resources/Upload/" + member_no);
                dto.setMember_no(member_no);
                int res = biz.insertPicture(dto);
                System.out.println(res);
                if (res > 0) {
                    System.out.println("업로드 성공");
                } else {
                    System.out.println("업로드 실패");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispatch(request, response, "pet.do?command=picture_main");

        } else if (command.equals("picture_delete")) {
            int member_no = 1;
            int picture_no = Integer.parseInt(request.getParameter("picture_no"));
            System.out.println(member_no + "/" + picture_no);
            PictureDto dto = biz.selectPictureOne(member_no, picture_no);

            String path = dto.getPicture_directory() + "/" + dto.getPicture_name();

            Util.deleteFile(path);
            int res = biz.deletePicture(member_no, picture_no);
            if (res > 0) {
                System.out.println("삭제 성공");
                dispatch(request, response, "pet.do?command=picture_main");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "pet.do?command=picture_main");
            }

        } else if (command.equals("calendar_main")) {
            int member_no = 1;
            List<CalendarDto> list = biz.selectTripList(1);
            request.setAttribute("list", list);
            dispatch(request, response, "calendar/calendar_main.jsp");

        } else if (command.equals("calendar_insert_form")) {
            response.sendRedirect("calendar/calendar_insert.jsp");

        } else if (command.equals("calendar_insert_res")) {

            String calendar_startdate = request.getParameter("calendar_startdate");
            String calendar_enddate = request.getParameter("calendar_enddate");
            String calendar_necessity = request.getParameter("calendar_necessity");
            String calendar_item = request.getParameter("calendar_item");
            String calendar_title = request.getParameter("calendar_title");
            String calendar_content = request.getParameter("calendar_content");
            int member_no = Integer.parseInt(request.getParameter("member_no"));

            CalendarDto dto = new CalendarDto(0, calendar_startdate, calendar_enddate, calendar_necessity, calendar_item, calendar_title, calendar_content, member_no);
            int res = biz.insertTrip(dto);
            if (res > 0) {
                System.out.println("여행 일정 작성 성공");
                dispatch(request, response, "index.html");
            } else {
                System.out.println("여행 일정 작성 실패");
                dispatch(request, response, "index.html");
            }
        } else if (command.equals("calendar_detail")) {
            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));

            CalendarDto dto = biz.selectTripOne(member_no, calendar_no);
            request.setAttribute("dto", dto);
            dispatch(request, response, "calendar/calendar_detail.jsp");

        } else if (command.equals("calendar_update_form")) {

            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            CalendarDto dto = biz.selectTripOne(member_no, calendar_no);
            request.setAttribute("dto", dto);
            dispatch(request, response, "calendar/calendar_update.jsp");


        } else if (command.equals("calendar_update_res")) {

            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            String start_date = request.getParameter("start_date");
            String end_date = request.getParameter("end_date");
            String necessity = request.getParameter("necessity");
            String item = request.getParameter("item");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            CalendarDto dto = new CalendarDto(calendar_no, start_date, end_date, necessity, item, title, content, member_no);
            int res = biz.updateTrip(dto);
            if (res > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }


        } else if (command.equals("calendar_delete")) {

            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            System.out.println(calendar_no);

            int res = biz.deleteTrip(1, calendar_no);

            if (res > 0) {
                System.out.println("삭제 성공");
                dispatch(request, response, "index.html");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "index.html");
            }
        } else if (command.equals("pet_Paging")) {

            int member_no = 1;
            //int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            int count = Integer.parseInt(request.getParameter("count"));
            List<PetDto> list = biz.selectPetList(1);
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = new JSONArray();
            //petDto dto = biz.selectPetOne(member_no, 1);
            PetDto dto = biz.selectPetOnePaging(member_no, count);

            JSONObject jObj = new JSONObject();
            jObj.put("pet_no", dto.getPet_no());
            jObj.put("pet_name", dto.getPet_name());
            jObj.put("pet_species", dto.getPet_species());
            jObj.put("pet_breed", dto.getPet_breed());
            jObj.put("pet_birthday", dto.getPet_birthday().substring(0, 10));
            jObj.put("pet_gender", dto.getPet_gender());
            jObj.put("pet_path", dto.getPet_path());
            jObj.put("pet_vaccination", dto.getPet_vaccination());

            jsonArray.add(jObj);
            out.print(jsonArray);
            out.flush();
        }

        if (command.equals("weather_main")) {
			response.sendRedirect("weather/weatherView.html");
		}
        


        if (command.equals("weather_main")) {
			response.sendRedirect("weather/weatherView.html");
		}
        
        
        
        // 캘린더 내 clud
        
        if (command.equals("calendar_calMain")) {
        	int member_no = (int) session.getAttribute("member_no");
        	dispatch(request, response, CalendarDirectory + "");
        }
    
     	if("calendar_calInsert".equals(command)) {
     		String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
     		
   			request.setAttribute("year", year);
     		request.setAttribute("month", month);
     		request.setAttribute("date", date);
     		dispatch(request, response, CalendarDirectory + "insert.jsp");
     		
     	}
     	
        // 일정 등록
     	if("calendar_calInsertForm".equals(command)) {
     		pet_util util = new pet_util();
     		String calendar_title = request.getParameter("calendar_title");
     		String s_year = request.getParameter("s_year");
     		String s_month = request.getParameter("s_month");
     		String s_date = request.getParameter("s_date");
     		String s_hour = request.getParameter("s_hour");
   			String s_min = request.getParameter("s_min");
   			String e_year = request.getParameter("e_year");
   			String e_month = request.getParameter("e_month");
   			String e_date = request.getParameter("e_date");
     		String e_hour = request.getParameter("e_hour");
   			String e_min = request.getParameter("e_min");
     		String calendar_necessity = request.getParameter("calendar_necessity");
     		String calendar_item = request.getParameter("calendar_item");
     		String calendar_content = request.getParameter("calendar_content");
     		int member_no = (int) session.getAttribute("member_no");
     			
     		String calendar_startdate = s_year + util.isTwo(s_month) + util.isTwo(s_date) + util.isTwo(s_hour) + util.isTwo(s_min);
     		String calendar_enddate = e_year + util.isTwo(e_month) + util.isTwo(e_date) + util.isTwo(e_hour) + util.isTwo(e_min);
     			
     		CalendarDto CalDto = new CalendarDto();
     		CalDto.setCalendar_title(calendar_title);
     		CalDto.setCalendar_startdate(calendar_startdate);
     		CalDto.setCalendar_enddate(calendar_enddate);
     		CalDto.setCalendar_necessity(calendar_necessity);
     		CalDto.setCalendar_item(calendar_item);
     		CalDto.setCalendar_content(calendar_content);
     		CalDto.setMember_no(member_no);
     		int res = dao.CalendarInsert(CalDto);
     		
     			
     		if (res > 0) {
     			jsResponse(response, "일정이 등록되었습니다.", CalendarDirectory + "main.jsp");
     		} else {
     			jsResponse(response, "일정이 등록되지 않았습니다.", CalendarDirectory + "main.jsp");
     			}
     	}
     		
     	if ("calendar_calList".equals(command)) {
     		pet_util util = new pet_util();
     		String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
   			String yyyyMMdd = year + util.isTwo(month) + util.isTwo(date);
   			int member_no = (int) session.getAttribute("member_no");
    			
   			List<CalendarDto> list = biz.CalendarList(member_no, yyyyMMdd);
     			
   			request.setAttribute("year", year);
     		request.setAttribute("month", month);
     		request.setAttribute("date", date);
     		request.setAttribute("list", list);
     		dispatch(request, response, CalendarDirectory + "list.jsp");
     	}
     		
     	if("calendar_calDetail".equals(command)) {
     		String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
     		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
     			
     		CalendarDto dto = biz.CalendarOne(calendar_no);
     			
     		request.setAttribute("year", year);
     		request.setAttribute("month", month);
     		request.setAttribute("date", date);
     		request.setAttribute("dto", dto);
     		dispatch(request, response, CalendarDirectory + "detail.jsp");
     		}
     		
     	if("calendar_calDelete".equals(command)) {
     		String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
     		int member_no = (int) session.getAttribute("member_no");
     		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
     		
     		int res = biz.CalendarDelete(calendar_no);
     		if (res > 0) {
     			jsResponse(response, "삭제가 완료되었습니다.", "/semi_PetDiary/pet.do?command=calendar_calList&year="+year+"&month="+month+"&date="+date+"&member_no="+member_no);
     		} else {
     			jsResponse(response, "오류가 발생했습니다.", "/semi_PetDiary/pet.do?command=calendar_calList&year="+year+"&month="+month+"&date="+date+"&member_no="+member_no);
     		}
     	}
     		
   		if("calendar_calUpdate".equals(command)) {
   			String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
     		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
     			
     			
     		CalendarDto dto = biz.CalendarOne(calendar_no);
     		request.setAttribute("year", year);
     		request.setAttribute("month", month);
     		request.setAttribute("date", date);
     		request.setAttribute("dto", dto);
     		dispatch(request, response, CalendarDirectory + "update.jsp");
     	}
     		
     	if("calendar_calUpdateform".equals(command)) {
     		String year = request.getParameter("year");
     		String month = request.getParameter("month");
     		String date = request.getParameter("date");
     			
     		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
     		String calendar_title = request.getParameter("calendar_title");
     		String calendar_necessity = request.getParameter("calendar_necessity");
     		String calendar_item = request.getParameter("calendar_item");
     		String calendar_content = request.getParameter("calendar_content");
     		int member_no = (int) session.getAttribute("member_no");
     			
     		CalendarDto dto = new CalendarDto();
     		dto.setCalendar_no(calendar_no);
     		dto.setCalendar_title(calendar_title);
     		dto.setCalendar_necessity(calendar_necessity);
     		dto.setCalendar_item(calendar_item);
     		dto.setCalendar_content(calendar_content);
     			
     		int res = biz.CalendarUpdate(dto);
     			
     		if (res > 0) {
     			jsResponse(response, "수정이 완료되었습니다.", "/semi_PetDiary/pet.do?command=calendar_calList&year="+year+"&month="+month+"&date="+date+"&member_no="+member_no);
     		} else {
     			jsResponse(response, "오류가 발생했습니다.", "/semi_PetDiary/pet.do?command=calendar_calList&year="+year+"&month="+month+"&date="+date+"&member_no="+member_no);
     		}

     	}
     	
    	if("login_login".equals(command)) {
			response.sendRedirect(loginDirectory+"login.jsp");
		}	
     	
    	if("login_loginForm".equals(command)) {
    	
    		String member_id = request.getParameter("member_id");
    		String member_pw = request.getParameter("member_pw");
    			
    		MemberDto dto = biz.Login(member_id, member_pw);
    			
    		if(dto != null) {
    			session.setAttribute("dto", dto);
    			session.setAttribute("member_no", dto.getMember_no());
    			session.setMaxInactiveInterval(3600);
    				
    			if (dto.getMember_role().equals("ADMIN")) {
    				// 관리자 페이지 이동
    			} else if (dto.getMember_role().equals("USER")) {
    				response.sendRedirect("main/main.jsp");
    			} else if (dto.getMember_role().equals("EMPLOYEE")) {
    				// 사업자 페이지로 이동
    			}
    		} else {
    			jsResponse(response, "가입하지 않은 아이디거나, 잘못된 비밀번호입니다.", loginDirectory+"login.jsp");
    		}
    			
    	}  
    		
    	// 로그아웃 추가해야 함
    	if("login_logout".equals(command)) {
    		session.invalidate();
    		response.sendRedirect("main/main.jsp");
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
