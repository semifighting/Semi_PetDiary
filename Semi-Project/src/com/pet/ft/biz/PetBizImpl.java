package com.pet.ft.biz;
import com.pet.ft.dao.PetDao;
import com.pet.ft.dao.PetDaoImpl;
import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;

import java.util.List;

public class PetBizImpl implements PetBiz {

    PetDao dao = new PetDaoImpl();

    @Override
    public List<petDto> selectPetList(int member_no) {
        return dao.selectPetList(member_no);
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
    public int deleteCalendar(int member_no, int calendar_no) {
        return dao.deleteCalendar(member_no, calendar_no);
    }
}
