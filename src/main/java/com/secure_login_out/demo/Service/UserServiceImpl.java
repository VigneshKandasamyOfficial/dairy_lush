package com.secure_login_out.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secure_login_out.demo.Model.User;
import com.secure_login_out.demo.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncode; 
	
	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

}
