package com.example.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.User;

@FeignClient(name="bug")
public interface BugClient {
	@PostMapping("/registration")
	public User registerFromBugService(@RequestBody User user);
}
