package com.pet.ft.model;

import java.util.List;

import com.pet.ft.dto.BookDto;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.dto.CalendarDto;
import com.pet.ft.model.PetDao;
import com.pet.ft.model.PetDaoImpl;


import com.pet.ft.dto.CommunityDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;

public class PetBizImpl implements PetBiz {
	
	private PetDao dao = new PetDaoImpl();
	private BusinessDao bdao = new BusinessDaoImpl();



	@Override
	public List<BusinessDto> hospitalList(int offset, int noOfRecords) {

			return dao.hospitalList(offset,noOfRecords);
	}
	
	@Override
	public int totalHospital() {
			// TODO Auto-generated method stub
			return dao.totalHospital();
	}

	@Override
	public BusinessDto hospitalSelect(int business_num) {
	
		return dao.hospitalSelect(business_num);
	}

	@Override
	public int hospitalBookInsert(BookDto dto) {
		
		return dao.hospitalBookInsert(dto);
	}


	public BusinessDto businessOne(int business_num) {
		return bdao.businessOne(business_num);
	}

	@Override
	public int totalMember() {
		return dao.totalMember();
	}

	@Override
	public List<MemberDto> memberList() {
		return dao.memberList();
	}

	@Override
	public int changeRole(MemberDto dto) {
		return dao.changeRole(dto);
	}

	@Override
	public int totalReport() {
		return dao.totalReport();
	}

	@Override
	public List<CommunityDto> reportList() {
		return dao.reportList();
	}

	@Override
	public int deleteCommnutiy(int seq) {
		return dao.deleteCommnutiy(seq);
	}

	@Override
	public List<MemberDto> memberList(int offset, int noOfRecords) {
		return dao.memberList(offset, noOfRecords);
	}

   @Override
    public List<PetDto> selectPetList(int member_no) {
        return dao.selectPetList(member_no);
    }

    @Override
    public PetDto selectPetOne(int member_no, int pet_no) {
        return dao.selectPetOne(member_no, pet_no);
    }

    @Override
    public int insertPet(PetDto dto) {
        return dao.insertPet(dto);
    }

    @Override
    public int getCount(int member_no) {
        return dao.getCount(member_no);
    }

    @Override
    public int updatePet(PetDto dto) {
        return dao.updatePet(dto);
    }

    @Override
    public int deletePet(int member_no, int pet_no) {
        return dao.deletePet(member_no, pet_no);
    }

    @Override
    public PetDto selectPetOnePaging(int member_no, int count) {
        return dao.selectPetOnePaging(member_no, count);
    }

    @Override
    public List<PictureDto> selectPictureList(int member_no) {
        return dao.selectPictureList(member_no);
    }

    @Override
    public PictureDto selectPictureOne(int member_no, int picture_no) {
        return dao.selectPictureOne(member_no, picture_no);
    }

    @Override
    public int insertPicture(PictureDto dto) {
        return dao.insertPicture(dto);
    }

    @Override
    public int deletePicture(int member_no, int picture_no) {
        return dao.deletePicture(member_no, picture_no);
    }

    @Override
    public List<CalendarDto> selectTripList(int member_no) {
        return dao.selectTripList(member_no);
    }

    @Override
    public CalendarDto selectTripOne(int member_no, int calendar_no) {
        return dao.selectTripOne(member_no, calendar_no);
    }

    @Override
    public int insertTrip(CalendarDto dto) {
        return dao.insertTrip(dto);
    }

    @Override
    public int updateTrip(CalendarDto dto) {
        return dao.updateTrip(dto);
    }

    @Override
    public int deleteTrip(int member_no, int calendar_no) {
        return dao.deleteTrip(member_no, calendar_no);
    }

	@Override
	public List<CalendarDto> CalViewList(int member_no, String yyyyMM) {
		return dao.CalViewList(member_no, yyyyMM);
	}

	@Override
	public List<CalendarDto> CalendarList(int member_no, String yyyyMMdd) {
		return dao.CalendarList(member_no, yyyyMMdd);
	}

	@Override
	public int CalendarInsert(CalendarDto CalDto) {
		return dao.CalendarInsert(CalDto);
	}

	@Override
	public CalendarDto CalendarOne(int calendar_no) {
		return dao.CalendarOne(calendar_no);
	}

	@Override
	public int CalendarDelete(int calendar_no) {
		return dao.CalendarDelete(calendar_no);
	}

	@Override
	public int CalendarUpdate(CalendarDto dto) {
		return dao.CalendarUpdate(dto);
	}

	@Override
	public MemberDto Login(java.lang.String member_id, java.lang.String member_pw) {
		return dao.Login(member_id, member_pw);
	}
	
}
