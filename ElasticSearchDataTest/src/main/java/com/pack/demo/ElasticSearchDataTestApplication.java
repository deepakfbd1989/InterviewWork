package com.pack.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.demo.model.User;
import com.pack.demo.repository.UserRespository;
import com.pack.demo.service.UserService;

@SpringBootApplication
@RestController
@RequestMapping("/elasticSearchAPI")
public class ElasticSearchDataTestApplication {

	
	/*
	 * @Bean RestTemplate restTemplate() { RestTemplate restTemplate = new
	 * RestTemplate(); MappingJacksonHttpMessageConverter converter = new
	 * MappingJacksonHttpMessageConverter(); converter.setObjectMapper(new
	 * ObjectMapper()); restTemplate.getMessageConverters().add(converter); return
	 * restTemplate; }
	 */
	
	@Autowired
	private UserRespository repository;
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public int saveUser() {
		List<User> userListData = service.getUserData();
		if(userListData!=null) {
		repository.saveAll(userListData);
		}
		return userListData.size();
	}
	
	@GetMapping("/getUsers")
	public Iterable<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id){
		return repository.findById(id).orElse(null);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDataTestApplication.class, args);
	}

}
