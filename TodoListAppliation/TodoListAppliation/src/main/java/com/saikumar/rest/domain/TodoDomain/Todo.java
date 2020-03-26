package com.saikumar.rest.domain.TodoDomain;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Todo {

	
	private Long id = Math.abs(idCounter.getAndIncrement());
	
	
	private static AtomicLong idCounter = new AtomicLong();

	@NotBlank
	@Length(min = 2, max = 255)
	private String name;
	private String description;

	private List<Task> tasks;

	public Todo() {
	}

	public Todo(Long id, String name, String description, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tasks = tasks;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static AtomicLong getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(AtomicLong idCounter) {
		Todo.idCounter = idCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public static Long createID() {
		return idCounter.getAndIncrement();
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", description=" + description + ", tasks=" + tasks + "]";
	}

}
