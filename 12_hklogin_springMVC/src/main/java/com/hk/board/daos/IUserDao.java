package com.hk.board.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.board.dtos.UserDto;


public interface IUserDao {
	//1. 회원가입 기능(enabled:'Y', role:'USER', regDate:SYSDATE() )
	//insert문 실행
	public boolean insertUser(UserDto dto) ;
	
	//아이디 중복 체크하기
	public String idCheck(String id) ;
	
	//로그인 기능: 파라미터 ID, Password
	public UserDto getLogin(UserDto dto);
	
	//나의 정보 조회
	public UserDto getUser(String id) ;
	
	//나의 정보 수정하기: 파라미터 - id , address, email
	public boolean updateUser(UserDto dto) ;
	
	//회원 탈퇴 : enabled - 'N' 업데이트 , 파라미터: id
	public boolean delUser(String id) ;
	
	//회원목록 전체조회
	public List<UserDto> getAllUserList();
		
	//회원목록 전제 조회[사용중]
	public List<UserDto> getUserList();
		
	//회원등급수정
	public boolean userUpdateRole(UserDto dto);
}
