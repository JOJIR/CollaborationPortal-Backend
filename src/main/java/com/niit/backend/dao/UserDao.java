package com.niit.backend.dao;

import com.niit.backend.model.User;

public interface UserDao {
	
	User authenticate(User user);
	void updateUser(User user);
	User registerUser(User user);

}