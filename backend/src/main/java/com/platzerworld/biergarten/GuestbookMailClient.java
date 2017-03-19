package com.platzerworld.biergarten;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("mail")
public interface GuestbookMailClient {

	@RequestMapping(value = "/mail/",
			method= RequestMethod.POST,
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public void sendMail(@RequestBody GuestbookEntry entry);
	
}
