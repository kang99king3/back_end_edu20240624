package com.hk.file.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command=request.getRequestURI()
				     .substring(request.getContextPath().length());
		
		System.out.println("요청내용:"+command);
		
		if(command.equals("/fileuploadform.file")) {
			response.sendRedirect("uploadform.jsp");
		}else if(command.equals("/fileupload.file")) {
			//1. 경로 설정(상대경로, 절대경로)
			//- 절대경로
			String saveDirectory
				="C:/Users/user/git/back_end_edu20240624_web_20240924/"
				+ "10_fileboard_MVC2_myBatis/src/main/webapp/upload";
			
			//- 상대경로
//			String saveDirectory=request.getSession().getServletContext()
//					             .getRealPath("upload");
			
			System.out.println("업로드경로:"+saveDirectory);
			//2.file 업로드 최대 사이즈 설정: byte단위
			int maxPostSize=1*1024*1024*10; // 10MB
			
			MultipartRequest multi=null;
			
			try {
				//MultipartRequest객체가 생성될때 파일업로드가 실행된다.
				multi=new MultipartRequest(request, //요청객체
										   saveDirectory, //저장경로
										   maxPostSize, //한번에 최대 업로드 크기
										   "utf-8", // 인코딩
										   new DefaultFileRenamePolicy() //중복 이름 재정의
										   );
				//text 파라미터 받을 경우
	//			request.getParameter("title");//(x)
	//			multi.getParameter("title");//(O)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//try-catch종료
			
			response.sendRedirect("uploadform.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
