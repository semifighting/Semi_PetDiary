package com.pet.ft.dao;

import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.diaryDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class petDaoImpl extends SqlMapConfig implements petDao {



    @Override
    public List<petDto> selectPetList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<petDto> list = session.selectList(namespace + "selectPetList", member_no);
        session.close();
        return list;
    }

    @Override
    public petDto selectPetOne(int member_no, int pet_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("pet_no", pet_no);
        petDto dto = session.selectOne(namespace + "selectPetOne", map);
        session.close();

        return dto;
    }

    @Override
    public int getCount(int member_no) {

        int res = 0;
        SqlSession session = getSqlSessionFactory().openSession();
        res = session.selectOne(namespace + "getCount", member_no);
        session.close();
        return res;
    }
    @Override
    public int insertPet(petDto dto) {
        int res = 0;

        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "insertPet", dto);
        }
        return res;
    }

    @Override
    public int updatePet(petDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.update(namespace + "updatePet", dto);
        }
        return res;
    }

    @Override
    public int deletePet(int member_no, int pet_no) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("pet_no", pet_no);
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.delete(namespace + "deletePet", map);
        }
        return res;
    }

    @Override
    public List<pictureDto> selectPictureList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<pictureDto> list = session.selectList(namespace + "selectPictureList",  member_no);
        session.close();
        return list;
    }

    @Override
    public pictureDto selectPictureOne(int member_no, int picture_no) {
        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("picture_no", picture_no);
        pictureDto dto = session.selectOne(namespace + "selectPictureOne", map);
        session.close();
        return dto;
    }


    @Override
    public int insertPicture(pictureDto dto) {

        int res = 0;
        try(SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "insertPicture", dto);
        }
        return res;
    }

    @Override
    public int deletePicture(int member_no, int picture_no) {

        int res = 0;
        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("picture_no", picture_no);

        try(SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "deletePicture", map);
        }

        return res;
    }

    @Override
    public petDto selectPetOnePaging(int member_no, int count) {


        SqlSession session = getSqlSessionFactory().openSession();

        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("count", count);

        petDto dto = session.selectOne(namespace + "selectPetOnePaging", map);
        return dto;
    }

    @Override
    public List<calendarDto> selectCalendarList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<calendarDto> list = session.selectList(namespace + "selectCalendarList", member_no);
        session.close();

        return list;
    }

    @Override
    public calendarDto selectCalendarOne(int member_no, int calendar_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("calendar_no", calendar_no);
        calendarDto dto = session.selectOne(namespace + "selectCalendarOne", map);

        return dto;
    }

    @Override
    public int calendarInsert(calendarDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.insert(namespace + "insertCalendar", dto);
        }
        return res;
    }

    @Override
    public int updateCalendar(calendarDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.update(namespace + "updateCalendar", dto);
        }
        return res;
    }

    @Override
    public int deleteCalendar(int member_no, int calendar_no) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("calendar_no", calendar_no);

        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.delete(namespace + "deleteCalendar", map);
        }
        return res;
    }
}
