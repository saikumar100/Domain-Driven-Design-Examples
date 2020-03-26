package com.saikumar.rest.services;

import java.util.List;

import com.saikumar.rest.domain.TodoDomain.Todo;
import com.saikumar.rest.domain.TodoDomain.TodoRootEntity;

/**
 * Todo's domain specific service which handles all the domain behavior 
 * through Todo's aggregate entity
 * @see {@link TodoRootEntity}
 * @author saikumar
 *
 */
public class TodoService {

	/** Intializes TodoRootEntity(Aggregate root entity) & returns the todo object
	 * @param id
	 * @return
	 */
	public Todo getTodo(Long id) {
		TodoRootEntity trEntity = new TodoRootEntity();
		return trEntity.getTodo(id);
	}
	
	/**Intializes TodoRootEntity(Aggregate root entity) &  creates todo object by taking todo as a input
	 * @param todo
	 * @return
	 */
	public Long createTodo(Todo todo) {
		TodoRootEntity trEntity = new TodoRootEntity();
		return trEntity.createTodo(todo);
	}

	/** Intializes TodoRootEntity(Aggregate root entity) & Updates existing todo object
	 * @param id
	 * @param todo
	 * @return
	 */
	public Long updateTodo(Long id,Todo todo) {

		TodoRootEntity trEntity = new TodoRootEntity();
		return trEntity.updateTodo(id, todo);
	}

	/**Intializes TodoRootEntity(Aggregate root entity) &  Gets all the todo's from the application
	 * @return
	 */
	public List<Todo> getTodos() {
		TodoRootEntity trEntity = new TodoRootEntity();
		return trEntity.getTodos();
	}
	
	
	/**Intializes TodoRootEntity(Aggregate root entity) & remove specific todo
	 * @param id
	 */
	public void removeTodo(Long id){
		TodoRootEntity trEntity = new TodoRootEntity();
		trEntity.removeTodo(id);
    }


}
