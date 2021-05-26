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
	
	@PostMapping("initial")
	public ResponseEntity<String> initialvalue(@RequestBody User user)
	{
		loginServ.insertUser(user);
		System.out.println("user is saved successfully");
		
		return new ResponseEntity<String>("users are saved succesfully",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/registration")
	public ResponseEntity<String> registrationInsert(@RequestBody User user)
	{
		loginServ.insertUser(user);
		System.out.println("user is saved successfully");
		
		return new ResponseEntity<String>("users are saved succesfully",HttpStatus.ACCEPTED);
	}

	
	@PostMapping("/logindetail")
	public ResponseEntity<Boolean> loginCheck(@RequestParam("username") String username,@RequestParam("password") String password)
	{
       System.out.println(username);
       System.out.println(password);
		Boolean b =loginServ.CheckusernameAndPasswordMatch(username, password);
		
		if(b == true)
		{
			//this.restTemp.getForObject("http://localhost:9003/flashcar", null);
		}
		return new ResponseEntity<Boolean>(b,HttpStatus.ACCEPTED);
	}

	
	
	


	
	
	
	
}