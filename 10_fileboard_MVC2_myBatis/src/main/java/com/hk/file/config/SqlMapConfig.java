package com.hk.file.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	//SqlSessionFactory객체를 구하는 코드를 정의
	
	//작업을 하기 위한 객체를 저장할 맴버필드
	private SqlSessionFactory sqlSessionFactory;
	
	//작업을 하기 위한 객체를 구하는 메서드
	public SqlSessionFactory getSqlSessionFactory() {
		String resource="sql/Configuration.xml";
		
		try {
			//Reader:작업메뉴얼, Resources: 작업메뉴얼을 만드는 객체
			Reader reader=Resources.getResourceAsReader(resource);
			//SqlSessionFactoryBuilder():sqlSessionFactory객체를 구해줌
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}










