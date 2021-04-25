package com.pet.ft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.pet.ft.dto.MemberDto;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;

import java.net.URLEncoder;
import java.util.Random;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;



@WebServlet("/login_do")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public login_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String command = request.getParameter("command");
		System.out.println(command);
		
		HttpSession session = request.getSession();
		MemberDto dto = new MemberDto();
		PetDao dao = new PetDaoImpl();
		
		// 네이버 로그인 처리
		if ("naver_login".equals(command)) {
			
			String clientId = "n8OVzf4XjGNAd8jAA6Hi";//애플리케이션 클라이언트 아이디값";
		    String clientSecret = "B9Pqf7aDXD";//애플리케이션 클라이언트 시크릿값";
		    String code = request.getParameter("code");
		    String state = request.getParameter("state");
		    String redirectURI = URLEncoder.encode("http://localhost:8787/semi_PetDiary/login.do?command=naver_login", "UTF-8");
		    String apiURL;
		    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		    apiURL += "client_id=" + clientId;
		    apiURL += "&client_secret=" + clientSecret;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&code=" + code;
		    apiURL += "&state=" + state;
		    String access_token = "";
		    String refresh_token = "";
		    System.out.println("apiURL="+apiURL);
		    
		    try {
		        URL url = new URL(apiURL);
		        HttpURLConnection con = (HttpURLConnection)url.openConnection();
		        con.setRequestMethod("GET");
		        int responseCode = con.getResponseCode();
		        BufferedReader br;
		        System.out.print("responseCode="+responseCode);
		        if(responseCode==200) { // 정상 호출
		          br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		        } else {  // 에러 발생
		          br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		        }
		        String inputLine;
		        StringBuffer res = new StringBuffer();
		        while ((inputLine = br.readLine()) != null) {
		          res.append(inputLine);
		        }
		        br.close();
		        if(responseCode==200) {
		        	System.out.println(res.toString());
		        	JSONParser parsing = new JSONParser();
		        	Object obj = parsing.parse(res.toString());
		        	JSONObject jsonObj = (JSONObject)obj;
		        	
		        	access_token = (String)jsonObj.get("access_token");
		        	refresh_token = (String)jsonObj.get("refresh_token");
		        	
		        	session.setAttribute("access_token", access_token);

		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    
		   response.sendRedirect("/semi_PetDiary/login.do?command=naver_confirm");
		}
	
		
	if("naver_confirm".equals(command)) {
		
		String token = (String)session.getAttribute("access_token");
		String header = "Bearer " + token;
		try {
			String apiurl = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String inputLine;
			StringBuffer res = new StringBuffer();
			 while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
			}
			br.close();
			
			System.out.println(response.toString());
			
			JSONParser parsing = new JSONParser();
			Object obj = parsing.parse(res.toString());
			JSONObject jsonObj = (JSONObject)obj;
			JSONObject resObj = (JSONObject)jsonObj.get("response");
			
			String naver_id = (String)resObj.get("id"); // id 아니고 고유번호
			String naver_email = (String)resObj.get("email");
			String naver_name = (String)resObj.get("name");
			String naver_phone = (String)resObj.get("mobile");
			
			String member_id = "$naver$" + naver_id;
			
			dto = dao.SignUpIdChk(member_id);
			
			if (dto==null) {
				// 추가 정보 입력 회원가입
				request.setAttribute("member_id", member_id);
				request.setAttribute("member_email", naver_email);
				request.setAttribute("member_name", naver_name);
				request.setAttribute("member_phone", naver_phone);
				dispatch(request, response, "login/login_social.jsp");
				
			} else {
				// 로그인
				dto = dao.SocialLogin(member_id);
				session.setAttribute("dto", dto);
				session.setAttribute("member_no", dto.getMember_no());
				session.setMaxInactiveInterval(3600);
				
				response.sendRedirect("main/main.jsp");
			}
				
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	if ("social_signUp".equals(command)) {
		String member_id = request.getParameter("member_id");
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");
		String member_addr = request.getParameter("member_addr");
		String member_addr_detail = request.getParameter("member_addr_detail");
		
		String member_address = member_addr + " " + member_addr_detail;
		
		dto = new MemberDto();
		dto.setMember_id(member_id);
		dto.setMember_name(member_name);
		dto.setMember_email(member_email);
		dto.setMember_phone(member_phone);
		dto.setMember_address(member_address);
		
		int res = dao.SocialSignUp(dto);
		
		if (res > 0) {
			// 회원가입 후 바로 로그인 상태로 메인화면 이동
			session.setAttribute("dto", dto);
			session.setAttribute("member_no", dto.getMember_no());
			jsResponse(response, "회원가입이 완료되었습니다.", "main/main.jsp");
		} else {
			jsResponse(response, "회원가입 실패", "login/login_login.jsp");
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
