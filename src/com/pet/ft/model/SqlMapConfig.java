package com.pet.ft.model;

import java.io.IOException;
<<<<<<< HEAD



import java.io.Reader;


=======
import java.io.Reader;

>>>>>>> cf2a11737c593a3ed4ac7c9697b7ec278a3f855f
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

<<<<<<< HEAD


=======
>>>>>>> cf2a11737c593a3ed4ac7c9697b7ec278a3f855f
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "com/pet/ft/db/mybatis_config.xml";
		
		try(Reader reader = Resources.getResourceAsReader(resource)){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return sqlSessionFactory;
	}
<<<<<<< HEAD

=======
	
>>>>>>> cf2a11737c593a3ed4ac7c9697b7ec278a3f855f
}
