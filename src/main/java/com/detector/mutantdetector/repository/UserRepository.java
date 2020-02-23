package com.detector.mutantdetector.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.detector.mutantdetector.entiry.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
	
	public List<User> findByName(String name);

}
