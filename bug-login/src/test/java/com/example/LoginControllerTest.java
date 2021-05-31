package com.example;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.LoginController;
import com.example.service.LoginService;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoginService loginService;

	@Test
	public void validateLoginCheck() throws Exception {

		when(loginService.login("divyareddy@gmail.com", "Divya@17")).thenReturn("user");

		this.mockMvc
				.perform(post("/logindetail").param("username", "divyareddy@gmail.com").param("password", "Divya@17"))
				.andExpect(status().isAccepted()).andExpect(content().string("user"));

	}

	@Test
	public void FailureValidateLogin() throws Exception {

		when(loginService.login("", "")).thenReturn("incorrent credentials");
		
		this.mockMvc.perform(post("/logindetail").param("username", "").param("password", ""))
				.andExpect(content().string("incorrent credentials"));
	}

}
