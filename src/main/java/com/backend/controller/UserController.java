package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/login")
	public int UserLogin(@PathVariable("username") String username1, @PathVariable("password")  String password1) {
		
		int flag = userService.LoginValidation(username1, password1);
		if(flag == 0) {
			return 0;
		}else {
			return flag;
		}
	}

}
