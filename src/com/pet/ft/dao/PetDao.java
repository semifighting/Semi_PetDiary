package com.pet.ft.dao;
import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;

import java.util.List;

public interface PetDao {

    String namespace = "com.pet.ft.mapper.";

    // pet
    public List<PetDto> selectPetList(int member_no);
    public PetDto selectPetOne(int member_no, int pet_no);
    public int updatePet(PetDto dto);
    public int insertPet(PetDto dto);
    public int deletePet(int member_no, int pet_no);
    public int getCount(int member_no);
    public PetDto selectPetOnePaging(int member_no, int count);

    //picture
    public List<PictureDto> selectPictureList(int member_no);
    public PictureDto selectPictureOne(int member_no, int picture_no);
    public int insertPicture(PictureDto dto);
    public int deletePicture(int member_no, int picture_no);

    //calendar
    public List<CalendarDto> selectCalendarList(int member_no);
    public CalendarDto selectCalendarOne(int member_no, int calendar_no);

    public int updateCalendar(CalendarDto dto);
    public int calendarInsert(CalendarDto dto);
    public int deleteCalendar(int member_no, int calendar_no);


}
