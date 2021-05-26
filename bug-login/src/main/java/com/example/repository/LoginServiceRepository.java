package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.User;

public interface LoginServiceRepository extends JpaRepository<User, Long>{

	 @Query("SELECT u.id FROM User u WHERE u.userName =:username and u.password=:password") 
	    Long findIdByEmailAndPassword(@Param("username") String username,@Param("password") String password);
	 
	 
}
