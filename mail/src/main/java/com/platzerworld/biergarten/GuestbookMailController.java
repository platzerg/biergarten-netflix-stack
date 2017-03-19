package com.platzerworld.biergarten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mail")
public class GuestbookMailController {

	@Autowired
	private MailSender sender;
	
	@Value("${mail.from}")
	private String from;
	
	@Value("${mail.to}")
	private String to;

	@RequestMapping(value = "/",
			method= RequestMethod.POST,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendMail(@RequestBody GuestbookEntry entry) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(from);
		msg.setTo(to);
		msg.setSubject("[Guestbook] " + entry.getTitle());
		msg.setText(entry.getCommenter() + " schrieb:\r\n\r\n" + entry.getComment());
		
		//sender.send(msg);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
