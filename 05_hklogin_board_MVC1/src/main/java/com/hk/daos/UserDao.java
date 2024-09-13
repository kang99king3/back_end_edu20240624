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
		
		String sql=" INSERT INTO T_USER "
				 + " VALUES(?,?,?,?,?,?,'Y',?,SYSDATE())";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTid());
			psmt.setString(2, dto.getTpassword());
			psmt.setString(3, dto.getTname());
			psmt.setString(4, dto.getTaddress());
			psmt.setString(5, dto.getTphone());
			psmt.setString(6, dto.getTemail());
			psmt.setString(7, String.valueOf(RoleStatus.USER));
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//아이디 중복 체크하기
	public String idCheck(String tid) {
		String resultId=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql="SELECT TID FROM T_USER WHERE TID=?";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, tid);
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
	public UserDto getLogin(String tid, String tpassword) {
		UserDto dto=new UserDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT TID, TNAME, TROLE "
				 + " FROM T_USER "
				 + " WHERE TID=? AND TPASSWORD=? AND TENABLED='Y' ";
		
		try {
			conn=getConnection();
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, tid);
			psmt.setString(2, tpassword);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				dto.setTid(rs.getString(1));
				dto.setTname(rs.getString(2));
				dto.setTrole(rs.getString(3));
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
		
		String sql=" SELECT TID, TNAME, TADDRESS,TPHONE, TEMAIL, TROLE, TREGDATE "
				 + " FROM T_USER "
				 + " WHERE TID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setTid(rs.getString(1));
				dto.setTname(rs.getString(2));
				dto.setTaddress(rs.getString(3));
				dto.setTphone(rs.getString(4));
				dto.setTemail(rs.getString(5));
				dto.setTrole(rs.getString(6));
				dto.setTregDate(rs.getDate(7));
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
		
		String sql=" UPDATE T_USER SET TADDRESS = ?,TPHONE=?, TEMAIL = ? "
				 + " WHERE TID = ? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTaddress());
			psmt.setString(2, dto.getTphone());
			psmt.setString(3, dto.getTemail());
			psmt.setString(4, dto.getTid());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//회원 탈퇴 : enabled - 'N' 업데이트 , 파라미터: id
	public boolean delUser(String tid) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" UPDATE T_USER SET TENABLED = 'N' WHERE TID=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, tid);
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
			
			String sql=" SELECT TID, TNAME, TADDRESS,TPHONE, TEMAIL, TROLE, "
					 + " TENABLED,TREGDATE "
					 + " FROM T_USER ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					UserDto dto=new UserDto();
		
					dto.setTid(rs.getString(1));
					dto.setTname(rs.getString(2));
					dto.setTaddress(rs.getString(3));
					dto.setTphone(rs.getString(4));
					dto.setTemail(rs.getString(5));
					dto.setTrole(rs.getString(6));
					dto.setTenabled(rs.getString(7));
					dto.setTregDate(rs.getDate(8));
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
			
			String sql=" SELECT  TID, TNAME, TROLE, "
					 + " TREGDATE "
					 + " FROM T_USER "
					 + " WHERE TENABLED='Y' ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					UserDto dto=new UserDto();
					dto.setTid(rs.getString(1));
					dto.setTname(rs.getString(2));
					dto.setTrole(rs.getString(3));
					dto.setTregDate(rs.getDate(4));
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
		public boolean userUpdateRole(String tid, String trole) {
			int count=0;
			Connection conn=null;
			PreparedStatement psmt=null;
			
			String sql=" UPDATE T_USER "
					 + " SET TROLE=? "
					 + " WHERE TID=? ";
			
			try {
				conn=getConnection();
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, trole);
				psmt.setString(2, tid);
				count=psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(null, psmt, conn);
			}
			
			return count>0?true:false;
		}
}














