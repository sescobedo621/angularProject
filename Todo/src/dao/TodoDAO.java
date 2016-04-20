package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Transactional
public class TodoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public User getUserByEmail(String email){
		String query = "SELECT u FROM User u WHERE u.email = " + email;
		return em.createQuery(query, User.class).getSingleResult();
	}
	
	public User getUserByEmailAndPassword(String email, String password){
		String query = "SELECT u FROM User u WHERE u.email = " + email + " and u.password = " + password;
		
		return em.createQuery(query, User.class).getSingleResult();
	}
}
