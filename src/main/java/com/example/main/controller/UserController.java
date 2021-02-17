package com.example.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.model.User;
import com.example.main.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;
	
	@Value("${app.message}")
	private String message;
	
	@GetMapping("/greeting") 
	public String greetings() {
		return this.message;
	}

	@PostMapping("/new")
	public Optional<User> newUser(@RequestBody User user) {
		return this.service.saveNewUser(user);
	}
	
	@PostMapping("/new-list")
	public Optional<String> saveUsersList(@RequestBody List<User> user_list) {
		return this.service.saveUsersList(user_list);
	}

	@GetMapping("/{user_id}")
	public Optional<User> findById(@PathVariable long user_id) {
		return this.service.findUserById(user_id);
	}
	
	@GetMapping("/name/{username}")
	public Optional<User> findByUsername(@PathVariable String username) {
		return this.service.findUserByUsername(username);
	}

	@GetMapping("/")
	public Optional<List<User>> findAllUsers() {
		return this.service.getAllUsers();
	}

	@PutMapping("/update")
	public Optional<User> updateUser(@RequestBody User user) {
		return this.service.updateUserData(user);
	}

	@DeleteMapping("/{user_id}")
	public void deleteById(@PathVariable long user_id) {
		this.service.deleteUserById(user_id);
	}

	@DeleteMapping
	public void deleteUser(@RequestBody User user) {
		this.service.deleteUser(user);
	}
}
