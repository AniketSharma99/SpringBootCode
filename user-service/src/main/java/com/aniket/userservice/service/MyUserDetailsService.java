package com.aniket.userservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aniket.userservice.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{ //DAO Authentication Provider ( help data access)
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.aniket.userservice.model.User user= userRepo.findByUsername(username);
		System.out.println(user);
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
