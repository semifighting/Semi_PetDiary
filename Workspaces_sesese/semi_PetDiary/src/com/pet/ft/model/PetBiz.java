package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public interface PetBiz {

	public int totalMember();
	public int totalReport();
	public int totalBook();
	
//	public List<MemberDto> memberList();
//	public List<CommunityDto> reportList();
	
	public List<MemberDto> memberList(int offset, int noOfRecords);
	public List<CommunityDto> reportList(int offset, int noOfRecords);
	public List<BookDto> bookList(int offset, int noOfRecords);
	
	public int changeRole(MemberDto dto);
	public int deleteCommnutiy(int seq);
}
