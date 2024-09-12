<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.hk.daos.UserDao"%>
<%@page import="com.hk.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command=request.getParameter("command");
	
	UserDao dao=UserDao.getUserDao();//클래스명.메서드():static메서드호출방법
	
	if(command.equals("registform")){//회원가입폼이동
		response.sendRedirect("registform.jsp");
	}else if(command.equals("adduser")){//회원가입하기
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		//주소 API 활용 : 파라미터 받기
		String addr1=request.getParameter("addr1");//우편번호
		String addr2=request.getParameter("addr2");//기본주소
		String addr3=request.getParameter("addr3");//상세주소
		String addr4=request.getParameter("addr4");//참고항목
		
// 		String address=request.getParameter("address");
		String address=addr1+" "+addr2+" "+addr3+" "+addr4;
		String email=request.getParameter("email");
		
		boolean isS=dao.insertUser(new UserDto(id,name,password,address,email));
		if(isS){
			%>
			<script type="text/javascript">
				alert("회원에 가입이 되셨습니다.");
				location.href="index.jsp";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("회원 가입 실패");
				location.href="userController.jsp?command=registform";
			</script>
			<%
		}
	}else if(command.equals("idchk")){
		String id=request.getParameter("id");
		String resutlId=dao.idCheck(id);//결과값이 null이면 사용가능
		
		request.setAttribute("resultId", resutlId);
		pageContext.forward("idchkform.jsp");//사용자에게 id가 사용가능한지 알려줄 페이지
	}else if(command.equals("login")){//로그인 하기
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		//Dao객체에 메서드 실행: getLogin(id, password)
		UserDto ldto=dao.getLogin(id, password);
		
		if(ldto==null||ldto.getId()==null){//회원이 존재하지 않는 경우
			response.sendRedirect("index.jsp?msg="
							+URLEncoder.encode("회원가입을 해주세요","utf-8"));
		}else{
			//회원이라면..
			//sessionScope객체에 로그인 정보를 저장하자..
			session.setAttribute("ldto", ldto);
			session.setMaxInactiveInterval(10*60);//10분간 요청이 없으면 세션을 삭제
		
			//등급[ADMIN,MANAGER,USER]을 확인해서 해당 MAIN페이지로 이동하기
			if(ldto.getRole().toUpperCase().equals("ADMIN")){
				response.sendRedirect("admin_main.jsp");
			}else if(ldto.getRole().toUpperCase().equals("MANAGER")){
				response.sendRedirect("manager_main.jsp");
			}else if(ldto.getRole().toUpperCase().equals("USER")){
				response.sendRedirect("user_main.jsp");
			}
		}
	}else if(command.equals("logout")){//로그아웃하기
		//로그아웃은 session에서 로그인정보를 삭제한다는 의미
// 		session.removeAttribute("ldto");//ldto라는 이름의 객체를 삭제
		session.invalidate();//session안에 모든 정보를 삭제한다.
		System.out.println("로그아웃함");
		response.sendRedirect("index.jsp");
	}else if(command.equals("userinfo")){// 나의 정보 조회
		//controller페이지에서 session에 로그인 정보를 가져올 수 도 있다.
// 		UserDto ldto=(UserDto)session.getAttribute("ldto");
// 		String id=ldto.getId();

		//user_main.jsp에서 id값을 전달할 수 도 있다.
		String id=request.getParameter("id");
		UserDto dto=dao.getUser(id);
		
		request.setAttribute("dto", dto);
		pageContext.forward("userinfo.jsp");
	}else if(command.equals("userupdate")){
		String id=request.getParameter("id");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		boolean isS=dao.updateUser(new UserDto(id,address,email));
// 		            dao.updateUser(id,address,email) 그냥 3개 선언해서 처리해도 됨
		if(isS){
			%>
			<script type="text/javascript">
				alert('수정완료');
				location.href="userController.jsp?command=userinfo&id=<%=id%>";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert('수정실패');
				location.href="userController.jsp?command=userinfo&id=<%=id%>";
			</script>
			<%
		}
	}else if(command.equals("deluser")){
		String id=request.getParameter("id");
		boolean isS=dao.delUser(id);
		session.invalidate();
		if(isS){
			%>
			<script type="text/javascript">
				alert("회원탈퇴 완료하였습니다.");
				location.href="index.jsp";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("회원탈퇴실패");
				location.href="index.jsp";
			</script>
			<%
		}
	}else if(command.equals("getAllUserList")){//회원전체조회
		List<UserDto>list=dao.getAllUserList();
	
		request.setAttribute("list", list);
		
		pageContext.forward("userAllList.jsp");
	}else if(command.equals("getUserList")){//회원목록조회[등급수정을 위한 조회]
		List<UserDto>list=dao.getUserList();
	
		request.setAttribute("list", list);
		pageContext.forward("userList.jsp");
	}else if(command.equals("roleForm")){//등급수정폼으로 이동
		String id=request.getParameter("id");
		UserDto dto=dao.getUser(id);//나의정보조회하기 기능
		
		request.setAttribute("dto", dto);
		pageContext.forward("userRoleForm.jsp");//등급수정 폼으로 이동
	}else if(command.equals("userUpdateRole")){//등급수정하기
		String id=request.getParameter("id");
		String role=request.getParameter("role");
		
		boolean isS=dao.userUpdateRole(id, role);
		if(isS){
			response.sendRedirect("userController.jsp?command=getUserList");
		}else{
			response.sendRedirect("error.jsp?msg="+URLEncoder.encode("등급수정실패","utf-8"));
		}
	}
%>
</body>
</html>






