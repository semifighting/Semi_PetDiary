package com.pet.ft.model;

import java.util.List;


import com.pet.ft.dto.BusinessDto;


import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public interface PetDao {
	String namespace = "com.pet.ft.mapper.";

	MemberDto MemberOne(int member_no);
	
	int MemberInsert(MemberDto Dto);
	
	int CommunityInsert(CommunityDto CDto);

	List<CommunityDto> CommunityList();

	CommunityDto CommunityOne(int seq);
	
	public List<BusinessDto> hospitalList();
	
	public BusinessDto hospitalSelect(int business_num);
	
	// id 중복체크
	MemberDto SignUpIdChk(String member_id);
	
	// email 중복체크
	MemberDto SighUpEmailChk(String member_email);

}
