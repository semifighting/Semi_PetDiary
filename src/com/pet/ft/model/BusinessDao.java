package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BusinessDto;

public interface BusinessDao {
	String namespace1 = "com.pet.ft.mapper.";
	
	List<BusinessDto> BusinessList();
	
	BusinessDto BusinessOne(int seq);
	

}
