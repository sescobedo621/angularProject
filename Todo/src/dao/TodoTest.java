package dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entities.User;

public class TodoTest {
//	@Autowired
	private TodoDAO todoDao = new TodoDAO();
	
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
//	
//	@Test
//	public void testCreateUser(){
//		User user = new User("frank@gmail.com", "hello");
//		System.out.println("this is the user variable "+ user);
//		User test = todoDao.createUser(user);
//		System.out.println("this is the test variable " + test);
//		assertNotNull(test);
//		//assertEquals(todoDao.createUser(user).getEmail(), user.getEmail());
//	}
	
	@Test
	public void testGetUser(){
		User user = todoDao.getUserByEmail("shelbyescobedo@gmail.com");
		//System.out.println(user);
		assertNotNull(user);
	}
	
}