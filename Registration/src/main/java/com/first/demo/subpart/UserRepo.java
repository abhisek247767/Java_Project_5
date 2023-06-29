package com.first.demo.subpart;

import org.springframework.data.repository.CrudRepository;

import com.first.demo.User;

public interface UserRepo extends CrudRepository<User, Long> {
	
}
