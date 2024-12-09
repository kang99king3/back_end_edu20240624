package com.hk.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hk.board.command.AddUserCommand;
import com.hk.board.command.LoginCommand;
import com.hk.board.dtos.MemberDto;
import com.hk.board.mapper.MemberMapper;
import com.hk.board.status.RoleStatus;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor ;lombok 기능: final 필드를 초기화 - Autowired 생략가능
@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;// <-- @Bean으로 등록:SecurityConfig클래스에서..
	
	public boolean addUser(AddUserCommand addUserCommand) {
		
		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		
		//password암호화하여 저장하자
		mdto.setPassword(passwordEncoder.encode(addUserCommand.getPassword()));
		
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		mdto.setRole(RoleStatus.USER+"");//등급추가
		return memberMapper.addUser(mdto);
	}
	
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
	
	public MemberDto login(LoginCommand loginCommand
			           ,HttpServletRequest request
			           ,Model model) {
		MemberDto dto = memberMapper.loginUser(loginCommand.getId());
		String path="home";
		HttpSession session=request.getSession(true);
		if(dto!=null) {
			//로그인 폼에서 입력받은 패스워드값과 DB에 암호화된 패스워드 비교
			if(passwordEncoder.matches(loginCommand.getPassword()
					                  , dto.getPassword())) {
				System.out.println("패스워드 같음: 회원이 맞음");
				//session객체에 로그인 정보 저장
				session.setAttribute("mdto", dto);
				session.setMaxInactiveInterval(1*60*60);
				return dto;
			}else {
				return null;
			}
//			else {
//				System.out.println("패스워드 틀림");
//				model.addAttribute("msg", "패스워드를 확인하세요");
//				path="pwFalse";
//				return null;
//			}
		}else {
			System.out.println("회원이 아닙니다. ");
			model.addAttribute("msg", "아이디를 확인하세요");
			return null;
		}
		
//		return path;
	}
}














