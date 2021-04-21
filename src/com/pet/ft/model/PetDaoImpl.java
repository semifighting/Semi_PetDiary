package com.pet.ft.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public class PetDaoImpl extends SqlMapConfig implements PetDao {


	@Override
	public MemberDto MemberOne(int member_no) {
		MemberDto mdto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			mdto = session.selectOne(namespace+"MemberOne", member_no);
		}		
		return mdto;
	}
		
	
	@Override
	public List<CommunityDto> CommunityList() {
		List<CommunityDto> list = new ArrayList<CommunityDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CommunityList");
		}
		return list;
	}
	
	@Override
	public int CommunityInsert(CommunityDto CDto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"CommunityInsert", CDto);
		}
		return res;
	}

	@Override
	public CommunityDto CommunityOne(int seq) {
		CommunityDto cdto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			cdto = session.selectOne(namespace+"CommunityOne", seq);
		}
		return cdto;
	}
	
	
	// 내가 작성
	
	@Override
	public int MemberInsert(MemberDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"MemberInsert", dto);
		}
		return res;
	}

	@Override
	public MemberDto SignUpIdChk(String member_id) {
		MemberDto dto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			dto = session.selectOne(namespace+"SignUpIdChk", member_id);
		}
		return dto;
	}

	@Override
	public MemberDto SighUpEmailChk(String member_email) {
		MemberDto dto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			dto = session.selectOne(namespace+"SignUpEmailChk", member_email);
		}
		return dto;
	}


	@Override
	public int CalendarInsert(CalendarDto CalDto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"CalendarInsert", CalDto);
		}
		return res;
	}


	@Override
	public List<CalendarDto> CalViewList(int member_no, String yyyyMM) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		map.put("member_no", member_no);
		map.put("calendar_startdate", yyyyMM);
		System.out.println(map);
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CalViewList",map);
		}
		return list;
	}



		
}
