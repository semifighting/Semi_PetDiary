package com.pet.ft.model;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
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
	public List<CommunityDto> CommunitySearchList(String filter, String community_search){
		List<CommunityDto> list = new ArrayList<CommunityDto>();		
		switch (filter) {
		case "title":
			try(SqlSession session = getSqlSessionFactory().openSession(true)){
				list = session.selectList(namespace+"CommunitySearchTitle", community_search);
			}		
			break;

		case "content":
			try(SqlSession session = getSqlSessionFactory().openSession(true)){
				list = session.selectList(namespace+"CommunitySearchContent", community_search);
			}		
			
			break;
		case "comment_content" :
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CommunitySearchCommentContent", community_search);
			}				
		}
		return list;
	}
	
	@Override
	public int CommunityReport(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.update(namespace+"CommunityReport", seq);
		}		
		return res;
	}
	
	@Override
	public int CommunityUpdate(CommunityDto cdto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.update(namespace+"CommunityUpdate", cdto);
		}		
		return res;
	}

	@Override
	public int CommunityDelete(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.delete(namespace+"CommunityDelete", seq);
		}		
		return res;
	}


	@Override
	public int CommunityViews(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.update(namespace+"CommunityViews", seq);
		}		
		return res;
	}
	

	@Override
	public int CommunityCommentCount(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.selectOne(namespace+"CommunityCommentCount", seq);
		}		
		return res;
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
	public List<CommunityDto> CommentList(int community_no) {
		List<CommunityDto> list = new ArrayList<CommunityDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CommentList", community_no);
		}
		for(CommunityDto dto : list) {
		}
		
		return list;
	}
	
	
	@Override
	public int CommentInsert(CommunityDto cdto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"CommentInsert", cdto);
		}
		
		return res;
	}
	
	
	//병원상담
	@Override
	public List<BusinessDto> hospitalList() {
		
		
	     SqlSession session = getSqlSessionFactory().openSession();
								
			List<BusinessDto> list = session.selectList(namespace+"hospitalList");
			session.close();
			
		return list;
	
	
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
	public BusinessDto hospitalSelect(int business_num) {
		SqlSession session = null;
		BusinessDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "hospitalOne", business_num);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
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
	public int hospitalBookInsert(BookDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"BookCounselInsert", dto);
		}
		return res;
		
	}


	


	

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
