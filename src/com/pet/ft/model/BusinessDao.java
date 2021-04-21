package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;

public interface BusinessDao {
	String namespace1 = "com.pet.ft.mapper.";
	
	List<BusinessDto> BusinessList();
	
	BusinessDto businessOne(int business_num);
	
	int bookInsert(BookDto bookDto);//bookInsert: mapper에서 쓰는 아이디

}
