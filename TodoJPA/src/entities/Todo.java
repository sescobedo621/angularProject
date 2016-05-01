package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String todo;
	@ManyToOne
	@JoinColumn(name="users_id")
	@JsonBackReference(value="userTodos")
	private User user;
	@OneToMany(mappedBy = "todo", cascade = CascadeType.ALL)
	@JsonManagedReference(value="todoItems")
	private List<TodoItem> todoItems;
	
	public Todo(){
		todoItems = new ArrayList();
	}
	
	public Todo(String todo, User user){
		this.todo = todo;
		this.user = user;
		todoItems = new ArrayList();
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTodo()
	{
		return todo;
	}
	public void setTodo(String todo)
	{
		this.todo = todo;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public List<TodoItem> getTodoItems()
	{
		return todoItems;
	}
	public void setTodoItems(List<TodoItem> todoItems)
	{
		this.todoItems = todoItems;
	}
	public void addTodoItem(TodoItem item){
		todoItems.add(item);
	}
	public boolean removeTodoItem(TodoItem item){
		return todoItems.remove(item);
	}
}
