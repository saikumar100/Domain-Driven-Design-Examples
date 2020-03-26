package com.saikumar.rest.repository;

import java.util.List;

import com.saikumar.rest.domain.TodoDomain.Todo;
import com.saikumar.rest.domain.TodoDomain.TodoRepository;


/**
 * This is the outside world db implementation using domain model repository pattern
 * @see {@link TodoRepository}
 * 
 * @author saikumar
 *
 */
//TODO:	Need to write db specific implementation 
public class TodoJPARepository implements TodoRepository {

	@Override
	public List<Todo> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo getTodo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTodo(Long id, Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTodo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long createTodo(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
