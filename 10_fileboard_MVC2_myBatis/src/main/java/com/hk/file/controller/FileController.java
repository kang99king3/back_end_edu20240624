package com.hk.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.file.daos.FileDao;
import com.hk.file.dtos.FileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command=request.getRequestURI()
				     .substring(request.getContextPath().length());
		
		System.out.println("요청내용:"+command);
		
		FileDao dao=new FileDao();
		
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
			
			//DB에 파일정보를 추가하기
			//1.원본파일명 구하기
			// name="filename"
			String origin_name=multi.getOriginalFileName("filename");
			System.out.println("원본파일명:"+origin_name);
			
			//2.저장 파일명 구하기: UUID객체 ---> 32자리 값을 구함
			//"12345678-12345678-12345678-12345678"
			String random32=
			UUID.randomUUID().toString().replace("-", "");// "-"제거하기
			// abcd.jpg --> random32+.jpg 변환
			String stored_name=random32
					+(origin_name.substring(origin_name.lastIndexOf(".")));
			
			System.out.println("저장파일명:"+stored_name);
			//3.파일사이즈 구하기
			int file_size=(int)multi.getFile("filename").length();
			System.out.println("파일사이즈:"+file_size);
			//4.DB에 정보 추가하기
			boolean isS=dao.insertFile(new FileDto(0,origin_name,stored_name,file_size,null));
			
			//5.업로드된 파일명을 변경하기(원본파일명으로 업로드 되어 있음)
			// old이름 ---> stored이름 변경
			File oldFile=new File(saveDirectory+"/"
								 +multi.getFilesystemName("filename"));
			
			File newFile=new File(saveDirectory+"/"+stored_name);
			oldFile.renameTo(newFile);//old명 --> new명으로 변경
			
			response.sendRedirect("uploadform.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
