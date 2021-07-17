package it.luca.jeez.christ.springbootfirsttodoapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import it.luca.jeez.christ.springbootfirsttodoapp.model.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "luca", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(4, "in28Minutes", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(int id) {
<<<<<<< HEAD
        //List<Todo> filteredTodos = new ArrayList<Todo>();
=======
        List<Todo> filteredTodos = new ArrayList<Todo>();
>>>>>>> branch 'master' of https://github.com/ccal97/spring_boot_todo.git
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }
    
    public void updateTodo(Todo todo) {
    	System.out.println(todo.getId());
    	todos.remove(todo);
    	todos.add(todo);
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}