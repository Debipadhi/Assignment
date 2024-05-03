package com.hyscalar.cimm.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String subject,String body,String to) {
		
		boolean sendmesg = false;
		
		try {
			
			MimeMessage message = mailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			mailsender.send(message);
			sendmesg = true;
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		
		return sendmesg;
	}
	

}
