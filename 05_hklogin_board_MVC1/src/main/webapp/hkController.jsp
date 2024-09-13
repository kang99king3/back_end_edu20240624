<%@page import="java.util.Arrays"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hkController.jsp</title>
</head>
<body>
<%
	//1단계:command 값 받기 - 어떤 요청인지 확인
	//     index.jsp -> 글목록요청 -> hkcontroller.jsp?command=boardlist
	String command=request.getParameter("command");
	
	//2단계:DAO객체 생성 - DB관련 작업 수행을 위한 준비단계
	HkDao dao=new HkDao();
	
	//3단계: 분기 - command값 확인해서 요청작업 처리 실행
	if(command.equals("boardlist")){//글목록 요청 처리
		//4단계:파라미터 받기 <--여기서는 받을 값이 없음
		
		//5단계:dao메서드 실행
		List<HkDto> lists=dao.getAllList();//글목록 반환
		
		//6단계:Scope객체에 담기
		request.setAttribute("lists", lists);// RS["lists":lists]
		
		//7단계:페이지 이동
		pageContext.forward("boardlist.jsp");
	}else if(command.equals("boarddetail")){//상세보기
		//4단계:파라미터받기
		int seq=Integer.parseInt(request.getParameter("seq"));
		HkDto dto=dao.getBoard(seq);//글하나에 대한 정보
		request.setAttribute("dto", dto);
		pageContext.forward("boarddetail.jsp");
	}else if(command.equals("insertboardform")){//글추가폼이동
		response.sendRedirect("insertboardform.jsp");
	}else if(command.equals("insertboard")){//글추가하기
		//4단계:파라미터받기
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		boolean isS=dao.insertBoard(new HkDto(id,title,content));
		if(isS){
			// 브라우저에 주소창에 응답 URL로 변경된다. update작업시 응답
			response.sendRedirect("hkController.jsp?command=boardlist");
			// 브라우저에 주소창에 요청 URL로 적용된다. 조회작업시 응답
// 			pageContext.forward("hkController.jsp?command=boardlist");
		}else{
			%>
			<script type="text/javascript">
				alert("글추가실패");
				location.href="hkController.jsp?command=insertboardform";
			</script>
			<%
		}
	}else if(command.equals("boardupdateform")){
		// seq값을 받아서 DAO요청해서 글상세내용을 조회하는 작업
		// --> 수정폼에 글상세내용이 조회되기때문에
		String sseq=request.getParameter("seq");
		int seq=Integer.parseInt(sseq);
		HkDto dto=dao.getBoard(seq);//글 상세내용 조회
		
		request.setAttribute("dto", dto);//request Scope에 담기
		pageContext.forward("boardupdateform.jsp");
	}else if(command.equals("boardupdate")){
		String sseq=request.getParameter("seq");
		int seq=Integer.parseInt(sseq);
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		boolean isS=dao.updateBoard(new HkDto(seq,title,content));
		if(isS){
			response.sendRedirect("hkController.jsp?"
								  +"command=boarddetail&seq="+seq);
		}else{
			//url에 한글을 포함해서 요청할 경우 인코딩하자
			response.sendRedirect("error.jsp?msg="
							+URLEncoder.encode("글수정실패","utf-8"));
		}
	}else if(command.equals("deleteboard")){
		String sseq=request.getParameter("seq");
		int seq=Integer.parseInt(sseq);
		
		boolean isS=dao.delBoard(seq);
		if(isS){
			response.sendRedirect("hkController.jsp?command=boardlist");
		}else{
			response.sendRedirect("error.jsp?msg="
								+URLEncoder.encode("글삭제실패","utf-8"));
		}
	}else if(command.equals("muldel")){
		//삭제할 글의 번호들을 받기(배열)
		String[] chks=request.getParameterValues("chk");//chk={1,2,3,4}
		
		//여러글을 삭제하는 기능 구현: 전달할 파라미터 타입은 배열
		//자바에서 유효값 처리할 경우
		//유효하지 않은 값을 처리하기 위해서 요청이 실행되는 단점
// 		System.out.println(Arrays.toString(chks));
// 		out.println(Arrays.toString(chks));
// 		if(chks==null||chks.length==0){
// 			response.sendRedirect("error.jsp?msg="
// 			+URLEncoder.encode("글삭제할때 최소하나이상체크해야합니다","utf-8"));
// 		}else{
	// 		dao.muldelBoard(chks);
			
// 		}
		boolean isS=dao.mulDel(chks);
		if(isS){
			response.sendRedirect("hkController.jsp?command=boardlist");
		}else{
			response.sendRedirect("error.jsp?msg="
							+URLEncoder.encode("글삭제실패","utf-8"));
		}
	}else if(command.equals("searchid")){//아이디로 검색하여 글목록 조회하기
		String id=request.getParameter("id");
		System.out.println(id);
		List<HkDto> list=null;
		
		if(id==null||id==""){
			list=dao.getAllList();//검색어 입력없이 검색을 했을 경우 글 모두 조회
		}else{
			list=dao.getSearchListId(id);//검색어에 해당되는 글 모두 조회
		}

		request.setAttribute("lists", list);
		pageContext.forward("boardlist.jsp");
	}
%>
</body>
</html>








