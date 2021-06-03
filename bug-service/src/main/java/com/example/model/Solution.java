package com.example.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solutions")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "solution_id", nullable = false, unique = true)
	private int solutionId;
	
	@Column(name = "solution", nullable = false)     //added
	private String solution;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	private boolean solutionStatus;

	@Column(name = "submission_date", nullable = false)
	private LocalDateTime solutionSubmissionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bug_id_fk")
	private Bug bug;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User user;

	public Solution(int solutionId, boolean solutionStatus, LocalDateTime solutionSubmissionDate, Bug bug, User user) {
		super();
		this.solutionId = solutionId;
		this.solutionStatus = solutionStatus;
		this.solutionSubmissionDate = solutionSubmissionDate;
		this.bug = bug;
		this.user = user;
	}

	public Solution(boolean solutionStatus, LocalDateTime solutionSubmissionDate, Bug bug, User user) {
		super();
		this.solutionStatus = solutionStatus;
		this.solutionSubmissionDate = solutionSubmissionDate;
		this.bug = bug;
		this.user = user;
	}

	public Solution() {
		super();
	}

	public int getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}

	public boolean isSolutionStatus() {
		return solutionStatus;
	}

	public void setSolutionStatus(boolean solutionStatus) {
		this.solutionStatus = solutionStatus;
	}

	public LocalDateTime getSolutionSubmissionDate() {
		return solutionSubmissionDate;
	}

	public void setSolutionSubmissionDate(LocalDateTime solutionSubmissionDate) {
		this.solutionSubmissionDate = solutionSubmissionDate;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}

