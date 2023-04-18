package com.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Users;
import com.exceptions.UserAlreadyExistsException;
import com.exceptions.UserNotFoundException;
import com.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userDao;
	
	@Override
	public List<Users> getUsers() {
		return userDao.findAll();
	}

	@Override
	public Users getUserById(Long userId){
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		return userDao.findById(userId).get();
	}

	@Override
	public Users addUser(Users user) {
		return userDao.save(user);
	}

	@Override
	public Users updateUser(Long userId, Users user) {
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		return userDao.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		
		
		Users user = userDao.findById(userId).get();
		
		userDao.delete(user);
		
	}

	

}
