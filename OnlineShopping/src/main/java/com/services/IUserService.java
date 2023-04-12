package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.User;
@Service
public interface IUserService{

	public List<User> getUsers();
	public User getUserById(Long userId);
	public User addUser(User user);
	public User updateUser(Long userId, User user);
	public void deleteUser(Long userId);
}
