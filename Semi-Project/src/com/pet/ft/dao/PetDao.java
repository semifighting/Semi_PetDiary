package com.pet.ft.dao;
import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.diaryDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;

import java.util.List;

public interface petDao {

    String namespace = "com.pet.ft.mapper.";

    // pet
    public List<petDto> selectPetList(int member_no);
    public petDto selectPetOne(int member_no, int pet_no);
    public int updatePet(petDto dto);
    public int insertPet(petDto dto);
    public int deletePet(int member_no, int pet_no);
    public int getCount(int member_no);
    public petDto selectPetOnePaging(int member_no, int count);

    //picture
    public List<pictureDto> selectPictureList(int member_no);
    public pictureDto selectPictureOne(int member_no, int picture_no);
    public int insertPicture(pictureDto dto);
    public int deletePicture(int member_no, int picture_no);

    //calendar
    public List<calendarDto> selectCalendarList(int member_no);
    public calendarDto selectCalendarOne(int member_no, int calendar_no);

    public int updateCalendar(calendarDto dto);
    public int calendarInsert(calendarDto dto);
    public int deleteCalendar(int member_no, int calendar_no);


}
