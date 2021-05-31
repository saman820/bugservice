package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.User;

public interface LoginServiceRepository extends JpaRepository<User, Integer>{

//	 @Query("SELECT u.id FROM User u WHERE u.userName =:username and u.password=:password") 
//	    int findIdByEmailAndPassword(@Param("username") String username,@Param("password") String password);
//	 
//	 @Query("SELECT u.id FROM User u WHERE u.userName =:username") 
//	 int findByUserName(@Param("username") String username);
	
	User findByUserName(String username);
	 
	 
	 
}
