package com.hk.file.daos;

import org.apache.ibatis.session.SqlSession;

import com.hk.file.config.SqlMapConfig;
import com.hk.file.dtos.FileDto;

public class FileDao extends SqlMapConfig{

	private String namespace="com.hk.file.";
	
	//1.업로드 파일의 정보 추가
	public boolean insertFile(FileDto dto) {
		int count=0;
		
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.insert(namespace+"insertfile", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;
	}
}







