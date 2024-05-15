package com.blueyonder.loginservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestController {

	@GetMapping("/test")

	private ResponseEntity<String> testinString()
	{
		return  new ResponseEntity<String>("Test sucessfull",HttpStatus.OK);
	}
	@GetMapping("/test/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	private String testadmin()
	{
		return "Admin ac";
	}
}
