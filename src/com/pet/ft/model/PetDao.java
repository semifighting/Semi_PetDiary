package com.pet.ft.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public interface PetDao {
	String namespace = "com.pet.ft.mapper.";

	int CommunityInsert(CommunityDto CDto);

	List<CommunityDto> CommunityList();

	CommunityDto CommunityOne(int seq);

	MemberDto MemberOne(int member_no);
	
	int MemberInsert(MemberDto dto);
	
	
	// 내가 추가 !!
	// id 중복체크
	MemberDto SignUpIdChk(String member_id);
	// email 중복체크
	MemberDto SighUpEmailChk(String member_email);
	
	int CalendarInsert(CalendarDto CalDto);

	List<CalendarDto> CalViewList(int member_no, String yyyyMM);
	
}