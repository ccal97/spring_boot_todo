package it.luca.jeez.christ.springbootfirsttodoapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.luca.jeez.christ.springbootfirsttodoapp.model.Todo;

import it.luca.jeez.christ.springbootfirsttodoapp.service.TodoService;

/**
 * Mappiamo localhost:8080/login alla classe
 * attraverso @RequestMapping(path="")
 * 
 * I metodi della classe vengono mappati con @GetMapping e 
 * @Post mapping a seconda delle chiamate che vogliono servire
 *  
 * [ctrl+1 apre le Eclipse suggestion]
 * 
 * Per passare dei parametri attraverso alla richiesta
 * utilizziamo @RequestParam da iniettare nel metodo del controller.
 * In Spring MVC per passare dati dal Controller al View utilizziamo il Model
 * 
 * @author ldarech
 *
 */

//per jsp, @Controller altrimenti @RestController + cartella main/WEN-INF/jsp
@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		String loggedUsr = (String) model.get("name");
		model.put("todos", service.retrieveTodos(loggedUsr));
		return "list-todos";	//ritorniamo la view login.jsp. bisogna configurare in app.properties prefix e suffix
		
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo",new Todo(0,(String) model.get("name"),"default description",new Date(), false));
		return "todo";
		
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, Todo todo) { //COMMAND BEAN = double binding : mappare direttamente i campi del form all'oggetto che creiamo. Controller + View Spring tags
		String loggedUsr = (String) model.get("name");
		service.addTodo(loggedUsr, todo.getDesc(), new Date(), false);
		return "redirect:/list-todos"; //se invece ritorniamo solo la jsp, model.todo non viene po'polato. quindi reindirizziamo al metodo sopra
		
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(Todo todo, ModelMap model) {
		todo.setUser((String) model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
}
