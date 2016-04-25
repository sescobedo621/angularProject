package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.TodoDAO;
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
	
	@ResponseBody
	@RequestMapping("user/{email}/{password}")
	public User getUserByEmailAndPassword
		(@PathVariable("email") String email, @PathVariable("password") String password){
		return todoDao.getUserByEmailAndPassword(email, password);
	}
}
