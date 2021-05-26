package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.LoginServiceRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
@Service
public class LoginService {

	private LoginServiceRepository loginRepo;
	
	
	//for login 
	public  Boolean CheckusernameAndPasswordMatch(String username,String password) {
		Long id =  loginRepo.findIdByEmailAndPassword(username, password);
		System.out.println(id);
		return id !=null;
	}
	
	
	
	
	
	
	
	//for user registration 
	public void  insertUser(User u)
	{
		loginRepo.save(u);
	}
	
	public List<User> findAll()
	{
		 return loginRepo.findAll();
	}
	
	
	public void  deleteUser(User u)
	{
		loginRepo.delete(u);
	}	
	public void deleteUserById(Long id)
	{
		loginRepo.deleteById(id);
	}

	
	
	
	
}
