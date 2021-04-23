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
import com.pet.ft.dto.BusinessDto;

import com.pet.ft.dto.MemberDto;
import com.pet.ft.dto.PetDto;
import com.pet.ft.dto.PictureDto;


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
	public List<CommunityDto> CommunityList() {
		List<CommunityDto> list = new ArrayList<CommunityDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			list = session.selectList(namespace+"CommunityList");
		}
		return list;
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
	public List<MemberDto> memberList() {
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<MemberDto> list = session.selectList(namespace + "memberList");
		session.close();
		
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

	public List<MemberDto> memberList(int offset, int noOfRecords) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("offset", offset);
		params.put("noOfRecords", noOfRecords);
		
		SqlSession session = getSqlSessionFactory().openSession();
		List<MemberDto> list = session.selectList(namespace + "memberListPaging", params);
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
	
	
	//병원상담
	public List<BusinessDto> hospitalList(int offset, int noOfRecords) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("noOfRecords", noOfRecords);

	    SqlSession session = getSqlSessionFactory().openSession();
		List<BusinessDto> list = session.selectList(namespace+"hospitalList",params);
		session.close();
			
		return list;
	}
	
	public int totalHospital() {

		int res = 0;
		try (SqlSession session = getSqlSessionFactory().openSession(true)){
			res  = session.selectOne(namespace + "totalHospital");
		}
		return res;

	}
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
		}
		return dto;
	}

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

	@Override
	public int CalendarInsert(CalendarDto CalDto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"CalendarInsert", CalDto);
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
	public List<CommunityDto> reportList() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<CommunityDto> list = session.selectList(namespace + "reportList");
		session.close();
		
		return list;
	}

	@Override
	public int deleteCommnutiy(int seq) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "deleteCommunity" , seq);
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
	public boolean nextPage(String pageNumber) {
		boolean res = false;
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.selectOne(namespace + "nextPage" , pageNumber);
		}
		return res;
	}

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
		public MemberDto Login(String member_id, String member_pw) {
			MemberDto dto = null;
			Map<String, Object> map = new HashMap<>();
			map.put("member_id", member_id);
			map.put("member_pw", member_pw);
			
			try(SqlSession session = getSqlSessionFactory().openSession(true)){
				dto = session.selectOne(namespace+"Login", map);
				
			}
			return dto;
		}

		
}
