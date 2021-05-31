package com.example.clients;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="login")
public interface LoginClient {
	@PostMapping("/logindetail")
	public String  loginCheck(@RequestParam("username") String username,@RequestParam("password") String password);
}
