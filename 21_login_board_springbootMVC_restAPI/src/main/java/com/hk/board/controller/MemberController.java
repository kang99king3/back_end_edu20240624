package com.hk.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hk.board.command.AddUserCommand;
import com.hk.board.command.LoginCommand;
import com.hk.board.dtos.MemberDto;
import com.hk.board.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
//	@GetMapping(value = "/addUser")
//	public String addUserForm(Model model) {
//		System.out.println("회원가입폼 이동");
//		
//		//회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
//		//null일경우 오류가 발생하기때문에 보내줘야 함
//		model.addAttribute("addUserCommand", new AddUserCommand());
//		
//		return "member/addUserForm";
//	}
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<?> addUser(@Validated @RequestBody AddUserCommand addUserCommand
			             ,BindingResult result,Model model) {
		System.out.println("회원가입하기");
		
		if(result.hasErrors()) {
			System.out.println("회원가입 유효값 오류");
			return ResponseEntity.badRequest().body("회원가입 유효성 검사 실패");//400코드
		}
		
		try {
			  // 회원가입 성공 시 CREATED 상태와 성공 메시지 반환
            memberService.addUser(addUserCommand);
            System.out.println("회원가입 성공");
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");//201코드:요청성공(새로운 리소스 생성 성공)
		} catch (Exception e) {
			System.out.println("회원가입 실패");
            e.printStackTrace();
            // 예외 발생 시 INTERNAL_SERVER_ERROR 상태와 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
		}

	}
	
	@GetMapping(value = "/idchk/{id}")
	public ResponseEntity<String> idChk(@PathVariable String id){
		System.out.println("ID중복체크");
		
		String resultId=memberService.idChk(id);
		// json객체로 보내기 위해 Map에 담아서 응답
		// text라면 그냥 String으로 보내도 됨
//		Map<String,String>map=new HashMap<>();
//		map.put("id", resultId);
		return ResponseEntity.ok(resultId);
	}
	
	//로그인 폼 이동
//	@GetMapping(value = "/login")
//	public String loginForm(Model model) {
//		model.addAttribute("loginCommand", new LoginCommand());
//		return "member/login";
//	}
	//로그인 실행
	@PostMapping(value = "/login")
	public ResponseEntity<?> login( //@RequestBody는 json으로 전송된 데이터를 받을 수 있게 지원한다.
						@Validated @RequestBody LoginCommand loginCommand
			           ,BindingResult result
			           ,Model model
			           ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println(request.getParameter("id"));
			System.out.println("로그인 유효값 오류");
			return ResponseEntity.badRequest().body("로그인 유효값 확인하기");
		}
		
		try {
			 
			MemberDto mdto=memberService.login(loginCommand, request, model);
			MemberDto dtotest=(MemberDto) request.getSession().getAttribute("mdto");
			System.out.println(dtotest);
			if(mdto!=null) {
				return ResponseEntity.ok(mdto);//200코드
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 확인하세요");//401코드
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("로그인실패");
		}

	}
	
	@PutMapping(value="/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		System.out.println("로그아웃");
		request.getSession().invalidate();
		return ResponseEntity.ok("logout");
	}
	
	//나의 정보 조회
	
	//나의 정보 수정
	
}










