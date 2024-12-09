package com.hk.board.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.board.service.MailManager;

/*
 * email인증 기능 테스트
 * 본 프로젝트와 관련 없음
 * 
 */
@Controller
public class MailController {

	@Autowired
	private MailManager mailManager;
	
	//email인증
	@GetMapping("/sendMail") // 
    @ResponseBody  //AJAX후 값을 리턴하기위해 작성
    public String SendMail(String email) throws Exception {
        UUID uuid = UUID.randomUUID(); // 랜덤한 UUID 생성
        String key = uuid.toString().substring(0, 7); // UUID 문자열 중 7자리만 사용하여 인증번호 생성
        String sub ="인증번호 입력을 위한 메일 전송";
        String con = "인증 번호 : "+key;
        mailManager.send(email,sub,con);
//        key = SHA256Util.getEncrypt(key, email);
        return key;
    }
	
//	@PostMapping("/checkMail") // 
//    @ResponseBody  
//    public boolean CheckMail(String key, String insertKey,String email) throws Exception {
//        insertKey = SHA256Util.getEncrypt(insertKey, email);
//        
//        if(key.equals(insertKey)) {
//        	return true;
//        }
//        return false;
//    }
}
