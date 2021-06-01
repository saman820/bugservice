package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.LoginService;

import lombok.NoArgsConstructor;


@NoArgsConstructor
//@AllArgsConstructor(onConstructor=@__(@Autowired))
@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "*")
public class LoginController {

	private LoginService loginServ;
	//private RestTemplate restTemp;

	@Autowired
	public LoginController(LoginService loginServ) {
		super();
		this.loginServ = loginServ;
		//this.restTemp = restTemp;
	}
	
//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
	
//	@PostMapping("initial")
//	public ResponseEntity<String> initialvalue(@RequestBody User user)
//	{
//		loginServ.insertUser(user);
//		System.out.println("user is saved successfully");
//		
//		return new ResponseEntity<String>("users are saved succesfully",HttpStatus.ACCEPTED);
//	}
	
	@PostMapping("/registration")
	public ResponseEntity<User> registrationInsert(@RequestBody User user)
	{
		user.setCurrentRole(new Role(1, "normal_user"));
		if(loginServ.login(user.getUserName(), user.getPassword())!=null) {
			user = loginServ.login(user.getUserName(), user.getPassword());
		}
		loginServ.insertUser(user);		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	
//	@PostMapping("/registration")
//	public ResponseEntity<String> registrationInsert(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("profilePicture") String profile)
//	{
//		
//		
//	//	System.out.println("adding ");
//		String role="1";
//		//System.out.println(username+password+profile);
//		User user1= new User(username,password,profile,role);
//		System.out.println(loginServ.findByuserName(username));
//		
//		if(loginServ.findByuserName(username)) {
//			
//			loginServ.insertUser(user1);
//
//			
//		}else {
//			
//			
//			return new ResponseEntity<String>("users already exists",HttpStatus.ACCEPTED);
// 
//		}
//		
//	//	System.out.println("user is saved successfully");
//		
//		return new ResponseEntity<String>("users are saved succesfully",HttpStatus.ACCEPTED);
//	}

	
	@PostMapping("/logindetail")
	public ResponseEntity<User> loginCheck(@RequestParam("username") String username,@RequestParam("password") String password)
//	public ResponseEntity<User> loginCheck(@RequestBody User user)
	{
		User user2 =loginServ.login(username, password);
		return new ResponseEntity<User>(user2,HttpStatus.ACCEPTED);
	}
	
}