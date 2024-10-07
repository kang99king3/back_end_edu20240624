package com.hk.board.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.dtos.UserDto;
import com.hk.board.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login(UserDto dto, HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("로그인하기");
		
		UserDto ldto=userService.getLogin(dto);
		if(ldto==null||ldto.getId()==null) {
			String msg=URLEncoder.encode("회원정보를 확인하세요", "utf-8");
			return "redirect:index.jsp?msg="+msg;
		}else {
			request.getSession().setAttribute("ldto", ldto);
			
			String role=ldto.getRole();
			if(role.equals("ADMIN")) {
				return "admin_main";
			}else if(role.equals("MANAGER")) {
				return "user_main";
			}else {
				return "user_main";
			}
		}
	}
	
	@RequestMapping(value = "/logout.do",method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃하기");
		
		request.getSession().invalidate();
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "/getAllUserList.do",method = RequestMethod.GET)
	public String getAllUserList(Model model) {
		System.out.println("회원전체목록 보여주기");
		
		List<UserDto> list=userService.getAllUserList();
		model.addAttribute("list", list);
		return "userAllList";
	}
	
	@RequestMapping(value = "/getUserList.do",method = RequestMethod.GET)
	public String getUserList(Model model) {
		System.out.println("회원목록 보여주기");
		
		List<UserDto> list=userService.getUserList();
		model.addAttribute("list", list);
		return "userList";
	}
}
