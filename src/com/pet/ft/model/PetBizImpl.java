package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;

import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;


import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public class PetBizImpl implements PetBiz {
	
	private PetDao dao = new PetDaoImpl();
	private BusinessDao bdao = new BusinessDaoImpl();



	@Override
	public List<BusinessDto> hospitalList() {
	
		return dao.hospitalList();
	}

	@Override
	public BusinessDto hospitalSelect(int business_num) {
	
		return dao.hospitalSelect(business_num);
	}

	@Override
	public int hospitalBookInsert(BookDto dto) {
		
		return dao.hospitalBookInsert(dto);
	}

	

	

	public BusinessDto businessOne(int business_num) {
		return bdao.businessOne(business_num);
	}

	

	@Override
	public int totalMember() {
		return dao.totalMember();
	}

	@Override
	public List<MemberDto> memberList() {
		return dao.memberList();
	}

	@Override
	public int changeRole(MemberDto dto) {
		return dao.changeRole(dto);
	}

	@Override
	public int totalReport() {
		return dao.totalReport();
	}

	@Override
	public List<CommunityDto> reportList() {
		return dao.reportList();
	}

	@Override
	public int deleteCommnutiy(int seq) {
		return dao.deleteCommnutiy(seq);
	}

	@Override
	public List<MemberDto> memberList(int offset, int noOfRecords) {
		return dao.memberList(offset, noOfRecords);
	}

}
