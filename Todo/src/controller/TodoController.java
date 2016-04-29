package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.TodoDAO;
import entities.Todo;
import entities.User;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDAO todoDao;
	
	@ResponseBody
	@RequestMapping("ping")
	public String ping(){
		return "pong";
	}
	//getting a user based on email and password
	@ResponseBody
	@RequestMapping("user/{email}/{password}")
	public User getUserByEmailAndPassword
		(@PathVariable("email") String email, @PathVariable("password") String password){
		return todoDao.getUserByEmailAndPassword(email, password);
	}
	//creating a new user
	@ResponseBody
	@RequestMapping("addUser")
	public User addUser(@RequestBody User user){
		return todoDao.createUser(user);
	}
	//getting a todo
	@ResponseBody
	@RequestMapping("todoList/{id}")
	public Todo getTodoList(@PathVariable("id") int id){
		return todoDao.getTodoById(id);
	}
	
	@ResponseBody
	@RequestMapping("addTodoList")
	public Todo addTodo(@RequestBody Todo todo){
		return todoDao.createTodo(todo);
	}
}
