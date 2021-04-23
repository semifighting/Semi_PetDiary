package com.pet.ft.model;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CommunityDto;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pet.ft.dto.BusinessDto;

public class BusinessDaoImpl extends SqlMapConfig implements BusinessDao {

	@Override
	public List<BusinessDto> BusinessList() {
		List<BusinessDto> list = new ArrayList<BusinessDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace1+"BusinessList");
		}
		return list;
	}

	@Override
	public BusinessDto businessOne(int business_num) {
		BusinessDto bdto = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			bdto = session.selectOne(namespace1+"BusinessOne", business_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bdto;
	
	}

	@Override
	public int BusinessInsert(BusinessDto bdto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace1+"BusinessInsert", bdto);
		}
		return res;
	}
	

	@Override
	public int bookInsert(BookDto bookDto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace1+"BookInsert", bookDto);
		}
		return res;
	}

}
