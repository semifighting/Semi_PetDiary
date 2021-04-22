package com.pet.ft.biz;


import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;

import java.util.List;

public interface PetBiz {

    //pet
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
    public List<CalendarDto> selectTripList(int member_no);
    public CalendarDto selectTripOne(int member_no, int calendar_no);
    public int insertTrip(CalendarDto dto);
    public int updateTrip(CalendarDto dto);
    public int deleteTrip(int member_no, int calendar_no);
    
  //calendar - 캘린더 내 clud
    public List<CalendarDto> CalViewList(int member_no, String yyyyMM);
	public List<CalendarDto> CalendarList(int member_no, String yyyyMMdd);
	public int CalendarInsert(CalendarDto CalDto);
	public CalendarDto CalendarOne(int calendar_no);
	public int CalendarDelete(int calendar_no);
	public int CalendarUpdate(CalendarDto dto);
	
}
