package com.pack.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pack.demo.model.User;
import com.pack.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User createUser(User user) {
		
		return repository.save(user);
	}
	
	public void createUsers(List<User> userList) {
		
		repository.saveAll(userList);
		
	}
	
	public List<User> getUserData() {
		List<User> userList = null;
		RestTemplate rt = new RestTemplate();
		 final String ROOT_URI = "http://localhost:9191/api/users";

			User[] userArr = rt.getForObject(ROOT_URI, User[].class);
			 Arrays.stream(userArr) .forEach(e->System.out.print(e + " "));
			 
			userList =  Arrays.asList(userArr);
			return userList;

	}
	
	public List<User> getAllUser(){
		return repository.findAll();
	}
}
