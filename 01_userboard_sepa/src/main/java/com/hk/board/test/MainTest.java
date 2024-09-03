package com.hk.board.test;

import java.util.List;

import com.hk.board.daos.UserDao;
import com.hk.board.dtos.UserDto;

public class MainTest {

	public static void main(String[] args) {
		
		//DB접근----> DAO객체
		UserDao dao=new UserDao();
		
		//회원목록 조회
		List<UserDto> userList=dao.getAllUser();
		System.out.println("==회원목록==");
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		
		//회원정보 등록
		//setter메서드를 사용했을 경우
//		UserDto dto=new UserDto();
//		dto.setUserID("KKA");
//		dto.setName("김경호");
//		dto.setBirthYear(1971);
		//생성자 오버로딩을 사용했을 경우 코드가 간단하다..
//		UserDto dto=new UserDto("KKH", "김경호", 1971, 
//				                "전남", "019", "12345678", 177, null);
//		boolean isS=dao.insertUser(dto);//파리미터를 DTO객체를 통해 전달.
//		System.out.println("회원정보등록성공:"+isS);
		
		//회원정보 수정
		boolean isSUpdate=dao.updateUser(new UserDto(
							 				"KKH",
							 				"김건모",
							 				 1970,
							 				"서울",
							 				"011",
							 				"12345678",
							 				 170
										));
		System.out.println("회원수정성공:"+isSUpdate);
		
		//회원상세조회
		System.out.println("==회원상세조회==");
		UserDto dto=dao.getUser("KKH");
		System.out.println(dto);
	}

}







