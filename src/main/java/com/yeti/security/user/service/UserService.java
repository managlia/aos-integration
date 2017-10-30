package com.yeti.security.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.model.host.User;
import com.yeti.security.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepository;
	
	public List<User> getAllUsers() {
		List<User> companies = new ArrayList<User>();
		UserRepository.findAll().forEach(companies::add);
		return companies;
	}
	
	/*
	public List<User> getAllUsersByDescription(String UserDescription) {
		List<User> companies = new ArrayList<User>();
		UserRepository.findByContactDescriptionIgnoreCaseContaining(UserDescription).forEach(companies::add);
		return companies;
	}

	public List<User> getAllUsersByName(String UserName) {
		List<User> companies = new ArrayList<User>();
		UserRepository.findByUserNameIgnoreCaseContaining(UserName).forEach(companies::add);
		return companies;
	}
*/	
	public User getUser(Integer id) {
		return UserRepository.findOne(id);
	}
	
	public void addUser(User User) {
		UserRepository.save(User);
	}

	public void updateUser(Integer id, User User) {
		UserRepository.save(User);
	}

	public void deleteUser(Integer id, User User) {
		UserRepository.delete(id);
	}
	
}
