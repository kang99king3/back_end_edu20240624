package com.hk.board.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.board.dtos.FileBoardDto;
import com.hk.board.mapper.FileMapper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileService {

	@Autowired
	private FileMapper fileMapper;
	
	//파일업로드하기
	@Transactional
	public List<FileBoardDto> uploadFiles(String uploadPath
						    ,MultipartRequest multipartRequest) 
						   throws IllegalStateException, IOException{
		//여러개의 파일들을 List에 담는 코드
		List<MultipartFile> multipartFiles
		                  =multipartRequest.getFiles("filename");
		
		//업로드된 파일들의 정보(원본명,저장명)를 담아줄 LIST 
		List<FileBoardDto> uploadFileList=new ArrayList<>();
		
		for(MultipartFile multipartFile:multipartFiles) {
			//원본파일명 구하기
			String origin_filename=multipartFile.getOriginalFilename();
			//저장파일명 구하기: 32자리생성(1234567812345678~.txt)
			String stored_filename=UUID.randomUUID()
			+origin_filename.substring(origin_filename.indexOf("."));
			//파일저장 경로 구하기(파일명을 바꾸기위한 작업)
			String fileuploadUrl=uploadPath+"/"+stored_filename;
			multipartFile.transferTo(new File(fileuploadUrl));//upload실행
			//각각의 파일정보를 list에 저장하는 코드
			uploadFileList.add(new FileBoardDto(0,0,origin_filename,stored_filename));
		}
		
		return uploadFileList;
	}
	
	//파일정보 가져오기
	public FileBoardDto getFileInfo(int file_seq) {
		return fileMapper.getFileInfo(file_seq);
	}

	public void fileDownload(String origin_filename, String stored_filename, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		
		//저장경로
		String filePath=request.getSession().getServletContext()
				        .getRealPath("upload");
		
		//다운로드를 위한 준비 작업
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				            "attachment; fileName="
		                     +URLEncoder.encode(origin_filename,"UTF-8") );
		
		response.setHeader("Content-transfer", "binary");
		
		File file=new File(filePath+"/"+stored_filename);
		
		FileInputStream fs =null;// 자바로 파일 읽어들이기위한 객체
		ServletOutputStream out= null;// 출력 객체
		
		try {
			fs = new FileInputStream(file);
			out = response.getOutputStream();
			
			FileCopyUtils.copy(fs, out);// 읽고 쓰는 작업을 처리
			response.flushBuffer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ee) {
			ee.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.flush();
				out.close();
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}












