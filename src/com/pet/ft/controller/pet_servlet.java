package com.pet.ft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import javax.servlet.http.HttpSession;

import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;

import net.sf.json.JSONObject;

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
		String loginDirectory = "login/login_";
		String CalendarDirectory = "calendar/calendar_";
		
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
		
		
		// 내가 작성
		
		// 회원가입 페이지로 이동
		if("login_signup".equals(command)) {
			response.sendRedirect(loginDirectory+"signup.jsp");
		}
		
		// 회원가입 중복 id 체크
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
					
					
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from,"testpet03");
					}
				});
					
			// 이메일 전송
			try {
				InternetAddress addr = new InternetAddress();
				addr.setPersonal(fromName, "UTF-8");
				addr.setAddress(from);
								
				Message msg = new MimeMessage(session);
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
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script>"
							+ "alert('"+msg+"');"
							+ "location.href='"+url+"';"
							+ "</script>;";
		response.getWriter().append(responseText);
	}	
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
