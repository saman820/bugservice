package com.example;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Bug;
import com.example.model.Role;
import com.example.model.Status;
import com.example.model.User;
import com.example.repository.BugRepository;
import com.example.repository.StatusRepository;
import com.example.service.BugService;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BugServiceTest {
	
	/*
	 * Mocking objects that are used to test
	 */
	@Mock
	private BugRepository bRepo;
	private StatusRepository statusRepo = mock(StatusRepository.class);
	Status resolved = new Status(3, "Resolved");
	LocalDateTime date = LocalDateTime.now();
	Role role = new Role();
	User user1 = new User(1,"anyUser","123123","any", "test",role);
	User user2 = new User(2,"anyUser","123123","any", "test",role);
	User user3 = new User(3,"anyUser","123123","any", "test",role);
	List<Bug> mockBugs = new ArrayList<>();
	
	
	@InjectMocks
	private BugService service = new BugService();
	private Bug bug;
	
	/*
	 * Initialize mocked values
	 */
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockBugs.add(new Bug(1,"Bug description created for testing", date, user1, resolved));
		when(service.getAllResolvedBugs()).thenReturn(mockBugs);
		when(statusRepo.getById(3)).thenReturn(resolved);
		when(service.getAllBugsByUser(user1)).thenReturn(mockBugs);
		when(bRepo.getById(1)).thenReturn(mockBugs.get(0));
	}
	
	/*
	 * test case for getAllBugs method
	 */
	@Test
	public void getAllBugsTest() {
		List<Bug> bugList = new ArrayList<Bug>();
		LocalDateTime date = LocalDateTime.now();
		Role role = new Role();
		User user1 = new User(1,"anyUser","123123","any", "test",role);
		
		Bug b1 = new Bug(1,"Bug description created for testing",date,user1,null);
		
		bugList.add(b1);
		
		when(service.getAllBugs()).thenReturn(bugList);
		
		List<Bug> list = bRepo.findAll();
		
		assertEquals(1, bugList.size());
		verify(bRepo, times(1)).findAll();	
	}
	
	/*
	 * test case for getBugsByUserId method
	 */
	@Test
	public void getBugsByUserIdTest() {
		LocalDateTime date = LocalDateTime.now();
		Role role = new Role();
		User user1 = new User(1,"anyUser","123123","any", "test",role);
		Bug bug = new Bug(1,"Bug description created for testing",date,user1,null);
		
		List<Bug> list = new ArrayList<>();
		list.add(bug);
		
		when(bRepo.findAllByBugOwner(user1)).thenReturn(list);
		List<Bug> bugs = service.getAllBugsByUser(user1);
		
		assertEquals(1, bugs.size());
		verify(bRepo, times(1)).findAllByBugOwner(user1);
	}
	
	/*
	 * test case for getResolvedBugs method
	 */
	@Test
	public void getResolvedBugsTest() {
		List<Bug> resolvedBugs = new ArrayList<>();
		resolvedBugs = service.getAllResolvedBugs();
		assertEquals(mockBugs, resolvedBugs);
	}
	
	/*
	 * test case for getAllBugsByUser method
	 */
	@Test
	public void getAllBugsByUserTest() {
		List<Bug> bugs = new ArrayList<>();
		bugs = service.getAllBugsByUser(user1);
		assertEquals(mockBugs, bugs);
	}
}