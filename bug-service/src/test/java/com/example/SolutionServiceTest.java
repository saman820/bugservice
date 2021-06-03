package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Bug;
import com.example.model.Role;
import com.example.model.Solution;
import com.example.model.Status;
import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.SolutionRepository;
import com.example.service.BugService;
import com.example.service.SolutionService;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SolutionServiceTest {

	/*
	 * Mocking objects that are used to test
	 */
	@Mock
	private BugRepository bRepo = mock(BugRepository.class);
	private SolutionRepository sRepo = mock(SolutionRepository.class);
	private BugService bugServ = mock(BugService.class);
	private SolutionService solServ = mock(SolutionService.class);
	
	Status resolved = new Status(3, "Resolved");
	LocalDateTime date = LocalDateTime.now();
	Role role = new Role();
	User user1 = new User(1,"anyUser","123123","any", "test",role);
	Bug bug = new Bug(1,"Bug description created for testing", date, user1, resolved);
	Solution solution = new Solution(1, false, date, bug, user1);
	List<Solution> mockSolutions = new ArrayList<>();
	List<Bug> resolvedBugs = new ArrayList<>();
	List<Solution> resolvedSolutions = new ArrayList<>();
	Solution resolvedSolution1 = new Solution(2, true, date, bug, user1);
	Solution resolvedSolution2 = new Solution(3, true, date, bug, user1);
	
	/*
	 * Initialize mocked values
	 */
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockSolutions.add(solution);
		resolvedBugs.add(bug);
		resolvedSolutions.add(resolvedSolution1);
		resolvedSolutions.add(resolvedSolution2);
		when(bRepo.getById(1)).thenReturn(bug);
		when(sRepo.findByBug(bug)).thenReturn(mockSolutions);
		when(bugServ.getAllResolvedBugs()).thenReturn(resolvedBugs);
		when(solServ.getAllSolutionResolved()).thenReturn(resolvedSolutions);
		when(solServ.getAllSolutionsByUserId(user1)).thenReturn(resolvedSolutions);
	}
	
	/*
	 * test case for allSolutionsForBug
	 */
	@Test
	public void allSolutionsForBugTest() {
		Bug bug = bRepo.getById(1);
		List<Solution> solutions = sRepo.findByBug(bug);
		assertEquals(solutions, mockSolutions);
	}
	
	/*
	 * test case for getAllSolutionResolved
	 */
	@Test
	public void getAllSolutionResolvedTest() {
		List<Solution> solutions = new ArrayList<>();
		solutions.add(resolvedSolution1);
		solutions.add(resolvedSolution2);
		assertEquals(solutions, resolvedSolutions);
	}
	
	/*
	 * test case for getAllSolutionsByUser
	 */
	@Test
	public void getAllSolutionsByUserId() {
		List<Solution> solutions = new ArrayList<>();
		solutions.add(resolvedSolution1);
		solutions.add(resolvedSolution2);
		assertEquals(solutions, resolvedSolutions);
	}
	
}
