package com.pack.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pack.demo.model.User;

@Service
public class UserService {
	//@Autowired
	/*
	 * RestTemplate rt ;//= new RestTemplate();
	 */	
	public List<User> getUserData() {
		List<User> userList = null;
		RestTemplate rt = new RestTemplate();
		 final String ROOT_URI = "http://localhost:9191/api/users";

			User[] userArr = rt.getForObject(ROOT_URI, User[].class);
			
			/*
			 * Arrays.stream(userArr) .forEach(e->System.out.print(e + " "));
			 */
			userList =  Arrays.asList(userArr);
			return userList;

	}
}
