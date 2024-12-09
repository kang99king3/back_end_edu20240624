package com.hk.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Component
public class MailManager {
	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String sendTo, String sub, String con) throws Exception {
//		HTML 태그 그대로 전송하는 방법
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		mimeMessage.setFrom(sender);
		//받는사람
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(sendTo));
		mimeMessage.setSubject(sub);
		mimeMessage.setText(con);
		javaMailSender.send(mimeMessage);
		

	}
}
