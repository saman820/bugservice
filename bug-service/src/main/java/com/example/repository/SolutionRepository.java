package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Bug;
import com.example.model.Solution;
import com.example.model.User;


public interface SolutionRepository extends JpaRepository<Solution, Integer> {
	
	public List<Solution> findByBug(Bug bug);
	
	public List<Solution> findAllByUser(User user);
}
