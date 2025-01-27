package com.blueyonder.loginservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blueyonder.loginservice.entities.UserInfo;
import com.blueyonder.loginservice.repositories.UserRepository;
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo userInfoResult=userRepository.findByUserName(username);
		return new UserInfoUserDetails(userInfoResult);
	}

}
