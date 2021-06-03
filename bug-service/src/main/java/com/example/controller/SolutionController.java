package com.example.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Solution;
import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.SolutionRepository;
import com.example.service.SolutionService;


@RestController
@RequestMapping(value = "/solutions")
public class SolutionController {

	private SolutionService solutionServ;
	private BugRepository bugRepository;
	private SolutionRepository solutionRepository;

	@Autowired
	public SolutionController(SolutionService solutionServ, BugRepository bugRepository, SolutionRepository solutionRepository) {
		super();
		this.solutionServ = solutionServ;
		this.bugRepository = bugRepository;
		this.solutionRepository = solutionRepository;
	}

	public SolutionController() {
		super();
	}

	/*
     * Updates solution status (accept solution)
     * @param solution object to be updated
     * @return true value
     */
	@PostMapping("/update-solution-status")
	public ResponseEntity<Boolean> updateSolutionStatus(@RequestBody Solution solution) {
		boolean result = this.solutionServ.updateSolutionStatus(solution);
		return new ResponseEntity<Boolean>(result, HttpStatus.ACCEPTED);
	}
	
	/*
     * Returns list of solutions belong to a bug
     * @param bugId
     * @return solutions of a bug
     */
	@GetMapping("/{bugId}") 
	public ResponseEntity<List<Solution>> getSolutionByBug(@PathVariable("bugId") int id) {
		List<Solution> solutions = this.solutionServ.allSolutionsForBug(id);
		
		return new ResponseEntity<List<Solution>>(solutions, HttpStatus.OK);
	}

	/*
     * Creates new solution
     * @param solution object
     * @return ID of solution created
     */
	@PostMapping("/new-solution")
	public ResponseEntity<Integer> createSolution(@RequestBody Solution solution) {
		int solutionId = this.solutionServ.insertSolution(solution.getSolution(), solution.getSolutionSubmissionDate(),
						solution.getBug(), solution.getUser());
		
		return new ResponseEntity<>(solutionId, HttpStatus.CREATED);
	}
	
	/*
     * Calculates user's points whose solution is accepted 
     * @return hash map of user and user's points
     */
	@GetMapping("/calc")
	public ResponseEntity<HashMap<User, Integer>> calculatePoints() {
		HashMap<User, Integer> points = new HashMap<>();
		points = solutionServ.getUserPointsMap();
		return new ResponseEntity<HashMap<User, Integer>>(points, HttpStatus.OK);
	}
	
	/*
	 * Get all solutions that belong to an user
	 * @param user object
	 * @return list of solutions that belong to an user
	 */
	@GetMapping("/user-solution")
	public ResponseEntity<List<Solution>> getAllSolutionsByUser(@RequestBody User user) {	
		List<Solution> solutions = solutionServ.getAllSolutionsByUserId(user);
		return new ResponseEntity<List<Solution>>(solutions, HttpStatus.OK);
	}
}
