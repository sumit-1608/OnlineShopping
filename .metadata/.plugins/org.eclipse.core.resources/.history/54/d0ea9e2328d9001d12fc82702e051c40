package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.User;
import com.exceptions.UserNotFoundException;
import com.services.IUserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable Long userId) throws UserNotFoundException{
		return this.userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		return this.userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
	}
}
