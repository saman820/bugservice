package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;


@RestController
public class UserController {

	private UserService userServ;

	@Autowired
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}

	public UserController() {

	}
	
	@PostMapping("/registration")
	public ResponseEntity<User> registrationInsert(@RequestBody User user){
		user.setCurrentRole(new Role(1, "normal_user"));
//		if(userServ.login(user.getUserName(), user.getPassword())!=null) {
//			user = userServ.login(user.getUserName(), user.getPassword());
//		}
		userServ.insertUser(user);		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}

}
