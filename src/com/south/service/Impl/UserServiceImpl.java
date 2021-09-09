package com.south.service.Impl;


import com.south.dao.Impl.UserDaoImpl;
import com.south.dao.UserDao;
import com.south.pojo.User;
import com.south.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void saveUser(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
	}

	@Override
	public void delete(String id) {
		UserDao userDao = new UserDaoImpl();
		userDao.delete(id);
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User user = userDao.findUserByUsernameAndPassword(username,  password);
		return user;
	}

	@Override
	public User findUserById(String id) {
		UserDao userDao = new UserDaoImpl();
		User user=userDao.findUserById(id);
		return user;
	}

	@Override
	public List findAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.findAllUsers();
	}
}
