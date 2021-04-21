package com.pet.ft.biz;
import com.pet.ft.dao.PetDao;
import com.pet.ft.dao.PetDaoImpl;
import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;

import java.util.List;

public class PetBizImpl implements PetBiz {

    PetDao dao = new PetDaoImpl();

    @Override
    public List<PetDto> selectPetList(int member_no) {
        return dao.selectPetList(member_no);
    }

    @Override
    public PetDto selectPetOne(int member_no, int pet_no) {
        return dao.selectPetOne(member_no, pet_no);
    }

    @Override
    public int insertPet(PetDto dto) {
        return dao.insertPet(dto);
    }

    @Override
    public int getCount(int member_no) {
        return dao.getCount(member_no);
    }

    @Override
    public int updatePet(PetDto dto) {
        return dao.updatePet(dto);
    }

    @Override
    public int deletePet(int member_no, int pet_no) {
        return dao.deletePet(member_no, pet_no);
    }

    @Override
    public PetDto selectPetOnePaging(int member_no, int count) {
        return dao.selectPetOnePaging(member_no, count);
    }

    @Override
    public List<PictureDto> selectPictureList(int member_no) {
        return dao.selectPictureList(member_no);
    }

    @Override
    public PictureDto selectPictureOne(int member_no, int picture_no) {
        return dao.selectPictureOne(member_no, picture_no);
    }

    @Override
    public int insertPicture(PictureDto dto) {
        return dao.insertPicture(dto);
    }

    @Override
    public int deletePicture(int member_no, int picture_no) {
        return dao.deletePicture(member_no, picture_no);
    }

    @Override
    public List<CalendarDto> selectCalendarList(int member_no) {
        return dao.selectCalendarList(member_no);
    }

    @Override
    public CalendarDto selectCalendarOne(int member_no, int calendar_no) {
        return dao.selectCalendarOne(member_no, calendar_no);
    }

    @Override
    public int calendarInsert(CalendarDto dto) {
        return dao.calendarInsert(dto);
    }

    @Override
    public int updateCalendar(CalendarDto dto) {
        return dao.updateCalendar(dto);
    }

    @Override
    public int deleteCalendar(int member_no, int calendar_no) {
        return dao.deleteCalendar(member_no, calendar_no);
    }
}