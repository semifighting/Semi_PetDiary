package com.pet.ft.model;

import com.pet.ft.dto.BusinessDto;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	// 회원가입
	public int MemberInsert(MemberDto Dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"MemberInsert", Dto);
		}
		return res;
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
	@Override
	public List<BusinessDto> hospitalList() {

		SqlSession session = getSqlSessionFactory().openSession();
								//session.selectList는 sqlSeesion클래스의 메소드
								//myboard-mapper가서 selectList는 id가 될 것
			List<BusinessDto> list = session.selectList(namespace+"selectList");
			session.close();
			
		return list;
	}

	@Override
	public BusinessDto hospitalSelect(int business_num) {
		SqlSession session = null;
		BusinessDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "selectOne", business_num);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}

}
