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
	public ResponseEntity<String> registrationInsert(@RequestBody User user)
	{
		loginServ.insertUser(user);
		System.out.println("user is saved successfully");
		
		return new ResponseEntity<String>("users are saved succesfully",HttpStatus.ACCEPTED);
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
	public ResponseEntity<String> loginCheck(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		String str =loginServ.login(username, password);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
}