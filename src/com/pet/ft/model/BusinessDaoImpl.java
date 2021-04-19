package com.pet.ft.model;

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
	public BusinessDto BusinessOne(int seq) {
		BusinessDto bdto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			bdto = session.selectOne(namespace1+"BusinessOne", seq);
		}
		return bdto;
	}

}
