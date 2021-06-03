package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.RoleRepository;
import com.example.repository.SolutionRepository;
import com.example.repository.StatusRepository;
import com.example.repository.UserRepository;


@Service
public class UserService {

	private BugRepository bugRepo;
	private RoleRepository roleRepo;
	private SolutionRepository solutionRepo;
	private StatusRepository statusRepo;
	private UserRepository userRepo;

	@Autowired
	public UserService(BugRepository bugRepo, RoleRepository roleRepo, SolutionRepository solutionRepo,
			StatusRepository statusRepo, UserRepository userRepo) {
		super();
		this.bugRepo = bugRepo;
		this.roleRepo = roleRepo;
		this.solutionRepo = solutionRepo;
		this.statusRepo = statusRepo;
		this.userRepo = userRepo;
	}

	public UserService() {
		super();
	}
	
	public void  insertUser(User u)
	{
		userRepo.save(u);
	}
	//for login 
		public  User login(String username,String password) {
			User user =  userRepo.findByUserName(username);
			if(user.getPassword().equals(password)) {
				return user;
			}
			return null;
		}

}
