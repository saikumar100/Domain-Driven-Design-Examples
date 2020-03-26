package com.saikumar.rest.domain.TodoDomain;

import java.util.ArrayList;
import java.util.List;

import com.saikumar.rest.repository.TodoMockDB;

/**
 * Aggregate root class for todo domain and performs domain related business
 * logic here
 * @see {@link TodoRepository} {@link TodoMockDB}
 * @author Sai Kumar
 * 
 *
 */
public class TodoRootEntity {

	
	/**
	 * @param id
	 * @return
	 */
	public Todo getTodo(Long id) {
		TodoRepository rep = new TodoMockDB();
		return rep.getTodo(id);

	}

	/**
	 * @param id
	 * @param todo
	 * @return
	 */
	public Long updateTodo(Long id, Todo todo) {
		TodoRepository rep = new TodoMockDB();
		rep.updateTodo(id, todo);
		return id;
	}

	/**
	 * @return List<Todo>
	 */
	public List<Todo> getTodos() {
		return new ArrayList<Todo>(TodoMockDB.todos.values());
	}

	
	/**
	 * @param id
	 */
	public void removeTodo(Long id) {
		TodoRepository rep = new TodoMockDB();
		rep.removeTodo(id);
		//TodoMockDB.todos.remove(id);
	}

	/**
	 * @param todo
	 * @return
	 */
	public Long createTodo(Todo todo) {
		TodoRepository rep = new TodoMockDB();
		return rep.createTodo(todo);
	}

}
