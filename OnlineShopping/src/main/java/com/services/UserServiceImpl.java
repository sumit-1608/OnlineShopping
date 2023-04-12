package com.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.User;
import com.exceptions.UserAlreadyExistsException;
import com.exceptions.UserNotFoundException;
import com.repositories.IUserRepository;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userDao;
	
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(Long userId){
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		return userDao.findById(userId).get();
	}

	@Override
	public User addUser(User user) {
		if(userDao.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}
		return userDao.save(user);
	}

	@Override
	public User updateUser(Long userId, User user) {
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
		
		
		User user = userDao.findById(userId).get();
		
		userDao.delete(user);
		
	}

	

}
