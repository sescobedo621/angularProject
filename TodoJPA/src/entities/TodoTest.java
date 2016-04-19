package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TodoTest {
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("todoPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		User user = new User("shelbyescobedo@gmail.com", "banana");
		em.persist(user);
		
		em.getTransaction().commit();
	}

}
