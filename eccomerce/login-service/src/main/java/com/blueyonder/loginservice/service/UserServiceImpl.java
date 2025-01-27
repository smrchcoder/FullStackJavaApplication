package com.blueyonder.loginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blueyonder.loginservice.entities.UserInfo;
import com.blueyonder.loginservice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	//creating a  Bean of the passwordEncoder to encode the incoming password
	@Autowired
	public PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserInfo addUser(UserInfo userEntity) {
		// TODO Auto-generated method stub
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		
		return userRepository.save(userEntity);
	}
	

}
