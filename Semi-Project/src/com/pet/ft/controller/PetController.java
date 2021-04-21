package com.pet.ft.controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.ft.biz.petBiz;
import com.pet.ft.biz.petBizImpl;
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
public class petController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        petBiz biz = new petBizImpl();
        String command = request.getParameter("command");
        System.out.println(command);

        if (command.equals("pet_main")) {
            int member_no = Integer.parseInt(request.getParameter("member_no"));
            List<petDto> list = biz.selectPetList(member_no);
            request.setAttribute("list", list);
            dispatch(request, response, "pet/pet_main.jsp");


        }  else if (command.equals("picture_insert_select")) {
            int member_no = 1;
            List<pictureDto> list = biz.selectPictureList(member_no);
            request.setAttribute("list", list);
            dispatch(request, response, "pet/pet_insert_select.jsp");

        } else if (command.equals("picture_update_select")) {
            int member_no = 1;
            List<pictureDto> list = biz.selectPictureList(member_no);
            request.setAttribute("list", list);
            dispatch(request, response, "pet/pet_update_select.jsp");

        } else if (command.equals("pet_update_form")) {
            int member_no = 1;
            int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            petDto dto = biz.selectPetOne(member_no, pet_no);
            System.out.println(dto.getPet_path());
            request.setAttribute("dto", dto);
            dispatch(request, response, "pet/pet_update.jsp");

        } else if (command.equals("pet_update_res")) {
            int member_no = 1;
            int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            String path = request.getParameter("path");
            String vaccination = request.getParameter("vaccination");
            petDto dto = new petDto();

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

            petDto dto = new petDto(0, species, breed, name, birthday, gender, member_no, path, vaccination);
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
                dispatch(request, response, "pet/pet_paging.jsp");
            } else {
                System.out.println("삭제 실패");
                dispatch(request, response, "pet/pet_paging.jsp");
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

            pictureDto dto = new pictureDto();

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
            pictureDto dto = biz.selectPictureOne(member_no, picture_no);

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
            List<calendarDto> list = biz.selectCalendarList(1);
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

            calendarDto dto = new calendarDto(0, calendar_startdate, calendar_enddate, calendar_necessity, calendar_item, calendar_title, calendar_content, member_no);
            int res = biz.calendarInsert(dto);
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

            calendarDto dto = biz.selectCalendarOne(member_no, calendar_no);
            request.setAttribute("dto", dto);
            dispatch(request, response, "calendar/calendar_detail.jsp");

        } else if (command.equals("calendar_update_form")) {

            int member_no = 1;
            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            calendarDto dto = biz.selectCalendarOne(member_no, calendar_no);
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

            calendarDto dto = new calendarDto(calendar_no, start_date, end_date, necessity, item, title, content, member_no);
            int res = biz.updateCalendar(dto);
            if (res > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }


        } else if (command.equals("calendar_delete")) {

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
        } else if (command.equals("pet_Paging")) {

            int member_no = 1;
            //int pet_no = Integer.parseInt(request.getParameter("pet_no"));
            int count = Integer.parseInt(request.getParameter("count"));
            List<petDto> list = biz.selectPetList(1);
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = new JSONArray();
            //petDto dto = biz.selectPetOne(member_no, 1);
            petDto dto = biz.selectPetOnePaging(member_no, count);

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
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher(path);

        dispatch.forward(request, response);
    }
}
