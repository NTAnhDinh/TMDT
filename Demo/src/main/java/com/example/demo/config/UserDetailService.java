package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	UserDetail userDetail;

	@Autowired
	UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Bean
	public UserDetail userDetail() {
	    return new UserDetail();
	}
	 @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
		    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		    return bCryptPasswordEncoder;
		}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + username + " not found");
		}
		System.out.println(new UserDetail(user).toString());
		userDetail = new UserDetail(user);
		return userDetail;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public List<User> findByIdRole() {
		return userRepository.findByIdRole();
	}

	public User save(User u) {
		System.out.println("User "+ u.toString());
		String encodePass = passwordEncoder.encode(u.getPassword());
		u.setPassword("{bcrypt}"+encodePass);
		return userRepository.save(u);
	}

	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}
	 
}
