package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Todo;
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
		String query = "SELECT u FROM User u WHERE u.email = " + email + " and u.password = " + password;
		
		return em.createQuery(query, User.class).getSingleResult();
	}
	
	public User createUser(User user){
		System.out.println("in todoDAO " + user);
		em.persist(user);
			return user;
		
	}

	public Todo createTodo(Todo todo)
	{
		System.out.println("in create Todo dao " + todo.getTodo());
		em.persist(todo);
		return todo;
	}
	
}
