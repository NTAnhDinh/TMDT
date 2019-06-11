package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.UserDetail;
import com.example.demo.model.User;
import com.example.demo.repository.*;

@Service
public class UserService {

//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	public List<User> findAll() {
//		return userRepository.findAll();
//	}
//
//	public User findByName(String name) {
//		return userRepository.findByName(name);
//	}
//
//	public List<User> findByIdRole() {
//		return userRepository.findByIdRole();
//	}
//
//	public User save(User u) {
//		String encodePass = passwordEncoder.encode(u.getPassword());
//		u.setPassword(encodePass);
//		return userRepository.save(u);
//	}
//
//	public void updatePassword(String password) {
////		String userName = userDetailService.getUserDetail().getUsername();
////		User u = findByName(userName);
////		userRepository.updatePassword(password, u.getId());
//	}
//
//	public User findByPassword(String password) {
//		return userRepository.findByPassword(password);
//	}
}
