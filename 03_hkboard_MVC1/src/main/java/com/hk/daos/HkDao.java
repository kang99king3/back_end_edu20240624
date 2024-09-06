package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hk.database.DataBase;
import com.hk.dtos.HkDto;

//DAO객체: Database에 접근하여 작업하는 객체
public class HkDao extends DataBase{

	public HkDao() {//생략가능
		super();//생략가능 --> 부모의 생성자 호출--> 생성자를 호출한다는건.. 객체를 생성
	}
	
	//글목록 조회 기능: 여러개의 행이 반환 --> 반환타입은?? List
	//                                    하나의 행 --> DTO
	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<>();
		
		Connection conn=null;//DB연결 객체
		PreparedStatement psmt=null;//쿼리준비 객체
		ResultSet rs=null;//쿼리 결과를 받을 객체
		
		String sql=" SELECT SEQ, ID, TITLE, CONTENT, REGDATE "
				+  " FROM HKBOARD ORDER BY REGDATE DESC ";
		
		try {
			conn=getConnection();//2단계:DB연결
			psmt=conn.prepareStatement(sql);//3단계:쿼리 준비
			rs=psmt.executeQuery();//4단계:쿼리실행
			while(rs.next()) {
				HkDto dto=new HkDto();//DTO는 행단위로 저장
				dto.setSeq(rs.getInt(1));//DB는 인덱스 체계가 1부터 시작함
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getDate(5));
				list.add(dto);
				System.out.println(dto);
			}
			System.out.println("5단계:쿼리결과받기");
		} catch (SQLException e) {
			System.out.println("JDBC실패:"+getClass()+"getAllList()");
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);//6단계:DB닫기
		}
		
		return list;
	}
	
	//글추가하기: insert문 ,            파라미터: id, title, content 
	//테이블을 변경하는 작업 --> 처리만 하고 결과X   seq, regdate -> 쿼리 추가
	public boolean insertBoard(HkDto dto) {
		int count=0;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" INSERT INTO HKBOARD "
				+ " VALUES(NULL,?,?,?,SYSDATE()) ";
		
		try {
			conn=getConnection();
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;
	}
	
	//글상세조회: select문 실행, 파라미터:seq(pk)
	//조회기능: 결과반환O --> ResultSet객체 필요
	//반환타입: DTO객체
	public HkDto getBoard(int seq) {
		HkDto dto=new HkDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT SEQ, ID, TITLE, CONTENT, REGDATE "
				+ " FROM HKBOARD WHERE SEQ = ? ";
		
		try {
			conn=getConnection();
			
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			rs=psmt.executeQuery();//조회: 결과 내용을 반환
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));//int타입으로 변환--> DTO객체 저장
				dto.setId(rs.getString(2));//String 타입으로 변환 -->
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getDate(5));//Date타입으로 변환--> DTO저장
				System.out.println(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return dto;
	}
	
	//수정하기: update문 실행,  파라미터: seq,title,content
	//                      수정할 내용: title, content , regdate-> Sysdate()
	public boolean updateBoard(HkDto dto) {//int seq, Sting title..
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
//		Statement st=null;// ? -> 파라미터 적용하는 기능이 없어
		
		//String 객체이용했을 경우
		String sql=" UPDATE HKBOARD SET TITLE=?,CONTENT=?, "
				 + "                    REGDATE=SYSDATE() "
				 + " WHERE SEQ = ? ";
		
		//String~클래스를 이용했을 경우 new예약어 사용--> 메모리 효율은 좋다
		StringBuffer sb=new StringBuffer();
		sb.append(" UPDATE HKBOARD SET TITLE=?,CONTENT=?, ");
		sb.append("                   REGDATE=SYSDATE() ");
		sb.append(" WHERE SEQ = ? ");
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sb.toString());
//			st=conn.createStatement();
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getSeq());//쿼리준비 완료
			count=psmt.executeUpdate();//쿼리실행: 반환값은 변경된 행의 개수
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;
	}
	
	//글삭제하기: delete문 실행 , 파라미터: seq
	public boolean delBoard(int seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql="DELETE FROM HKBOARD WHERE SEQ=?";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
}








