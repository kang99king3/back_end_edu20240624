package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.daos.IUserDao;
import com.hk.board.dtos.UserDto;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public boolean insertUser(UserDto dto) {
		return userDao.insertUser(dto);
	}

	@Override
	public String idCheck(String id) {
		return userDao.idCheck(id);
	}

	@Override
	public UserDto getLogin(UserDto dto) {
		return userDao.getLogin(dto);
	}

	@Override
	public UserDto getUser(String id) {
		return userDao.getUser(id) ;
	}

	@Override
	public boolean updateUser(UserDto dto) {
		return userDao.updateUser(dto);
	}

	@Override
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	@Override
	public List<UserDto> getAllUserList() {
		return userDao.getAllUserList();
	}

	@Override
	public List<UserDto> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public boolean userUpdateRole(UserDto dto) {
		return userDao.userUpdateRole(dto);
	}

}
