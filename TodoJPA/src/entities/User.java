package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	private List<Todo> todos;
	public User(){
		todos = new ArrayList();
	}
	public User(String email, String password){
		this.email = email;
		this.password = password;
		todos = new ArrayList();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<Todo> getTodos()
	{
		return todos;
	}
	public void setTodos(List<Todo> todos)
	{
		this.todos = todos;
	}
	public void addTodo(Todo todo){
		this.todos.add(todo);
	}
	public boolean removeTodo(Todo todo){
		return this.todos.remove(todo);
	}
	
}
