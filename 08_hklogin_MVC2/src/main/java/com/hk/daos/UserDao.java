package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.database.DataBase;
import com.hk.dtos.RoleStatus;
import com.hk.dtos.UserDto;

public class UserDao extends DataBase{

	//싱글톤 패턴 : 객체를 한번만 생성하자
	//외부에 접근할때 new를 사용 못하게 하자: new UserDao()
	public static UserDao userDao;
	private UserDao() {}
	public static UserDao getUserDao() { // UserDao.getUserDao() 가능
		if(userDao==null) {
			userDao=new UserDao();//내부에서 객체생성 한번 함			
		}
		return userDao;
	}
	
	//사용자 기능
	
	//1. 회원가입 기능(enabled:'Y', role:'USER', regDate:SYSDATE() )
	//insert문 실행
	public boolean insertUser(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" INSERT INTO USERINFO "
				 + " VALUES(NULL,?,?,?,?,?,'Y',?,SYSDATE())";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, String.valueOf(RoleStatus.USER));
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//아이디 중복 체크하기
	public String idCheck(String id) {
		String resultId=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql="SELECT ID FROM USERINFO WHERE ID=?";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				resultId=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return resultId;
	}
	
	//로그인 기능: 파라미터 ID, Password
	public UserDto getLogin(String id, String password) {
		UserDto dto=new UserDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT ID, NAME, ROLE "
				 + " FROM USERINFO "
				 + " WHERE ID=? AND PASSWORD=? AND ENABLED='Y' ";
		
		try {
			conn=getConnection();
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}
	
	//나의 정보 조회
	public UserDto getUser(String id) {
		UserDto dto=new UserDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT SEQ, ID, NAME, ADDRESS, EMAIL, ROLE, REGDATE "
				 + " FROM USERINFO "
				 + " WHERE ID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setRole(rs.getString(6));
				dto.setRegDate(rs.getDate(7));
			}
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}
	
	//나의 정보 수정하기: 파라미터 - id , address, email
	public boolean updateUser(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE USERINFO SET ADDRESS = ?, EMAIL = ? "
				 + " WHERE ID = ? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getAddress());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getId());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//회원 탈퇴 : enabled - 'N' 업데이트 , 파라미터: id
	public boolean delUser(String id) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE USERINFO SET ENABLED = 'N' WHERE ID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//회원목록 전체조회
		public List<UserDto> getAllUserList(){
			List<UserDto> list=new ArrayList<>();
			
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			
			String sql=" SELECT seq, id, NAME, address, email, role, "
					 + " enabled,regdate "
					 + " FROM userinfo ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					UserDto dto=new UserDto();
					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setAddress(rs.getString(4));
					dto.setEmail(rs.getString(5));
					dto.setRole(rs.getString(6));
					dto.setEnabled(rs.getString(7));
					dto.setRegDate(rs.getDate(8));
					list.add(dto);
					System.out.println(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, psmt, conn);
			}
			return list;
		}
		
		//회원목록 전제 조회[사용중]
		public List<UserDto> getUserList(){
			List<UserDto> list=new ArrayList<>();
			
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			
			String sql=" SELECT seq, id, NAME, role, "
					 + " regdate "
					 + " FROM userinfo "
					 + " WHERE enabled='Y' ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					UserDto dto=new UserDto();
					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setRole(rs.getString(4));
					dto.setRegDate(rs.getDate(5));
					list.add(dto);
					System.out.println(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, psmt, conn);
			}
			return list;
		}
		
		//회원등급수정
		public boolean userUpdateRole(String id, String role) {
			int count=0;
			Connection conn=null;
			PreparedStatement psmt=null;
			
			String sql=" UPDATE userinfo "
					 + " SET role=? "
					 + " WHERE id=? ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, role);
				psmt.setString(2, id);
				count=psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(null, psmt, conn);
			}
			
			return count>0?true:false;
		}
}














