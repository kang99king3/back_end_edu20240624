package com.hk.board.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.UserDto;

@Repository
public class UserDaoImp implements IUserDao{

	private String namespace="com.hk.board.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean insertUser(UserDto dto) {
		int count=sqlSession.insert(namespace+"insertuser", dto);
		return count>0?true:false;
	}

	@Override
	public String idCheck(String id) {
		return sqlSession.selectOne(namespace+"idcheck", id);
	}

	@Override
	public UserDto getLogin(UserDto dto) {
		return sqlSession.selectOne(namespace+"login", dto);
	}

	@Override
	public UserDto getUser(String id) {
		return sqlSession.selectOne(namespace+"getuser", id);
	}

	@Override
	public boolean updateUser(UserDto dto) {
		int count=sqlSession.update(namespace+"updateuser", dto);
		return count>0?true:false;
	}

	@Override
	public boolean delUser(String id) {
		int count=sqlSession.update(namespace+"deluser", id);
		return count>0?true:false;
	}

	@Override
	public List<UserDto> getAllUserList() {
		return sqlSession.selectList(namespace+"getalluserlist");
	}

	@Override
	public List<UserDto> getUserList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getuserlist");
	}

	@Override
	public boolean userUpdateRole(UserDto dto) {
		int count=sqlSession.update(namespace+"userupdaterole", dto);
		return count>0?true:false;
	}

}
