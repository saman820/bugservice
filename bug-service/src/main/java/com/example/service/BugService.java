package com.example.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Bug;
import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.RoleRepository;
import com.example.repository.SolutionRepository;
import com.example.repository.StatusRepository;
import com.example.repository.UserRepository;



@Service
public class BugService {

	private BugRepository bugRepo;
	private RoleRepository roleRepo;
	private SolutionRepository solutionRepo;
	private StatusRepository statusRepo;
	private UserRepository userRepo;

	@Autowired
	public BugService(BugRepository bugRepo, RoleRepository roleRepo, SolutionRepository solutionRepo,
			StatusRepository statusRepo, UserRepository userRepo) {
		super();
		this.bugRepo = bugRepo;
		this.roleRepo = roleRepo;
		this.solutionRepo = solutionRepo;
		this.statusRepo = statusRepo;
		this.userRepo = userRepo;
	}

	public BugService() {

	}

	public int insertBug(String description, LocalDateTime submissionDate, User bugOwner) {
		Bug bug = new Bug();
		bug.setBugDescription(description);
		bug.setBugSubmissionDate(submissionDate);
		bug.setBugOwner(bugOwner);
		bug.setBugStatus(statusRepo.getById(1));

		return bugRepo.save(bug).getBugId();
	}
	
	/*
     * Returns all list of bugs existing.
     * @return bug list
     */
	public List<Bug> getAllBugs() {
		return bugRepo.findAll();
	}

	/*
     * Returns all list of bugs resolved.
     * @return list of bugs resolved
     */
	public List<Bug> getAllResolvedBugs() {
		List<Bug> bugsResolved = bugRepo.findByBugStatus(statusRepo.getById(3));
		return bugsResolved;
	}

	/*
     * Returns all list of bugs accepted and resolved.
     * @return list of bugs accepted and resolved
     */
	public List<Bug> getAllAcceptedAndResolvedBugs() {
		List<Bug> bugsAccepted = bugRepo.findByBugStatus(statusRepo.getById(2));
		List<Bug> bugsResolved = bugRepo.findByBugStatus(statusRepo.getById(3));
		bugsAccepted.addAll(bugsResolved);
		return bugsAccepted;
	}

	/*
     * Updates bug and returns bug.
     * @param bug object that would be updated
     * @return bugId that has been updated
     */
	public int updateBugStatus(Bug bug) {
		Bug mybug = bugRepo.getById(bug.getBugId());
		if (bug.getBugStatus() != null) {
			mybug.setBugStatus(bug.getBugStatus());
		}

		return bugRepo.save(mybug).getBugId();
	}
	
	/*
     * Returns all bugs by userId
     * @param user object that has bug(s)
     * @return all bugs belong to the user
     */
	public List<Bug> getAllBugsByUser(User user) {
		List<Bug> bugs = new ArrayList<>();
		bugs = bugRepo.findAllByBugOwner(user);
		return bugs;
	}

}
