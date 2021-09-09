package com.south.dao;

import com.south.pojo.User;

import java.util.List;

public interface UserDao {
	void saveUser(User user);
	void updateUser(User user);
	void delete(String id);
	User findUserByUsernameAndPassword(String username, String password);
	User findUserById(String id);
	List findAllUsers();
}
