package com.pet.ft.biz;


import com.pet.ft.dto.calendarDto;
import com.pet.ft.dto.diaryDto;
import com.pet.ft.dto.petDto;
import com.pet.ft.dto.pictureDto;

import java.util.List;

public interface PetBiz {

    //pet
    public List<petDto> selectPetList(int member_no);

    //picture
    public List<pictureDto> selectPictureList(int member_no);
    public pictureDto selectPictureOne(int member_no, int picture_no);
    public int insertPicture(pictureDto dto);
    public int deletePicture(int member_no, int picture_no);

    //calendar
    public List<calendarDto> selectCalendarList(int member_no);
    public calendarDto selectCalendarOne(int member_no, int calendar_no);
    public int calendarInsert(calendarDto dto);
    public int deleteCalendar(int member_no, int calendar_no);
}
