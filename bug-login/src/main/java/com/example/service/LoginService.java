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
	public  User login(String username,String password) {
		User user =  loginRepo.findByUserName(username);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	
	
		
//	//for login 
//	public  String login(String username,String password) {
//		User user =  loginRepo.findByUserName(username);
//		if(user.getPassword().equals(password)) {
//			if(user.getCurrentRole().getRole().equals("admin")) {
//				return "admin";
//			}
//			return "user";
//		}
//		return "incorrent credentials";
//	}
	
	
	
//	//existing user check	
//		public Boolean findByuserName(String user) {
//			int exit=loginRepo.findByUserName(user);
//		System.out.println(exit);
////			if(exit==null) {
////				return true;
////			}
//			
//			return false;
//			
//		}
		

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
	public void deleteUserById(int id)
	{
		loginRepo.deleteById(id);
	}

	
	
	
	
}
