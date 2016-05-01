package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="todo_items")
public class TodoItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="todo")
	private String todoItem;
	private Date completed;
	@ManyToOne
	@JoinColumn(name="todos_id")
	@JsonBackReference(value="todoItems")
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
