package com.saikumar.rest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saikumar.rest.domain.TodoDomain.Task;
import com.saikumar.rest.domain.TodoDomain.Todo;
import com.saikumar.rest.domain.TodoDomain.TodoRepository;
import com.saikumar.rest.domain.TodoDomain.TodoRootEntity;
import com.saikumar.rest.domain.TodoDomain.valueObjects.TaskName;



/**
 * This class is mock representation of the back-end DB
 * @author saikumar
 *
 */
public class TodoMockDB implements TodoRepository {
     
    public static HashMap<Long, Todo> todos = new HashMap<>();
    static{
        Long id = Todo.createID();
    	Task finishLean1XBackendTask = new Task(Math.abs(Task.createID()),"LEAN1X_TASK_ONE","Need to finish Lean1X back-end task using dropwizard");
    	Task finishLean1XFronendTask = new Task(Math.abs(Task.createID())+1,"LEAN1X_TASK_TWO","Need to finish Lean1X frond-end task using angular");
    	List<Task> lean1XTaks = new ArrayList<>();
    	lean1XTaks.add(finishLean1XFronendTask);
    	lean1XTaks.add(finishLean1XBackendTask);
    	
    	Todo todo_1 = new Todo(id,"TODO1","LEAN1X tasks",lean1XTaks);
        todo_1.setId(id);
    	
        todos.put(Todo.createID(), todo_1);
    }
     
    @Override
    public List<Todo> getTodos(){
        return new ArrayList<Todo>(todos.values());
    }
    
    @Override
    public Todo getTodo(Long id){
        for(Map.Entry<Long,Todo> entry : todos.entrySet()){
                Todo tempTodo = entry.getValue();
                if(tempTodo.getId() == id){
                    return tempTodo;
                }
        }
        return todos.get(id);
    }
    
    @Override
    public void updateTodo(Long id, Todo employee){
        Long idToBeUpdatedFromMap  = null;
        for(Map.Entry<Long,Todo> entry : todos.entrySet()){
            Todo tempTodo = entry.getValue();
            if(tempTodo.getId() == id){
                idToBeUpdatedFromMap = entry.getKey();
            }
        }
        todos.put(idToBeUpdatedFromMap, employee);
    }
     
    @Override
    public void removeTodo(Long id) {
        Long idToBeDeletedFromMap  = null;
        for(Map.Entry<Long,Todo> entry : todos.entrySet()){
            Todo tempTodo = entry.getValue();
            if(tempTodo.getId() == id){
                idToBeDeletedFromMap = entry.getKey();
            }
        }
        todos.remove(idToBeDeletedFromMap);
    }

	@Override
	public Long createTodo(Todo todo) {
		Long id = Todo.createID();
		System.out.println("Generated Todo Id: "+id);
		todos.put(id, todo);
		System.out.println(todos);
		return id;
	}


}