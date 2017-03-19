package com.platzerworld.biergarten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guestbook")
@CrossOrigin(origins = "*")
public class GuestbookController {

	@Autowired
	private GuestbookRepository repository;
	
	@Autowired
	private GuestbookMailService service;
	
	@RequestMapping(value="/",
			method= RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEntries() {
		// 1. Daten laden
		List<GuestbookEntry> entries = repository.findAllByOrderByIdDesc();
		
		// 2. Daten zurückgeben
		return ResponseEntity.ok(entries);
	}
	
	@RequestMapping(value="/",
			method= RequestMethod.PUT,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody GuestbookEntry entry) {
		// 1. Speichern
		entry = repository.save(entry);
		
		// Versenden
		System.out.println("+++ Before sending mail +++");
		service.sendMail(entry);
		System.out.println("+++ After sending mail +++");
				
		// 2. Zurückgeben
		return ResponseEntity.ok(entry);
	}
	
	
}
