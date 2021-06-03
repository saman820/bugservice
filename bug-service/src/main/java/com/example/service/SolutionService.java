package com.example.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Bug;
import com.example.model.Solution;
import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.RoleRepository;
import com.example.repository.SolutionRepository;
import com.example.repository.StatusRepository;
import com.example.repository.UserRepository;



@Service
public class SolutionService {

	private BugRepository bugRepo;
	private RoleRepository roleRepo;
	private SolutionRepository solutionRepo;
	private StatusRepository statusRepo;
	private UserRepository userRepo;
	private BugService bugServ;

	@Autowired
	public SolutionService(BugRepository bugRepo, RoleRepository roleRepo, SolutionRepository solutionRepo,
			StatusRepository statusRepo, UserRepository userRepo, BugService bugServ) {
		super();
		this.bugRepo = bugRepo;
		this.roleRepo = roleRepo;
		this.solutionRepo = solutionRepo;
		this.statusRepo = statusRepo;
		this.userRepo = userRepo;
		this.bugServ = bugServ;
	}

	public SolutionService() {
		super();
	}
	
	/*
     * Updates solution status (true or false, true means solution is accepted)
     * @param solution object to be updated
     * @return true after solution is updated (accepted)
     */
	public boolean updateSolutionStatus(Solution solution) {
		Solution mySolution = this.solutionRepo.getById(solution.getSolutionId());
		mySolution.setSolutionStatus(solution.isSolutionStatus());
		this.solutionRepo.save(mySolution);
		return true;
	}

	/*
     * Creates a solution
     * @param properties of solution object to be created
     * @return ID of solution created
     */
	public int insertSolution(String solution, LocalDateTime solutionSubmissionDate, Bug bug, User user) {

		if (bug.getBugOwner().getUserId() == user.getUserId()) {
			return -1;
		}

		Solution s = new Solution();

		s.setSolution(solution);
		s.setSolutionStatus(false);
		s.setSolutionSubmissionDate(solutionSubmissionDate);
		s.setBug(bug);
		s.setUser(user);

		return solutionRepo.save(s).getSolutionId();
	}

	/*
     * Returns all solution of a bug
     * @param bugId of a bug that has solution(s)
     * @return list of solutions belong to a bug
     */
	public List<Solution> allSolutionsForBug(int bugId) {
		Bug bug = this.bugRepo.getById(bugId);
		List<Solution> solutions = this.solutionRepo.findByBug(bug);
		return solutions;
	}

	/*
     * Returns all solutions whose status is true
     * @return list of solutions having status true
     */
	public List<Solution> getAllSolutionResolved() {
		List<Bug> resolvedBugs = bugServ.getAllResolvedBugs();
		List<Solution> solutions = new ArrayList<>();
		for (Bug bug : resolvedBugs) {
			solutions.addAll(solutionRepo.findByBug(bug));
		}

		List<Solution> trueSolutions = new ArrayList<>();
		for (Solution solution : solutions) {
			if (solution.isSolutionStatus()) {
				trueSolutions.add(solution);
			}
		}
		return trueSolutions;
	}

	/*
     * Returns user and user's point whose solutions is accepted (true)
     * @return hash map of userPoints that has user and user's point
     */
	public HashMap<User, Integer> getUserPointsMap() {
		HashMap<User, Integer> userPoints = new HashMap<>();
		List<Solution> solutionResolved = getAllSolutionResolved();
		for (Solution solution : solutionResolved) {
			User u = solution.getUser();
			if (userPoints.get(u) == null) {
				userPoints.put(u, 1);
			} else {
				userPoints.put(u, userPoints.get(u) + 1);
			}
		}
		return userPoints;
	}
	
	/*
     * Returns all solution of an user
     * @param userId of an user who has solutions
     * @return list of solutions belong to an user
     */
	public List<Solution> getAllSolutionsByUserId(User user) {
		return solutionRepo.findAllByUser(user);
	}

}
