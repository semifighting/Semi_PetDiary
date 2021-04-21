package com.pet.ft.biz;
import com.pet.ft.dao.petDao;
import com.pet.ft.dao.petDaoImpl;
import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.diaryDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;

import java.util.List;

public class petBizImpl implements petBiz {

    petDao dao = new petDaoImpl();

    @Override
    public List<petDto> selectPetList(int member_no) {
        return dao.selectPetList(member_no);
    }

    @Override
    public petDto selectPetOne(int member_no, int pet_no) {
        return dao.selectPetOne(member_no, pet_no);
    }

    @Override
    public int insertPet(petDto dto) {
        return dao.insertPet(dto);
    }

    @Override
    public int getCount(int member_no) {
        return dao.getCount(member_no);
    }

    @Override
    public int updatePet(petDto dto) {
        return dao.updatePet(dto);
    }

    @Override
    public int deletePet(int member_no, int pet_no) {
        return dao.deletePet(member_no, pet_no);
    }

    @Override
    public petDto selectPetOnePaging(int member_no, int count) {
        return dao.selectPetOnePaging(member_no, count);
    }

    @Override
    public List<pictureDto> selectPictureList(int member_no) {
        return dao.selectPictureList(member_no);
    }

    @Override
    public pictureDto selectPictureOne(int member_no, int picture_no) {
        return dao.selectPictureOne(member_no, picture_no);
    }

    @Override
    public int insertPicture(pictureDto dto) {
        return dao.insertPicture(dto);
    }

    @Override
    public int deletePicture(int member_no, int picture_no) {
        return dao.deletePicture(member_no, picture_no);
    }

    @Override
    public List<calendarDto> selectCalendarList(int member_no) {
        return dao.selectCalendarList(member_no);
    }

    @Override
    public calendarDto selectCalendarOne(int member_no, int calendar_no) {
        return dao.selectCalendarOne(member_no, calendar_no);
    }

    @Override
    public int calendarInsert(calendarDto dto) {
        return dao.calendarInsert(dto);
    }

    @Override
    public int updateCalendar(calendarDto dto) {
        return dao.updateCalendar(dto);
    }

    @Override
    public int deleteCalendar(int member_no, int calendar_no) {
        return dao.deleteCalendar(member_no, calendar_no);
    }
}
