package it.luca.jeez.christ.springbootfirsttodoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 * 
 * Per passare dei parametri attraverso alla richiesta
 * utilizziamo @RequestParam da iniettare nel metodo del controller.
 * In Spring MVC per passare dati dal Controller al View utilizziamo il Model ancora da inserire
 * @author ldarech
 *
 */

@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	@GetMapping(path="/uno")
	public String loginMessage() {
		return "login";	//ritorniamo la view login.jsp. bisogna configurare in app.properties prefix e suffix
		//però non funziona
	}

}
