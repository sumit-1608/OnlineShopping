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

import com.entities.Users;
import com.exceptions.UserNotFoundException;
import com.services.IUserService;

@RestController

public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public Users getUserById(@PathVariable Long userId) throws UserNotFoundException{
		return this.userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	public Users addUser(@RequestBody Users user){
		return this.userService.addUser(user);
	}
	
	@PutMapping("/user/{userId}")
	public Users updateUser(@PathVariable Long userId, @RequestBody Users user) throws UserNotFoundException{
		return this.userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable Long userId) throws UserNotFoundException{
		this.userService.deleteUser(userId);
	}
}
