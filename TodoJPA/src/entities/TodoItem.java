package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TodoItem {
	private int id;
	@Column(name="todo")
	private String todoItem;
	private Date completed;
	@ManyToOne
	@JoinColumn(name="todo_id")
	private Todo todo;
	
	public TodoItem(){
		
	}
	public TodoItem(String todoItem, Todo todo){
		this.todoItem = todoItem;
		this.todo = todo;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTodoItem()
	{
		return todoItem;
	}
	public void setTodoItem(String todoItem)
	{
		this.todoItem = todoItem;
	}
	public Date getCompleted()
	{
		return completed;
	}
	public void setCompleted(Date completed)
	{
		this.completed = completed;
	}
	public Todo getTodo()
	{
		return todo;
	}
	public void setTodo(Todo todo)
	{
		this.todo = todo;
	}
}
