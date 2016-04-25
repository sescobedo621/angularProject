package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.Todo;
import entities.TodoItem;
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
	@Test
	public void testGetTodoById(){
		Todo todo = todoDao.getTodoById(1);
		assertEquals(todo.getTodo(), "Grocery List");
	}
	
	@Test
	public void testAddTodoItem(){
		Todo todo = todoDao.getTodoById(1);
		TodoItem item = new TodoItem();
		item.setTodo(todo);
		item.setTodoItem("milk");
		//item.setCompleted(null);
		TodoItem test = todoDao.createTodoItem(item);
		
		assertEquals(test.getTodoItem(), "milk");
	}
}
