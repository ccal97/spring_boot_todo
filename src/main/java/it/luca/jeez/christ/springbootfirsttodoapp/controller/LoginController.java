package it.luca.jeez.christ.springbootfirsttodoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mappiamo localhost:8080/login alla classe
 * attraverso @RequestMapping(path="")
 * 
 * I metodi della classe vengono mappati con @GetMapping e 
 * @Post mapping a seconda delle chiamate che vogliono servire
 *  
 * [ctrl+1 apre le Eclipse suggestion]
 * @author ldarech
 *
 */

@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	@GetMapping(path="/uno")
	public String loginMessage() {
		return "Hello world";
	}

}
