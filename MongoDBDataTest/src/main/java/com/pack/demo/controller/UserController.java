package com.pack.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.demo.model.User;
import com.pack.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/createUser")
	public User saveUser(@RequestParam String name,@RequestParam String address,@RequestParam int contact) {
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setContact(contact);
		return service.createUser(user);
	}
	
	@PostMapping("/createUsers")
	public String saveUsers() {
		List<User> userList = service.getUserData();
		
		service.createUsers(userList);
		return userList.size()+" Data Saved from MYSQL";
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return service.getAllUser();
	}
}
