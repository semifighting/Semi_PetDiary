package com.pet.ft.controller;

import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;

public class pet_util {

	static PetDao dao = new PetDaoImpl();
	
	public static String FromMemberNoTogetName(int member_no) {
		return dao.MemberOne(member_no).getMember_name();
	}
	public static String FromMemberNoTogetPhone(int member_no) {
		return dao.MemberOne(member_no).getMember_phone();
	}
	public static String FromMemberNoTogetEmail(int member_no) {
		return dao.MemberOne(member_no).getMember_email();
	}
	public static String FromMemberNoTogetAddress(int member_no) {
		return dao.MemberOne(member_no).getMember_address();
	}
	public static String FromMemberNoTogetId(int member_no) {
		return dao.MemberOne(member_no).getMember_id();
	}	
	public static int CommunityCommentCount(int seq) {
		int res = dao.CommunityCommentCount(seq)-1;
		return res;
	}
	public static String FromBussinessNoTogetName(int seq) {
		return null;
	}
	
}
