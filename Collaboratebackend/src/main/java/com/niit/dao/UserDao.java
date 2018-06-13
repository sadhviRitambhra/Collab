package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {

	User getUserByUserName(String user);
	boolean validUser(User user);
	boolean addUser(User User);
	boolean deleteUser(int userId);
	boolean editUser(User user);
	User getUserbyUserId(int userId);
	List<User> getAllUsers();
	User validUser(String userName, String userPassword);
}
