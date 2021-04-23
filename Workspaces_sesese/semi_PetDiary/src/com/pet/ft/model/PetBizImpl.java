package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public class PetBizImpl implements PetBiz {
	
	PetDao dao = new PetDaoImpl();

	@Override
	public int totalMember() {
		return dao.totalMember();
	}
	
	@Override
	public int totalReport() {
		return dao.totalReport();
	}
	
	@Override
	public int totalBook() {
		return dao.totalBook();
	}

	/*
	@Override
	public List<MemberDto> memberList() {
		return dao.memberList();
	}
	
	@Override
	public List<CommunityDto> reportList() {
		return dao.reportList();
	}
	*/
	
	@Override
	public List<MemberDto> memberList(int offset, int noOfRecords) {
		return dao.memberList(offset, noOfRecords);
	}
	

	@Override
	public List<CommunityDto> reportList(int offset, int noOfRecords) {
		return dao.reportList(offset, noOfRecords);
	}
	
	@Override
	public List<BookDto> bookList(int offset, int noOfRecords) {
		return dao.bookList(offset, noOfRecords);
	}


	@Override
	public int changeRole(MemberDto dto) {
		return dao.changeRole(dto);
	}


	@Override
	public int deleteCommnutiy(int seq) {
		return dao.deleteCommnutiy(seq);
	}



}
