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
	public int totalBookHos() {
		return dao.totalBookHos();
	}
	
	@Override
	public int totalBookSt() {
		return dao.totalBookSt();
	}
	
	@Override
	public List<BookDto> totalDateTime(){
		return dao.totalDateTime();
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
	public List<BookDto> bookListHos(int offset, int noOfRecords) {
		return dao.bookListHos(offset, noOfRecords);
	}
	
	@Override
	public List<BookDto> bookListSt(int offset, int noOfRecords) {
		return dao.bookListSt(offset, noOfRecords);
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
