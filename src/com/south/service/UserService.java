package com.south.service;


import com.south.pojo.User;

import java.util.List;

public interface UserService {
	User findUserByUsernameAndPassword(String username, String password);
	void saveUser(User user);
	List findAllUsers();
	User findUserById(String id);
	void updateUser(User user);
	void delete(String id);
}
