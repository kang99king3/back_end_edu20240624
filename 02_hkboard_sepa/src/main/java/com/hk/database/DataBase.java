package com.hk.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC 1,2,6단계 구현
public class DataBase {
	
	//1단계:드라이버 로딩
	public DataBase() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("1단계:드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1단계:드라이버로딩 실패");
		}
	}
	
	//2단계:DB연결
	public Connection getConnection() throws SQLException {
		//                         톰캣서버이름:포트/데이터베이스명
//		String url="jdbc:mariadb://localhost:3306/hk";
//		String user="root";
//		String password="manager";
		
//		Connection conn=DriverManager.getConnection(url, user, password);
//		System.out.println("2단계:DB연결성공");
		
		//Connectoin pool 구현
		//tomcat 서버에 Context.xml에 추가하기
//		<Resource name="jdbc/hk"
//	              auth="Container"
//	              type="javax.sql.DataSource"
//	              maxTotal="20"    
//	              maxIdle="10"
//	              maxWaitMillis="10000"
//	              username="root"
//	              password="manager"
//	              driverClassName="org.mariadb.jdbc.Driver"
//	              url="jdbc:mariadb://localhost:3306/hk"/>
		DataSource ds = null;
		try {
			// 1. JNDI 초기화(이름과 객체로 맵핑관리)
			  Context initCtx = new InitialContext();//Context에 접근하기 위한 객체생성
			  //"java:comp/env" 접근가능한 환경 이름 공간으로 
			  // -> context.xml에 등록한 Resource가 "java:com/env" 안에 등록된다.
			  Context envCtx  = (Context) initCtx.lookup("java:comp/env");
			// 2. DataSource 찾기
			  ds = (DataSource) envCtx.lookup("jdbc/hk");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	      // 3. Connection 얻기
	     Connection conn = ds.getConnection();
		return conn;
	}
	
	//6단계: DB 열결 닫기
	public void close(ResultSet rs, PreparedStatement psmt,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			System.out.println("6단계:DB닫기성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("6단계:DB닫기실패");
		}
	}
}











