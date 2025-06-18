package com.backend.service;

import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
	
	public int LoginValidation(String username, String password);
	

}
