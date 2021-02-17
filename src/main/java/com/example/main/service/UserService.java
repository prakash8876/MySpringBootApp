package com.example.main.service;

import java.util.List;
import java.util.Optional;

import com.example.main.model.User;

public interface UserService {
	
	Optional<User> saveNewUser(User user);
	Optional<String> saveUsersList(List<User> user_list);
	Optional<User> findUserById(long user_id);
	Optional<List<User>> getAllUsers();
	Optional<User> findUserByUsername(String username);
	Optional<User> updateUserData(User newUser);
	void deleteUserById(long user_id);
	void deleteUser(User user);
}
