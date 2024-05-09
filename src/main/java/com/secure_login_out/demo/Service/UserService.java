package com.secure_login_out.demo.Service;

import com.secure_login_out.demo.Model.User;

public interface UserService {
	public User createUser(User user);
	public boolean checkEmail(String email);
}
