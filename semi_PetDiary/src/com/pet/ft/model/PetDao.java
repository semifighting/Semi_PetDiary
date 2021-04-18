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
<<<<<<< HEAD

	MemberDto MemberOne(int member_no);
	
	public List<BusinessDto> hospitalList();
	
	public BusinessDto hospitalSelect(int business_num);

=======
	
>>>>>>> 2fca2884c0c828504e62fb402322657862f7aa4b

}
