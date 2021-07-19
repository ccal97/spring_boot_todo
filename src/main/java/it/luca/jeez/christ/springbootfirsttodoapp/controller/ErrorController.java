package it.luca.jeez.christ.springbootfirsttodoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	
	/*
	 * Ogni volta che verrà lanciatqa un eccezione di tipo Exception (+ generico)
	 * verrà eseguito questo metodo.
	 * ModelAndView è una classe che ci permette di salvare insieme i dettagli del
	 * model e della view.
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletResponse response, HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception",ex.getStackTrace());
		mv.addObject("url",request.getRequestURL());
		mv.setViewName("error");	//mostrare pagina di errore
		return mv;
	}
	
}
