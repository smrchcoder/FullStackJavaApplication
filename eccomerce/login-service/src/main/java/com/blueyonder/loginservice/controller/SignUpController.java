package com.blueyonder.loginservice.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.loginservice.entities.UserInfo;
import com.blueyonder.loginservice.service.UserService;



@RestController
@RequestMapping("/auth/v1/")

public class SignUpController {
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserInfo userInfo) {
		System.out.println(userInfo.toString());
        // Assuming the registration logic is successful
		UserInfo userInforesult=userService.addUser(userInfo);
		if(userInforesult!=null)
		{
			 return  new ResponseEntity<String>("User registered successfully",HttpStatus.OK);
		}
        return  new ResponseEntity<String>("Provided Details Are Wrong",HttpStatus.BAD_REQUEST);
    }
     

}
