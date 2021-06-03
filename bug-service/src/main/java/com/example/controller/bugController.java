package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Bug;
import com.example.model.User;
import com.example.service.BugService;

@RestController
@RequestMapping(value = "/bug")
@CrossOrigin("*")
public class BugController {

	private BugService bugServ;

	@Autowired
	public BugController(BugService bugServ) {
		super();
		this.bugServ = bugServ;
	}

	public BugController() {
		super();
	}

	/*
     * Returns all existing bugs
     * @return list of bugs existing
     */
	@GetMapping()
	public ResponseEntity<List<Bug>> getAllBugs(){
		return new ResponseEntity<List<Bug>>(bugServ.getAllBugs(), HttpStatus.OK);
	}

	/*
     * Creates new bug
     * @param bug object
     * @return string message of creation success
     */
	@PostMapping("/new-bug")
	public ResponseEntity<String> insertBug(@RequestBody Bug bug){
		this.bugServ.insertBug(bug.getBugDescription(), bug.getBugSubmissionDate(), bug.getBugOwner());
		return new ResponseEntity<String>("Bug Created", HttpStatus.CREATED);
	}
	
	/*
     * Returns all accepted bugs
     * @return list of bugs accepted
     */
	@GetMapping("/accepted")
	public ResponseEntity<List<Bug>> getAllAcceptedBugs(){
		return new ResponseEntity<List<Bug>>(bugServ.getAllAcceptedAndResolvedBugs(), HttpStatus.OK);
	}

	/*
     * Updates bug status
     * @param bug object
     * @return ID of a bug that has been updated
     */
	@PostMapping("/update-bugStatus")
	public ResponseEntity<Integer> updateBugStatus(@RequestBody Bug bug){			
		return new ResponseEntity<Integer>(bugServ.updateBugStatus(bug), HttpStatus.OK);
	}
	
	/*
     * Returns all bugs that belong to an user
     * @param user object
     * @return list of bugs that belong to an user
     */
	@GetMapping("/user-bug")
	public ResponseEntity<List<Bug>> getAllBugsByUser(@RequestBody User user) {	
		List<Bug> bugs = bugServ.getAllBugsByUser(user);
		return new ResponseEntity<List<Bug>>(bugs, HttpStatus.OK);
	}
}
