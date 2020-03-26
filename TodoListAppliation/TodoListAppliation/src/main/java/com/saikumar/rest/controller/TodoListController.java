package com.saikumar.rest.controller;
 
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.saikumar.rest.domain.TodoDomain.ProjectStatus;
import com.saikumar.rest.domain.TodoDomain.Task;
import com.saikumar.rest.domain.TodoDomain.Todo;
import com.saikumar.rest.domain.TodoDomain.valueObjects.TaskName;
import com.saikumar.rest.repository.TodoMockDB;
import com.saikumar.rest.services.TodoService;



/**
 * @author saikumar
 * {@link TodoListController} this controller is responsible for create/update/delete todos given by the user.
 * @see {@link Task} {@link TaskName} {@link TodoMockDB} {@link Todo} {@link TodoService}
 */
/**
 * @author saikumar
 *
 */
@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class TodoListController {
 
    private final Validator validator;
 
    /**
     * @param validator
     */
    public TodoListController(Validator validator) {
        this.validator = validator;
    }
 
    /**this method returns all the tods's from back-end db
     * @return
     */
    @GET
    @Path("/getAll")
    public Response getTodos() {
    	TodoService todoService = new TodoService();
        return Response.ok(todoService.getTodos()).build();
    }
 
    /**this method takes todo id as a parameter and returns the Todo object
     * @param id
     * @return
     */
    @GET
    @Path("/getToDo/{id}")
    public Response getTodoById(@PathParam("id") Long id) {
    	TodoService todoService = new TodoService();
        Todo todo = todoService.getTodo(id);
        if (todo != null)
            return Response.ok(todo).build();
        else
            return Response.status(Status.NOT_FOUND).entity(new ProjectStatus("Not Found")).build();

    }
 
    
    /** this method creates a Todo by taking todo object as a input
     * @param todo
     * @return
     * @throws URISyntaxException
     */
    @POST
    @Path("/createToDo")
    public Response createTodo(Todo todo) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<Todo>> violations = validator.validate(todo);
        TodoService todoService = new TodoService();
        Todo e = todoService.getTodo(todo.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<Todo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            todoService.updateTodo(e.getId(), todo);
            return Response.status(Status.CREATED).entity(new ProjectStatus("Created")).build();
        } else {
            todoService.createTodo(todo);
           return Response.status(Status.CREATED).entity(new ProjectStatus("Created")).build();
        }
    }
 
    /** this method updates existing todo
     * @param id
     * @param todo
     * @return
     */
    @PUT
    @Path("/updateToDo/{id}")
    public Response updateTodoById(@PathParam("id") Long id, Todo todo) {
        // validation
        Set<ConstraintViolation<Todo>> violations = validator.validate(todo);
        TodoService todoService = new TodoService();
        Todo e = todoService.getTodo(id);
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<Todo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            todo.setId(id);
            todoService.updateTodo(id, todo);
            return Response.ok(todo).build();
        } else
            return Response.status(Status.OK).entity(new ProjectStatus("Not Found")).build();
    }
 
    /** removes existing todo from the application
     * @param id
     * @return
     */
    @DELETE
    @Path("/deleteToDo/{id}")
    public Response removeTodoById(@PathParam("id") Long id) {
    	TodoService todoService = new TodoService();
        Todo e = todoService.getTodo(id);
        if (e != null) {
            todoService.removeTodo(id);
            return Response.status(Status.OK).entity(new ProjectStatus("Deleted")).build();
        } else
            return Response.status(Status.NOT_FOUND).entity(new ProjectStatus("Not Found")).build();
    }
}