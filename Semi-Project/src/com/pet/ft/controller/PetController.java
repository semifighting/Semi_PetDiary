package com.pet.ft.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.ft.biz.PetBiz;
import com.pet.ft.biz.PetBizImpl;
import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/pet.do")
public class PetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PetBiz biz = new PetBizImpl();
        String command = request.getParameter("command");
        System.out.println(command);

        if (command.equals("diary")) {
            int member_no = Integer.parseInt(request.getParameter("member_no"));

            dispatch(request, response, "diary_main.jsp");


        } else if (command.equals("pagingDiary")) {

            List<petDto> list = biz.selectPetList(1);
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = new JSONArray();
            petDto dto = null;
            for (int i = 0; i < list.size(); i++) {
                dto = list.get(i);
                JSONObject jObj = new JSONObject();
                jObj.put("pet_name", dto.getPet_name());
                jObj.put("pet_species", dto.getPet_species());
                jObj.put("pet_breed", dto.getPet_breed());
                jObj.put("pet_birthday", dto.getPet_birthday().substring(0, 10));
                jObj.put("pet_gender", dto.getPet_gender());

                jsonArray.add(jObj);
            }
            out.print(jsonArray);
            out.flush();

        } else if (command.equals("picture")) {
            response.sendRedirect("picture_main.jsp");

        } else if (command.equals("pictureUpload")) {

            int member_no = 1;
            Util.MakeFolder(member_no);
            String path = request.getSession().getServletContext().getRealPath("resources/Upload/" + member_no);
            int size = 1024 * 1024 * 10;
            String file = "";
            String originalFile = "";

            pictureDto dto = new pictureDto();

            try {
                MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

                Enumeration files = multi.getFileNames();

                while (files.hasMoreElements()) {
                    String str = (String) files.nextElement();
                    System.out.println(str);

                    file = multi.getFilesystemName(str);
                    originalFile = multi.getOriginalFileName(str);

                    dto.setPicture_name(file);
                    dto.setPicture_directory("resources/Upload/" + member_no);
                    dto.setMember_no(member_no);
                    int res = biz.insertPicture(dto);
                    System.out.println(res);
                    if (res > 0) {
                        System.out.println("업로드 성공");
                    } else {
                        System.out.println("업로드 실패");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispatch(request, response, "pet.do?command=picture");

        } else if (command.equals("deletePicture")) {
            int member_no = 1;
            int picture_no = Integer.parseInt(request.getParameter("picture_no"));
            System.out.println(member_no + "/" + picture_no);
            pictureDto dto = biz.selectPictureOne(member_no, picture_no);

            String path = dto.getPicture_directory() + "/" + dto.getPicture_name();

            Util.deleteFile(path);
            int res = biz.deletePicture(member_no, picture_no);
            if (res > 0) {
                System.out.println("삭제 성공");
                dispatch(request, response, "pet.do?command=picture");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "pet.do?command=picture");
            }
        } else if (command.equals("calendar")) {
            int member_no = 1;
            List<calendarDto> list = biz.selectCalendarList(1);
            request.setAttribute("list", list);
            dispatch(request, response, "calendar_main.jsp");
        } else if (command.equals("calendarInsertForm")) {
            response.sendRedirect("calendar_insert.jsp");
        } else if (command.equals("calendarInsertRes")) {

            String calendar_startdate = request.getParameter("calendar_startdate");
            String calendar_enddate = request.getParameter("calendar_enddate");
            String calendar_necessity = request.getParameter("calendar_necessity");
            String calendar_item = request.getParameter("calendar_item");
            String calendar_title = request.getParameter("calendar_title");
            String calendar_content = request.getParameter("calendar_content");
            int member_no = Integer.parseInt(request.getParameter("member_no"));

            calendarDto dto = new calendarDto(0, calendar_startdate, calendar_enddate, calendar_necessity, calendar_item, calendar_title, calendar_content, member_no);
            int res = biz.calendarInsert(dto);
            if (res > 0) {
                System.out.println("여행 일정 작성 성공");
                dispatch(request, response, "index.html");
            } else {
                System.out.println("여행 일정 작성 실패");
                dispatch(request, response, "index.html");
            }
        } else if (command.equals("calendarDetail")) {
            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));

            calendarDto dto = biz.selectCalendarOne(member_no, calendar_no);
            request.setAttribute("dto", dto);
            dispatch(request, response, "calendar_detail.jsp");

        } else if (command.equals("calendarDelete")) {

            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            System.out.println(calendar_no);

            int res = biz.deleteCalendar(1, calendar_no);

            if (res > 0) {
                System.out.println("삭제 성공");
                dispatch(request, response, "index.html");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "index.html");
            }
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher(path);

        dispatch.forward(request, response);
    }
}
