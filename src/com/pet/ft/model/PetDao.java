package com.pet.ft.model;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;

<<<<<<< HEAD
import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;


=======
import org.apache.ibatis.annotations.Param;

import com.pet.ft.dto.CalendarDto;
>>>>>>> jihyeon
import com.pet.ft.dto.CommunityDto;

import com.pet.ft.dto.MemberDto;


public interface PetDao {
	String namespace = "com.pet.ft.mapper.";

	int CommunityInsert(CommunityDto CDto);

	List<CommunityDto> CommunityList();

	CommunityDto CommunityOne(int seq);

<<<<<<< HEAD
<<<<<<< HEAD:semi_PetDiary/src/com/pet/ft/model/PetDao.java
	
=======
	//병원상담
>>>>>>> heeju:src/com/pet/ft/model/PetDao.java
	public List<BusinessDto> hospitalList();
	
	
	
	public BusinessDto hospitalSelect(int business_num);

<<<<<<< HEAD:semi_PetDiary/src/com/pet/ft/model/PetDao.java
	int CommentInsert(CommunityDto cdto);

	List<CommunityDto> CommentList(int community_no);


	List<CommunityDto> CommunitySearchList(String filter, String community_search);

	int CommunityReport(int community_seq);

	int CommunityUpdate(CommunityDto cdto);

	int CommunityDelete(int seq);

	int CommunityViews(int seq);

	int CommunityCommentCount(int seq);

=======
	public int hospitalBookInsert(BookDto dto);
	
>>>>>>> heeju:src/com/pet/ft/model/PetDao.java
=======
	MemberDto MemberOne(int member_no);
	
	int MemberInsert(MemberDto dto);
	
>>>>>>> jihyeon
	
	// 내가 추가 !!
	// id 중복체크
	MemberDto SignUpIdChk(String member_id);
	// email 중복체크
	MemberDto SighUpEmailChk(String member_email);
	
	int CalendarInsert(CalendarDto CalDto);

	List<CalendarDto> CalViewList(int member_no, String yyyyMM);
	
}
=======

import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public interface PetDao {

	public int totalMember();
	public int totalReport();
	public List<MemberDto> memberList();
	public List<MemberDto> memberList(int offset, int noOfRecords);
	public List<CommunityDto> reportList();
	public int changeRole(MemberDto dto);
	public int deleteCommnutiy(int seq);
	public boolean nextPage(String pageNumber);
}
>>>>>>> ig
