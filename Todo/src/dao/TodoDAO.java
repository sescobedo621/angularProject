package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Todo;
import entities.TodoItem;
import entities.User;

@Transactional
public class TodoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public User getUserByEmail(String email){
		String query = "SELECT u FROM User u WHERE u.email = '" + email + "'";
		System.out.println(query);
		return em.createQuery(query, User.class).getSingleResult();
	}
	
	public User getUserByEmailAndPassword(String email, String password){
		String query = "SELECT u FROM User u WHERE u.email = '" + email + "' and u.password = '" + password +"'";
		System.out.println(query);
		return em.createQuery(query, User.class).getSingleResult();
	}
	
	public User createUser(User user){
		em.persist(user);
			return user;
		
	}

	public Todo createTodo(Todo todo)
	{
		em.persist(todo);
		return todo;
	}
	
	public Todo getTodoById(int id){
		return em.find(Todo.class, id);
	}
	
	public TodoItem createTodoItem(TodoItem item){
		em.persist(item);
		return item;
	}
	
	public TodoItem getTodoItemById(int id){
		return em.find(TodoItem.class, id);
	}
}
