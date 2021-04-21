package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BusinessDto;

public interface PetBiz {
	
	public List<BusinessDto> hospitalList();
	
	public BusinessDto hospitalSelect(int business_num);

	public BusinessDto businessOne(int business_num);
}
