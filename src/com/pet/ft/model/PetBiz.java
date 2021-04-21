package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;



public interface PetBiz {
	
	public List<BusinessDto> hospitalList();
	
	
	public BusinessDto hospitalSelect(int business_num);
	
	public int hospitalBookInsert(BookDto dto);
	
	

	public BusinessDto businessOne(int business_num);

	public int totalMember();
	public int totalReport();
	public List<MemberDto> memberList();
	public List<MemberDto> memberList(int offset, int noOfRecords);
	public List<CommunityDto> reportList();
	public int changeRole(MemberDto dto);
	public int deleteCommnutiy(int seq);
}
