package com.pet.ft.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

@WebServlet("/pet_sms_servlet")
public class pet_sms_servlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		String book_date = null;
		String book_time = null;
		int business_num = 0;
		String business_name = pet_util.FromBussinessNoTogetName(business_num);
		
		int member_no = 0;
		String phone= pet_util.FromMemberNoTogetPhone(member_no);
		String Name= pet_util.FromMemberNoTogetPhone(member_no);
		String massage = Name+"님 이름으로 "+book_date+book_time+business_name+"에 예약되었습니다.";
		
		
		String targetUrl = "https://api.solapi.com/messages/v4/send";
		String parameters = " {\"message\":{\"to\":\""+phone+"\",\"from\":\"01077915161\",\"text\":\""+massage+"\",\"type\":\"SMS\"}}";

		URL url = new URL(targetUrl); //URL 생성
		HttpURLConnection con = (HttpURLConnection)url.openConnection(); //URL에 연결 객체 생성

	    con.setRequestMethod("POST");

		con.setRequestProperty("Authorization", APIInit.getHeaders());
		con.setRequestProperty("Content-Type", "application/json");

	    con.setDoOutput(true);
	    OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
	    BufferedWriter bw = new BufferedWriter(osw);
	    PrintWriter pw = new PrintWriter(bw);
	    pw.print(parameters);
	    pw.flush();
	    pw.close();
	      
	    int responseCode = con.getResponseCode();
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String line;
	    StringBuffer smsresponse = new StringBuffer();
	    while ((line = in.readLine()) != null) {
	      smsresponse.append(line);
	    }
	    in.close();

	    System.out.println("HTTP response code : " + responseCode);
	    System.out.println("HTTP body : " + smsresponse.toString());	    
	    	
	    JsonObject resjson = (JsonObject) JsonParser.parseString(smsresponse.toString());
	    String  statusMessage = resjson.get("statusMessage").getAsString();
	    
	    
	    
		String responseText = "<script>"
				+ "alert('예약문자가 "+statusMessage+"되었습니다.');"
				+ "location.href='"+"url"+"';"
				+ "</script>;";
		response.getWriter().append(responseText);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}