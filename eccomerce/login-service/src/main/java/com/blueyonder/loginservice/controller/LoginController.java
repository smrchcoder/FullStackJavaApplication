package com.blueyonder.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.loginservice.Dto.LoginAuthRequest;
import com.blueyonder.loginservice.exception.UserNotFoundException;
import com.blueyonder.loginservice.service.JwtService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class LoginController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticateAndGetToken(@RequestBody LoginAuthRequest loginAuthRequest) throws UserNotFoundException {
		Authentication authentication	=	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginAuthRequest.getUserName(), loginAuthRequest.getPassword()));
		if(authentication.isAuthenticated())
		{
			return new ResponseEntity<String>(jwtService.generateToken(loginAuthRequest.getUserName()),HttpStatus.OK);
		}
		else {
            throw new UserNotFoundException("invalid user request !");
        }
	}
	

}
