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

	int CommentInsert(CommunityDto cdto);

	List<CommunityDto> CommentList(int community_no);


	List<CommunityDto> CommunitySearchList(String filter, String community_search);

	int CommunityReport(int community_seq);

	int CommunityUpdate(CommunityDto cdto);

	int CommunityDelete(int seq);

	int CommunityViews(int seq);

	int CommunityCommentCount(int seq);

	

}
