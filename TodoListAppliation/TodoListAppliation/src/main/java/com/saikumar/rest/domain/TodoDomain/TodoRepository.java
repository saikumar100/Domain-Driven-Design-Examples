package com.saikumar.rest.domain.TodoDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * repository interface for to-do domain
 * 
 * @author Sai Kumar
 * 
 *
 */
public interface TodoRepository {


    public List<Todo> getTodos();
    
    public Todo getTodo(Long id);
    
   
    public void updateTodo(Long id, Todo todo);
     
    public void removeTodo(Long id);

	public Long createTodo(Todo todo);
	
}
