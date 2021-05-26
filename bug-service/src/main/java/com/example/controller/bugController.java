package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clients.LoginClient;


@RestController
@RequestMapping(value="/")
public class bugController {

//	@Autowired
	private LoginClient loginClient;
	
//	@Autowired
	private CircuitBreakerFactory<LoginClient,?> cbfactory;
	
	public bugController() {}

	@Autowired
//	public bugController(LoginClient loginClient, CircuitBreakerFactory<LoginClient, ?> cbfactory) {
		public bugController(LoginClient loginClient) {
		super();
		this.loginClient = loginClient;
//		this.cbfactory = cbfactory;
	}
	
	@GetMapping("/login/logindetail")
	public ResponseEntity<String> testBug(@RequestParam("username") String username,@RequestParam("password") String password){
		if(loginClient.loginCheck(username, password))
		return ResponseEntity.ok("this works");
		return ResponseEntity.badRequest().build();
	}
	
	
}
