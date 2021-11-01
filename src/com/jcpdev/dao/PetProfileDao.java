package com.jcpdev.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.Pet;
import com.jcpdev.mybatis.SqlSessionBean;

public class PetProfileDao {

	
		SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
		private static PetProfileDao dao = new PetProfileDao();
		private PetProfileDao() {}
		public static PetProfileDao getInstance() {
			return dao;
		}
		

		public void p_insert(Pet dto) {
			SqlSession mapper = factory.openSession();
			mapper.insert("petprofile.p_insert", dto);
			mapper.commit();
			mapper.close();
		}
		
		public com.jcpdev.dto.Pet p_check(Map<String, String> map) {
			SqlSession mapper = factory.openSession();
			Pet dto = mapper.selectOne("petprofile.p_check", map);
			return dto;
		}
	
}
