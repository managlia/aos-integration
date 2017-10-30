package com.yeti.security.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yeti.model.host.User;
import com.yeti.security.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/Users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/Users/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Integer id) {
		userService.updateUser(id, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Users/{id}")
	public void deleteUser(@RequestBody User user, @PathVariable Integer id) {
		userService.deleteUser(id, user);
	}
	
	
}








