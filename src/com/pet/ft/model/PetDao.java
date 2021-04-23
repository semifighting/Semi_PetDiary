package com.pet.ft.model;

import java.util.List;
import java.util.Map;
import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import org.apache.ibatis.annotations.Param;
import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;

public interface PetDao {
	String namespace = "com.pet.ft.mapper.";

	int CommunityInsert(CommunityDto CDto);

	List<CommunityDto> CommunityList();

	CommunityDto CommunityOne(int seq);

	//병원상담
	public List<BusinessDto> hospitalList(int offset, int noOfRecords);
	public int totalHospital();
	
	public BusinessDto hospitalSelect(int business_num);

	List<CommunityDto> CommentList(int community_no);


	List<CommunityDto> CommunitySearchList(String filter, String community_search);

	int CommunityReport(int community_seq);

	int CommunityUpdate(CommunityDto cdto);

	int CommunityDelete(int seq);

	int CommunityViews(int seq);

	int CommunityCommentCount(int seq);

	public int hospitalBookInsert(BookDto dto);

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
    public List<CalendarDto> selectTripList(int member_no);
    public CalendarDto selectTripOne(int member_no, int calendar_no);

    public int updateTrip(CalendarDto dto);
    public int insertTrip(CalendarDto dto);
    public int deleteTrip(int member_no, int calendar_no);

	// member
	MemberDto MemberOne(int member_no);
	int MemberInsert(MemberDto dto);
	MemberDto SignUpIdChk(String member_id);
	MemberDto SighUpEmailChk(String member_email);
	MemberDto Login(String member_id, String member_pw);
	
	public int totalMember();
	public int totalReport();
	public List<MemberDto> memberList();
	public List<MemberDto> memberList(int offset, int noOfRecords);
	public List<CommunityDto> reportList();
	public int changeRole(MemberDto dto);
	public int deleteCommnutiy(int seq);
	public boolean nextPage(String pageNumber);

    public List<CalendarDto> selectTripList(int member_no);
    public CalendarDto selectTripOne(int member_no, int calendar_no);
    public int updateTrip(CalendarDto dto);
    public int insertTrip(CalendarDto dto);
    public int deleteTrip(int member_no, int calendar_no);

    //calendar - 캘린더 내 clud
    public List<CalendarDto> CalViewList(int member_no, String yyyyMM);
	public List<CalendarDto> CalendarList(int member_no, String yyyyMMdd);
	public int CalendarInsert(CalendarDto CalDto);
	public CalendarDto CalendarOne(int calendar_no);
	public int CalendarDelete(int calendar_no);
	public int CalendarUpdate(CalendarDto dto);

}
