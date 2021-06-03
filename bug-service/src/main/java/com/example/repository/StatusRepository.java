package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Status;


public interface StatusRepository extends JpaRepository<Status, Integer> {

}
