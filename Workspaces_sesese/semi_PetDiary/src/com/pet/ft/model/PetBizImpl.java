package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public class PetBizImpl implements PetBiz {
	
	PetDao dao = new PetDaoImpl();

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
