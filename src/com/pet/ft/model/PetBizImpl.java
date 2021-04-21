package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BusinessDto;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;

public class PetBizImpl implements PetBiz {
	
	private PetDao dao = new PetDaoImpl();
	
	@Override
	public List<BusinessDto> hospitalList() {
	
		return dao.hospitalList();
	}

	@Override
	public BusinessDto hospitalSelect(int business_num) {
	
		return dao.hospitalSelect(business_num);
	}

}
