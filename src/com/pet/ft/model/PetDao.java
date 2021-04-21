package com.pet.ft.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;


public interface PetDao {
	
	
	String namespace = "com.pet.ft.mapper.";

	MemberDto MemberOne(int member_no);

	List<CommunityDto> CommunitySearchList(String filter, String community_search);

	public int CommunityReport(int seq);
	
	public int CommunityUpdate(CommunityDto cdto);

	public int CommunityDelete(int seq);


	public int CommunityViews(int seq);

	public int CommunityCommentCount(int seq);
	
	
	// 회원가입
	public int MemberInsert(MemberDto Dto);
		
	
	public List<CommunityDto> CommunityList();

	
	public int totalMember();

	
	public List<MemberDto> memberList() ;
	
	
	public int CommunityInsert(CommunityDto CDto);

	
	public CommunityDto CommunityOne(int seq);

	
	public List<CommunityDto> CommentList(int community_no);
	
	
	public int CommentInsert(CommunityDto cdto);
	public List<MemberDto> memberList(int offset, int noOfRecords);

	public int changeRole(MemberDto dto);
	
	
	public List<BusinessDto> hospitalList();
	
	
	public BusinessDto hospitalSelect(int business_num);
	public MemberDto SignUpIdChk(String member_id);
	public MemberDto SighUpEmailChk(String member_email);


	public int hospitalBookInsert(BookDto dto) ;
	

	public int CalendarInsert(CalendarDto CalDto);

	public int totalReport();


	public int deleteCommnutiy(int seq) ;


	public List<CalendarDto> CalViewList(int member_no, String yyyyMM);

	public boolean nextPage(String pageNumber);

	List<CommunityDto> reportList();

		
}

