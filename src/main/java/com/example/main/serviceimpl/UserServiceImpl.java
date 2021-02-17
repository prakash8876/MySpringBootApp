package com.example.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public Optional<User> saveNewUser(User user) {
		return Optional.of(this.repo.save(user));
	}
	
	@Override
	public Optional<String> saveUsersList(List<User> user_list) {
		return Optional.of((this.repo.saveAll(user_list) != null) ? "Saved List" : "Not Saved List");
	}

	@Override
	public Optional<User> findUserById(long user_id) {
		return Optional.of(this.repo.findById(user_id).get());
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		return Optional.of(this.repo.findAll());
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		return Optional.of(this.repo.findByUsername(username).get());
	}

	@Override
	public Optional<User> updateUserData(User newUser) {
		return Optional.of(this.repo.saveAndFlush(newUser));
	}

	@Override
	public void deleteUserById(long user_id) {
		this.repo.deleteById(user_id);
	}

	@Override
	public void deleteUser(User user) {
		this.repo.delete(user);
	}

}
