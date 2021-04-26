package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public interface PetDao {

	public int totalMember();
	public int totalReport();
	public int totalBookHos();
	public int totalBookSt();
	public List<BookDto> totalDateTime();
	
	/* 
	 * ∆‰¿Ã¬° x
	 * public List<MemberDto> memberList();
	 * public List<CommunityDto> reportList();
	 *  
	*/
	
	
	// ∆‰¿Ã¬° o
	public List<MemberDto> memberList(int offset, int noOfRecords);
	public List<CommunityDto> reportList(int offset, int noOfRecords);
	public List<BookDto> bookListHos(int offset, int noOfRecords);
	public List<BookDto> bookListSt(int offset, int noOfRecords);
	
	public int changeRole(MemberDto dto);
	public int deleteCommnutiy(int seq);
}
