package com.manas.springboot.cruddemo.service;

import com.manas.springboot.cruddemo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

}
