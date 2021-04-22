package com.pet.ft.dao;

import com.pet.ft.dto.CalendarDto;
import com.pet.ft.dto.MemberDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetDaoImpl extends SqlMapConfig implements PetDao {



    @Override
    public List<PetDto> selectPetList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<PetDto> list = session.selectList(namespace + "selectPetList", member_no);
        session.close();
        return list;
    }

    @Override
    public PetDto selectPetOne(int member_no, int pet_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("pet_no", pet_no);
        PetDto dto = session.selectOne(namespace + "selectPetOne", map);
        session.close();

        return dto;
    }

    @Override
    public int getCount(int member_no) {

        int res = 0;
        SqlSession session = getSqlSessionFactory().openSession();
        res = session.selectOne(namespace + "getCount", member_no);
        session.close();
        return res;
    }
    @Override
    public int insertPet(PetDto dto) {
        int res = 0;

        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "insertPet", dto);
        }
        return res;
    }

    @Override
    public int updatePet(PetDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.update(namespace + "updatePet", dto);
        }
        return res;
    }

    @Override
    public int deletePet(int member_no, int pet_no) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("pet_no", pet_no);
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.delete(namespace + "deletePet", map);
        }
        return res;
    }

    @Override
    public List<PictureDto> selectPictureList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<PictureDto> list = session.selectList(namespace + "selectPictureList",  member_no);
        session.close();
        return list;
    }

    @Override
    public PictureDto selectPictureOne(int member_no, int picture_no) {
        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("picture_no", picture_no);
        PictureDto dto = session.selectOne(namespace + "selectPictureOne", map);
        session.close();
        return dto;
    }


    @Override
    public int insertPicture(PictureDto dto) {

        int res = 0;
        try(SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "insertPicture", dto);
        }
        return res;
    }

    @Override
    public int deletePicture(int member_no, int picture_no) {

        int res = 0;
        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("picture_no", picture_no);

        try(SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(namespace + "deletePicture", map);
        }

        return res;
    }

    @Override
    public PetDto selectPetOnePaging(int member_no, int count) {


        SqlSession session = getSqlSessionFactory().openSession();

        Map<String, Integer> map = new HashMap<String , Integer>();
        map.put("member_no", member_no);
        map.put("count", count);

        PetDto dto = session.selectOne(namespace + "selectPetOnePaging", map);
        return dto;
    }

    @Override
    public List<CalendarDto> selectTripList(int member_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        List<CalendarDto> list = session.selectList(namespace + "selectTripList", member_no);
        session.close();

        return list;
    }

    @Override
    public CalendarDto selectTripOne(int member_no, int calendar_no) {

        SqlSession session = getSqlSessionFactory().openSession();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("calendar_no", calendar_no);
        CalendarDto dto = session.selectOne(namespace + "selectTripOne", map);

        return dto;
    }

    @Override
    public int insertTrip(CalendarDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.insert(namespace + "insertTrip", dto);
        }
        return res;
    }

    @Override
    public int updateTrip(CalendarDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)){
            res = session.update(namespace + "updateTrip", dto);
        }
        return res;
    }

    @Override
    public int deleteTrip(int member_no, int calendar_no) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("member_no", member_no);
        map.put("calendar_no", calendar_no);

        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.delete(namespace + "deleteTrip", map);
        }
        return res;
    }
    
    @Override
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

	@Override
	public List<CalendarDto> CalendarList(int member_no, String yyyyMMdd) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		map.put("member_no", member_no);
		map.put("calendar_startdate", yyyyMMdd);
		System.out.println(map);
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CalendarList",map);
		}
		return list;
	}

	@Override
	public CalendarDto CalendarOne(int carlendar_no) {
		CalendarDto CalDto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			CalDto = session.selectOne(namespace+"CalendarOne", carlendar_no);
		}
		return CalDto;
	}

	@Override
	public int CalendarDelete(int calendar_no) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.delete(namespace+"CalendarDelete", calendar_no);
		}
		return res;
	}

	@Override
	public int CalendarUpdate(CalendarDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.delete(namespace+"CalendarUpdate", dto);
		}
		return res;
	}

	@Override
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

}
