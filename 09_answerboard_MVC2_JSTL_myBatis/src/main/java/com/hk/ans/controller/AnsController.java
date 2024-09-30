package com.hk.ans.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.ans.daos.AnswerDao;
import com.hk.ans.dtos.AnswerDto;
import com.hk.ans.util.Paging;

@WebServlet("*.board")
public class AnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//command 값 구하기
		//9_answerboard_MVC_JSTL_maBatis/*.board
		//9_answerboard_MVC_JSTL_maBatis
		// --->                         "/*.board" 구하기 위함
		String command=request.getRequestURI()
				              .substring(request.getContextPath().length());
	
		System.out.println("요청내용:"+command);
		AnswerDao dao=new AnswerDao();
		
		if(command.equals("/boardlist.board")) {
			
			//페이지번호 받기
			String pnum=request.getParameter("pnum");
			
			//-- 현재 요청한 페이지 번호 유지를 위한 코드----
			//session 스코프객체 이용--> request 객체로부터 얻어온다.
			//session객체가 개인 장바구니 개념
			HttpSession session=request.getSession();
//			HttpSession session2=new HttpSession();(X)
			session.setAttribute("pnum", pnum);
			
			
			List<AnswerDto> list=dao.getAllList(pnum);
			request.setAttribute("list", list);
			
			//페이지수
			int pcount=dao.getPCount();
			request.setAttribute("pcount", pcount);
			
			//-----페이지에 페이징 처리 기능을 추가하자
			//필요한 값: pcount(페이지개수), pnum(요청 페이지번호), 페이지범위(패이지수)
			Map<String, Integer> map=Paging.pagingValue(pcount, pnum, 5);
			request.setAttribute("pMap", map);
						// ${pMap.startPage} 페이지에서 호출하는 방법
			request.getRequestDispatcher("boardlist.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertform.board")) {//글추가폼이동
			response.sendRedirect("insertboardform.jsp");
		}else if(command.equals("/insertboard.board")) {//글추가하기
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new AnswerDto(id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board?pnum=1");
			}else {
				response.sendRedirect("error.jsp?msg="
									+URLEncoder.encode("글추가실패", "utf-8"));
			}
		}else if(command.equals("/boarddetail.board")) {//글 상세조회
			String seq=request.getParameter("seq");
			AnswerDto dto=dao.getBoard(seq);
			
			dao.readCount(Integer.parseInt(seq));//조회수 업데이트
			
			request.setAttribute("dto", dto);
			
			request.getRequestDispatcher("detailboard.jsp")
		       .forward(request, response);
		}else if(command.equals("/replyboard.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.replyBoard(new AnswerDto(seq,id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board?pnum=1");
			}else {
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("답글추가실패", "utf-8"));
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
