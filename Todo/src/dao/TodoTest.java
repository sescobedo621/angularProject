package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.Todo;
import entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"test-servlet.xml"})
public class TodoTest {
	@Autowired
	private TodoDAO todoDao;
	
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
	
	@Test
	@Ignore
	public void testCreateUser(){
		User user = new User("silverfox@gmail.com", "hello");
		User test = todoDao.createUser(user);
		assertNotNull(test);
		assertEquals(test.getEmail(), user.getEmail());
	}
	
	@Test
	public void testGetUser(){
		User user = todoDao.getUserByEmail("shelbyescobedo@gmail.com");
		assertNotNull(user);
		assertEquals(user.getEmail(), "shelbyescobedo@gmail.com");
	}
	@Test
	@Ignore
	public void testAddTodo(){
		User user = todoDao.getUserByEmail("shelbyescobedo@gmail.com");
		Todo todo = new Todo();
		todo.setTodo("Grocery List");
		todo.setUser(user);
		Todo test = todoDao.createTodo(todo);
		assertNotNull(test);
	}
	
}
