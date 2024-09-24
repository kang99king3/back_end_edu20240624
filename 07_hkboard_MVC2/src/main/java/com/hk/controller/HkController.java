package com.hk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.HkDao;
import com.hk.dtos.HkDto;

@WebServlet("*.board")
public class HkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		//인코딩처리 -> filter에서 구현함
		
		//command 구현
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
//		String pathInfo=request.getPathInfo();
//		StringBuffer requestURL=request.getRequestURL();
		
//		System.out.println(requestURI+"\n"
//				          +contextPath+"\n"
//				          +pathInfo+"\n"
//				          +requestURL.toString());
		
		String command=requestURI.substring(contextPath.length());
		System.out.println("command:"+command);
		
		HkDao dao=new HkDao();
		
		if(command.equals("/boardlist.board")) {
			List<HkDto> lists=dao.getAllList();
			request.setAttribute("lists", lists);
			
//			request.getRequestDispatcher("boardlist.jsp")
//				   .forward(request, response);
			dispatch("boardlist.jsp", request, response);
		}else if(command.equals("/boarddetail.board")){//상세보기
			//4단계:파라미터받기
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);//글하나에 대한 정보
			request.setAttribute("dto", dto);
			
			dispatch("boarddetail.jsp", request, response);
//			pageContext.forward("boarddetail.jsp");
		}else if(command.equals("/insertboardform.board")){//글추가폼이동
			response.sendRedirect("insertboardform.jsp");
		}else if(command.equals("/insertboard.board")){//글추가하기
			//4단계:파라미터받기
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new HkDto(id,title,content));
			if(isS){
				// 브라우저에 주소창에 응답 URL로 변경된다. update작업시 응답
				response.sendRedirect("boardlist.board");
				// 브라우저에 주소창에 요청 URL로 적용된다. 조회작업시 응답
//	 			pageContext.forward("hkController.jsp?command=boardlist");
			}else{
//				String jsLocation="<script type='text/javascript'>"
//								 +"	alert('글추가실패');"
//								 +"	location.href='insertboardform.board';"
//								 +"</script>" ;
//				PrintWriter pw=response.getWriter();//브라우저 출력용 프린터
//				pw.print(jsLocation);
				jsLocation("글추가실패", "insertboardform.board", response);
			}
		}else if(command.equals("/boardupdateform.board")){
			// seq값을 받아서 DAO요청해서 글상세내용을 조회하는 작업
			// --> 수정폼에 글상세내용이 조회되기때문에
			String sseq=request.getParameter("seq");
			int seq=Integer.parseInt(sseq);
			HkDto dto=dao.getBoard(seq);//글 상세내용 조회
			
			request.setAttribute("dto", dto);//request Scope에 담기
//			pageContext.forward("boardupdateform.jsp");
			dispatch("boardupdateform.jsp", request, response);
		}else if(command.equals("/boardupdate.board")){
			String sseq=request.getParameter("seq");
			int seq=Integer.parseInt(sseq);
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.updateBoard(new HkDto(seq,title,content));
			if(isS){
				response.sendRedirect("boarddetail.board?seq="+seq);
			}else{
				//url에 한글을 포함해서 요청할 경우 인코딩하자
				response.sendRedirect("error.jsp?msg="
								+URLEncoder.encode("글수정실패","utf-8"));
			}
		}else if(command.equals("/deleteboard.board")){
			String sseq=request.getParameter("seq");
			int seq=Integer.parseInt(sseq);
			
			boolean isS=dao.delBoard(seq);
			if(isS){
				response.sendRedirect("boardlist.board");
			}else{
				response.sendRedirect("error.jsp?msg="
									+URLEncoder.encode("글삭제실패","utf-8"));
			}
		}else if(command.equals("/muldel.board")){
			//삭제할 글의 번호들을 받기(배열)
			String[] chks=request.getParameterValues("chk");//chk={1,2,3,4}
			
			//여러글을 삭제하는 기능 구현: 전달할 파라미터 타입은 배열
			//자바에서 유효값 처리할 경우
			//유효하지 않은 값을 처리하기 위해서 요청이 실행되는 단점
//	 		System.out.println(Arrays.toString(chks));
//	 		out.println(Arrays.toString(chks));
//	 		if(chks==null||chks.length==0){
//	 			response.sendRedirect("error.jsp?msg="
//	 			+URLEncoder.encode("글삭제할때 최소하나이상체크해야합니다","utf-8"));
//	 		}else{
		// 		dao.muldelBoard(chks);
				
//	 		}
			boolean isS=dao.mulDel(chks);
			if(isS){
				response.sendRedirect("boardlist.board");
			}else{
				response.sendRedirect("error.jsp?msg="
								+URLEncoder.encode("글삭제실패","utf-8"));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//forward 메서드 구현
	public void dispatch(String url,HttpServletRequest request
						,HttpServletResponse response) 
						throws ServletException, IOException {
		request.getRequestDispatcher(url)
		   .forward(request, response);
	}
	
	//JS location 구현
	public void jsLocation(String msg,String url,
									 HttpServletResponse response) 
						 throws IOException {
		String jsLocation="<script type='text/javascript'>"
						 +"	alert('"+msg+"');"
						 +"	location.href='"+url+"';"
						 +"</script>" ;
		PrintWriter pw=response.getWriter();//브라우저 출력용 프린터
		pw.print(jsLocation);
	}

}




