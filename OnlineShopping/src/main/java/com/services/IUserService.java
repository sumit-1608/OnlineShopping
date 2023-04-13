package com.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.entities.Users;

public interface IUserService{

	public List<Users> getUsers();
	public Users getUserById(Long userId);
	public Users addUser(Users user);
	public Users updateUser(Long userId, Users user);
	public void deleteUser(Long userId);
}
