package com.pack.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pack.demo.model.User;

public interface UserRespository extends ElasticsearchRepository<User, Integer> {

}
