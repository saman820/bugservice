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
import com.example.model.Role;
import com.example.model.User;
import com.example.service.LoginService;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoginService loginService;

	@Test
	public void validateLoginCheck() throws Exception {
		Role role= new Role(1, "user");
		User user = new User(2,"user1", "user1", "user1", "pass1", role);
		when(loginService.login("divyareddy@gmail.com", "Divya@17")).thenReturn(user);

		this.mockMvc
				.perform(post("/logindetail").param("username", "divyareddy@gmail.com").param("password", "Divya@17"))
//				.andExpect(status().isAccepted()).andExpect(content().string("user"));
				.andExpect(status().isAccepted()).andExpect(content().string(("{\r\n"
						+ "    \"userId\": 2,\r\n"
						+ "    \"firstName\": \"user1\",\r\n"
						+ "    \"lastName\": \"user1\",\r\n"
						+ "    \"userName\": \"user1\",\r\n"
						+ "    \"password\": \"pass1\",\r\n"
						+ "    \"currentRole\": {\r\n"
						+ "        \"roleId\": 1,\r\n"
						+ "        \"role\": \"user\"\r\n"
						+ "    }\r\n"
						+ "}")));

	}

	@Test
	public void FailureValidateLogin() throws Exception {

		when(loginService.login("", "")).thenReturn(null);
		
		this.mockMvc.perform(post("/logindetail").param("username", "").param("password", ""))
//				.andExpect(content().string("incorrent credentials"));
				.andExpect(content().string(""));
	}

}
