package it.luca.jeez.christ.springbootfirsttodoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.luca.jeez.christ.springbootfirsttodoapp.service.LoginService;
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
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";	//ritorniamo la view login.jsp. bisogna configurare in app.properties prefix e suffix
		
	}
	
	

}