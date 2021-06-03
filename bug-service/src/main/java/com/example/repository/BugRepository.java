package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Bug;
import com.example.model.Status;
import com.example.model.User;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer>{

    public List<Bug> findAll();
    
    public Bug findByBugId(int bugId);
    
    public List<Bug> findByBugStatus(Status status);
    
    public List<Bug> findAllByBugOwner(User bugOwner);
}