package com.pet.ft.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;

public class PetDaoImpl extends SqlMapConfig implements PetDao {

	private String namespace = "com.pet.ft.mapper.";
	int noOfRecords;
	
	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	public int totalMember() {
		
		int res = 0;
		try (SqlSession session = getSqlSessionFactory().openSession(true)){
			res  = session.selectOne(namespace + "totalMember");
		}
	
		
		return res;
		
	}
	
	@Override
	public int totalReport() {
		
		int res = 0;
		try (SqlSession session = getSqlSessionFactory().openSession(true)){
			res  = session.selectOne(namespace + "totalReport");
		}
	
		
		return res;
	}
	

	@Override
	public int totalBook() {
		
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.selectOne(namespace + "totalBook");
		}
		return res;
	}

/*
	@Override
	public List<MemberDto> memberList() {
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<MemberDto> list = session.selectList(namespace + "memberList");
		session.close();
		
		System.out.println("rk");
		return list;
	}
	
	@Override
	public List<CommunityDto> reportList() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<CommunityDto> list = session.selectList(namespace + "reportList");
		session.close();
		
		return list;
	}
*/
	
	@Override
	public List<MemberDto> memberList(int offset, int noOfRecords) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("offset", offset);
		params.put("noOfRecords", noOfRecords);
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<MemberDto> list = session.selectList(namespace + "memberListPaging", params);	// 조건으로 볼 record숫자
		session.close();
		
		return list;
	}
	
	@Override
	public List<CommunityDto> reportList(int offset, int noOfRecords) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("offset", offset);
		params.put("noOfRecords", noOfRecords);
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<CommunityDto> list = session.selectList(namespace + "reportListPaging", params);	// 조건으로 볼 record숫자
		session.close();
		
		return list;
	}
	
	@Override
	public List<BookDto> bookList(int offset, int noOfRecords) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		System.out.println("of :" + offset + "no : " + noOfRecords);
		
		params.put("offset", offset);
		params.put("noOfRecords", noOfRecords);
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<BookDto> list = session.selectList(namespace + "bookListPaging", params);
		session.close();
		
		return list;
	}


	@Override
	public int changeRole(MemberDto dto) {
		
		int res = 0;
		
		try (SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.update(namespace + "changeRole", dto);
		}
		
		return res;
	}
	
	@Override
	public int deleteCommnutiy(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "deleteCommunity" , seq);
		}
		return res;
	}


}
